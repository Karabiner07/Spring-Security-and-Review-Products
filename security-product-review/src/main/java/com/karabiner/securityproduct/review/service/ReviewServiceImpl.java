package com.karabiner.securityproduct.review.service;

import com.karabiner.securityproduct.review.entity.Product;
import com.karabiner.securityproduct.review.entity.Review;
import com.karabiner.securityproduct.review.entity.User;
import com.karabiner.securityproduct.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;


    @Override
    public Review createReview(User user, Product product, String comment) {
        if (reviewRepository.existsByUserAndProduct(user, product)){
            throw new ReviewAlreadyExistsExeption("A review already exists for this product by your username");
        }

        Review review = new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setReviewComment(comment);

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> fetchAllReviewByProductId(Long productId) {
        return reviewRepository.findAllReviewByProductId(productId);
    }

    @Override
    public Long countByProductId(Long productId) {
        return reviewRepository.countReviewByProduct_ProductId(productId);
    }
}
