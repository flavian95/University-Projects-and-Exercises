
const toggleButton = document.getElementsByClassName('toggle-button')[0];
const input = document.getElementsByClassName('input')[0];
const navBarLinks = document.getElementsByClassName('nav-list')[0];
const navIcon  = document.getElementsByClassName('div-icon')[0];
const navBar1 = document.getElementsByClassName('bar1')[0];
const navBar2 = document.getElementsByClassName('bar2')[0];
const nav = document.getElementsByClassName('nav')[0];
const inputDiv = document.getElementsByClassName('input-div')[0];
const divSpace = document.getElementsByClassName('div-space')[0];
const iconSearch = document.getElementsByClassName('icon-search-div')[0];
const theDivSearch = document.getElementsByClassName('div-search')[0];


toggleButton.addEventListener('click', function(){
    navBarLinks.classList.toggle('active')
    navIcon.classList.toggle('activeIcon')
    navBar1.classList.toggle('btnActive1')
    navBar2.classList.toggle('btnActive2')
    nav.classList.toggle('navActive')
    inputDiv.classList.toggle('inputActive')
    divSpace.classList.toggle('divSpaceActive')
    iconSearch.classList.toggle('iconSearchActive')
    theDivSearch.classList.toggle('theDivSearchActive')
});