
/**
 * @param {string} expression
 * @return {boolean}
 */
const parseBoolExpr = function (expression) {
  let i = 0;
  return parse(s);

  function parse(s) {
    let c = s.charAt(i++);
    if (c === 't') {
      return true;
    }
    if (c === 'f') {
      return false;
    }
    if (c === '!') {
      i++;
      let temp = parse(s);
      i++;
      return !temp;
    }
    if (c === '&') {
      i++;
      let temp = true;
      while (true) {
        temp &= parse(s);
        if (s.charAt(i++) === ')') break;
      }
      return temp;
    }
    i++;
    let temp = false;
    while (true) {
      temp |= parse(s);
      if (s.charAt(i++) === ')') break;
    }
    return temp;
  }
};
