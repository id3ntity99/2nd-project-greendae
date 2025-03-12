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
