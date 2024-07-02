new Swiper('.swiper', {
			autoplay: {
			    // 자동재생 여부
			    delay: 5000, // 시작시간 설정
			 },
			effect: "fade", 
			loop: true,
			// 페이저 버튼 사용자 설정
			pagination: {
			  // 페이지 번호 요소 선택자
			  el: '.swiper-pagination',
			  dynamicBullets: true,
			  clickable: true,
			},
			navigation : {
				nextEl : '.swiper-button-next', // 다음 버튼 클래스명
				prevEl : '.swiper-button-prev', // 이번 버튼 클래스명
			},
});