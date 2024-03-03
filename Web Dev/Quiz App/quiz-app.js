const inputs = document.querySelectorAll(".input");
const header = document.querySelector(".header");
const labels = document.querySelectorAll(".form-label");
const optionList = document.querySelectorAll(".option");
let rightCount = 0;
let wrongCount = 0;

optionList.forEach(option => {
  option.addEventListener("click", () => {
    const label = option.querySelector(".form-label");
    const input = option.querySelector(".input");

    if (label.textContent == "Canada") {
      handleAnswer(option, true);
    } else {
      handleAnswer(option, false);
    }

    if(["rightAnswer", "wrongAnswer"].some(className => option.classList.contains(className))){
      const icon = option.querySelector(".icon");
      setTimeout(() => {
        console.log("End");
        option.classList.remove("rightAnswer");
        option.classList.remove("wrongAnswer");
        input.classList.remove("displayNone");
        icon.classList.add("display");
        quiz2();

        if (label.textContent == "Manilla") {
          handleAnswer(option, true);
        } else {
          handleAnswer(option, false);
        }
      }, 1000);
    }
  });
});

function handleAnswer(option, isCorrect) {
  const answerClass = isCorrect ? "rightAnswer" : "wrongAnswer";
  option.classList.add(answerClass);
  const input = option.querySelector(".input");
  input.classList.add("displayNone");

  const icon = document.createElement("img");
  icon.classList.add("icon");
  icon.src = isCorrect ? "../icons/correct.png" : "../icons/cross.png";
  option.insertBefore(icon, option.firstChild);
}


function quiz2(){
    header.textContent = "What is the capital of the Philippines?";
    labels[0].textContent = "Manilla";
    labels[1].textContent = "Marawi";
    labels[2].textContent = "Jakarta";
    labels[3].textContent = "Dili";

    labels[0].value = "Manilla";
    labels[1].value = "Marawi";
    labels[2].value = "Jakarta";
    labels[3].value = "Dili";
}

// function quiz3(){
//   header.textContent = "The Great Barrier Reef is off the coast of which country?";
//   labels[0].textContent = "South Africa";
//   labels[1].textContent = "Fiji";
//   labels[2].textContent = "New Zealand";
//   labels[3].textContent = "Australia";
//   optionList[3].classList.add("rightAnswer");
// }














// optionList.forEach(option => {
//   option.addEventListener("click", () => {
//     const input = option.querySelector(".input");
//     const label = option.querySelector(".form-label");

//     if (label.textContent == "Canada") {
//       option.classList.add("rightAnswer");
//       input.remove();

//       const icon = document.createElement("img");
//       icon.classList.add("icon");
//       icon.src = "../icons/correct.png";
//       option.insertBefore(icon, option.firstChild);
//     }
//      else {
//       option.classList.add("wrongAnswer");
//       input.remove();

//       const icon = document.createElement("img");
//       icon.classList.add("icon");
//       icon.src = "../icons/cross.png";
//       option.insertBefore(icon, option.firstChild);
//     }
//   });
// });