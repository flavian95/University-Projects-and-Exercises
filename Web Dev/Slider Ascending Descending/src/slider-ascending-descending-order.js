
const sliderMain = document.querySelector('.slider-main');
const item = document.getElementsByClassName('item');
const btn1= document.querySelector('.btn-1');
const btn2 = document.querySelector('.btn-2');


btn1.addEventListener('click' , function(){
    sliderMain.prepend(item[item.length -1])
})


btn2.addEventListener('click', function() {
    sliderMain.append(item[0]);
});