/**
 * @param {string} S
 * @return {string}
 */
const removeDuplicates = function(S) {
    let result = [];
    for (let c of S) {
        if (result.length === 0 || c !== result[result.length - 1]) {
            result.push(c);
        } else {
            result.pop();
        }
    }
    return result.join("");
};

let result = removeDuplicates("abbaca")
console.log(result);
