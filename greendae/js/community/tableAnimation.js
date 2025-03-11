const tr = document.querySelectorAll("#container table tr");
const len = tr.length;

for (let i = 1; i < len; i++) {
  const currentTr = tr[i];
  currentTr.addEventListener("mouseover", (event) => {
    onMouseOver(currentTr);
  });
  currentTr.addEventListener("mouseout", (event) => {
    onMouseOut(currentTr);
  });
}

function onMouseOver(tr) {
  tr.style.backgroundColor = "#fafafa";
}

function onMouseOut(tr) {
  tr.style.backgroundColor = "#fff";
}

const titles = document.querySelectorAll("#container table tr a");
const MAX_TITLE_LEN = 30;
for (let title of titles) {
  const value = title.innerText;
  let concatTitle = "";
  if (value.length > MAX_TITLE_LEN) {
    concatTitle = value.substring(0, MAX_TITLE_LEN - 1);
  }
  title.innerText = concatTitle + "...";
}
