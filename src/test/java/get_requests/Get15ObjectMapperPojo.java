package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get15ObjectMapperPojo extends JsonPlaceHolderBaseUrl {
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
        spec.pathParams("first","todos","second",198);

        String expectedDataAsString ="{\n" +
                "   \"userId\": 10,\n" +
                "   \"id\": 198,\n" +
                "   \"title\": \"quis eius est sint explicabo\",\n" +
                "    \"completed\": true\n" +
                "  }";

      JsonPlaceHolderPojo expectedData= JsonUtils.convertJsonToJavaObject(expectedDataAsString, JsonPlaceHolderPojo.class);
        System.out.println(expectedData);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        JsonPlaceHolderPojo actualData= JsonUtils.convertJsonToJavaObject(response.asString(),JsonPlaceHolderPojo.class);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());

    }
}
