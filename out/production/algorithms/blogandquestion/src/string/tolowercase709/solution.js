/**
 * @param {string} s
 * @return {string}
 */
const toLowerCase = function(s) {
  return s.replace(/[A-Z]/g, m => String.fromCharCode(m.charCodeAt(0) + 32));
};
