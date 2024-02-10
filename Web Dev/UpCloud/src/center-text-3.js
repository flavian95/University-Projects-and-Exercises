
let elements3 = document.querySelectorAll('.blocks-div-p-header-1');

for (let i = 0; i < elements3.length; i++){

    elements3[i].onclick  = function(){

      let key3 =elements3[0];

      while (key3){

        if(key3.tagName === "DIV"){

          key3.classList.remove('active');
        }
        key3 = key3.nextSibling;
      }

      this.classList.add('active')
    };

}