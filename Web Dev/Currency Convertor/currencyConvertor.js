const input = document.querySelector(".currency-input");
const currencyFrom = document.querySelector(".currencyFrom");
const currencyTo = document.querySelector(".currencyTo");
const btn = document.querySelector(".submitBtn");
const container = document.querySelector(".container");

const exchangeRates = {
    "USD_EUR": 1.08,
    "USD_GBP": 1.27,
    "USD_RON": 0.22,
    "EUR_USD": 0.92,
    "EUR_GBP": 1.17,
    "EUR_RON": 0.20,
    "RON_USD": 4.58, 
    "RON_EUR": 4.97,
    "RON_GBP": 5.81,
    "GBP_USD": 0.79,
    "GBP_EUR": 0.86,
    "GBP_RON": 0.17
};

function main(event){
    event.preventDefault();
    const value = exchange();
    result(value);
}

btn.addEventListener("click", main);

input.addEventListener("keypress", function(event) {
    if (event.key === 'Enter') {
        main(event);
    }
});

function exchange() { 
    const inputValue = input.value.trim();
    
    if (!/^\d*\.?\d+$/.test(inputValue)) {
        return "NaN";
    }

    const currencyValue = Number(input.value);
    const from = currencyFrom.value;
    const to = currencyTo.value;
    const exchangeKey = `${from}_${to}`;
    let exchangeValue = exchangeRates[exchangeKey];
    
    exchangeValue = (currencyValue / exchangeValue).toFixed(4);

    if (to == from) {
        exchangeValue = false;
    }

    return exchangeValue;
}

function result(exchangeValue) {
    let resultContainer = document.querySelector(".result-container");
    let resultText = document.querySelector(".result");

    if (!resultContainer) {
        resultContainer = document.createElement("div");
        resultText = document.createElement("p");

        resultContainer.classList.add("result-container", "flex");
        resultText.classList.add("result");

        resultContainer.appendChild(resultText);
        container.appendChild(resultContainer);
    }

    if (exchangeValue === "NaN") {
        resultText.textContent = "Please insert a valid number";
    }
    else if (exchangeValue === "0.0000") {
        resultText.textContent = "Please insert a number greater than zero";
    }
    else if (exchangeValue === false) {
        resultText.textContent = "Please insert a different currency";
    }
    else {
        resultText.textContent = `${input.value} ${currencyFrom.value} is ${exchangeValue} ${currencyTo.value}`;
    }
}