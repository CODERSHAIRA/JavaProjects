document.addEventListener("DOMContentLoaded", function() {
    const balloonCount = 10;
    const balloonsContainer = document.getElementById("balloons-container");
    let score = 0;
    const scoreElement = document.getElementById("score");
    const popSound = document.getElementById("pop-sound");
  
    const balloonImages = [
      "images/Symbol 100006.png",
      "images/Symbol 100007.png",
      "images/Symbol 100008.png",
      "images/Symbol 100009.png",
      "images/Symbol 1000010.png",
    ];
  
    function createBalloon() {
      const balloon = document.createElement("div");
      balloon.classList.add("balloon");
      const randomIndex = Math.floor(Math.random() * balloonImages.length);
      const balloonImage = balloonImages[randomIndex];
      balloon.style.backgroundImage = `url('${balloonImage}')`;
      balloon.addEventListener("click", function() {
        burstBalloon(balloon);
      });
      return balloon;
    }
  
    function getRandomPosition() {
      const minX = 50;
      const maxX = window.innerWidth - 200;
      const minY = 50;
      const maxY = window.innerHeight - 200;
      const randomX = Math.floor(Math.random() * (maxX - minX + 1) + minX);
      const randomY = Math.floor(Math.random() * (maxY - minY + 1) + minY);
      return { x: randomX, y: randomY };
    }
  
    function addBalloon() {
      const balloon = createBalloon();
      const position = getRandomPosition();
      balloon.style.top = position.y + "px";
      balloon.style.left = position.x + "px";
      balloonsContainer.appendChild(balloon);
    }
  
    function burstBalloon(balloon) {
      balloon.classList.add("burst");
      balloon.removeEventListener("click", burstBalloon);
      popSound.play();
      score++;
      scoreElement.textContent = "Score: " + score;
      setTimeout(() => {
        balloonsContainer.removeChild(balloon);
      }, 500);
    }
  
    function produceBalloon() {
      if (balloonsContainer.children.length < balloonCount) {
        addBalloon();
      }
    }
  
    setInterval(produceBalloon, 1000);
  });
  
  