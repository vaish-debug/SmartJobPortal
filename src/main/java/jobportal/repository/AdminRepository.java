package jobportal.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import jobportal.entity.Admin;
public interface AdminRepository
        extends JpaRepository<Admin,Integer> {
    Admin findByUsernameAndPassword(
            String username,
            String password);
}
