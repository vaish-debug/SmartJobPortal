package jobportal.controller;
import jobportal.entity.User;
import jobportal.repository.ApplicationRepository;
import jobportal.repository.JobRepository;
import jobportal.repository.UserRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/saveUser")
public String saveUser(
        @Valid @ModelAttribute("user") User user,
        BindingResult result,
        Model model) {
    if(result.hasErrors()) {
        return "register";
    }
    userRepository.save(user);
    model.addAttribute("success",
            "Registration Successful");
    return "register";
}
    @GetMapping("/login")
public String loginPage() {
    return "login";
}
@Autowired
private JobRepository jobRepository;
@PostMapping("/loginUser")
public String loginUser(
        @RequestParam String email,
        @RequestParam String password,
        HttpSession session,
        Model model) {
    User user =
            userRepository.findByEmail(email);
    if(user == null) {
        model.addAttribute(
                "error",
                "User Not Found");
        return "login";
    }
    if(!user.getPassword().equals(password)) {
        model.addAttribute(
                "error",
                "Invalid Password");
        return "login";
    }
    session.setAttribute(
            "loggedUser",
            user);
    if("ADMIN".equalsIgnoreCase(user.getRole())) {
        return "redirect:/dashboard";
    } else {
        return "redirect:/userDashboard";
    }
}
@Autowired
private ApplicationRepository applicationRepository;
@GetMapping("/profile")
public String profilePage(
HttpSession session,
Model model) {
User user =
        (User) session.getAttribute(
                "loggedUser");
if(user == null) {
    return "redirect:/login";
}
model.addAttribute("user", user);
return "profile";
}
@GetMapping("/logout")
public String logout(
HttpSession session) {
session.invalidate();
return "redirect:/login";
}
@GetMapping("/allUsers")
public String allUsers(Model model) {
    model.addAttribute(
            "users",
            userRepository.findAll());
    return "allusers";
}
@GetMapping("/editProfile")
public String editProfile(HttpSession session,
                          Model model) {
    User user =
            (User) session.getAttribute("loggedUser");
    model.addAttribute("user", user);
    return "editprofile";
}
@PostMapping("/updateProfile")
public String updateProfile(
        @ModelAttribute User user,
        HttpSession session) {
    userRepository.save(user);
    session.setAttribute(
            "loggedUser",
            user);
    return "redirect:/profile";
}
}
