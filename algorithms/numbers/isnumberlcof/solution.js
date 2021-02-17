/**
 * @param {string} s
 * @return {boolean}
 */
const isNumber = function(s) {
  const regexp = /^[+-]?(\d+|\d+\.\d*|\.\d+)([Ee][+-]?\d+)?$/;
  return regexp.test(s.trim());
};
