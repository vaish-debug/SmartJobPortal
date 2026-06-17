package jobportal.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;
import jobportal.entity.User;
import jobportal.repository.ApplicationRepository;
import jobportal.repository.JobRepository;
import jobportal.repository.UserRepository;
@Controller
public class DashboardController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private ApplicationRepository applicationRepository;
    @GetMapping("/dashboard")
    public String dashboard(
            HttpSession session,
            Model model) {
        User user =
                (User) session.getAttribute("loggedUser");
        if(user == null) {
            return "redirect:/login";
        }
        if(!"ADMIN".equalsIgnoreCase(user.getRole())) {
            return "redirect:/userDashboard";
        }
        model.addAttribute(
                "totalUsers",
                userRepository.count());
        model.addAttribute(
                "totalJobs",
                jobRepository.count());
        model.addAttribute(
                "totalApplications",
                applicationRepository.count());
        model.addAttribute(
                "user",
                user);
        return "dashboard";
    }
    @GetMapping("/userDashboard")
    public String userDashboard(
            HttpSession session,
            Model model) {
        User user =
                (User) session.getAttribute("loggedUser");
        if(user == null) {
            return "redirect:/login";
        }
        model.addAttribute(
                "user",
                user);
        return "user-dashboard";
    }
}
