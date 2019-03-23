package demo.Service;

import demo.DTO.UserRequest;
import demo.DTO.UserResponse;
import demo.Entity.UserEntity;

import java.io.IOException;
import java.util.List;

public interface UserService {

    UserResponse save(UserRequest userRequest) throws IOException;

    List<UserEntity> findByAge(Integer age);

    List<UserEntity> findByColor(String color);
}
