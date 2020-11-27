

/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
  return s.split(" ").filter(value => value).reverse().join(" ");
};

let str = "  hello world!  ";
console.log(reverseWords(str));

// "  hello world!  "
