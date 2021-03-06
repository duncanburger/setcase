// Loading appropriate page bodies
$("#main_content").load('html/dashboard.html');

$("#button_dashboard").click(function(){
    $("#main_content").load('html/dashboard.html');
});

$("#button_movies").click(function(){
    $("#main_content").load('html/movies.html');
});


// Toaster config
toastr.options = {
    "closeButton": false,
    "debug": false,
    "newestOnTop": false,
    "progressBar": false,
    "positionClass": "toast-bottom-full-width",
    "preventDuplicates": false,
    "onclick": null,
    "showDuration": "300",
    "hideDuration": "1000",
    "timeOut": "5000",
    "extendedTimeOut": "1000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
};
