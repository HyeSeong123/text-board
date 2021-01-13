var $circle = $('.circle');
$(".hover").mouseleave(
  function () {
    $(this).removeClass("hover");
  }
);
function moveCircle(e) {
  TweenLite.to($circle, 0.3, {
    css: {
      left: e.pageX,
      top: e.pageY
    }
  });
}
$('.top-menu').mouseleave(function(){
	 $('.circle').removeClass('active');
});
$('.top-menu').mouseenter(function(){
  $('.circle').addClass('active');
});
$('.top-menu').on('mousemove', moveCircle);


/* 마우스 온 */
function mouseOn(){
  $('ul').find('.word1 > .a__1').mouseenter(function(){
    $('.word1').children('.a__1').addClass('black'),
    $('.word1').children('.a__2').addClass('black');
  });

  $('ul').find('.word1 > .a__2').mouseenter(function(){
    $('.word1').children('.a__2').addClass('black');
    $('.word1').children('.a__1').addClass('black');
    $('.word1').children('.a__3').addClass('black');
  });

  $('ul').find('.word1 > .a__3').mouseenter(function(){
    $('.word1').children('.a__3').addClass('black');
    $('.word1').children('.a__2').addClass('black');
    $('.word1').children('.a__4').addClass('black');
  });

  $('ul').find('.word1 > .a__4').mouseenter(function(){
    $('.word1').children('.a__4').addClass('black');
    $('.word1').children('.a__5').addClass('black');
    $('.word1').children('.a__3').addClass('black');
  });

  $('ul').find('.word1 > .a__5').mouseenter(function(){
    $('.word1').children('.a__5').addClass('black');
    $('.word1').children('.a__3').addClass('black');
    $('.word1').children('.a__4').addClass('black');
  });
  
  /* 2번째 단어*/
  $('ul').find('.word2 > .a__1').mouseenter(function(){
    $('.word2').children('.a__1').addClass('black');
    $('.word2').children('.a__2').addClass('black');
  });

  $('ul').find('.word2 > .a__2').mouseenter(function(){
    $('.word2').children('.a__2').addClass('black');
    $('.word2').children('.a__1').addClass('black');
    $('.word2').children('.a__3').addClass('black');
  });

  $('ul').find('.word2 > .a__3').mouseenter(function(){
    $('.word2').children('.a__3').addClass('black');
    $('.word2').children('.a__2').addClass('black');
    $('.word2').children('.a__4').addClass('black');
  });

  $('ul').find('.word2 > .a__4').mouseenter(function(){
    $('.word2').children('.a__4').addClass('black');
    $('.word2').children('.a__5').addClass('black');
    $('.word2').children('.a__3').addClass('black');
  });

  $('ul').find('.word2 > .a__5').mouseenter(function(){
    $('.word2').children('.a__5').addClass('black');
    $('.word2').children('.a__4').addClass('black');
    $('.word2').children('.a__6').addClass('black');
    $('.word2').children('.a__3').addClass('black');
  });
  
  $('ul').find('.word2 > .a__6').mouseenter(function(){
    $('.word2').children('.a__5').addClass('black');
    $('.word2').children('.a__4').addClass('black');
    $('.word2').children('.a__6').addClass('black');
  });
  /* 2번째 단어*/
  
  /* 3번째 단어*/
  $('ul').find('.word3 > .a__1').mouseenter(function(){
    $('.word3').children('.a__1').addClass('black'),
    $('.word3').children('.a__2').addClass('black');
  });

  $('ul').find('.word3 > .a__2').mouseenter(function(){
    $('.word3').children('.a__2').addClass('black');
    $('.word3').children('.a__1').addClass('black');
    $('.word3').children('.a__3').addClass('black');
  });

  $('ul').find('.word3 > .a__3').mouseenter(function(){
    $('.word3').children('.a__3').addClass('black');
    $('.word3').children('.a__2').addClass('black');
    $('.word3').children('.a__4').addClass('black');
  });

  $('ul').find('.word3 > .a__4').mouseenter(function(){
    $('.word3').children('.a__4').addClass('black');
    $('.word3').children('.a__5').addClass('black');
    $('.word3').children('.a__3').addClass('black');
  });

  $('ul').find('.word3 > .a__5').mouseenter(function(){
    $('.word3').children('.a__5').addClass('black');
    $('.word3').children('.a__3').addClass('black');
    $('.word3').children('.a__4').addClass('black');
  });

  $('ul').find('.word3 > .a__6').mouseenter(function(){
    $('.word3').children('.a__6').addClass('black');
    $('.word3').children('.a__5').addClass('black');
    $('.word3').children('.a__7').addClass('black');
  });

  $('ul').find('.word3 > .a__7').mouseenter(function(){
    $('.word3').children('.a__7').addClass('black');
    $('.word3').children('.a__6').addClass('black');
    $('.word3').children('.a__8').addClass('black');
  });

  $('ul').find('.word3 > .a__8').mouseenter(function(){
    $('.word3').children('.a__8').addClass('black');
    $('.word3').children('.a__9').addClass('black');
    $('.word3').children('.a__7').addClass('black');
  });

  $('ul').find('.word3 > .a__9').mouseenter(function(){
    $('.word3').children('.a__9').addClass('black');
    $('.word3').children('.a__10').addClass('black');
    $('.word3').children('.a__8').addClass('black');
  });

  $('ul').find('.word3 > .a__10').mouseenter(function(){
    $('.word3').children('.a__10').addClass('black');
    $('.word3').children('.a__9').addClass('black');
    $('.word3').children('.a__11').addClass('black');
    $('.word3').children('.a__8').addClass('black');
  });
  
  $('ul').find('.word3 > .a__11').mouseenter(function(){
    $('.word3').children('.a__11').addClass('black');
    $('.word3').children('.a__10').addClass('black');
    $('.word3').children('.a__12').addClass('black');
  });
$('ul').find('.word3 > .a__12').mouseenter(function(){
    $('.word3').children('.a__12').addClass('black');
    $('.word3').children('.a__10').addClass('black');
    $('.word3').children('.a__9').addClass('black');
  });
  /* 3번째 단어*/
  
   /* 4번째 단어*/
  $('ul').find('.word4 > .a__1').mouseenter(function(){
    $('.word4').children('.a__1').addClass('black'),
    $('.word4').children('.a__2').addClass('black');
  });

  $('ul').find('.word4 > .a__2').mouseenter(function(){
    $('.word4').children('.a__2').addClass('black');
    $('.word4').children('.a__1').addClass('black');
    $('.word4').children('.a__3').addClass('black');
  });

  $('ul').find('.word4 > .a__3').mouseenter(function(){
    $('.word4').children('.a__3').addClass('black');
    $('.word4').children('.a__2').addClass('black');
    $('.word4').children('.a__4').addClass('black');
  });

  $('ul').find('.word4 > .a__4').mouseenter(function(){
    $('.word4').children('.a__4').addClass('black');
    $('.word4').children('.a__5').addClass('black');
    $('.word4').children('.a__3').addClass('black');
  });
  /* 4번째 단어*/
  
  /* 5번째 단어*/
  $('ul').find('.word5 > .a__1').mouseenter(function(){
    $('.word5').children('.a__1').addClass('black'),
    $('.word5').children('.a__2').addClass('black');
    $('.word5').children('.a__3').addClass('black');
  });

  $('ul').find('.word5 > .a__2').mouseenter(function(){
    $('.word5').children('.a__2').addClass('black');
    $('.word5').children('.a__1').addClass('black');
    $('.word5').children('.a__3').addClass('black');
  });

  $('ul').find('.word5 > .a__3').mouseenter(function(){
    $('.word5').children('.a__3').addClass('black');
    $('.word5').children('.a__2').addClass('black');
    $('.word5').children('.a__4').addClass('black');
  });

  $('ul').find('.word5 > .a__4').mouseenter(function(){
    $('.word5').children('.a__4').addClass('black');
    $('.word5').children('.a__5').addClass('black');
    $('.word5').children('.a__3').addClass('black');
  });
  $('ul').find('.word5 > .a__5').mouseenter(function(){
    $('.word5').children('.a__5').addClass('black');
    $('.word5').children('.a__6').addClass('black');
    $('.word5').children('.a__4').addClass('black');
  });
  /* 5번째 단어*/
  
};
/* 마우스 온 */

/* 마우스 오프 */
function mouseOff(){
  $('ul').find('.word1 > .a__1').mouseleave(function(){
    $('.word1').children('.a__1').removeClass('black'),
    $('.word1').children('.a__2').removeClass('black');
  });

  $('ul').find('.word1 > .a__2').mouseleave(function(){
    $('.word1').children('.a__2').removeClass('black');
    $('.word1').children('.a__1').removeClass('black');
    $('.word1').children('.a__3').removeClass('black');
  });

  $('ul').find('.word1 > .a__3').mouseleave(function(){
    $('.word1').children('.a__3').removeClass('black');
    $('.word1').children('.a__2').removeClass('black');
    $('.word1').children('.a__4').removeClass('black');
  });

  $('ul').find('.word1 > .a__4').mouseleave(function(){
    $('.word1').children('.a__4').removeClass('black');
    $('.word1').children('.a__5').removeClass('black');
    $('.word1').children('.a__3').removeClass('black');
  });

  $('ul').find('.word1 > .a__5').mouseleave(function(){
    $('.word1').children('.a__5').removeClass('black');
    $('.word1').children('.a__3').removeClass('black');
    $('.word1').children('.a__4').removeClass('black');
  });
  
  /* 2번째 단어*/
  $('ul').find('.word2 > .a__1').mouseleave(function(){
    $('.word2').children('.a__1').removeClass('black');
    $('.word2').children('.a__2').removeClass('black');
  });

  $('ul').find('.word2 > .a__2').mouseleave(function(){
    $('.word2').children('.a__2').removeClass('black');
    $('.word2').children('.a__1').removeClass('black');
    $('.word2').children('.a__3').removeClass('black');
  });

  $('ul').find('.word2 > .a__3').mouseleave(function(){
    $('.word2').children('.a__3').removeClass('black');
    $('.word2').children('.a__2').removeClass('black');
    $('.word2').children('.a__4').removeClass('black');
  });

  $('ul').find('.word2 > .a__4').mouseleave(function(){
    $('.word2').children('.a__4').removeClass('black');
    $('.word2').children('.a__5').removeClass('black');
    $('.word2').children('.a__3').removeClass('black');
  });

  $('ul').find('.word2 > .a__5').mouseleave(function(){
    $('.word2').children('.a__5').removeClass('black');
    $('.word2').children('.a__4').removeClass('black');
    $('.word2').children('.a__6').removeClass('black');
    $('.word2').children('.a__3').removeClass('black');
  });
  
  $('ul').find('.word2 > .a__6').mouseleave(function(){
    $('.word2').children('.a__5').removeClass('black');
    $('.word2').children('.a__4').removeClass('black');
    $('.word2').children('.a__6').removeClass('black');
  });
  /* 2번째 단어*/
  
  /* 3번째 단어*/
  $('ul').find('.word3 > .a__1').mouseleave(function(){
    $('.word3').children('.a__1').removeClass('black'),
    $('.word3').children('.a__2').removeClass('black');
  });

  $('ul').find('.word3 > .a__2').mouseleave(function(){
    $('.word3').children('.a__2').removeClass('black');
    $('.word3').children('.a__1').removeClass('black');
    $('.word3').children('.a__3').removeClass('black');
  });

  $('ul').find('.word3 > .a__3').mouseleave(function(){
    $('.word3').children('.a__3').removeClass('black');
    $('.word3').children('.a__2').removeClass('black');
    $('.word3').children('.a__4').removeClass('black');
  });

  $('ul').find('.word3 > .a__4').mouseleave(function(){
    $('.word3').children('.a__4').removeClass('black');
    $('.word3').children('.a__5').removeClass('black');
    $('.word3').children('.a__3').removeClass('black');
  });

  $('ul').find('.word3 > .a__5').mouseleave(function(){
    $('.word3').children('.a__5').removeClass('black');
    $('.word3').children('.a__3').removeClass('black');
    $('.word3').children('.a__4').removeClass('black');
  });

  $('ul').find('.word3 > .a__6').mouseleave(function(){
    $('.word3').children('.a__6').removeClass('black');
    $('.word3').children('.a__5').removeClass('black');
    $('.word3').children('.a__7').removeClass('black');
  });

  $('ul').find('.word3 > .a__7').mouseleave(function(){
    $('.word3').children('.a__7').removeClass('black');
    $('.word3').children('.a__6').removeClass('black');
    $('.word3').children('.a__8').removeClass('black');
  });

  $('ul').find('.word3 > .a__8').mouseleave(function(){
    $('.word3').children('.a__8').removeClass('black');
    $('.word3').children('.a__9').removeClass('black');
    $('.word3').children('.a__7').removeClass('black');
  });

  $('ul').find('.word3 > .a__9').mouseleave(function(){
    $('.word3').children('.a__9').removeClass('black');
    $('.word3').children('.a__10').removeClass('black');
    $('.word3').children('.a__8').removeClass('black');
  });

  $('ul').find('.word3 > .a__10').mouseleave(function(){
    $('.word3').children('.a__10').removeClass('black');
    $('.word3').children('.a__9').removeClass('black');
    $('.word3').children('.a__11').removeClass('black');
    $('.word3').children('.a__8').removeClass('black');
  });
  
  $('ul').find('.word3 > .a__11').mouseleave(function(){
    $('.word3').children('.a__11').removeClass('black');
    $('.word3').children('.a__10').removeClass('black');
    $('.word3').children('.a__12').removeClass('black');
  });
$('ul').find('.word3 > .a__12').mouseleave(function(){
    $('.word3').children('.a__12').removeClass('black');
    $('.word3').children('.a__10').removeClass('black');
    $('.word3').children('.a__9').removeClass('black');
  });
  /* 3번째 단어*/


  /* 3번째 단어*/
  
  /* 4번째 단어*/
  $('ul').find('.word4 > .a__1').mouseleave(function(){
    $('.word4').children('.a__1').removeClass('black'),
    $('.word4').children('.a__2').removeClass('black');
  });

  $('ul').find('.word4 > .a__2').mouseleave(function(){
    $('.word4').children('.a__2').removeClass('black');
    $('.word4').children('.a__1').removeClass('black');
    $('.word4').children('.a__3').removeClass('black');
  });

  $('ul').find('.word4 > .a__3').mouseleave(function(){
    $('.word4').children('.a__3').removeClass('black');
    $('.word4').children('.a__2').removeClass('black');
    $('.word4').children('.a__4').removeClass('black');
  });

  $('ul').find('.word4 > .a__4').mouseleave(function(){
    $('.word4').children('.a__4').removeClass('black');
    $('.word4').children('.a__5').removeClass('black');
    $('.word4').children('.a__3').removeClass('black');
  });

  /* 4번째 단어*/
  
  /* 5번째 단어*/
  $('ul').find('.word5 > .a__1').mouseleave(function(){
    $('.word5').children('.a__1').removeClass('black'),
    $('.word5').children('.a__2').removeClass('black');
    $('.word5').children('.a__3').removeClass('black');
  });

  $('ul').find('.word5 > .a__2').mouseleave(function(){
    $('.word5').children('.a__2').removeClass('black');
    $('.word5').children('.a__1').removeClass('black');
    $('.word5').children('.a__3').removeClass('black');
  });

  $('ul').find('.word5 > .a__3').mouseleave(function(){
    $('.word5').children('.a__3').removeClass('black');
    $('.word5').children('.a__2').removeClass('black');
    $('.word5').children('.a__4').removeClass('black');
  });

  $('ul').find('.word5 > .a__4').mouseleave(function(){
    $('.word5').children('.a__4').removeClass('black');
    $('.word5').children('.a__5').removeClass('black');
    $('.word5').children('.a__3').removeClass('black');
  });
  $('ul').find('.word5 > .a__5').mouseleave(function(){
    $('.word5').children('.a__5').removeClass('black');
    $('.word5').children('.a__6').removeClass('black');
    $('.word5').children('.a__4').removeClass('black');
  });
  /* 5번째 단어*/
  
}
/* 마우스 오프 */
mouseOn();
mouseOff();