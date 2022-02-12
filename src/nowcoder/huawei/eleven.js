// function solution() {
//     let str = readline();
//     let ret = "";
//     let n = str.length;
//     for (let i = n - 1; i >= 0; i--) ret += str[i];
//     console.log(ret);
// }

function solution() {
  console.log(readline().split("").reverse().join(""));
}

solution();
