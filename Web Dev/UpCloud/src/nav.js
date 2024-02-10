
let navBarBtn = document.querySelector('.nav-div-menu-bar');
let navSidebar =document.querySelector('.nav-bar-sidebar');
let navBarButton1 = document.querySelector('.solutions-btn');
let navBarButton2 = document.querySelector('.products-btn');
let navBarButton3 = document.querySelector('.insights-btn');
let navBarButton4 = document.querySelector('.resources-btn');
let navBarButton5 = document.querySelector('.company-btn');
let expandedSolutions1 = document.querySelector('.nav-bar-div-expanded .solutions-show');
let expandedSolutions2 = document.querySelector('.nav-bar-div-expanded .navFirstImg');
let expandedProducts1 = document.querySelector('.nav-bar-div-expanded .products-show-1');
let expandedProducts2 = document.querySelector('.nav-bar-div-expanded .products-show-2');
let expandedProducts3 = document.querySelector('.nav-bar-div-expanded .products-show-3');
let expandedProducts4 = document.querySelector('.nav-bar-div-expanded .products-show-4');
let expandedProducts5= document.querySelector('.nav-bar-div-expanded .navSecondImg');
let expandedInsights1 = document.querySelector('.nav-bar-div-expanded .insights-show');
let expandedInsights2= document.querySelector('.nav-bar-div-expanded .navThirdImg');
let expandedResources1 = document.querySelector('.nav-bar-div-expanded .resources-show');
let expandedResources2= document.querySelector('.nav-bar-div-expanded .navForthImg');
let expandedCompany1 = document.querySelector('.nav-bar-div-expanded .company-show');
let expandedCompany2= document.querySelector('.nav-bar-div-expanded .navFifthImg');

navBarBtn.addEventListener('click', function(){
    // navBarBtn.classList.toggle('click');
   navSidebar.classList.toggle('show');
 });
 
  navBarButton1.addEventListener('click', function(){
    expandedSolutions1.classList.toggle('showSolutions');
    expandedSolutions2.classList.toggle('rotate');
 });

 navBarButton2.addEventListener('click', function(){
   expandedProducts1.classList.toggle('showProducts1');
   expandedProducts2.classList.toggle('showProducts2');
   expandedProducts3.classList.toggle('showProducts3');
   expandedProducts4.classList.toggle('showProducts4');
   expandedProducts5.classList.toggle('rotate');
});

navBarButton3.addEventListener('click', function(){
  expandedInsights1.classList.toggle('showInsights');
  expandedInsights2.classList.toggle('rotate');
});

navBarButton4.addEventListener('click', function(){
  expandedResources1.classList.toggle('showResources');
  expandedResources2.classList.toggle('rotate');
});

navBarButton5.addEventListener('click', function(){
  expandedCompany1.classList.toggle('showCompany');
  expandedCompany2.classList.toggle('rotate');
});