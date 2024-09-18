const registerMouseWheel = (selector) => { 
  window.addEventListener("wheel", function (e) {
	let target = document.querySelector(`${selector}:hover`);
	if ( target != null) {
	    if (e.deltaY > 0) target.scrollLeft += 100;
	    else target.scrollLeft -= 100;
	}
  });
}