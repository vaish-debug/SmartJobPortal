package jobportal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String status = "Pending";
    private Integer userId;
    private Integer jobId;
    private String application;

    public Application() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }
    private String resumeFileName;
    public String getResumeFileName() {
    return resumeFileName;
}

public void setResumeFileName(String resumeFileName) {
    this.resumeFileName = resumeFileName;
}
public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}
}