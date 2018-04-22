
$(document).ready(function() {
    $('#submit').click(function() {

        event.preventDefault(); // prevent PageReLoad

        // console.log(1)
        console.log($('#username').val());
        console.log($('#password').val());


        var username = $("#username").val().trim();
        var password = $("#password").val().trim();



        var msg = "";
        var object = {username : username, password : password};
        var by_pass = 0


        if( username != "" && password != ""){
            console.log("In if");
            $.ajax({
                url:'http://localhost:8080/api/user/login',
                type:'post',
                contentType: "application/json; charset=utf-8",
                data:JSON.stringify(object),
                success:function(response){

                    if(response == 2){
                        console.log(response);
                        $.cookie("name", username);
                        $.cookie("type", response);

                        window.location.href = "../public/Profile/user-profile.html";
                        console.log('success 2');
                    }else{
                        msg = "Invalid username and password!";
                        console.log(msg);

                    }
                }
            });
        }
        else{
            console.log("Error elese")
        }

    });
});


// $(document).ready(function() {
//     //$('#username').focus();
//
//     $('#submit').click(function() {
//
//         event.preventDefault(); // prevent PageReLoad
//
//         var ValidEmail = $('#username').val() === 'jay'; // User validate
//         var ValidPassword = $('#password').val() === 'jay'; // Password validate
//         console.log($('#username').val());
//         console.log($('#password').val());
//         if (ValidEmail === true && ValidPassword === true) { // if ValidEmail & ValidPassword
//
//             window.location = "../public/success.html"; // go to home.html
//
//         }
//         else {
//             window.location = "../public/error.html";
//
//         }
//     });
// });
