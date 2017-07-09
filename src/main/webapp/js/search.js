function search() {

    $.ajax({
        url: '/searchItem?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: $('#searchIn').val(),
        success: function (res) {
            var items = '';
            for (var i in res) {
                items += '<tr><td>' + res[i].id + '</td><td>' + res[i].pathImage + '</td><td>' + res[i].titleOfBook + '</td>' + '<td><img src="' + res[i].priceOfBook + '">' + '</td></tr>'
            }
            document.getElementById('searchResult').innerHTML = items;
        }
    })
}

function searchPrices() {
    var prices = [];
    $.ajax({
        url: '/itemSearch?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        success: function (res) {
            for (var i in res) {
                prices.push(res[i].priceOfBook);
            }
            var div, div_2, range_min, range_max;
            range_min = document.getElementById("price-min").value;
            range_max = document.getElementById("price-max").value;
            div = document.getElementById("searchDiv");
            div_2 = div.getElementsByTagName("div");

            for (i = 0; i < div_2.length; i++) {
                for (var j = 0; j < prices.length; j++) {
                    if (prices[j] >= range_min && prices[j] <= range_max) {
                        div_2[j].style.display = "";
                    } else {
                        div_2[j].style.display = "none";
                    }
                }
            }
        },
        error: function (err) {
            console.log(err)
        }
    })
}

function changeLabel() {
    $("#amount").val("$" + document.getElementById("price-min").value + " - $" + document.getElementById("price-max").value);

}