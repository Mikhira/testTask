package demo.Service;

import demo.DTO.ArticleRequest;
import demo.DTO.ArticleResponce;

import java.io.IOException;
import java.util.List;

public interface ArticleService {

    ArticleResponce save(ArticleRequest articleRequest) throws IOException;

    List<String> findDistinctUserNameWhereArticleCountGreaterThanThree();
}
