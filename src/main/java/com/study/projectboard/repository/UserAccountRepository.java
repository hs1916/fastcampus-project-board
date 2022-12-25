package com.study.projectboard.repository;

import com.study.projectboard.domain.Article;
import com.study.projectboard.domain.UserAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

//    Page<Article> findByUserAccount_UserIdContaining(String userId, Pageable pageable);
    UserAccount findByUserId(String userId);
}
