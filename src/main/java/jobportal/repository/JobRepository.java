package jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jobportal.entity.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

    List<Job> findByCategory(String category);
    List<Job> findBySkillsContaining(String skills);
}