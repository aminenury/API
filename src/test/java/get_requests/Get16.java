package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get16 extends HerOkuAppBaseUrl {
    /*
        Given
                https://restful-booker.herokuapp.com/booking/555
        When
                I send GET Request to the URL
        Then
                Status code is 200
                         {
    "firstname": "Edgar",
    "lastname": "Dominguez",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
     */
    @Test
    public void get16(){
        spec.pathParams("first","booking","second",555);

        String expectedDataAsString =" {\n" +
                "    \"firstname\": \"Edgar\",\n" +
                "    \"lastname\": \"Dominguez\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";
        Map<String,Object> expectedData = JsonUtils.convertJsonToJavaObject(expectedDataAsString, HashMap.class);
        System.out.println(expectedData);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String,Object> actualData = JsonUtils.convertJsonToJavaObject(response.asString(), HashMap.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(expectedData.get("bookingdates.checkin"),actualData.get("bookingdates.checkin"));
        assertEquals(expectedData.get("bookingdates.checkout"),actualData.get("bookingdates.checkout"));



    }
}
