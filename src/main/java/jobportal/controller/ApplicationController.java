package jobportal.controller;

import jobportal.entity.Application;
import jobportal.repository.ApplicationRepository;
import jobportal.repository.JobRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private JobRepository jobRepository;

    @GetMapping("/apply")
    public String applyPage(
            @RequestParam Integer jobId,
            Model model) {

        model.addAttribute("jobId", jobId);

        return "apply";
    }

    @PostMapping("/saveApplication")
public String saveApplication(
        @RequestParam Integer userId,
        @RequestParam Integer jobId,
        @RequestParam("resume") MultipartFile file)
        throws Exception {

    String uploadDir = "uploads/";

    String fileName = file.getOriginalFilename();

    Path path =
            Paths.get(uploadDir + fileName);

    Files.write(path, file.getBytes());

    Application application =
            new Application();

    application.setUserId(userId);
    application.setJobId(jobId);
    application.setResumeFileName(fileName);
    application.setStatus("Applied");
    applicationRepository.save(application);

    return "redirect:/viewapplications";
}

    @GetMapping("/viewapplications")
    public String viewApplications(Model model) {

        model.addAttribute(
                "applications",
                applicationRepository.findAll());

        return "viewapplications";
    }
@GetMapping("/downloadResume/{fileName}")
public ResponseEntity<Resource> downloadResume(
        @PathVariable String fileName)
        throws Exception {

    Path path =
            Paths.get("uploads/" + fileName);

    Resource resource =
            new UrlResource(path.toUri());

    return ResponseEntity.ok()
            .header(
                    HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" +
                            fileName + "\"")
            .body(resource);
}
@GetMapping("/admin-applications")
public String viewApp(Model model) {

    model.addAttribute(
            "applications",
            applicationRepository.findAll());

    return "admin-applications";
}
@GetMapping("/approve/{id}")
public String approve(@PathVariable Integer id) {

    Application app =
            applicationRepository.findById(id).orElse(null);

    if(app != null){
        app.setStatus("Approved");
        applicationRepository.save(app);
    }

    return "redirect:/admin-applications";
}
@GetMapping("/reject/{id}")
public String reject(@PathVariable Integer id) {

    Application app =
            applicationRepository.findById(id).orElse(null);

    if(app != null){
        app.setStatus("Rejected");
        applicationRepository.save(app);
    }

    return "redirect:/admin-applications";
}
}
