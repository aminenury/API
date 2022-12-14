package utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtils {

    protected static ObjectMapper mapper;

    static {
        mapper= new ObjectMapper();
    }
    public static  <T> T convertJsonToJavaObject(String json, Class<T> cls){
        T javaResult= null;
        try {
           javaResult =  mapper.readValue(json,cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return javaResult;
    }
}
