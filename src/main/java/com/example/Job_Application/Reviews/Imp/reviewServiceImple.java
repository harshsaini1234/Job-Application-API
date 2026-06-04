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

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);

    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if(compService.getCompanyById(companyId)!= null){
            updatedReview.setCompany(compService.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        }else {
        return false;
        }
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if (compService.getCompanyById(companyId)!=null &&
                reviewRepository.existsById(reviewId))
        {
            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            compService.updateCompany(company,companyId);
            reviewRepository.deleteById(reviewId);
            return true;
        }
        else {

        return false;
        }
    }
}
