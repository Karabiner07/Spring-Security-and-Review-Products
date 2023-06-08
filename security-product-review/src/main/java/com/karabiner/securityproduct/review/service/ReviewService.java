package com.karabiner.securityproduct.review.service;

import com.karabiner.securityproduct.review.entity.Product;
import com.karabiner.securityproduct.review.entity.Review;
import com.karabiner.securityproduct.review.entity.User;

import java.util.List;

public interface ReviewService {

    public Review createReview(User user, Product product, String Comment);

    public List<Review> fetchAllReviewByProductId(Long productId);

    public Long countByProductId(Long productId);
}
