package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get02 {

    /*
   Given
       https://restful-booker.herokuapp.com/booking/1
   When
       User send a GET Request to the url
   Then
       HTTP Status code should be 404
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Response body contains "Not Found"
   And
       Response body does not contain "TechProEd"
   And
       Server is "Cowboy"
*/
    @Test
    public void get02(){

        String url ="https://restful-booker.herokuapp.com/booking/0";

        //set the expected data

        //send the request and get the reponse

     Response response=  given().when().get(url);
     response.prettyPrint();

      // do assertion
      response.then().
               assertThat().
               statusCode(404).
               statusLine("HTTP/1.1 404 Not Found")  ;
       //how to assert if reponse body contains any data
      assertTrue( response.asString().contains("Not Found"));

       //response body does not contain "techproed"
        assertFalse(response.asString().contains("TechProEd"));

        //server is "cowboy"
        assertEquals("Cowboy",response.getHeader("Server"));


    }




}
