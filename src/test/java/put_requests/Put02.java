package put_requests;

import base_urls.DummyApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyApiPojo;
import pojos.DummyApiResponsePojo;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Put02 extends DummyApiBaseUrl {
    /*
    given
        URL: https://dummy.restapiexample.com/api/v1/update/21
     and {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
      when
                 Status code is 200
       and

                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been added."
                    }
     */
    @Test
    public void put02() {
        //Set the url
        spec.pathParams("first", "update", "second", 21);

        //Set the expected data
        DummyApiPojo expectedData = new DummyApiPojo("Tom Hanks",111111,23,"Perfect image");
        DummyApiResponsePojo responsePojo = new DummyApiResponsePojo("success",expectedData,"Successfully! Record has been updated.");
        System.out.println("responsePojo = " + responsePojo);

        //Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().put("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        DummyApiResponsePojo actualData = JsonUtils.convertJsonToJavaObject(response.asString(),DummyApiResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(responsePojo.getStatus(),actualData.getStatus());
        assertEquals(expectedData.getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals(expectedData.getEmployee_salary(),actualData.getData().getEmployee_salary());
        assertEquals(expectedData.getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(expectedData.getProfile_image(),actualData.getData().getProfile_image());
        assertEquals(responsePojo.getMessage(),actualData.getMessage());


    }
}
