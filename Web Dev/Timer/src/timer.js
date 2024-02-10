
let output = document.querySelector('.header');
let isPaused = false;
let time = 0;
let t = window.setInterval(function() {
  if(!isPaused) {
    time++;
    output.textContent =("Seconds: " + time);
  }
}, 1000);



document.querySelector('.pause').addEventListener('click', function(e) {
  e.preventDefault();
  isPaused = true;
});



document.querySelector('.play').addEventListener('click', function(e) {
  e.preventDefault();
  isPaused = false;
});