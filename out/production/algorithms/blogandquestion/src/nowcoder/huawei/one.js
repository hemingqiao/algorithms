function solution() {
  let input = readline();
  let n = input.length - 1; // in不能作为变量名称，因为in是关键字
  let ret = 0;
  while (n >= 0 && input.charAt(n) !== " ") {
    n--;
    ret++;
  }
  console.log(ret);
}

solution();
