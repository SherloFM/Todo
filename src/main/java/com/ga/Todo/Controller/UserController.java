package com.ga.Todo.Controller;
import com.ga.Todo.Model.Item;
import com.ga.Todo.Model.Request.LoginRequest;
import com.ga.Todo.Model.User;
import com.ga.Todo.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/auth/user")
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public User register(
            @RequestBody User userObject
    ){
        return userService.createUser(userObject);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        System.out.println("calling loginUser ==>");
        return userService.loginUser(loginRequest);
    }

}
