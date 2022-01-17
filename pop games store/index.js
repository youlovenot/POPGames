var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("slider");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  slides[slideIndex-1].style.display = "block";  
}
$( document ).ready( function() {
  $( '.slider_container' ).bxSlider( {
    auto: true,
    pause: 2000,
    speed: 500,
  } );
} );

function setCookie( name, value, expiredays ) { 
    var todayDate = new Date(); 
        todayDate.setDate( todayDate.getDate() + expiredays ); 
        document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";" 
    }
function closeWin() { 
    if ( document.notice_form.chkbox.checked ){ 
        setCookie( "maindiv", "done" , 1 ); 
    } 
    document.all['divpop'].style.visibility = "hidden"; 
} 
$(document).ready(function(){
  var height = $(".header_bottom").height();
  var num = $(".ul li").length;
  var max = height * num;
  var move = 0;
  function noticeRolling(){
    move += height;
    $(".ul").animate({"top":-move},600,function(){
      if(mpve >= max){
        $(this).css("top",0);
        move = 0;
      };

    });
  };
  noticeRollingOff = setInterval(noticeRolling,1000);
  $(".ul").append($(".ul li").first().clone());

  $(".ul_stop").click(function(){
    clearInterval(noticeRollingOff);
  })
  $(".ul_start").click(function(){
    noticeRollingOff = setInterval(noticeRolling,1000);
  });
});


