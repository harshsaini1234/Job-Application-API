package com.example.Job_Application.Reviews.Imp;

import com.example.Job_Application.Company.Company;
import com.example.Job_Application.Company.companyService;
import com.example.Job_Application.Reviews.Review;
import com.example.Job_Application.Reviews.ReviewRepository;
import com.example.Job_Application.Reviews.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reviewServiceImple  implements ReviewService {

    private final  ReviewRepository reviewRepository;
    private final companyService compService;


    public reviewServiceImple(ReviewRepository reviewRepository
    ,companyService compService) {
        this.reviewRepository = reviewRepository;
        this.compService=compService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews =reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = compService.getCompanyById(companyId);
        if (company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        else {
            return false;
        }

    }
}
