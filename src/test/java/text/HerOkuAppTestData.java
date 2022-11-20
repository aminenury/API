package text;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HerOkuAppTestData {

    public Map<String,String> bookingInnerMapSetup(String checkin,String checkout){

        Map<String,String> bookingInnerMap= new HashMap<>();
        bookingInnerMap.put("checkin",checkin);
        bookingInnerMap.put("checkout",checkout);
        return bookingInnerMap;
    }

    public Map<String,Object> expectedDataSetUp(String firstname, String lastname, Integer totalprice,Boolean depositpaid, Map<String ,String > bookingdates,String additionalneeds ) {

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", firstname);
        expectedData.put("lastname", lastname);
        expectedData.put("totalprice", totalprice);
        expectedData.put("depositpaid", depositpaid);
        expectedData.put("bookingdates", bookingdates);
        expectedData.put("additionalneeds", additionalneeds);

        return expectedData;
    }}