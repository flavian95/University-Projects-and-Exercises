const input = document.querySelector(".to-do-input");
const btn = document.querySelector(".to-do-btn");
const clear = document.querySelector(".to-do-clear");
const container = document.querySelector(".to-do-container");
const messageContainer = document.querySelector(".msg-container");
const message = document.querySelector(".message");

function showMessage(msg) {
    message.textContent = msg;
    messageContainer.style.display = "flex";

    setTimeout(() => {
        messageContainer.style.display = "none";
    }, 3000);
}

function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}

let countNr = 0; 

function updateCount() {
    const visibleSubContainers = document.querySelectorAll(".to-do-subcontainer:not([style*='display: none'])");
    countNr = visibleSubContainers.length;

    visibleSubContainers.forEach((subContainer, index) => {
        subContainer.querySelector(".to-do-count").textContent = index + 1;
    });
}

btn.addEventListener("click", () => {
    if (input.value.length > 1 && input.value.length < 40) {
        const capitalizedValue = capitalizeFirstLetter(input.value);

        countNr++;

        const newElement = `<div class="to-do-subcontainer">
        <div class="to-do-body">
           <p class="to-do-count">${countNr}</p>
           <h4 class="to-do-act">${capitalizedValue}</h4>
        </div>
        <div class="to-do-done">
          <button class="done-btn btn">Done</button>
          <img class="to-do-icon" src="../icons/done.png" alt="Done">
        </div>
      </div>`;

        container.insertAdjacentHTML('beforeend', newElement);

        updateCount();
    }

    else{
        showMessage("Invalid Input");
    }
});

container.addEventListener("click", (event) => {
    const doneBtn = event.target.closest(".done-btn");

    if (!doneBtn.clicked) {
        const icon = doneBtn.closest(".to-do-done").querySelector(".to-do-icon");
        const actBody = doneBtn.closest(".to-do-subcontainer").querySelector(".to-do-body");

        icon.style.display = "block";
        doneBtn.textContent = "Clear";
        actBody.style.textDecoration = "line-through";

        doneBtn.clicked = true;

        updateCount();
    } else {
        const subContainer = doneBtn.closest(".to-do-subcontainer");
        subContainer.style.display = "none";

        updateCount();
    }
});

clear.addEventListener("click", () => {
    const theSubContainers = document.querySelectorAll(".to-do-subcontainer");

    theSubContainers.forEach(subContainer => {
        subContainer.style.display = "none";
    });

    countNr = 0;
});

