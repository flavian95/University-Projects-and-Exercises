
let elements2 = document.querySelectorAll('.blocks-div-p-header');

for (let i = 0; i < elements2.length; i++){

    elements2[i].onclick  = function(){

      let key2 =elements2[0];

      while (key2){

        if(key2.tagName === "DIV"){

          key2.classList.remove('active-1');
        }
        key2 = key2.nextSibling;
      }

      this.classList.add('active-1')
    };

}