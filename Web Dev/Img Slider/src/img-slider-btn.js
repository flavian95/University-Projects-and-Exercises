let counter = 1;
let slider = document.querySelector('.slides');
let image = document.querySelector('.start-stop-btn-img');
let imageContainer = document.querySelector('.start-stop-btn');
let img = document.getElementsByClassName('start-stop-btn-img')[0];
let imgContainer = document.getElementsByClassName('start-stop-btn')[0];
let btn = document.querySelector('.start-stop-btn');
let clicked = false;

function setHoverInterval(){
   document.getElementById('radio' + counter).checked = true;
   counter++;

 if (counter > 4){
    counter = 1;
 }
}

firstTimeout =setInterval(setHoverInterval, 3000);
setHoverInterval();


imageContainer.addEventListener('click', function(){

   if(!clicked){  
      clearInterval(firstTimeout);
   }

   else{
      firstTimeout =setInterval(setHoverInterval, 3000); 
   }

   clicked = !clicked
});

slider.addEventListener('mouseenter', function () {
   clearInterval(firstTimeout);
});

slider.addEventListener('mouseleave', function () {
   firstTimeout =setInterval(setHoverInterval, 3000);
});

imgContainer.addEventListener('click', function(){
   img.classList.toggle('btnActive');
});