package demo.Controller;



import demo.DTO.UserRequest;
import demo.DTO.UserResponse;
import demo.Entity.UserEntity;
import demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public UserResponse save(@Valid @RequestBody UserRequest userRequest) throws IOException {
        return userService.save(userRequest);
    }

    @GetMapping("/findbyAge/{age}")
    public List<UserEntity> findByAge(@PathVariable("age") Integer age) {
        return userService.findByAge(age);
    }

    @GetMapping("/findByColor")
    public List<UserEntity> findByColor(@RequestParam String color) {
        return userService.findByColor(color);
    }
}
