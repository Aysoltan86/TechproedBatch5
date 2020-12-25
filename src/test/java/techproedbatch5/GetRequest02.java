package techproedbatch5;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class GetRequest02 {

    /* Positive Scenario
    When() bir get Request asagida verilen endpointe yollanir "https://restful-booker.herokuapp.com/booking"/
    And() kabul edilecek AcceptType "application/json" dur. Then() StatusCode 200 dur. And () ContentType
    "application/json"dur.
     */

    @Test
    public void get01() {
        given().
                accept("application/json").
                when().
                get("https://restful-booker.herokuapp.com/booking").
                then().
                assertThat().
                statusCode(200);
    }
         /* Negative Scenario
         When () bir Request asagidaki Endpointe yollanir: "hhtps://restful-booker.herokuapp.com/booking/1001".
         And() kabul edilir Accept Type "application/json"dur. Then() statusCode 400 dur.
         */
        @Test
        public void get02() {

            Response response = given().
                    accept("application/json").
                    when().
                    get("https://restful-booker.herokuapp.com/booking/1001");

            response.prettyPrint();

            response.then().assertThat().statusCode(404);
        }

        @Test
    public void get03(){

            Response response=given().when().get("https://restful-booker.herokuapp.com/booking/1001");
            response.prettyPrint();
            assertEquals(404, response.getStatusCode());
            assertTrue(response.asString().contains("Not Found"));
            assertFalse(response.asString().contains("techproed"));
        }
    }