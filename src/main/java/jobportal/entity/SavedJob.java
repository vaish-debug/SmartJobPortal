package jobportal.entity;
import jakarta.persistence.*;
@Entity
@Table(name="saved_jobs")
public class SavedJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer jobId;
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
}
