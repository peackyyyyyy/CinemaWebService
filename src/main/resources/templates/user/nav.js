$(function () {
    var bar = '';
    bar += '<nav class="navbar navbar-default" role="navigation">';
    bar += '<div className="collapse navbar-collapse" id="navbarSupportedContent">';
    bar += '<ul className="navbar-nav mr-auto">';
    bar += '<li className="nav-item">';
    bar += '<a className="nav-link active" aria-current="page" href="http://localhost:8080/admin">Moncine</a>';
    bar += '</li>';;
    bar += '</ul>';
    bar += '</div>';
    bar += '</nav>';

    $("#main-bar").html(bar);

    var id = getValueByName("id");
    $("#" + id).addClass("active");
});

function getValueByName(name) {
    var url = document.getElementById('nav').getAttribute('src');
    var param = new Array();
    if (url.indexOf("?") != -1) {
        var source = url.split("?")[1];
        items = source.split("&");
        for (var i = 0; i < items.length; i++) {
            var item = items[i];
            var parameters = item.split("=");
            if (parameters[0] == "id") {
                return parameters[1];
            }
        }
    }
}