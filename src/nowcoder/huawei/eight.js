function solution() {
  let set = new Set();
  let map = new Map();
  let list = [];

  let n = +(readline());
  while (n-- > 0) {
    let temp = readline().split(" ").map(val => +val);
    if (map.has(temp[0])) {
      map.set(temp[0], map.get(temp[0]) + temp[1]);
    } else {
      map.set(temp[0], temp[1]);
    }
    if (!set.has(temp[0])) {
      set.add(temp[0]);
      list.push(temp[0]);
    }
  }
  list.sort((a, b) => a - b);
  for (let num of list) {
    console.log(num + " " + map.get(num));
  }
}

solution();
