package demo.DTO;

import demo.Entity.Article;

import java.util.ArrayList;
import java.util.List;

public class UserRequest {

    private String name;

    private int age;

    private List<Article> articles = new ArrayList<>();

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

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
