package jobportal.controller;

import jobportal.entity.Job;
import jobportal.entity.SavedJob;
import jobportal.repository.JobRepository;
import jobportal.repository.SavedJobRepository;
import jakarta.servlet.http.HttpSession;
import jobportal.entity.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;
import jobportal.repository.UserRepository;
@Controller
public class JobController {

    @Autowired
    private JobRepository jobRepository;
    @Autowired
private UserRepository userRepository;
    @GetMapping("/addjob")
public String addJobPage(
HttpSession session) {
User user =
        (User) session.getAttribute(
                "loggedUser");

if(user == null ||
   !"ADMIN".equals(user.getRole())) {

    return "redirect:/login";
}

return "addjob";

}
    @PostMapping("/saveJob")
    public String saveJob(Job job) {

        jobRepository.save(job);

        return "redirect:/viewjobs";
    }
    @GetMapping("/viewjobs")
public String viewJobs(Model model) {

    model.addAttribute(
            "jobs",
            jobRepository.findAll());

    return "viewjobs";
}
@GetMapping("/search")
public String searchJobs(
        @RequestParam String keyword,
        Model model) {

    List<Job> jobs = jobRepository.findAll();

    List<Job> result = new ArrayList<>();

    for(Job job : jobs) {

        if(job.getSkills().toLowerCase()
                .contains(keyword.toLowerCase())) {

            result.add(job);
        }
    }

    model.addAttribute("jobs", result);

    return "viewjobs";
}
@GetMapping("/sortSalary")
public String sortSalary(Model model) {

    List<Job> jobs =
            jobRepository.findAll();

    jobs.sort(
        (a,b) ->
        Double.compare(
            b.getSalary(),
            a.getSalary())
    );

    model.addAttribute("jobs", jobs);

    return "viewjobs";
}
@GetMapping("/recommend")
public String recommendJobs(
        Model model) {

    User user =
            userRepository.findAll()
                    .get(userRepository.findAll()
                    .size()-1);

    List<Job> jobs =
            jobRepository.findAll();

    Map<Job,Integer> recommendations =
            new HashMap<>();

    for(Job job : jobs) {

        int match =
                calculateMatch(
                    user.getSkills(),
                    job.getSkills());

        recommendations.put(
                job,
                match);
    }

    model.addAttribute(
            "recommendations",
            recommendations);

    return "recommend";
}
@GetMapping("/deleteJob/{id}")
public String deleteJob(
@PathVariable int id,
HttpSession session){
User user =
        (User) session.getAttribute(
                "loggedUser");

if(user == null ||
   !"ADMIN".equals(user.getRole())) {

    return "redirect:/login";
}

jobRepository.deleteById(id);

return "redirect:/viewjobs";
}
@PostMapping("/uploadResume")
public String uploadResume(
        @RequestParam("file")
        MultipartFile file){

    System.out.println(file.getOriginalFilename());

    return "dashboard";
}
@GetMapping("/editJob/{id}")
public String editJob(@PathVariable Integer id,
                      Model model) {

    Optional<Job> job = jobRepository.findById(id);

    model.addAttribute("job", job.get());

    return "editjob";
}
@PostMapping("/updateJob")
public String updateJob(@ModelAttribute Job job) {

    jobRepository.save(job);

    return "redirect:/viewjobs";
}
@GetMapping("/category")
public String categorySearch(
        @RequestParam String category,
        Model model) {

    model.addAttribute(
            "jobs",
            jobRepository.findByCategory(category));

    return "viewjobs";
}
@Autowired
private SavedJobRepository savedJobRepository;
@GetMapping("/saveJob/{id}")
public String saveJob(
        @PathVariable Integer id) {

    SavedJob savedJob =
            new SavedJob();

    savedJob.setUserId(1);
    savedJob.setJobId(id);

    savedJobRepository.save(savedJob);

    return "redirect:/viewjobs";
}
@GetMapping("/savedJobs")
public String savedJobs(Model model){
    model.addAttribute("savedJobs", savedJobRepository.findAll());
    return "savedjobs";
}
private int calculateMatch(
        String userSkills,
        String jobSkills) {

    String[] user =
            userSkills.toLowerCase().split(",");

    String[] job =
            jobSkills.toLowerCase().split(",");

    int matched = 0;

    for(String u : user) {

        for(String j : job) {

            if(u.trim().equals(j.trim())) {

                matched++;
            }
        }
    }

    return (matched * 100) / user.length;
}
}