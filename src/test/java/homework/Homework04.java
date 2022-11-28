package homework;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Homework04 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Brandon&lastname=Wilson
        When
            User sends get request to the URL
        Then
            Status code is 200
        And
            Among the data there should be someone whose firstname is "Brandon" and lastname is "Wilson"

 */
    @Test
    public void homework04(){
      // String url ="https://restful-booker.herokuapp.com/booking?firstname=Brandon&lastname=Wilson";

     // Response response =  given().contentType(ContentType.JSON).when().get(url);
     // response.prettyPrint();

   // response.then().assertThat().statusCode(200).body("firstname",hasItem("Brandon"),"lastname",hasItem("Wilson"));


        //2.yol
        spec.pathParam("first","booking").queryParams("firstname","Brandon","lastname","Wilson");

        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        assertEquals(200,response.statusCode());
       assertTrue(response.asString().contains("bookingid"));
    }
}
