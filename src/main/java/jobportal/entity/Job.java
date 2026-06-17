package jobportal.entity;
import jakarta.persistence.*;
@Entity
@Table(name="jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String company;
    private String location;
    private double salary;
    private String skills;
    public Job() {}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id=id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title=title;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company=company;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location=location;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary=salary;
    }
    public String getSkills() {
        return skills;
    }
    public void setSkills(String skills) {
        this.skills=skills;
    }
    private String category;
    public String getCategory() {
    return category;
}
public void setCategory(String category) {
    this.category = category;
}
private String logo;
public String getLogo() {
    return logo;
}
public void setLogo(String logo) {
    this.logo = logo;
}
}
