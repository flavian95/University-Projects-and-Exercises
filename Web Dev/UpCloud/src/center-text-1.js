
let elements1 = document.querySelectorAll('.blocks-div-p');

for (let i = 0; i < elements1.length; i++){

    elements1[i].onclick  = function(){

      let key1 =elements1[0];

      while (key1){

        if(key1.tagName === "DIV"){

          key1.classList.remove('active');
        }
        key1 = key1.nextSibling;
      }

      this.classList.add('active')
    };

}


