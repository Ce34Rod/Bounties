document.addEventListener("DOMContentLoaded", function() {
    var textElement = document.querySelector('p.neighborhoods');
    textElement.style.transition = 'opacity 4s ease-in-out';
    setTimeout(function() {
        textElement.style.opacity = 1;
    }, 100); // Delay setting opacity to 1 after 100 milliseconds
});