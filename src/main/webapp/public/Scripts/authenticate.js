
$(document).ready(function() {
    $('#submit').click(function() {

        event.preventDefault(); // prevent PageReLoad
        Cookies.set('name', 'value');
        console.log(Cookies.get('name'));
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
                contentType: "application/json; charset=utf-8",
                data:{username:username,password:password},
                success:function(response){
                    alert('success');
                    if(response == 2){
                        window.location.replace("../success.html");
                        console.log('success 2');
                    }else{
                        msg = "Invalid username and password!";
                        alert(msg);
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