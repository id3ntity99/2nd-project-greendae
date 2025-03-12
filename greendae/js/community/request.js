/**
 * 작성자: id3ntity99(이현민)
 * 설명 : 게시물 클릭 시 서버로 HTTP 요청을 보내도록 하는 자바스크립트 코드
 */

/**
 * HTTP 응답의 상태 코드가 200일 경우 실행되는 핸들러 함수.
 * @param {*} response 서버로부터 전달받은 HTTP response
 */
function handleOK(response) {
  console.log(`${response.url}로의 요청이 성공적으로 완료되었습니다.`);
}

/**
 * HTTP 응답의 상태 코드가 400번대일 경우 실행되는 핸들러 함수.
 * @param {*} response 서버로부터 전달받은 HTTP response
 */
function handleErr(response) {
  const jsonBody = JSON.parse(response);
  alert(
    `[DEBUG] 에러 발생! Status Code: ${response.status} Response Body: ${jsonBody}`
  );
}

/**
 * HTTP 응답의 상태코드가 302번, 리다이렉션일 경우 실행되는 핸들러 함수.
 * 현재의 웹페이지 주소를 HTTP 리다이렉트 응답 메시지에 명시되어 있는 redirect URL로 변경한다.
 * @param {*} response 서버로부터 전달받은 HTTP response
 */
function handleRedirect(response) {
  window.location.replace(response.url);
}

/**
 *  매개변수 URL로 HTTP GET 요청을 전송한다.
 * @param {*} url <a> 태그의 href 속성 값
 */
async function request(url) {
  await fetch(url).then((response) => {
    if (response.status === 200) {
      // HTTP 응답이 200번(OK)인 경우
      handleOK(response);
    } else if (response.redirected) {
      handleRedirect(response);
    } else if (response.status / 100 === 4) {
      //HTTP 응답이 400번대인 경우
      handleErr(response);
    }
  });
}
