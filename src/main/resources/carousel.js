$(function() {
	$.fn.carousel = function(options) {
		var settings = {
			slider: ".wrapper",
			slide: "li",
			previous: ".previous",
			next: ".next"
		};
		options = $.extend(settings, options);
		return this.each(function() {
			var $element = $(this),
				$slider = $element.find(options.slider),
				$slide = $slider.find(options.slide),
				$previous = $element.find(options.previous),
				$next = $element.find(options.next);
			$slider.css("overflow", "hidden");
			var showSlide = function(direction) {
				var singleWidth = $slide.eq(0).outerWidth(),
					left = (direction == 1) ? "+=" + singleWidth : "-=" + singleWidth;
				$slider.stop(true, true).
					animate({
						scrollLeft: left
					}, 300);
			};

			$previous.on("click", function(e) {
				e.preventDefault();
				showSlide(-1);
			});

			$next.on("click", function(e) {
				e.preventDefault();
				showSlide(1);
			});

		});
	};
});

