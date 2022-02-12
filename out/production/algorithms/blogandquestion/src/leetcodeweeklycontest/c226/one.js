/**
 * @param {number} lowLimit
 * @param {number} highLimit
 * @return {number}
 */
var countBalls = function(lowLimit, highLimit) {
  let map = new Map();
  for (let i = lowLimit; i <= highLimit; i++) {
    let temp = [...getDigits(i)].reduce((a, b) => a + b);
    if (map.has(temp)) {
      map.set(temp, map.get(temp) + 1);
    } else {
      map.set(temp, 1);
    }
  }

  let arr = [...map.values()];
  arr.sort((a, b) => b - a);
  return arr[0];

  function* getDigits(num) {
    while (num) {
      yield num % 10;
      num = num /10 | 0;
    }
  }
};

console.log(countBalls(1, 10));

var countBalls1 = function(lowLimit, highLimit) {
  let map = new Map();
  for (let i = lowLimit; i <= highLimit; i++) {
    let temp = getDigitSum(i);
    if (map.has(temp)) {
      map.set(temp, map.get(temp) + 1);
    } else {
      map.set(temp, 1);
    }
  }

  let arr = [...map.values()];
  arr.sort((a, b) => b - a);
  return arr[0];

  function getDigitSum(num) {
    let res = 0;
    while (num > 0) {
      res += num % 10;
      num = num / 10 | 0;
    }
    return res;
  }
};
