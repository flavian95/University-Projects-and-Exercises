let counter = 1;
let slider = document.querySelector('.slider');

theTimeout = setInterval(function(){
   document.getElementById('radio' + counter).checked = true;
   counter++;

    if (counter > 4){
       counter = 1;
    }
}, 3000);


slider.addEventListener('mouseenter', function(){
   clearInterval(theTimeout)
});

slider.addEventListener('mouseleave', function(){
   theTimeout = setInterval(function(){
      document.getElementById('radio' + counter).checked = true;
   counter++;

    if (counter > 4){
       counter = 1;
    }
   }, 3000)
});

