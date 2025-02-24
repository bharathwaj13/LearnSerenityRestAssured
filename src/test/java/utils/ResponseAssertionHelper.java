package utils;


import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import static net.serenitybdd.rest.SerenityRest.then;

    public class ResponseAssertionHelper {

        private static ValidatableResponse response() {
            return then();
        }

        /** Assert a field equals a specific value */
        public static void assertFieldEquals(String field, Object expectedValue) {
            response().body(field, Matchers.equalTo(expectedValue));
        }

        /** Assert a field exists in the response */
        public static void assertFieldExists(String field) {
            response().body(field, Matchers.notNullValue());
        }

        /** Assert a field does NOT exist */
        public static void assertFieldDoesNotExist(String field) {
            response().body(field, Matchers.nullValue());
        }

        /** Assert a field contains a substring */
        public static void assertFieldContains(String field, String expectedSubstring) {
            response().body(field, Matchers.containsString(expectedSubstring));
        }

        /** Assert a field does NOT contain a substring */
        public static void assertFieldDoesNotContain(String field, String expectedSubstring) {
            response().body(field, Matchers.not(Matchers.containsString(expectedSubstring)));
        }

        /** Assert an array field contains a specific value */
        public static void assertListContains(String field, Object expectedValue) {
            response().body(field, Matchers.hasItem(expectedValue));
        }

        /** Assert an array field does NOT contain a specific value */
        public static void assertListDoesNotContain(String field, Object expectedValue) {
            response().body(field, Matchers.not(Matchers.hasItem(expectedValue)));
        }

        /** Assert an array field has an exact size */
        public static void assertListSize(String field, int expectedSize) {
            response().body(field, Matchers.hasSize(expectedSize));
        }

        /** Assert an array field is empty */
        public static void assertListIsEmpty(String field) {
            response().body(field, Matchers.empty());
        }

        /** Assert an array field is NOT empty */
        public static void assertListIsNotEmpty(String field) {
            response().body(field, Matchers.not(Matchers.empty()));
        }

        /** Assert HTTP Status Code */
        public static void assertStatusCode(int expectedStatusCode) {
            response().statusCode(expectedStatusCode);
        }

        /** Assert a field is greater than a value */
        public static <T extends Comparable<T>> void assertFieldGreaterThan(String field, T expectedValue) {
            response().body(field, Matchers.greaterThan(expectedValue));
        }

        /** Assert a field is less than a value */
        public static <T extends Comparable<T>> void assertFieldLessThan(String field, T expectedValue) {
            response().body(field, Matchers.lessThan(expectedValue));
        }

        /** Assert a field is within a range */
        public static <T extends Comparable<T>> void assertFieldBetween(String field, T min, T max) {
            response().body(field, Matchers.both(Matchers.greaterThanOrEqualTo(min)).and(Matchers.lessThanOrEqualTo(max)));
        }

        /** Assert a response time is within limits */
        public static void assertResponseTimeLessThan(long timeInMillis) {
            response().time(Matchers.lessThan(timeInMillis));
        }

        /** Assert response contains expected keys */
        public static void assertJsonContainsKeys(String field, String... keys) {
            for (String key : keys) {
                response().body(field + "." + key, Matchers.notNullValue());
            }
        }

        /** Assert a field matches a regex pattern */
        public static void assertFieldMatchesPattern(String field, String regexPattern) {
            response().body(field, Matchers.matchesPattern(regexPattern));
        }

        /** Assert a field starts with a specific value */
        public static void assertFieldStartsWith(String field, String expectedPrefix) {
            response().body(field, Matchers.startsWith(expectedPrefix));
        }

        /** Assert a field ends with a specific value */
        public static void assertFieldEndsWith(String field, String expectedSuffix) {
            response().body(field, Matchers.endsWith(expectedSuffix));
        }
}
