
function solution() {
  // let str = readline();
  let str = "bcdefa";
  let n = str.length;
  let flag = true;
  for (let i = 0; i < n - 1; i++) {
    if (str[i] > str[i + 1]) {
      flag = false;
      break;
    }
  }
  if (flag) {
    console.log(str);
    return;
  }
  let chars = str.split("");
  for (let j = 0; j < n; j++) {
    let temp = chars[j];
    let k = n - 1;
    let min = chars[k];
    let index = k;
    let find = false;
    while (k > j) {
      if (chars[k] < temp) {
        if (chars[k] < min) {
          min = chars[k];
          index = k;
        }
        find = true;
      }
      k--;
    }
    if (find) {
      let t = chars[j];
      chars[j] = chars[index];
      chars[index] = t;
      console.log(chars.join(""));
      return;
    }
  }
}

solution();
