package demo.Controller;

import demo.DTO.ArticleRequest;
import demo.DTO.ArticleResponce;
import demo.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/save")
    public ArticleResponce save(@Valid @RequestBody ArticleRequest articleRequest) throws IOException {
        return articleService.save(articleRequest);
    }

    @GetMapping("/find/user-names/where/count-greater/three")
    public List<String> findUserNamesWithArticleCountGreaterThanThree() {
        return articleService.findDistinctUserNameWhereArticleCountGreaterThanThree();
    }
}
