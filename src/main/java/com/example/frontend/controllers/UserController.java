    package com.example.frontend.controllers;

    import com.example.backend.modules.User;
    import com.example.backend.responsitory.UserResponsitory;
    import jakarta.servlet.http.HttpSession;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestMapping;

    import java.time.Instant;
    import java.util.Optional;

    @Controller
    @RequestMapping("/user")
    public class UserController {
        @Autowired
        private UserResponsitory userResponsitory;

        @GetMapping("/login")
        public  String getUserToLogin(Model model){
            model.addAttribute("account",new User());
            return "user/login";
        }
        @GetMapping("/signup")
        public String getUserToSignUp(Model model){
            model.addAttribute("addUser",new User());
            return "user/signup";
        }
        @PostMapping("/addUser")
        public String getAddUser(@ModelAttribute("addUser") User user){
            User user1 = new User(
                    user.getFirstName(),user.getMiddleName(),user.getLastName(),user.getMobile(),
                    user.getEmail(),user.getPasswordHash(), Instant.now(),null,user.getIntro(),"");
            userResponsitory.save(user1);
            return "redirect:/user/login";
        }
        @GetMapping("/login-action")
        public String loginAction(@ModelAttribute("account") User user){
            String url="";
            Optional<User>  op = userResponsitory.getloginAcount(user.getEmail(),user.getPasswordHash());
            System.out.println(op);
            if (op.isPresent()){
                url = "user/home";
            }
            return url;
        }
        @GetMapping("/home")
        public String getHome(){
            return "user/home";
        }
    }
