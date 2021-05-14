// Preloader -section
    //-------------------------------------------------------
  // Preloader 
	jQuery(window).on('load', function() {
		jQuery("#status").fadeOut();
		jQuery("#preloader").delay(350).fadeOut("slow");
	});
	$('.image_fade').hover( function(){
		$(this).filter(':not(:animated)').animate({opacity: 0.8}, 400);
	}, function() {
		$(this).animate({opacity: 1}, 400);
	});
	//--------------------up scroll js-----------------------------
	// ===== Scroll to Top ==== 
				$(window).scroll(function() {
					if ($(this).scrollTop() >= 300) {       
						$('#return-to-top').fadeIn(700);   
					} else {
						$('#return-to-top').fadeOut(700);  
					}
				});
				$('#return-to-top').click(function() {     
					$('body,html').animate({
						scrollTop : 0                
					}, 700);
				});
			
		// Menu js for Position fixed
		
		$(window).scroll(function(){
			var window_top = $(window).scrollTop() + 1; 
			if (window_top > 80) {
				$('.menu_wrapper').addClass('menu_fixed animated fadeIn');
			} else if (window_top < 80) {
				$('.menu_wrapper').removeClass('menu_fixed animated fadeIn');
			}
		});
		
		
	
	$('#search_button').on("click", function(e) {
		$('#search_open').slideToggle();
		e.stopPropagation(); 
	});

	$(document).on("click", function(e){
		if(!(e.target.closest('#search_open'))){	
			$("#search_open").slideUp();   		
		}
   });
   

		
	// Wow js
		$(window).on("load", function() {
				var wow = new WOW({
					boxClass: 'wow',
					animateClass: 'animated',
					offset: 0,
					mobile: true,
					live: true
				});
				wow.init();
			});
	
	
	  /*--- Responsive Menu Start ----*/

$("#toggle").on("click", function(){
  var w = $('#sidebar').width();
  var pos = $('#sidebar').offset().left;
 
  if(pos == 0){
  $("#sidebar").animate({"left": -w}, "slow");
  }
  else
  {
  $("#sidebar").animate({"left": "0"}, "slow");
  }
  
});

$("#toggle_close").on("click", function(){
  var w = $('#sidebar').width();
  var pos = $('#sidebar').offset().left;
 
  if(pos == 0){
  $("#sidebar").animate({"left": -w}, "slow");
  }
  else
  {
  $("#sidebar").animate({"left": "0"}, "slow");
  }
  
});
$(function () { $("[data-toggle='tooltip']").tooltip(); });
$(function () { $("[data-toggle='popover']").popover(); });

(function($){
$(document).ready(function(){

$('#cssmenu li.active').addClass('open').children('ul').show();
	$('#cssmenu li.has-sub>a').on('click', function(){
		$(this).removeAttr('href');
		var element = $(this).parent('li');
		if (element.hasClass('open')) {
			element.removeClass('open');
			element.find('li').removeClass('open');
			element.find('ul').slideUp(200);
		}
		else {
			element.addClass('open');
			element.children('ul').slideDown(200);
			element.siblings('li').children('ul').slideUp(200);
			element.siblings('li').removeClass('open');
			element.siblings('li').find('li').removeClass('open');
			element.siblings('li').find('ul').slideUp(200);
		}
	});


});
})(jQuery);


	