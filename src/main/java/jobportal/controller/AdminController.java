package jobportal.controller;
import jobportal.entity.Admin;
import jobportal.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;
    @GetMapping("/admin")
    public String adminPage() {
        return "adminlogin";
    }
    @PostMapping("/adminLogin")
    public String loginAdmin(
            @RequestParam String username,
            @RequestParam String password) {
        Admin admin =
                adminRepository
                .findByUsernameAndPassword(
                        username,
                        password);
        if(admin != null) {
            return "redirect:/dashboard";
        }
        return "redirect:/admin";
    }
}
