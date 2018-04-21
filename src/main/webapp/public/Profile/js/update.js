function update(index){
    var buttonId = "#updateButton" + index;
    var url = 'http://localhost:8080/api/destination/' + (index+1);

    $.ajax({
        url:url,
        type:'get',
        success:function(response) {
            console.log("At update: " + index);
            console.log(response);
            $(".modal-title").text(response.name);
            $("#destinationImage").attr("src", "../Images/rome.jpg");

        }
        });
}
