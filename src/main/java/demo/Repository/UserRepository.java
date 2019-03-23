package demo.Repository;

import demo.Entity.Color;
import demo.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u FROM UserEntity u WHERE u.age > :age")
    List<UserEntity> findByAgeGreaterThan(@Param("age") Integer age);

    @Query("SELECT a.userEntity FROM Article a WHERE a.color = :color")
    List<UserEntity> findAllUsersByArticleColor(@Param("color") Color color);



}
