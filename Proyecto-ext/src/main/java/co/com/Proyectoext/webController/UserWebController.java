package co.com.Proyectoext.webController;

import co.com.Proyectoext.entity.User;
import co.com.Proyectoext.repository.UserRepository;
import co.com.Proyectoext.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserWebController {
    @Autowired
    private UserService UserService;
    @Autowired
    private UserRepository userRepository;
    private UserRepository UserRepository;

    public UserWebController(co.com.Proyectoext.service.impl.UserService userService, co.com.Proyectoext.repository.UserRepository userRepository, co.com.Proyectoext.repository.UserRepository userRepository1) {
        UserService = userService;
        this.userRepository = userRepository;
        UserRepository = userRepository1;
    }

    @GetMapping("/user")
    public String home(Model model) {
        model.addAttribute("user", UserService.getAllUsers());
        return "user";
    }


    @GetMapping("/user/new")
    public String createUserForm(Model model){



        User user = new User();

        model.addAttribute("user", user);


        return "create_user";
    }

    @PostMapping("/user")
    public String saveUser (@ModelAttribute("user") User user) {
        UserService.createUser(user);
        return "redirect:/user";
    }
    @GetMapping("/user/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        User st = UserService.getUserById(id);

        model.addAttribute("user", st);


        return "edit_user";
    }
    @PostMapping("/user/{id}")
    public String updateUser(@PathVariable Long id,
                                @ModelAttribute("user")User user,
                                Model model) {
        //sacar el esudiante de la b.d. por el id

        User existentUser = UserService.getUserById(id);
        // cargarlo
        existentUser.setId(id);
        existentUser.setFirstName(user.getFirstName());
        existentUser.setLastName(user.getLastName());
        existentUser.setEmail(user.getEmail());


        // guardar el estudiante actualizado
        UserService.updateUser(existentUser);

        return "redirect:/user";
    }
    @GetMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        UserService.deleteUser(id);
        return "redirect:/user";
    }
}
