const btn = document.querySelector(".btn");

function rollDice(){
    const numOfDice= document.getElementById("numOfDice").value;
    const diceResult = document.getElementById("diceResult");
    const diceImg = document.getElementById("diceImg");
    const values = [];
    const images = [];

   for( let i = 0; i < numOfDice; i++){
     const value = Math.floor(Math.random() * 6) + 1;
     values.push(value);
     images.push(`<img src="img/Dice-${value}.png" alt="Dice: ${value}">`);
   }

   diceResult.textContent = `Dice: ${values.join(', ')}`;
   diceImg.innerHTML = images.join(' ');
}

btn.onclick= rollDice;