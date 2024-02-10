const btnSubmit = document.querySelector('.btn-submit');
const input = document.querySelector('.to-do-input');
const btnClear = document.querySelector('.btn-clear');
const toDo = document.querySelector('.to-do');
const toDoNr = document.querySelector('.to-do-nr');
const toDoClose = document.getElementsByClassName('to-do-close');
const listContainer = document.querySelector('.to-do-container');

btnSubmit.addEventListener('click', () =>{
     if(input.value.length === 0) alert ('Empty input field');

     else{
        listContainer.innerHTML += `<li class="to-do-font to-do-list to-do-list-${toDoClose.length + 1}">
        <p class="to-do-nr">${(document.getElementsByClassName('to-do-nr').length) +1 }</p>
        <p class="to-do">${innerText = input.value}</p>
        <button class="to-do-btn to-do-close to-do-close-${toDoClose.length + 1}">X</button>
        <button class="to-do-btn to-do-done to-do-done-${toDoClose.length + 1}">Done</button>
    </li>`
    };
});

listContainer.addEventListener('click', (event) => {
    const targetClassList = event.target.classList;
    const match1 = targetClassList.value.match(/to-do-close-(\d+)/);
    const match2 = targetClassList.value.match(/to-do-done-(\d+)/);
    const toDoLists = document.querySelectorAll('.to-do-list');

    if (match1) {
        const toDoListNumber1 = match1[1];
        const toDoListSelector1 = `.to-do-list-${toDoListNumber1}`;
        const toDoList1 = document.querySelector(toDoListSelector1);

        if (toDoList1) {
            toDoList1.remove();
        }
    }

    if (match2) {
        const toDoListNumber2 = match2[1];
        const toDoListSelector2 = `.to-do-done-${toDoListNumber2}`;
        const toDoList2 = document.querySelector(toDoListSelector2);

        if (toDoList2) {
            event.target.style.backgroundColor = '#2ecf25'
        }
    }

    for (let i = 1; i <= toDoLists.length; i++) {
        if (targetClassList.contains(`to-do-done-${i}`)) {
            const toDoList = toDoLists[i - 1];
            
            if (!toDoList.hasAttribute('data-image-added')) {
                toDoList.innerHTML += `<img src="../icons/done.png" class="to-do-img"></img>`;
                toDoList.setAttribute('data-image-added', 'true');
            }
        }
    }
});

btnClear.addEventListener('click', () =>{
    if(document.querySelector('.to-do-list')){
    listContainer.innerHTML -= `<li class="to-do-font to-do-list to-do-list-${toDoClose.length + 1}">
    <p class="to-do-nr"></p>
    <p class="to-do"></p>
    <button class="to-do-btn to-do-close to-do-close-${toDoClose.length + 1}">X</button>
    <button class="to-do-btn to-do-done">Done</button>
</li>`
    listContainer.textContent ='';
    }

    else{
        alert ('Empty list');
    }
});