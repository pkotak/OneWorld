function likeReview(obj) {

    console.log("------------")

    console.log(obj.review);

    var review = {
        description: obj.review.text,
        dateOfReview: "2016-10-02"
    };
    var username = obj.user;
    console.log("------------")

    var url = 'http://localhost:8080/api/user/';

    $.ajax({
        url: url,
        type: 'get',
        data: {username: username},
        success: function (user) {
            console.log(user);

            url = 'http://localhost:8080/api/review/';
            $.ajax({
                url: url,
                type: 'post',
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(review),
                success: function (response) {
                    console.log(response);

                    var like = {
                        user: user[0],
                        review: response
                    };
                    console.log("This is the like");
                    console.log(like);
                    url = 'http://localhost:8080/api/user/review/like';
                    $.ajax({
                        url: url,
                        type: 'post',
                        contentType: "application/json; charset=utf-8",
                        data: JSON.stringify(like),
                        success: function (like_response) {

                            console.log(like_response);
                        }
                    });
                }
            });
        }
    });
}