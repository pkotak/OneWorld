function addToTrips(arg) {
    console.log(arg);
    $.ajax({
        url:'http://localhost:8080/api/user',
        type:'get',
        data:{username : 'jd'},
        success:function(eventManager){
            console.log("THis is event manager");
            console.log(eventManager);
            eventManager = eventManager[0];
            console.log(eventManager.id);
            console.log(arg.destinationId);
            console.log("-------------------------------------");
            var obj = {eventManager: {id : eventManager.id}, destination : {id : arg.destinationId}};
            console.log(obj);
            $.ajax({
                url: 'http://localhost:8080/api/trip',
                type: 'post',
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(obj),
                success: function (response) {
                    console.log(response);
                }
            });
        }
    });
}




function getMyTrips(arg) {
    console.log(arg);
       $.ajax({
            url:'http://localhost:8080/api/trip',
            type:'get',
            success:function(response){
                var table_body = '<table border="1" id="example" class = "table table-hover"><thead><tr><th>Sr No</th><th>Name</th><th>City</th><th>Country</th><th>Website</th><th></th></tr></thead><tbody>';

                for(var i = 0; i < response.length; i++){
                    table_body+='<tr>';


                    table_body +='<td>';
                    table_body +=i+1;
                    // index += 1;
                    table_body +='</td>';
                    table_body +='<td>';
                    table_body +=response[i].name;

                    table_body +='</td>';

                    table_body +='<td>';
                    table_body +=response[i].city;
                    table_body +='</td>';

                    table_body +='<td>';
                    table_body +=response[i].country;
                    table_body +='</td>';

                    table_body +='<td>';
                    table_body +=response[i].websiteLink;
                    table_body +='</td>';



                    table_body +='<td>';

                    var buttonId = "updateButton" + i;

                    table_body += "<div class='container'><button class='btn .btnView' id="+buttonId+" onclick='updateUser("+i+");' data-toggle='modal' data-target='#product_view'><b>View</b></button></div>";
                    table_body +='</td>';
                    table_body+='</tr>';
                }
                table_body+='</tbody></table>';
                $("#tableDiv").html(table_body);
            }
        });

        // for search function.................................. only............................
        $("#search").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $("table tr").filter(function(index) {
                if(index>0){
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                }
            });
        });
    }

