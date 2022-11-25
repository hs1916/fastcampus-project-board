package com.study.projectboard.service;

import com.study.projectboard.dto.ArticleCommentDto;
import com.study.projectboard.repository.ArticleCommentRepository;
import com.study.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;


    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComment(long articleId) {
        return List.of();
    }

    public void saveArticleComment(ArticleCommentDto dto) {

    }

    public void updateArticleComment(ArticleCommentDto dto) {

    }

    public void deleteArticleComment(Long articleCommentId) {

    }

    public List<ArticleCommentDto> searchArticleComments(Long articleId) {
        return null;
    }
}
