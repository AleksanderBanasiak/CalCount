let valueDisplays = document.querySelectorAll(".num");
let start = 0;
let i = 1;
valueDisplays.forEach((valueDisplay) => {
    let startValue = 0;
    let endValue = parseInt(valueDisplay.getAttribute("data-val"));
    let counter = setInterval(function () {
        if(endValue > 1400){
            startValue += 8;
        }else if(endValue < 60){
            i++;
            if(i % 5 === 0){
                startValue += 1;
            }
        }else{
            startValue += 1;
        }
        valueDisplay.textContent = startValue;
        if (startValue >= endValue) {
            valueDisplay.textContent = endValue;
            clearInterval(counter);
        }
    });
});
function handleSubmit(event) {
    var clickedButton = event.submitter;
    return clickedButton.name === "submit";
}
var intervalId;

function startChangingValue(nutrient, change) {
    intervalId = setInterval(function() {
        changeValue(nutrient, change);
    }, 80);
}
function stopChangingValue() {
    clearInterval(intervalId);
}
function changeValue(nutrient, change) {
    var nutrientElement = document.querySelector('[data-nutrient="' + nutrient + '"]');
    var kcalElement = document.querySelector('[data-nutrient="kcal"]');
    var currentValue = parseInt(nutrientElement.textContent);
    var currentKcal = parseInt(kcalElement.textContent);

    var kcalIncrement = 4;
    if (nutrient === 'fat') {
        kcalIncrement = 9;
    } else if (nutrient === 'fiber') {
        kcalIncrement = 0;
    }

    var newValue = currentValue + change;
    var newKcal = currentKcal + change * kcalIncrement;

    if (newValue < 0) {
        newValue = currentValue;
        newKcal = currentKcal;
    }

    nutrientElement.textContent = newValue;
    kcalElement.textContent = newKcal;

    var nutrientInput = document.querySelector('input[name="' + nutrient + '"]');
    var kcalInput = document.querySelector('input[name="kcal"]');
    nutrientInput.value = newValue;
    kcalInput.value = newKcal;
}