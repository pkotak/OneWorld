function getAllReviews(place) {
    // place = JSON.stringify(place);
    console.log("Reached reviews: " + place.reviews);
    for (var i = 0 ; i < place.reviews.length ; i ++){
        var review = place.reviews[i];
        console.log(review);

    }

}



