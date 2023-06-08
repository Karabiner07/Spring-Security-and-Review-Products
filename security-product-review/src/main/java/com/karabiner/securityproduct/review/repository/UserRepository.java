package com.karabiner.securityproduct.review.repository;

import com.karabiner.securityproduct.review.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserName(String userName);

    User findByUserName(String userName);

    User findByUserId(Long userid);
}
