// Get the slider element and its slides
const slider = document.querySelector('.slider');
const slides = slider.querySelectorAll('.slide');

// Get the dots element and its dots
const dots = document.querySelector('.dots');
const dotEls = dots.querySelectorAll('.dot');

// Set up variables to keep track of the current slide and its index
let currentSlide = slides[0];
let currentIndex = 0;

// Set up variables to keep track of the previous and next slides
let prevSlide = slides[slides.length - 1];
let nextSlide = slides[1];

// Set up a variable to keep track of whether the slider is currently animating
let isAnimating = false;

// Add an event listener for the mouse wheel
slider.addEventListener('wheel', e => {
  // If the slider is currently animating, don't do anything
  if (isAnimating) {
    return;
  }

  // Calculate the direction of the mouse wheel
  const direction = e.deltaY > 0 ? 'right' : 'left';

  // Set the previous and next slides based on the current index and direction
  if (direction === 'right') {
    prevSlide = currentSlide;
    currentSlide = nextSlide;
    nextSlide = currentIndex === slides.length - 1 ? slides[0] : slides[currentIndex + 1];
    currentIndex = currentIndex === slides.length - 1 ? 0 : currentIndex + 1;
  } else {
    nextSlide = currentSlide;
    currentSlide = prevSlide;
    prevSlide = currentIndex === 0 ? slides[slides.length - 1] : slides[currentIndex - 1];
    currentIndex = currentIndex === 0 ? slides.length - 1 : currentIndex - 1;
  }

  // Set the active class on the current dot
  dotEls.forEach(dotEl => dotEl.classList.remove('active'));
  dotEls[currentIndex].classList.add('active');

  // Animate the slider
  isAnimating = true;
  slider.style.transform = `translateX(${direction === 'right' ? '-' : ''}${slider.clientWidth}px)`;
  slider.addEventListener('transitionend', function transitionEndListener() {
    slider.removeEventListener('transitionend', transitionEndListener);
    slider.style.transform = '';
    prevSlide.style.order = '1';
    currentSlide.style.order = '2';
    nextSlide.style.order = '3';
    isAnimating = false;
  });
});
