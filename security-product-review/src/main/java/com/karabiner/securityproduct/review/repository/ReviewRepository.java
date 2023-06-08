package com.karabiner.securityproduct.review.repository;

import com.karabiner.securityproduct.review.entity.Product;
import com.karabiner.securityproduct.review.entity.Review;
import com.karabiner.securityproduct.review.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Locale;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    public boolean existsByUserAndProduct(User user, Product product);



    @Query(
            value = "select * from review r where r.product_id = ?1",
            nativeQuery = true
    )
    public List<Review> findAllReviewByProductId(Long productId);


    public Long countReviewByProduct_ProductId(Long productId);

}
