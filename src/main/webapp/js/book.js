/**
 * Created by User on 26.06.2017.
 */

/**
 * Created by User on 20.06.2017.
 */

$('#saveBook').click(function () {

    var book = {
        name: $('#bookTitle').val()
    };

    $('#bookTitle').val('');

    $.ajax({

        url: '/book?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(book),
        success: function (res) {
            var booksFromDb = '';

            for (var i in res) {
                booksFromDb += '<tr>' +
                    '<td id=' + res[i].id + "book" + '>' + res[i].titleOfBook + '</td>' +
                    '<td id=' + res[i].id + "book" + '>' + res[i].priceOfBook + '</td>' +
                    '<td id=' + res[i].id + "book" + '>' + res[i].nameOfAuthor + '</td>' +
                    '<td id=' + res[i].id + "book" + '>' + res[i].surnameOfAuthor + '</td>' +
                    '<td id=' + res[i].id + "book" + '>' + res[i].yearOfPublishing + '</td>' +
                    '<td id=' + res[i].id + "book" + '>' + res[i].pathImage + '</td>'
                '></td><td><button class="btn btn-default updateBook ' + res[i].id + '" onclick="updateBook(' + res[i].id
                + ')">update</button></td><td><button class="btn btn-default"' +
                ' id="deleteBook" onclick="deleteBook(' + res[i].id + ')">delete</button></td></tr>';
            }

            document.getElementById('result').innerHTML = booksFromDb;

        },
        error: function (err) {
            console.log(err)
        }
    })
});


function deleteUser(idBook) {

    $.ajax({

        url: '/book?' + $('input[name=csrf_name]').val()
        + "=" + $('input[name=csrf_value]').val(),
        method: 'DELETE',
        data: JSON.stringify(idBook),
        success: function (res) {
            var booksFromDB = '';
            for (var i in res) {
                booksFromDB += '<tr><td id=' + res[i].id + "book" + '>' +
                    res[i].titleOfBook + '</td><td><button class="btn btn-default updateUser '
                    + res[i].id + '" onclick="updateUser(' + res[i].id + ')">update</button></td><td><button class="btn btn-default" id="deleteBook" onclick="deleteBook(' + res[i].id + ')">delete</button></td></tr>';
            }
            document.getElementById('result').innerHTML = booksFromDB;
        },
        error: function (err) {
            console.log(err)
        }
    })

}
loadBooks();

function loadBooks() {

    $.ajax({
        url: 'save.web',
        datatype: 'json',
        type: "post",
        contentType: "application/json",
        url: '/book?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        success: function (res) {
            var usersFromDb = '';
            for (var i in res) {
                usersFromDb += '<tr><td id=' + res[i].id + "user" + '>'
                    + res[i].name + '</td><td><button class="btn btn-default updateUser ' + res[i].id + '" onclick="updateUser('
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


function updateBook(idBook) {

    $.ajax({

        url: '/book?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        success: function (res) {
            var booksFromDb = '';
            for (var i in res) {

                if (res[i].id == idUser) {
                    booksFromDb += '<tr><td><input type="text" class="form-control" placeholder="' + res[i].name + '" id="newUserName"></td><td><button class="btn btn-default save" onclick="saveUserUpdates(' + res[i].id + ')">save updates</button></td></tr>';
                } else {
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
        data: newName + '_' + idUser,
        success: function (res) {
            var usersFromDb = '';

            for (var i in res) {
                usersFromDb += '<tr><td id=' +
                    res[i].id + "magazine" + '>' + res[i].name +
                    '</td><td><button class="btn btn-default updateUser ' + res[i].id + '" onclick="updateUser(' + res[i].id + ')">update' +
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

