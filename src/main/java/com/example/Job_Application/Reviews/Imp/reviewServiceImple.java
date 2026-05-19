package com.example.Job_Application.Reviews.Imp;

import com.example.Job_Application.Reviews.Review;
import com.example.Job_Application.Reviews.ReviewRepository;
import com.example.Job_Application.Reviews.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reviewServiceImple  implements ReviewService {

    private ReviewRepository reviewRepository;

    public reviewServiceImple(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews =reviewRepository.findByCompanyId(companyId);
        return reviews;
    }
}
