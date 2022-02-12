

/**
 * @param {string} number
 * @return {string}
 */
var reformatNumber = function(number) {
  let n = "";
  for (let e of number) {
    if (e === "-" || e === " ") continue;
    n += e;
  }

  number = n;
  if (number.length <= 3) return number;
  if (number.length === 4) return number.slice(0, 2).concat("-").concat(number.slice(2));
  const ret = [];
  let temp = "";
  let i;
  for (i = 0; i < number.length; i++) {
    temp = temp + number[i];
    if (temp.length === 3) {
      ret.push(temp);
      temp = "";
      if (number.length - i - 1 <= 4) break;
    }
  }
  let left = number.length - i - 1;
  switch (left) {
    case 2:
    case 3:
      ret.push(number.slice(i + 1));
      return ret.join("-")
    case 4:
      let l = number.slice(i + 1);
      ret.push(l.slice(0, 2));
      ret.push(l.slice(2))
      return ret.join("-");
  }
};

console.log(reformatNumber("9964-"));
