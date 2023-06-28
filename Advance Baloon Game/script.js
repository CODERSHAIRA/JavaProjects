window.onload = function() {
    var airFiller = document.querySelector(".air-filler");
    var gameContainer = document.getElementById("game-container");
    var isFilling = false;

    airFiller.addEventListener("click", function() {
        if (!isFilling) {
            isFilling = true;
            fillBalloons();
        }
    });

    gameContainer.addEventListener("click", function(event) {
        var target = event.target;
        if (target.classList.contains("filled")) {
            target.classList.remove("filled");
            target.style.animation = "none";
            setTimeout(function() {
                target.parentNode.removeChild(target);
            }, 500);
        }
    });

    function fillBalloons() {
        var balloon = document.createElement("div");
        balloon.className = "balloon";
        balloon.style.backgroundColor = getRandomColor();
        gameContainer.appendChild(balloon);
        balloon.classList.add("filled");
        balloon.style.animation = "fly-animation 5s infinite linear";

        var nextBalloonTimeout = Math.floor(Math.random() * 3000) + 1000;
        setTimeout(function() {
            fillBalloons();
        }, nextBalloonTimeout);
    }

    function getRandomColor() {
        var letters = "0123456789ABCDEF";
        var color = "#";
        for (var i = 0; i < 6; i++) {
            color += letters[Math.floor(Math.random() * 16)];
        }
        return color;
    }
};
