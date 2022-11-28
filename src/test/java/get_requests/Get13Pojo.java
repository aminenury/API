package get_requests;

import base_urls.GorestBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;

import static io.restassured.RestAssured.given;

public class Get13Pojo extends GorestBaseUrl {
 /*   Given
    https://gorest.co.in/public/v1/users/13
    When
    User send GET Request to the URL
            Then
    Status Code should be 200
    And
    Response body should be like
    {
        "meta": null,
            "data": {
        "id": 3615,
                "name": "Sarisha Mehrotra",
                "email": "mehrotra_sarisha@crooks.biz",
                "gender": "male",
                "status": "inactive"
    }
    }

*/
    @Test
    public void get13(){
        spec.pathParams("first","users","second",13);

        GoRestDataPojo goRestDataPojo =new GoRestDataPojo("Sarisha Mehrotra","mehrotra_sarisha@crooks.biz","male","inactive") ;
        GoRestPojo goRestPojo = new GoRestPojo(null,goRestDataPojo);
        System.out.println(goRestPojo);

       Response response= given().spec(spec).contentType(ContentType.JSON).body(goRestPojo).when().get("/{first}/{second}");
       response.prettyPrint();



    }

}
