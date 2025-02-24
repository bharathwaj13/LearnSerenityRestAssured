package baseapirequests;


import net.serenitybdd.rest.SerenityRest;

import java.util.Objects;

public class ApiRequestHelper {

    /**
     * Generic method to perform a POST request
     *
     * @param endpoint - API endpoint (e.g., "/pets")
     * @param body  - Request body (can be null)
     * @param responseClass - Response class to deserialize
     * @param <T> - Generic return type
     * @return Deserialized response
     */
    public static <T> T performPost(String endpoint, Object body, Class<T> responseClass) {

            return SerenityRest.given()
                    .body(Objects.nonNull(body)?body:"")
                    .when()
                    .post(Objects.nonNull(endpoint)?endpoint:"")
                    .then()
                    .statusCode(200)
                    .log().all()
                    .extract()
                    .as(responseClass);
    }

    /**
     * Overloaded method: Perform a POST request with only an endpoint (no body).
     */
    public static <T> T performPost(String endpoint, Class<T> responseClass) {
        return performPost(endpoint, null, responseClass);
    }

    /**
     * Overloaded method: Perform a POST request with only a body (uses default endpoint).
     */
    public static <T> T performPost(Object body, Class<T> responseClass) {
        return performPost(null, body, responseClass);
    }

    /**
     * Overloaded method: Perform a POST request with no parameters (uses default endpoint, no body).
     */
    public static <T> T performPost(Class<T> responseClass) {
        return performPost(null, null, responseClass);
    }
}

