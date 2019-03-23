package demo.Service.serviceImpl;

import demo.DTO.ArticleRequest;
import demo.DTO.ArticleResponce;
import demo.Entity.Article;
import demo.Repository.ArticleRepository;
import demo.Repository.UserRepository;
import demo.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ArticleResponce save(final ArticleRequest articleRequest) {
        final Article article = fillArticleEntityUsingDtoData(articleRequest);
        return new ArticleResponce(articleRepository.save(article));
    }

    @Override
    public List<String> findDistinctUserNameWhereArticleCountGreaterThanThree() {
        return articleRepository.findDistinctUserNameWhereArticleCountGreaterThanThree();
    }

    private Article fillArticleEntityUsingDtoData(final ArticleRequest articleRequest) {
        final Article article = new Article();
        article.setText(articleRequest.getText());
        article.setColor(articleRequest.getColor());
        return article;
    }



}
