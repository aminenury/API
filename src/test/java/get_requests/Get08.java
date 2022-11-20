package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import text.JsonPlaceHolderTestData;

import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class Get08 extends JsonPlaceHolderBaseUrl {
    /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */
    @Test
    public void get08(){
        spec.pathParams("first","todos","second",2);
        JsonPlaceHolderTestData obj = new JsonPlaceHolderTestData();
       Map<String, Object> expectedData = obj.expectedDataJPH(1,"quis ut nam facilis et officia qui",false);
        System.out.println(expectedData);

       Response response = given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();

    }
}
