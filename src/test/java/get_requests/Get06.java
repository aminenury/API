package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class Get06 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/32
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
              {
    "firstname": "James",
    "lastname": "Brown",
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
    public void get06() {
        //Set the url
        spec.pathParams("first", "booking", "second", 32);

        //Set the expected data


        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        //1st Way:
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",equalTo("James"),
                        "lastname",equalTo("Brown"),
                        "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2018-01-01"),
                        "bookingdates.checkout",equalTo("2019-01-01"),
                        "additionalneeds",equalTo("Breakfast"));

        //2nd Way: We will use JsonPath Class
        JsonPath jsonPath = response.jsonPath();

        //Hard Assertion
        assertEquals("James",jsonPath.getString("firstname"));
        assertEquals("Brown",jsonPath.getString("lastname"));
        assertEquals(111,jsonPath.getInt("totalprice"));
        assertEquals(true,jsonPath.getBoolean("depositpaid"));
        assertEquals("2018-01-01",jsonPath.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",jsonPath.getString("bookingdates.checkout"));
        assertEquals("Breakfast",jsonPath.getString("additionalneeds"));

        //soft assertion
        //to do soft assertion follow this 3 steps
        //1st: create soft asser object
        SoftAssert softAssert = new SoftAssert();


        // 2nd : do assertion

        softAssert.assertEquals(jsonPath.getString("firstname"),"James","first name did not match");
        softAssert.assertEquals(jsonPath.getString("lastname"),"Brown","last name did not match");
        softAssert.assertEquals(jsonPath.getInt("totalprice"),111,"total price name did not match");
        softAssert.assertEquals(jsonPath.getBoolean("depositpaid"),true,"depositpaid name did not match");

        // 3rd: use assetall() method
     softAssert.assertAll();



    }
}
