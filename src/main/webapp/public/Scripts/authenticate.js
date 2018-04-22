
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
        var object = {username : username, password : password};
        var by_pass = 0


        if( username != "" && password != ""){
            $.ajax({
                url:'http://localhost:8080/api/user/login',
                type:'post',
                contentType: "application/json; charset=utf-8",
                data:JSON.stringify(object),
                success:function(response){
                    alert(response);
                    //TODO : set type of user in cookie and username based on response
                    if(response == 2){
                        window.location.replace("../public/Profile/profile.html");
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
