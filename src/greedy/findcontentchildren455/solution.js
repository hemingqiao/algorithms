/*
需要注意的一点是，数组实例默认的排序方法是将元素转换为字符串，然后通过比较它们的UTF-16代码单元值序列构建的。
这也意味着如果使用默认的排序算法，10会出现再2-9之前，因为转为字符串之后，字符1的UTF-16序列小于2-9的。
所以有必要指明排序函数compareFn。
 */

const findContentChildren = function (g, s) {
    g.sort((a, b) => a - b);
    s.sort((a, b) => a - b);
    // g.sort();
    // s.sort();
    let child = 0, cookie = 0;
    while (child < g.length && cookie < s.length) {
        if (g[child] <= s[cookie]) ++child;
        ++cookie;
    }
    return child;
}

let children = [10, 9, 8, 7], cookies = [5, 6, 7, 8];
let result = findContentChildren(children, cookies)
console.log(result);
