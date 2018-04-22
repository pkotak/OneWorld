function getAllReviews(place) {
    // place = JSON.stringify(place);
    console.log("Reached reviews: " + place.reviews);
    var response = place.reviews;
    var table_body = '<table border="1" id="example" class = "table table-hover"><thead><tr><th>Sr No</th><th>Name</th><th>Text</th><th>Rating</th><th>Time</th><th></th></tr></thead><tbody>';
    for (var i = 0 ; i < place.reviews.length ; i ++){
        table_body+='<tr>';

        table_body +='<td>';
        table_body +=i+1;
        // index += 1;
        table_body +='</td>';
        table_body +='<td>';
        table_body +=response[i].author_name;

        table_body +='</td>';

        table_body +='<td>';
        table_body +=response[i].text;
        table_body +='</td>';

        table_body +='<td>';
        table_body +=response[i].rating;
        table_body +='</td>';

        table_body +='<td>';
        table_body +=response[i].relative_time_description;
        table_body +='</td>';



        table_body +='<td>';

        var buttonId = "updateButton" + i;

        table_body += "<div class='container'><button class='btn .btnView' id="+buttonId+" onclick='update("+i+");' data-toggle='modal' data-target='#product_view'><b>View</b></button></div>";
        table_body +='</td>';
        table_body+='</tr>';
        var review = place.reviews[i];
        console.log(review);

    }
    table_body+='</tbody></table>';
    $("#tableDiv").html(table_body);
}



