package com.study.projectboard.repository;

import com.study.projectboard.config.JpaConfig;
import com.study.projectboard.domain.Article;
import com.study.projectboard.domain.UserAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@ActiveProfiles("testdb")
@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;
    private final UserAccountRepository userAccountRepository;


    @Autowired
    public JpaRepositoryTest(ArticleRepository articleRepository, ArticleCommentRepository articleCommentRepository, UserAccountRepository userAccountRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
        this.userAccountRepository = userAccountRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void givenWhenThen() {
        //given
        long previousCount = articleRepository.count();
        UserAccount userAccount = userAccountRepository.save(
                UserAccount.of("heecha1", "password", null, null, null)
        );
        Article article = Article.of(userAccount, "new Article", "new content", "#spring");


        //when
        articleRepository.save(article);

        // then
        assertThat(articleRepository.count()).isEqualTo(previousCount + 1);
    }

    @DisplayName("insert 테스트")
    @Test
    void givenWhenThenInsert() {
        //given
        long previousCount = articleRepository.count();
        UserAccount userAccount = userAccountRepository.save(
                UserAccount.of("heechan", "password", null, null, null)
        );
        Article article = Article.of(userAccount, "new article", "new content", "#spring");


        //when
        Article savedArticle = articleRepository.save(article);


        //then
        assertThat(articleRepository.count()).isEqualTo(previousCount + 1);
    }

    @DisplayName("update 테스트")
    @Test
    void givenWhenThenUpdate() {
        //given
        Article article = articleRepository.findById(1L).orElseThrow();
        String updateHashtag = "#springboot";
        article.setHashtag(updateHashtag);

        //when
        Article savedArticle = articleRepository.saveAndFlush(article);

        //then
        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag", updateHashtag);
    }

    @DisplayName("delete 테스트")
    @Test
    void givenWhenThenDelete() {
        //given
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousArticleCount = articleRepository.count();
        long previousArticleCommentCount = articleCommentRepository.count();
        int deletedCommentSize = article.getArticleComments().size();

        //when
        articleRepository.delete(article);

        //then
        assertThat(articleRepository.count()).isEqualTo(previousArticleCount - 1);
        assertThat(articleCommentRepository.count()).isEqualTo(previousArticleCommentCount - deletedCommentSize);
    }


}
