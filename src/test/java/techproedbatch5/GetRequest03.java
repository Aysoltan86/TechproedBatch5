package techproedbatch5;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.hamcrest.text.MatchesPattern;
import org.junit.Test;

import static io.restassured.RestAssured.*;
public class GetRequest03 {
    /* Positive Scenario
     {
    "firstname": "Eric",
    "lastname": "Smith",
    "totalprice": 653,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2016-02-07",
        "checkout": "2016-03-21"  }
*/
    @Test
    public void get01(){

        Response response=given().
                accept("application/json").
                when().
                get("https://restful-booker.herokuapp.com/booking/7");
        response.prettyPrint();

        // Status Code 1.Yol
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", Matchers.equalTo("Marc")).
                body("lastname", Matchers.equalTo("Ericsson")).
                body("totalprice", Matchers.equalTo(850)).
                body("depositpaid", Matchers.equalTo("true")).
                body("bookingdates.checkin", Matchers.equalTo("2018-10-04")).
                body("bookingdates.checkout", Matchers.equalTo("2019-05-23"));
}
}
