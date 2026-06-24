package br.com.tests.ping.requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetPingRequest {

    public Response executeHealthCheck() {
        return given()
                .when()
                .get("/ping");
    }
}
