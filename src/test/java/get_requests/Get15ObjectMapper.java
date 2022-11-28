package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get15ObjectMapper extends JsonPlaceHolderBaseUrl {

    /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */
    @Test
    public void get15(){
        spec.pathParams("first","todos","second", 198);

        String expectedDataInString ="{\n" +
                                     "   \"userId\": 10,\n" +
                                     "   \"id\": 198,\n" +
                                     "   \"title\": \"quis eius est sint explicabo\",\n" +
                                     "   \"completed\": true\n" +
                                     "  }";
       Map<String,Object> expectedData= JsonUtils.convertJsonToJavaObject(expectedDataInString, HashMap.class);
        System.out.println(expectedData);

        Response response= given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

       Map<String,Object> actualData= JsonUtils.convertJsonToJavaObject(response.asString(), HashMap.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));

    }
}
