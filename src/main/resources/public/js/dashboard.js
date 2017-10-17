$(document).ready(function() {
    var raw = $.ajax({
        url: "/api/movies/dashboard",
        cache: false,
        success: function (data) {
            console.log(data);
            $("#movies_watched").html(data['watched']);
            $("#movies_unwatched").html(data['unwatched']);
            $("#movies_total").html((data['watched'] + data['unwatched'] ));
        },
        error: function (err) {
            console.log(err);
            toastr["error"](err.responseJSON.join('<br>'));
        }

    })
});
