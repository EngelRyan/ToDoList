package br.com.engelryan.todolist.User;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/view")
    public String view(){
        return "view";
    }

    @GetMapping("/viewusers")
    public List<UserModel> viewUsers(){
        return userRepository.findAll();
    }

    @DeleteMapping("/delete")
    public void delete(){
        userRepository.deleteAll();
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody UserModel userModel){

        if(userRepository.findByUsername(userModel.getUsername()) != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
        }
        var passwordHashed = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());
        userModel.setPassword(passwordHashed);

        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(userModel));
    }
}
