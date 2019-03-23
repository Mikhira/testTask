package demo.DTO;

import demo.Entity.Article;
import demo.Entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserResponse {

    private Long id;
    private String name;
    private int age;

    private List<ArticleResponce> articleResponces = new ArrayList<>();

    public UserResponse(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.age = userEntity.getAge();

        for(Article article : userEntity.getArticles()){
            ArticleResponce articleResponce = new ArticleResponce(article);
            articleResponces.add(articleResponce);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<ArticleResponce> getArticleResponces() {
        return articleResponces;
    }

    public void setArticleResponces(List<ArticleResponce> articleResponces) {
        this.articleResponces = articleResponces;
    }
}
