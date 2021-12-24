
const maximumNumber = function(num, change) {
    let n = num.length;
    let c = num.split("");
    let flag = 0;
    for (let i = 0; i < n; i++) {
        let idx = +c[i];
        if (idx >= change[idx] && !flag) continue;
        let p = i;
        while (p < n && change[Number(c[p])] >= Number(c[p]) && !flag) {
            c[p] = change[+c[p]];
            p++;
            i++;
        }
        flag = true;

    }
    return c.join("");
};

console.log(maximumNumber("214010", [6,7,9,7,4,0,3,4,4,7]));
