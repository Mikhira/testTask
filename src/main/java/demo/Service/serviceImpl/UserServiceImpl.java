package demo.Service.serviceImpl;


import demo.DTO.UserRequest;
import demo.DTO.UserResponse;
import demo.Entity.Color;
import demo.Entity.UserEntity;
import demo.Repository.ArticleRepository;
import demo.Repository.UserRepository;
import demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public UserResponse save(final UserRequest userRequest) {
        UserEntity userEntity = fillUserEntityWithDtoData(userRequest);
        return new UserResponse(userRepository.save(userEntity));
    }

    private UserEntity fillUserEntityWithDtoData(final UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userRequest.getName());
        userEntity.setAge(userRequest.getAge());
        userEntity.setArticles(userRequest.getArticles());
        return userEntity;
    }

    public List<UserEntity> findByAge(final Integer age){
        return userRepository.findByAgeGreaterThan(age);
    }

    @Override
    public List<UserEntity> findByColor(final String color) {
        Color enumColor = Color.findByColorValue(color);
        return userRepository.findAllUsersByArticleColor(enumColor);
    }

}
