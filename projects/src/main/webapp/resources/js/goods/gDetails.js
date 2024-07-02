function openTab(evt, tabName) {
	// 모든 탭 내용을 숨깁니다.
	var tabcontent = document.getElementsByClassName("tabcontent");
	for (var i = 0; i < tabcontent.length; i++) {
		tabcontent[i].style.display = "none";
	}
	
	// 모든 탭 버튼의 활성 클래스를 제거합니다.
	var tablinks = document.getElementsByClassName("tablinks");
	for (var i = 0; i < tablinks.length; i++) {
	     tablinks[i].className = tablinks[i].className.replace(" active", "");
	}
	
	// 선택한 탭 내용을 표시하고 탭 버튼에 활성 클래스를 추가합니다.
	document.getElementById(tabName).style.display = "block";
	evt.currentTarget.className += " active";
}	
// 페이지 로드 시 상세 정보 탭이 기본적으로 열리도록 설정
document.addEventListener('DOMContentLoaded', function() {
	document.getElementById('details').style.display = "block";
});