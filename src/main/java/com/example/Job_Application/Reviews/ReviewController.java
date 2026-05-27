package com.example.Job_Application.Reviews;


import com.example.Job_Application.Company.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        List<Review> reviews = reviewService.getAllReviews(companyId);
        return new ResponseEntity<>(reviewService.getAllReviews(companyId),HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReviews(@PathVariable Long companyId ,@RequestBody Review review){
       boolean isReviewSaved =  reviewService.addReview(companyId,review);
       if (isReviewSaved) {
           return new ResponseEntity<>("Review added Successfully", HttpStatus.OK);
       }else {
           return new ResponseEntity<>("Review not added Successfully", HttpStatus.NOT_FOUND);

       }

    }
}
