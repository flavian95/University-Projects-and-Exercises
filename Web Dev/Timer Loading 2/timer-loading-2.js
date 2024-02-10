let i = 0;
let elem = document.getElementById("myBar");
let button = document.querySelector('.button');
let text = document.querySelector('.text');
let width = 1;

  function move() {
  if (i == 0) {
    i = 1;
    let id = setInterval(frame, 10);
    function frame() {

      if (width >= 100) {
        clearInterval(id);
        text.classList.toggle('active');
        i = 0;
      } 
      
      else {
        width++;
        elem.style.width = width + "%";
      }
    }
  }
}

move();