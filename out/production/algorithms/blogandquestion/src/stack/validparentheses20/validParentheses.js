const isValid = function (s) {
    let bracket = [];
    for (let i = 0; i < s.length; i++) {
        let ch = s.charAt(i);
        switch (ch) {
            case "(":
            case "[":
            case "{":
                bracket.push(ch);
                break;
            case ")":
                if (!!bracket.length) {
                    if (bracket.pop() === "(") {
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            case "]":
                if (!!bracket.length) {
                    if (bracket.pop() === "[") {
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            case "}":
                if (!!bracket.length) {
                    if (bracket.pop() === "{") {
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
        }
    }
    return !bracket.length;
};

// test
let result = isValid("]");
console.log(result);
