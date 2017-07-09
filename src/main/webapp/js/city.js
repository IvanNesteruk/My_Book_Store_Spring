
$('#saveMagazine').click(function () {

    var magazine = {
        titleOfMagazine: $('#magazineName').val()
    };

    $('#magazineName').val('');

    $.ajax({

        url: '/magazine?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(magazine),
        success: function (res) {
            var magazinesFromDb = '';

            for (var i in res) {
                magazinesFromDb += '<tr><td id=' + res[i].id + "magazine" + '>' + res[i].titleOfMagazine +
                    '</td><td><button class="btn btn-default updateMagazine '+res[i].id+'" onclick="updateMagazine(' + res[i].id
                    + ')">update</button></td><td><button class="btn btn-default"' +
                    ' id="deleteMagazine" onclick="deleteMagazine(' + res[i].id + ')">delete</button></td></tr>';
            }

            document.getElementById('result').innerHTML = magazinesFromDb;

        },
        error: function (err) {
            console.log(err)
        }
    })
});



function deleteMagazine(idMagazine) {

    $.ajax({

        url: '/magazine?' + $('input[name=csrf_name]').val()
        + "=" + $('input[name=csrf_value]').val(),
        method: 'DELETE',
        data: JSON.stringify(idMagazine),
        success: function (res) {
            var magazinesFromDb = '';
            for (var i in res) {
                magazinesFromDb += '<tr><td id=' + res[i].id + "magazine" + '>' +
                    res[i].titleOfMagazine + '</td><td><button class="btn btn-default updateMagazine '
                    +res[i].id+'" onclick="updateMagazine(' + res[i].id + ')">update</button></td><td><button class="btn btn-default" id="deleteMagazine" onclick="deleteMagazine(' + res[i].id + ')">delete</button></td></tr>';
            }
            document.getElementById('result').innerHTML = magazinesFromDb;
        },
        error: function (err) {
            console.log(err)
        }
    })

}

function loadMagazines() {
    $.ajax({

        url: '/magazine?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        success: function (res) {
            var magazinesFromDb = '';
            for (var i in res) {
                magazinesFromDb += '<tr><td id=' + res[i].id + "magazine" + '>' + res[i].titleOfMagazine +
                    '</td><td><button class="btn btn-default updateMagazine '+res[i].id+'" onclick="updateMagazine(' + res[i].id + ')">update</button></td><td><button class="btn btn-default" id="deleteMagazine" onclick="deleteMagazine(' + res[i].id
                    + ')">delete</button></td></tr>';
            }
            document.getElementById('result').innerHTML = magazinesFromDb;
        },
        error: function (err) {
            console.log(err)
        }
    })

};


function updateMagazine(idMagazine) {

    $.ajax({

        url: '/magazine?' + $('input[name=csrf_name]').val() + "=" +
        $('input[name=csrf_value]').val(),
        method: 'GET',
        success: function (res) {
            var magazinesFromDb = '';
            for (var i in res) {

                if(res[i].id == idMagazine){
                    magazinesFromDb += '<tr><td><input type="text" class="form-control" placeholder="'+res[i].titleOfMagazine+'" id="newMagazineName"></td><td><button class="btn btn-default save" onclick="saveMagazineUpdates(' + res[i].id + ')">save updates</button></td></tr>';
                }else{
                    magazinesFromDb += '<tr><td id=' + res[i].id + "magazine" + '>' + res[i].titleOfMagazine + '</td><td></td></tr>';
                }

            }
            document.getElementById('result').innerHTML = magazinesFromDb;
        },
        error: function (err) {
            console.log(err)
        }
    })
}

loadMagazines();


function saveMagazineUpdates(idMagazine) {

    var newName = $('#newMagazineName').val();

    $.ajax({

        url: '/magazine?' + $('input[name=csrf_name]').val()
        + "=" + $('input[name=csrf_value]').val(),
        method: 'PUT',
        data: newName+'_'+idMagazine,
        success: function (res) {
            var magazinesFromDb = '';

            for (var i in res) {
                magazinesFromDb += '<tr><td id=' +
                    res[i].id + "magazine" + '>' + res[i].titleOfMagazine +
                    '</td><td><button class="btn btn-default updateMagazine '+res[i].id+'" onclick="updateMagazine(' + res[i].id + ')">update' +
                    '</button></td><td><button class="btn btn-default" id="deleteMagazine" onclick="deleteMagazine(' +
                    res[i].id + ')">delete</button></td></tr>';
            }

            document.getElementById('result').innerHTML = magazinesFromDb;

        },
        error: function (err) {
            console.log(err)
        }
    })

}