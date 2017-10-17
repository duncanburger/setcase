var table =
    $('#movieTable').DataTable({
        "ajax":  {"url":"/api/movies/","dataSrc":""},
        "columns": [
            { "data": "movieId" },
            { "data": "title"},
            { "data": "watched" }
        ],
        "columnDefs": [
            {
                "targets": [0],
                "visible": false,
                "searchable": false
            }
        ],
        "order": [[0, 'desc']],
        "pageLength": 10,
        "bLengthChange": false,
        "language": {
            "info": "Showing movies _START_ to _END_ of _TOTAL_ "
        }
    } );


function handleMovie(type) {

    var watched = ($("#watched").val() == true) ? 1 : 0 ;

    var obj = {
        movieId:     $("#movieId").val(),
        title:       $("#title").val(),
        watched:     watched
    };

    console.log(obj);

    var params = {
        url: "api/movies/",
        data: JSON.stringify(obj),
        contentType: "application/json; charset=utf-8"
    };

    switch (type) {
        case 'post':

            params.type = "POST";
            params.success = function (result) {
                console.log(result);
                // toggle modal
                $("#movieModal").modal('toggle');
                table.ajax.reload();
                toastr["success"]('Movie ' + result["title"] + ' added to your watchlist.');

            };
            params.error = function (err) {
                console.log(err);
                toastr["error"](err.responseJSON.join('<br>'));
            };

            break;

        case 'update':
            params.type = "PUT";
            params.success = function (result) {
                console.log(result);
                // toggle modal
                $("#movieModal").modal('toggle');
                // Refresh DataTable
                table.ajax.reload();
                toastr["success"]('Movie ' + result["title"] + ' updated on your watchlist.');
            };
            params.error = function (err) {
                console.log(err);
                toastr["error"](err.responseJSON.join('<br>'));

            };
            break;

        case 'delete':
            params.type = "DELETE";
            params.success = function (result) {
                console.log(result);
                // Toggle modal
                $("#movieModal").modal('toggle');
                // Reload DataTable
                table.ajax.reload();
                toastr["success"]('Movie ' + result["title"] + ' deleted from your watchlist.')

            };
            params.error = function (err) {
                console.log(err);
                toastr["error"](err.responseJSON.join('<br>'));
            };
            break;

    }
    $.ajax(params);
}


// Show modal for updating movies
$('#movieTable tbody').on('click', 'tr', function () {
    var data = table.row(this).data();
    console.log(data);
    showMovieModal('modify', data);
});

// Show modal for adding movies
$('#addMovieButton').on('click', function () {
    showMovieModal('add');
});

function showMovieModal(format, data) {
    // Populates inputfields and buttons based on format (String)
    // data is optional.
    switch (format) {
        case 'modify':

            // populate form
            $.each(data, function (key, value) {
                $('#addMovie').find("input[id='" + key + "']").val(value);
            });

            // initialize title and buttons
            $('#modalLabel').html('Edit movie');
            $('#movieDeleteButton').show();
            $('#movieSaveButton').show();
            $('#movieAddButton').hide();
            break;

        default:
            // empty form
            $(':input', '#addMovie')
                .not(':button, :submit, :reset')
                .val('');
            $("#watched").val(0);




            // initialize title and buttons
            $('#modalLabel').html('Add new movie');
            $('#movieDeleteButton').hide();
            $('#movieSaveButton').hide();
            $('#movieAddButton').show();
            break;
    }

    // init checkbox & show modal
    initCheckbox();
    $("#movieModal").modal('toggle');
}

$('#watchedCheckbox').on('click', function () {
    if( $("#watched").val() === 0 ){
        $("#watched").val("1");
    }else{
        $("#watched").val("0");
    }
});

function initCheckbox(){
    // Function to check/uncheck the checkbox based on the hidden field (#watched)'s value
    // The unchecking is not yet working.
    // (might be bootstrap issue)
    //
    if( $("#watched").val() === 0 ){
        $("watchedCheckbox").removeClass("active");
        console.log("should be unchecked now");
    }else{
        $("watchedCheckbox").addClass("active");
        console.log("should be checked now");
    }
}
