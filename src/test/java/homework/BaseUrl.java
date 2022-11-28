package homework;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrl {
    protected RequestSpecification spec;

    @Before// If you use @before annotation at the tap of a method, it will be executed
    public void setUp(){

        spec = new RequestSpecBuilder().setBaseUri("https://reqres.in/api").build();


    }
}
