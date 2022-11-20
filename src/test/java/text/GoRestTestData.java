package text;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GoRestTestData {

    public Map<String,String> goRestDataMap(String name, String email, String gender, String status ){
        Map<String,String> goRestDataMap = new HashMap<>();
        goRestDataMap.put("name",name);
        goRestDataMap.put("email",email);
        goRestDataMap.put("gender",gender);
        goRestDataMap.put("status",status);
        return goRestDataMap;
    }
    public Map<String , Object> expectedDataMapSetup(Object meta,Map<String,String> data){
        Map<String,Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("meta",meta);
        expectedDataMap.put("data",data);
        return expectedDataMap;
    }

}
/* "meta": null,
    "data": {
        "id": 13,
        "name": "Suresh Johar",
        "email": "suresh_johar@von-damore.biz",
        "gender": "female",
        "status": "active"
    }
}*/