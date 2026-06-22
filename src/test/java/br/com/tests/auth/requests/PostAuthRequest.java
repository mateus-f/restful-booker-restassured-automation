package br.com.tests.auth.requests;

import br.com.tests.auth.requests.payloads.AuthPayloads;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostAuthRequest {

    private final AuthPayloads authPayloads = new AuthPayloads();

    public Response executeCreateToken(Object payload) {
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/auth");
    }

    public String getToken() {
        return "token=" + this.executeCreateToken(authPayloads.validLogin())
                .then()
                .extract()
                .body()
                .path("token");
    }
}
