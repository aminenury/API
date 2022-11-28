package HerOkuAppSmokeTest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static utils.AuthenticationHerOkuApp.generateToken;

public class s1put extends HerOkuAppBaseUrl {
    /*
  Given
      https://restful-booker.herokuapp.com/booking/:id
  And
      {
          "firstname" : "James",
          "lastname" : "Brown",
          "totalprice" : 500,
          "depositpaid" : false,
          "bookingdates" : {
              "checkin" : "2022-11-27",
              "checkout" : "2022-11-29"
          },
          "additionalneeds" : "Breakfast"
      }
  When
      User sends Put request
  Then
      Status code is 200
  And
      Response body is like {
                           "firstname" : "James",
                          "lastname" : "Brown",
                          "totalprice" : 500,
                          "depositpaid" : false,
                          "bookingdates" : {
                              "checkin" : "2022-11-27",
                              "checkout" : "2022-11-29"
                          },
                          "additionalneeds" : "Breakfast"
                          }
   */

    @Test
    public void put01(){
        //Set the url
       spec.pathParams("first","booking","second",18957);

        //Set the expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2022-11-27","2022-11-29");
        BookingPojo expectedData = new BookingPojo("James","Brown",500,false,bookingDatesPojo,"Breakfast");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().
                spec(spec).
                contentType(ContentType.JSON).
                headers("Cookie","token="+generateToken()).
                body(expectedData).
                when().
                put("/{first}/{second}");

        response.prettyPrint();


    }
}
