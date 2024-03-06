function changeColorAndRedirect(event, link) {
    link.style.transition = "background-color 0.3s ease";
    link.style.backgroundColor = "#10AD4F";
    setTimeout(function() {
        window.location.href = link.getAttribute("href");
    }, 300);
    event.preventDefault();
}

document.addEventListener("DOMContentLoaded", function () {
    const radioOptions1 = document.querySelectorAll('.radio-option');
    const radioOptions2 = document.querySelectorAll('.radio-option2');

    function checkRadioOptions(radioOptions) {
        radioOptions.forEach(function(radioOption) {
            const radioInput = radioOption.querySelector('input[type="radio"]');
            if (radioInput.checked) {
                radioOption.classList.add('selected');
            }
        });
    }

    checkRadioOptions(radioOptions1);
    checkRadioOptions(radioOptions2);

    function handleRadioOptionClick(radioOptions) {
        radioOptions.forEach(function(radioOption) {
            radioOption.addEventListener("click", function () {
                const radioInput = radioOption.querySelector('input[type="radio"]');
                radioInput.checked = true;
                if (radioInput.checked) {
                    radioOptions.forEach(function(option) {
                        option.classList.remove('selected');
                    });
                    radioOption.classList.add('selected');
                }
            });
        });
    }

    handleRadioOptionClick(radioOptions1);
    handleRadioOptionClick(radioOptions2);
});


