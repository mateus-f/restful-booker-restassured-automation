package br.com.tests.booking.requests;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetBookingRequest {

    public Response executeGetAllBookingIds() {
        return given()
                .when()
                .get("/booking");
    }

    public Response executeGetBookingIdsWithFilters(Map<String, String> queryParams) {
        return given()
                .queryParams(queryParams)
                .when()
                .get("/booking");
    }

    public Response executeGetBookingIdsByFilter(String paramName, String paramValue) {
        return given()
                .queryParams(paramName, paramValue)
                .when()
                .get("/booking");
    }
}
