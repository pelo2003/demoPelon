package SpringbootAPI.SpringbootAPI.api.Controller;

import SpringbootAPI.SpringbootAPI.api.model.User;
import SpringbootAPI.SpringbootAPI.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
     private UserService userService;
     @Autowired
     public UserController(UserService userService){
         this.userService = userService;
     }
    @GetMapping
    public User getUser(@RequestParam  Integer id) {
         Optional <User> user = userService.getUser(id);
         if(user.isPresent()){
             return (User) user.get();
         }
        return null;
    }
}