package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.*;

public class Get09 extends HerOkuAppBaseUrl {
    /*
       Given
           https://restful-booker.herokuapp.com/booking/246
       When
           I send GET Request to the url
       Then
           Response body should be like that;
           {
               "firstname": "Alex",
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
    public void test09(){
        spec.pathParams("first","booking","second",246);

        Map<String,String> bookingInnerMap= new HashMap<>();
        bookingInnerMap.put("checkin","2018-01-01");
        bookingInnerMap.put("checkout","2019-01-01");

        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "Alex");
        expectedData.put("lastname", "Dominguez");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingInnerMap);
        expectedData.put("additionalneeds", "Breakfast");

     Response response =   given().spec(spec).when().get("/{first}/{second}");
     response.prettyPrint();

     Map<String,Object> actualData = response.as(HashMap.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));
        assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"),((Map)(actualData.get("bookingdates"))).get("checkin"));
        assertEquals(((Map)expectedData.get("bookingdates")).get("checkout"),((Map)(actualData.get("bookingdates"))).get("checkout"));

     //2.way
        //2nd Way:Recommended
        assertEquals(bookingInnerMap.get("checkin"),((Map)(actualData.get("bookingdates"))).get("checkin"));
        assertEquals(bookingInnerMap.get("checkout"),((Map)(actualData.get("bookingdates"))).get("checkout"));




    }
}
