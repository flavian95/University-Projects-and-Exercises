
const key = document.querySelector('.nav-div-menu-bar');
const paragraph = document.querySelector('.nav-toggler-p');

key.addEventListener('click', function handleClick() {
  const initialText = 'Open main menu';

  if (paragraph.textContent.includes(initialText)) {
    paragraph.textContent = 'Close main menu';
  } else {
    paragraph.textContent = initialText;
  }
});



  
