
const theInput = document.querySelector('.input');
const btnInput = document.querySelector('.btn-input');
const divSearch = document.querySelector('.div-search');
const liSearch = document.querySelector('.li-search');
const iconClose = document.querySelector('.icon-close');
const theValue = input.value;

theInput.addEventListener('click', () =>{
    liSearch.classList.add('liSearchActive')
    divSearch.classList.add('btnInputActive')
    btnInput.classList.add('btnInputDivActive')
});

btnInput.addEventListener('click', () =>{
    liSearch.classList.remove('liSearchActive')
    divSearch.classList.remove('btnInputActive')
    btnInput.classList.remove('btnInputDivActive')
});


function showIcon(){
    const theInput2 = document.querySelector('.input').value;

    if (theInput2.length <= 0) document.body.classList.remove('onChange');
    else document.body.classList.add('onChange');

    iconClose.addEventListener('click', () => {
        document.querySelector('input').value = '';
        document.body.classList.remove('onChange')
    })
}

