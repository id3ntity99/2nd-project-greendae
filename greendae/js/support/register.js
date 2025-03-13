/**
 * 작성자: id3ntity99(이현민)
 * 설명 : 서버에 수강신청 요청을 보내는 자바스크립트. 수강신청 버튼은 한번만 클릭할 수 있다.
 */
const registerBtns = document.getElementsByClassName("register-btn");

/**
 * 모든 '신청' 버튼에 클릭 이벤트 리스너를 설정
 */
for (let registerBtn of registerBtns) {
  registerBtn.addEventListener("click", doRegister);
}

/**
 * '신청' 버튼을 비활성화
 * @param {*} button
 */
function disable(button) {
  button.style.filter = "grayscale(100%)";
  button.style.cursor = "default";
}

/**
 * 서버에 HTTP POST 요청을 전송하고 disable() 함수를 호출.
 * @param {*} event 이벤트 객체
 */
function doRegister(event) {
  postRequest(null, null); //URL and JSON body for request
  console.log("[TEST] 수강신청이 완료되었습니다.");
  disable(event.target);
  event.target.removeEventListener("click", doRegister);
}
