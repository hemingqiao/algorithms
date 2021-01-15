
/**
 * @param {string} s
 * @return {boolean}
 */
const isValid = function(s) {
    const stack = [];
    for (let i = 0; i < s.length; i++) {
        if (s[i] === '(') {
            stack.push(')');
        } else if (s[i] === '[') {
            stack.push(']');
        } else if (s[i] === '{') {
            stack.push('}');
        } else if (!stack.length || stack.pop() !== s[i]) {
            // 如果栈已经空了，此时压入一个右括号，直接返回false
            // 如果栈非空，此时压入的右括号和左括号不匹配，返回false
            return false;
        }
    }
    // 遍历完字符串之后，如果栈空则表明没有非法字符
    return !stack.length;
};
