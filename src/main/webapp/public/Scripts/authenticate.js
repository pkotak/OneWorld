
$(document).ready(function() {
    $('#submit').click(function() {

        event.preventDefault(); // prevent PageReLoad
        // console.log(1)
        console.log($('#username').val());
        console.log($('#password').val());

        var ValidEmail = $('#username').val() === 'jay'; // User validate
        var ValidPassword = $('#password').val() === 'jay'; // Password validate

        var username = $("#username").val().trim();
        var password = $("#password").val().trim();
        var msg = "";

        var by_pass = 0

        if( username != "" && password != ""){
            $.ajax({
                url:'http://localhost:8080/api/user/login',
                type:'post',
                data:{username:username,password:password},
                success:function(response){


                    if(response > 0){
                        // window.location.replace("../success.html");
                        console.log(response);
                       }
                    else {
                        // $('.error').css('display', 'block'); // show error msg
                        console.log('error');
                    }
                }
            });
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