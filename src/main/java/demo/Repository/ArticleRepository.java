package demo.Repository;


import demo.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(value =
            "SELECT " +
                    "DISTINCT NAME " +
                    "FROM " +
                    "   USER_ENTITY " +
                    "WHERE " +
                    "   ID " +
                    "IN " +
                    "   (SELECT " +
                    "       USER_ID " +
                    "   FROM " +
                    "       ARTICLE " +
                    "   GROUP BY " +
                    "       USER_ID " +
                    "   HAVING " +
                    "       COUNT(*) > 3)", nativeQuery = true)
    List<String> findDistinctUserNameWhereArticleCountGreaterThanThree();

}
