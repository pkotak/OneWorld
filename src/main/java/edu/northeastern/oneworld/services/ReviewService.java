package edu.northeastern.oneworld.services;

import edu.northeastern.oneworld.models.Destination;
import edu.northeastern.oneworld.models.Owner;
import edu.northeastern.oneworld.models.Review;
import edu.northeastern.oneworld.models.User;
import edu.northeastern.oneworld.repositories.DestinationRepository;
import edu.northeastern.oneworld.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.crypto.Des;

import java.util.Optional;

@RestController
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    DestinationRepository destinationRepository;

    /**
     * Method to create a new review
     * @param review review object
     * @return owner
     */
    @PostMapping("/api/review")
    public Review createOwner(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    /**
     * @param id
     * @param newreview
     * @return
     */
    @PutMapping("/api/review/{rId}")
    public Review updateReview(@PathVariable("rId") int id, @RequestBody Review newreview) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();
//            review.set(newreview);
            return reviewRepository.save(review);
        } else
            return null;
    }

    @DeleteMapping("api/review/{rId}")
    public void deleteReview(@PathVariable("rId") int id){
        reviewRepository.deleteById(id);
    }
}
