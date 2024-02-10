let counter = 1;

intervalFunction = setInterval(function (){
   document.getElementById('radio' + counter).checked = true;
   counter++;

    if (counter > 4){
       counter = 1;
    }

}, 3000);

