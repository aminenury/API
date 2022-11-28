package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyApiResponsePojo {
    private String status;
    private DummyApiPojo data;
    private String message;

    public DummyApiResponsePojo(String status, DummyApiPojo data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public DummyApiResponsePojo() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyApiPojo getData() {
        return data;
    }

    public void setData(DummyApiPojo data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DummyApiResponsePojo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
/*
 {
         "status": "success",
         "data": {
         "employee_name": "Ali Can",
         "employee_salary": 111111,
         "employee_age": 23,
         "profile_image": "Perfect image",
         "id": 6344
         },
         "message": "Successfully! Record has been added."   */
