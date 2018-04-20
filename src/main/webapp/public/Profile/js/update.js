function update(index){
    var buttonId = "#updateButton" + index;
    console.log($(buttonId).attr('name'));


    $(".modal-title").text("This is the title!");
    $("#destinationImage").attr("src", "../Images/rome.jpg");
}
