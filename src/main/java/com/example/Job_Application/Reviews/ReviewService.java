package com.example.Job_Application.Reviews;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
}
