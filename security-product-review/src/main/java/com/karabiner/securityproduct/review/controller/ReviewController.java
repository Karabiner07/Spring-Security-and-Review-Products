package com.karabiner.securityproduct.review.controller;

import com.karabiner.securityproduct.review.entity.Product;
import com.karabiner.securityproduct.review.entity.Review;
import com.karabiner.securityproduct.review.entity.User;
import com.karabiner.securityproduct.review.repository.ProductRepository;
import com.karabiner.securityproduct.review.repository.UserRepository;
import com.karabiner.securityproduct.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/post/product/{productid}/{string}")
    public Review postReview(
            @CurrentSecurityContext(expression = "authentication?.name") String userName,
            @PathVariable("productid") Long productId,
            @PathVariable("string") String reviewComment

            //@RequestParam String reviewComment
    ) {

        User user = userRepository.findByUserName(userName);
        //User user = userRepository.findByUserId(userid);
        Product product = productRepository.findByProductId(productId);

        Review review = reviewService.createReview(user, product, reviewComment);

        return review;


    }


    @GetMapping("/review/productId/{productId}")
    public List<Review> fetchAllReviewByProductId(@PathVariable("productId") Long productId){
        return reviewService.fetchAllReviewByProductId(productId);
    }

    @GetMapping("review/count/productId/{productId}")
    public ResponseEntity<Long> getReviewCountByProductId(@PathVariable("productId") Long productId) {


        long reviewCount = reviewService.countByProductId(productId);
        return ResponseEntity.ok(reviewCount);
    }

    //@GetMapping
    //public List<Review> fetchAllReviewByProductName

    //@GetMapping
    //public List<Review> fetchAllReviewByProductCode



}
