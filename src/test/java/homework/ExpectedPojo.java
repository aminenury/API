package homework;

public class ExpectedPojo {
    private String name;
    private String job;

    public ExpectedPojo(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public ExpectedPojo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "ExpectedPojo{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
/*
 "name": "morpheus",
                "job": ""leader""
 */
