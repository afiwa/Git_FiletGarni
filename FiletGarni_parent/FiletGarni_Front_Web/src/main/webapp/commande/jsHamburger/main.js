var content = document.querySelector('#hamburger-content');
var sidebarBody = document.querySelector('#hamburger-sidebar-body');
var button = document.querySelector('#hamburger-button');
var overlay = document.querySelector('#hamburger-overlay');
var activatedClass = 'hamburger-activated';

sidebarBody.innerHTML = content.innerHTML;

button.addEventListener('click', function (e) {
    e.preventDefault();

    this.parentNode.classList.add(activatedClass);
});

button.addEventListener('keydown', function (e) {
    if (this.parentNode.classList.contains(activatedClass)) {
        if (e.repeat === false && e.which === 27)
            this.parentNode.classList.remove(activatedClass);
    }
});

overlay.addEventListener('click', function (e) {
    e.preventDefault();

    this.parentNode.classList.remove(activatedClass);
});

//Own part

function overFunction(domElem) {
    var navBig = document.getElementsByTagName("nav")[0];
    var smNavBig = navBig.getElementsByClassName('sous-menu-active');
    var navSmall = document.getElementsByTagName("nav")[1];
    var smNavSmall = navSmall.getElementsByClassName('sous-menu-active');



    var elmt = domElem.nextSibling.nextSibling;
    if (elmt.classList.contains('sous-menu-active')) {
        elmt.classList.remove('sous-menu-active');
    } else {
        if (smNavBig.length != 0) {
            for (let i = 0; i <= smNavBig.length; i++) {
                smNavBig[i].classList.remove('sous-menu-active');
            }
        }
        if (smNavSmall.length != 0) {
            for (let i = 0; i <= smNavSmall.length; i++) {
                smNavSmall[i].classList.remove('sous-menu-active');
            }
        }
        elmt.classList.add('sous-menu-active');
    }
}
