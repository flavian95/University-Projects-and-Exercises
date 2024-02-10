
let percent = document.querySelector('.percent');
let progress = document.querySelector('.progress');
let theText = document.querySelector('.theText');
let count = 4;
let per = 16;
let loading = setInterval(theLoading, 50);

function theLoading(){
  if(count == 100 && per == 400){
    percent.classList.add('text');
    theText.style.display = 'block';
     clearInterval(loading);
  }

  else{
    per = per + 4;
    count = count + 1;
    progress.style.width = per + 'px';
    percent.textContent = count + '%';
  }
}