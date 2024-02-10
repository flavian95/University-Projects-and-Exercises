
let navMenu = document.querySelector('.nav-div-menu-bar');
let navMenuToggle1 = document.querySelector('.bar1');
let navMenuToggle2 = document.querySelector('.bar2');
let navMenuToggle3 = document.querySelector('.bar3');

navMenu.addEventListener('click', function(){
    navMenuToggle1.classList.toggle('navActive');
 });

 navMenu.addEventListener('click', function(){
    navMenuToggle2.classList.toggle('navActive');
 });

 navMenu.addEventListener('click', function(){
    navMenuToggle3.classList.toggle('navActive');
 });

