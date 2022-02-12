/**
 * @param {string} coordinates
 * @return {boolean}
 */
const squareIsWhite = function(coordinates) {
  const x = ["a", "c", "e", "g"];
  const y = [1, 3, 5, 7];
  if (x.includes(coordinates[0])) {
    return !y.includes(+coordinates[1]);
  } else {
    return y.includes(+coordinates[1]);
  }
};

console.log(squareIsWhite("a1"));
