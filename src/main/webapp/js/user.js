
$('#saveUser').click(function () {

    var user = {
        name: $('#userName').val()
    };

    $('#userName').val('');

    $.ajax({

        url: '/user?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(user),
        success: function (res) {
            var usersFromDb = '';

            for (var i in res) {
                usersFromDb += '<table class="table table-hover"><thead>' +
                    '<tr><th>name</th><th>update</th><th id="HIDE">delete</th></tr></thead><tbody id="result"></tbody>' +
                    '</table><tr><td id=' + res[i].id + "user" + '>' + res[i].name +
                    '</td><td><button class="btn btn-default updateMagazine '+res[i].id+'" onclick="updateUser(' + res[i].id
                    + ')">update</button></td><td><button class="btn btn-default"' +
                    ' id="deleteUser" onclick="deleteUser(' + res[i].id + ')">delete</button></td></tr>';
            }

            document.getElementById('result').innerHTML = usersFromDb;

        },
        error: function (err) {
            console.log(err)
        }
    })
});



function deleteUser(idUser) {

    $.ajax({

        url: '/user?' + $('input[name=csrf_name]').val()
        + "=" + $('input[name=csrf_value]').val(),
        method: 'DELETE',
        data: JSON.stringify(idUser),
        success: function (res) {
            var usersFromDb = '';
            for (var i in res) {
                usersFromDb += '<tr><td id=' + res[i].id + "user" + '>' +
                    res[i].name + '</td><td><button class="btn btn-default updateUser '
                    +res[i].id+'" onclick="updateUser(' + res[i].id + ')">update</button></td><td><button class="btn btn-default" id="deleteUser" onclick="deleteUser(' + res[i].id + ')">delete</button></td></tr>';
            }
            document.getElementById('result').innerHTML = usersFromDb;
        },
        error: function (err) {
            console.log(err)
        }
    })

}
loadUsers();

function loadUsers() {

    $.ajax({
        url : 'save.web',
        datatype:'json',
        type: "post",
        contentType: "application/json",
        url: '/user?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        success: function (res) {
            var usersFromDb = '';
            for (var i in res) {
                usersFromDb += '<table class="table table-hover"><thead>' +
                    '<tr><th>name</th><th>update</th><th>delete</th></tr></thead><tbody id="result"></tbody>' +
                    '</table><tr><td id=' + res[i].id + "user" + '>'
                    + res[i].name + '</td><td><button class="btn btn-default updateUser '+res[i].id+'" onclick="updateUser('
                    + res[i].id +
                    ')">update</button></td><td><button class="btn btn-default" id="deleteUser" onclick="deleteUser('
                    + res[i].id
                    + ')">delete</button></td></tr>';
            }
            document.getElementById('result').innerHTML = usersFromDb;
        },
        error: function (err) {
            console.log(err)
        }
    })

};


function updateUser(idUser) {

    $.ajax({

        url: '/user?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        success: function (res) {
            var usersFromDb = '';
            for (var i in res) {

                if(res[i].id == idUser){
                    usersFromDb += '<tr><td><input type="text" class="form-control" placeholder="'+res[i].name+'" id="newUserName"></td><td><button class="btn btn-default save" onclick="saveUserUpdates(' + res[i].id + ')">save updates</button></td></tr>';
                }else{
                    usersFromDb += '<tr><td id=' + res[i].id + "magazine" + '>' + res[i].name + '</td><td></td></tr>';
                }

            }
            document.getElementById('result').innerHTML = usersFromDb;
        },
        error: function (err) {
            console.log(err)
        }
    })
}




function saveUserUpdates(idUser) {

    var newName = $('#newUserName').val();

    $.ajax({

        url: '/user?' + $('input[name=csrf_name]').val()
        + "=" + $('input[name=csrf_value]').val(),
        method: 'PUT',
        data: newName+'_'+idUser,
        success: function (res) {
            var usersFromDb = '';

            for (var i in res) {
                usersFromDb += '<table class="table table-hover"><thead>' +
                    '<tr><th>name</th><th>update</th><th id="HIDE">delete</th></tr></thead><tbody id="result"></tbody>' +
                    '</table><tr><td id=' +
                    res[i].id + "magazine" + '>' + res[i].name +
                    '</td><td><button class="btn btn-default updateUser '+res[i].id+'" onclick="updateUser(' + res[i].id + ')">update' +
                    '</button></td><td><button class="btn btn-default" id="deleteMagazine" onclick="deleteUser(' +
                    res[i].id + ')">delete</button></td></tr>';
            }

            document.getElementById('result').innerHTML = usersFromDb;

        },
        error: function (err) {
            console.log(err)
        }
    })

}
