const form = document.getElementById("search-form");
const searchBox = document.getElementsByClassName("search-box")[0];
const select = document.querySelector("#search-area > select");
const options = document.querySelectorAll("#search-area > select > option");
const searchBtn = document.getElementsByClassName("search-btn")[0];
const URL = "";

form.addEventListener("submit", (event) => {
  event.preventDefault();
});

searchBtn.addEventListener("click", () => {
  const selection = select.selectedIndex;
  const selectedOption = options[selection].value;
  const json = {
    keyword: searchBox.value,
    option: selectedOption.value,
  };
  const jsonBody = JSON.stringify(json);

  postRequest(URL, jsonBody);

  console.log(
    `[TEST] 검색 요청이 성공적으로 전송되었습니다. URL = ${URL}, Request Body = ${jsonBody}`
  );
});
