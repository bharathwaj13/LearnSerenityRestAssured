package utils;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Objects;

public class ApiRequestHelper {

    /**
     * Generic method to perform a POST request
     *
     * @param body     - Request body (can be null)
     * @return Deserialized response
     */
    public static Response sendPost(RequestSpecification requestSpec, Object body) {

        return requestSpec
                .given()
                .body(body)
                .when()
                .post()
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .response();
    }

    /**
     * Overloaded method: Perform a POST request with only an endpoint (no body).
     */
    public static Response sendPostWithEndpoint(RequestSpecification requestSpec, Object body,String endpoint) {

        return requestSpec
                .body(Objects.nonNull(body) ? body : "")
                .when()
                .post(endpoint)
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract()
                .response();
    }
}

