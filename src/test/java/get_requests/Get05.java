package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {

    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends get request to the URL
    Then
        Status code is 200
And
   Among the data there should be someone whose firstname is "Johhny" and lastname is "Dear"
 */

    @Test
    public void get05(){

        spec.pathParam("first","booking").queryParams("firstname","Adamz","lastname","Dear");

       Response response= given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("bookingid"));




    }

}
