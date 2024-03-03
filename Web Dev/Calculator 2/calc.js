
const display = document.querySelector(".display");
const options = document.querySelectorAll(".option");
const clearBtn = document.querySelector(".submit-btn");
let firstNr = null;
let operation = null;

options.forEach(option => {
  option.addEventListener("click", () => {
      let calculatorValue = display.value;

      switch (option.textContent) {
          case "1":
          case "2":
          case "3":
          case "4":
          case "5":
          case "6":
          case "7":
          case "8":
          case "9":
          case "0":
              calculatorValue += option.textContent;
              break;
          case "+":
          case "-":
          case "X":
          case "/":
              if (calculatorValue !== "") {
                  firstNr = parseFloat(calculatorValue);
                  operation = `${option.textContent}`;
                  calculatorValue = "";
              }
              break;
          case "=":
              if (firstNr !== null && calculatorValue !== "") {
                  const secondNr = parseFloat(calculatorValue);

                  if (operation === "+") {
                      calculatorValue = firstNr + secondNr;
                  }

                  if (operation === "-") {
                    calculatorValue = firstNr - secondNr;
                  }

                  if (operation === "X") {
                    calculatorValue = firstNr * secondNr;
                  }

                  if (operation === "/") {
                    calculatorValue = firstNr / secondNr;
                  }

                  firstNr = null;
                  operation = null;
              }
              break;
          case ".":
              if (!calculatorValue.includes(".")) {
                  calculatorValue += ".";
              }
              break;
          default:
              console.log("Error");
      }

      display.value = calculatorValue;
  });
});
