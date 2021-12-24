
/**
 * @param {string} s
 * @return {boolean}
 */
const isNumber = function(s) {
  let regex = /^[+-]?((\d+\.|\d+\.\d+|\.\d+)|(\d+))([Ee][+-]?\d+)?$/g;
  return s.match(regex) != null;
};

/*
\d+\. 和 \d+\.\d+ 可以合并成为 \d+\.\d*
所以，上面的正则又可以写为：const regex = /^[+-]?(\d+\.\d*|\.\d+|\d+)([Ee][+-]?\d+)?$/g;
 */
