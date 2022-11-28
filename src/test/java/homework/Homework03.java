package homework;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItems;
import static org.testng.AssertJUnit.assertEquals;

public class Homework03 extends BaseUrl{
    /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be “application/json”
       And
           “email” is “janet.weaver@reqres.in”,
       And
           “first_name” is "Janet"
       And
           “last_name” is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */
     @Test
    public void homework04(){
         spec.pathParams("first","users","second",2);



       Response response =  given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();



         JsonPath jsonPath= response.jsonPath();
         assertEquals("janet.weaver@reqres.in",jsonPath.getString("data.email"));
         assertEquals("Janet",jsonPath.getString("data.first_name"));
         assertEquals("Weaver",jsonPath.getString("data.last_name"));
         assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!",jsonPath.getString("support.text"));









     }

}
