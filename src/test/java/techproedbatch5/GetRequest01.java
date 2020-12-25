package techproedbatch5;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

    //Rest-Assured kullanarak API Testing

    @Test
    public void getMethod01(){

                given().
                when().
                   get("https://restful-booker.herokuapp.com").
                        then().
                        assertThat().
                        statusCode(200);

    }
    // Get ile aldigimiz datayi konsolda gormek, gelene daatayi bir konteyner icerisine alip yazdirmak gerekiyor.
    //Bunun icin de Response kullanarak, Postman'daki ciktinin aynisini elde edecegiz. Response Body kismini yazdirir.

    @Test
    public void getMethod02(){

        Response response = given().when().
                get("https://restful-booker.herokuapp.com/booking/3");

        //Response body'yi konsola yazdirmak icin
        response.prettyPrint();

        //Status kodunu konsola yazdirmak
        System.out.println("Status kod: " + response.getStatusCode());

        //Status satirini yazdirmak icin
        System.out.println("Status line: " + response.getStatusLine() );

        //Response Body'nin content typini konsola yazdir
        System.out.println("Content Type: " + response.getContentType());

        //Headers'teki tum bilgileri almak icin
        System.out.println(response.getHeaders());

        //Header'daki specific bir datayi almak icin
        System.out.println(response.getHeader("Date"));

        //Status Codunun 200 oldugunu dogrulayalim
                response.
                then().
                assertThat().
                statusCode(200);

        //Hard Assertion - ilk hatayi buldugu anda calismayi durdurur
                response.
                then().
                assertThat().
                statusCode(200).
                        statusLine("HTTP/1.1 200 OK").
                contentType("application/json; charset=utf-8");

        //Content typini almak
      //1.Yol
        System.out.println(response.getContentType());

        //2.Yol
        System.out.println(response.header("Content-Type"));

        //Headerdeki butun bilgileri al
        System.out.println(response.getHeaders());

        //Headerden specific bir data almak
        System.out.println(response.getHeader("Date"));

        System.out.println(response.getTime());

        //Hard asserteion - dogrulama
        response.
                then().
                assertThat().
                statusLine("HTTP/1.1 200 OK").
                contentType("application/json; charset=utf-8").
                statusCode(200);

    }

    }