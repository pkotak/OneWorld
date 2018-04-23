$(document).ready(function(){
    $("#btn_signup").click(function(){

        event.preventDefault();

        var fname = $('#txt_fname').val().trim();
        var lname = $('#txt_lname').val().trim();
        var username = $('#txt_uname').val().trim();
        var address = $('#txt_address').val().trim();
        var email = $('#txt_email').val().trim();
        var phone = $('#txt_phone').val().trim();

        var jsonObj = {firstName:fname,lastName:lname,phoneNumber: phone,
            address: address, email : email, username : username};
        $.ajax({
            url:'http://localhost:8080/api/user',
            type:'get',
            data:{username: username},
            success:function(response){
                console.log(response[0].id);
                $.ajax({
                    url:'http://localhost:8080/api/user/'+response[0].id,
                    type:'put',
                    contentType: "application/json; charset=utf-8",
                    data:JSON.stringify(jsonObj),
                    success:function(response){
                        var msg = "";
                        if(response != null){
                            window.location.reload();
                        }else{
                            msg = "Not Updated";
                        }
                        $("#message").html(msg);
                    }
                });
            }
        });
    });
});

// function getUserFromUsername(uname) {
//     var resp;
//     $.ajax({
//         url:'http://localhost:8080/api/user',
//         type:'get',
//         data:{username: uname},
//         success:function(response){
//             resp = response[0];
//         }
//     });
//     return resp;
// }
