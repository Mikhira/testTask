package demo.DTO;

import demo.Entity.Article;
import demo.Entity.Color;

public class ArticleResponce {

    private Long id;
    private String text;
    private Color color;
    private Long idUser;

    public ArticleResponce(Article article) {
        this.id = article.getId();
        this.text = article.getText();
        this.color = article.getColor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
