package jobportal.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import jobportal.entity.Application;
public interface ApplicationRepository extends JpaRepository<Application, Integer> {
}
