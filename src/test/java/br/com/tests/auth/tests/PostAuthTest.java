package br.com.tests.auth.tests;

import br.com.base.BaseTest;
import br.com.suites.*;
import br.com.tests.auth.requests.PostAuthRequest;
import br.com.tests.auth.requests.payloads.AuthPayloads;
import br.com.utils.Utils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;
import java.util.List;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

public class PostAuthTest extends BaseTest {

    private final PostAuthRequest postAuthRequest = new PostAuthRequest();
    private final AuthPayloads authPayloads = new AuthPayloads();

    @Test
    @Category({SmokeTests.class, AllTests.class})
    public void deveRetornarStatus200ETokenValido_QuandoEnviarCredenciaisValidas() {

        postAuthRequest.executeCreateToken(authPayloads.validLogin())
                .then()
                .statusCode(200)
                .body("token", notNullValue());
    }

    @Test
    @Category({AcceptanceCriticalTests.class, AllTests.class})
    public void deveRetornarApenasCampoTokenNaoVazio_QuandoRealizarAutenticacaoComSucesso() {

        postAuthRequest.executeCreateToken(authPayloads.validLogin())
                .then()
                .statusCode(200)
                .body("token", notNullValue())
                .body("token", not(empty()))
                .body("size()", is(1));
    }

    @Test
    @Category({AcceptanceExceptionTests.class, AllTests.class})
    public void deveRetornarMensagemBadCredentials_QuandoAutenticarComCredenciaisInvalidas() {

        List<Map<String, Object>> payloads = List.of(
                authPayloads.loginWithInvalidUsername(),
                authPayloads.loginWithInvalidPassword(),
                authPayloads.loginWithEmptyFields()
        );

        for (Map<String, Object> payload : payloads) {
            postAuthRequest.executeCreateToken(payload)
                    .then()
                    .statusCode(200)
                    .body("reason", equalTo("Bad credentials"));
        }
    }

    @Test
    @Category({SecurityTests.class, AllTests.class})
    public void deveRetornarMensagemBadCredentials_QuandoAutenticarComCredenciaisOmitidas() {

        List<Map<String, Object>> payloads = List.of(
                authPayloads.loginMissingUsername(),
                authPayloads.loginMissingPassword()
        );

        for (Map<String, Object> payload : payloads) {
            postAuthRequest.executeCreateToken(payload)
                    .then()
                    .statusCode(200)
                    .body("reason", equalTo("Bad credentials"));
        }
    }

    @Test
    @Category({ContractTests.class, AllTests.class})
    public void deveValidarJsonSchema_QuandoRealizarAutenticacaoComSucesso() {

        postAuthRequest.executeCreateToken(authPayloads.validLogin())
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("auth", "auth-schema"))));
    }
}
