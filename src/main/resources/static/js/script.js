let calcScrollValue = () => {
    let scrollProgress = document.getElementById("progress");
    let progressValue = document.getElementById("progress-value");
    let pos = document.documentElement.scrollTop;
    let calcHeight =
        document.documentElement.scrollHeight -
        document.documentElement.clientHeight;
    let scrollValue = Math.round((pos * 100) / calcHeight);
    if (pos > 100) {
        scrollProgress.style.display = "grid";
    } else {
        scrollProgress.style.display = "none";
    }
    scrollProgress.addEventListener("click", () => {
        document.documentElement.scrollTop = 0;
    });
    scrollProgress.style.background = `conic-gradient(#10AD4F ${scrollValue}%, #edf0f1 ${scrollValue}%)`;
};
window.onscroll = calcScrollValue;
window.onload = calcScrollValue;


document.addEventListener('DOMContentLoaded', function() {
    var hoverTrigger = document.querySelector('.hoverTrigger');
    var infoAboutMe = document.querySelector('.infoAboutMe');

    hoverTrigger.addEventListener('mouseenter', function() {
        infoAboutMe.classList.add('show');
    });

    hoverTrigger.addEventListener('mouseleave', function() {
        infoAboutMe.classList.remove('show');
    });
});


$(function() {
    $('.expandChildTable').on('click', function() {
        var $childRow = $(this).closest('tr').next('.childTableRow');
        $childRow.fadeToggle('slow');
        $(this).toggleClass('selected');
    });
});

