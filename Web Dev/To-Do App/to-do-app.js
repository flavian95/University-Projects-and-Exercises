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

const addedValues = new Set();

function handleButtonClick() {
    const trimmedValue = input.value.trim();
    
    if (trimmedValue.length > 2 && trimmedValue.length < 40) {
        if (addedValues.has(trimmedValue)) {
            showMessage("This value is already added.");
            return; 
        }

        const capitalizedValue = capitalizeFirstLetter(trimmedValue);

        countNr++;

        const subContainer = document.createElement('div');
        subContainer.classList.add('to-do-subcontainer');

        const bodyDiv = document.createElement('div');
        bodyDiv.classList.add('to-do-body');

        const countParagraph = document.createElement('p');
        countParagraph.classList.add('to-do-count');
        countParagraph.textContent = countNr;

        const actHeading = document.createElement('h4');
        actHeading.classList.add('to-do-act');
        actHeading.textContent = capitalizedValue;

        const doneDiv = document.createElement('div');
        doneDiv.classList.add('to-do-done');

        const doneBtn = document.createElement('button');
        doneBtn.classList.add('done-btn', 'btn');
        doneBtn.textContent = 'Done';

        const doneImg = document.createElement('img');
        doneImg.classList.add('to-do-icon');
        doneImg.src = '../icons/done.png';
        doneImg.alt = 'Done';

        bodyDiv.appendChild(countParagraph);
        bodyDiv.appendChild(actHeading);

        doneDiv.appendChild(doneBtn);
        doneDiv.appendChild(doneImg);

        subContainer.appendChild(bodyDiv);
        subContainer.appendChild(doneDiv);

        container.appendChild(subContainer);

        addedValues.add(trimmedValue);

        updateCount();
    } else {
        showMessage("Invalid Input");
    }
}


btn.addEventListener("click", handleButtonClick);

input.addEventListener("keypress", function(event) {
    if (event.key === "Enter") {
        event.preventDefault();
        handleButtonClick();
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