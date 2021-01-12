/**
 * @param {string} s
 * @return {boolean}
 */
var isNumber = function(s) {
  const regexp = /^[+-]?(\d+|\d+\.\d*|\.\d+)([eE][+-]?\d+)?$/;
  return s.trim().match(regexp) === null ? false : true;
};
