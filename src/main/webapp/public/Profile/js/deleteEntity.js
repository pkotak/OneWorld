function deleteUser(username){
    console.log("Deleting User");
    var url = 'http://localhost:8080/api/user';

    $.ajax({
        url: url,
        type: 'get',
        data: {username: username},
        success: function (response) {
            console.log(response);
            user = response[0];

            url = 'http://localhost:8080/api/user/' + user.id;

            $.ajax({
                url: url,
                type: 'delete',
                success: function (response) {
                    console.log(response);
                    window.location.reload();


        }
    });
        }

    });
}
