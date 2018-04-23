function addToTrips(arg) {
    console.log(arg);
    $.ajax({
        url:'http://localhost:8080/api/user',
        type:'get',
        data:{username : 'jd'},
        success:function(eventManager){
            console.log(eventManager)
            $.ajax({
                url: 'http://localhost:8080/api/trip',
                type: 'post',
                contentType: "application/json; charset=utf-8",
                data: {date : '2018-06-05',eventManager: {id : eventManager.id}, destinations : {id : arg.destinationId}},
                success: function (response) {
                    console.log(JSON.stringify(response));
                }
            });
        }
    });

}