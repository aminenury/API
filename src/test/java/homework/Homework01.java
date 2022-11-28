package homework;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class Homework01 extends BaseUrl {
/*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */
    @Test
    public void homework01(){
        spec.pathParams("first","users","second",3);

       Response response =  given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();

    response.then().
            assertThat().
            statusCode(200).
            statusLine("HTTP/1.1 200 OK").
            contentType(ContentType.JSON);


    }


}
