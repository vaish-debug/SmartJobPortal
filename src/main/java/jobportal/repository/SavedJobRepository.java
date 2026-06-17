package jobportal.repository;
import jobportal.entity.SavedJob;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SavedJobRepository
        extends JpaRepository<SavedJob,Integer> {
}
