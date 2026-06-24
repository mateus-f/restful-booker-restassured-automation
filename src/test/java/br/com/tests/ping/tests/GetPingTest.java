package br.com.tests.ping.tests;

import br.com.suites.AllTests;
import br.com.suites.SmokeTests;
import br.com.tests.ping.requests.GetPingRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.*;

public class GetPingTest {

    private final GetPingRequest getPingRequest = new GetPingRequest();

    @Test
    @Category({SmokeTests.class, AllTests.class})
    public void deveRetornarStatus201ETextoCreated_QuandoVerificarDisponibilidadeDaApi() {

        getPingRequest.executeHealthCheck()
                .then()
                .statusCode(201)
                .body(equalTo("Created"))
                .time(lessThan(2000L));
    }
}
