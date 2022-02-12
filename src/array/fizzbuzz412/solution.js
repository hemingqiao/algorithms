/*! *****************************************************************************
@author Heming
founded at 2020-12-07 13:08:58
created by WebStorm
description: 还有一个类似的是fizzbuzz
题目描述：
写一个程序，输出从 1 到 n 数字的字符串表示。

1. 如果 n 是3的倍数，输出“Fizz”；

2. 如果 n 是5的倍数，输出“Buzz”；

3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fizz-buzz

***************************************************************************** */
/**
 * 从覆盖面最小的情况开始排除
 * @param {number} n
 * @return {string[]}
 */
var fizzBuzz = function(n) {
  const res = [];
  while (n) {
    if (n % 3 === 0 && n % 5 === 0) {
      res.push("FizzBuzz");
    } else if (n % 5 === 0) {
      res.push("Buzz");
    } else if (n % 3 === 0) {
      res.push("Fizz");
    } else {
      res.push(n + "");
    }
    n--;
  }
  return res.reverse();
};

console.log(fizzBuzz(15));

const fizzBuzz1 = function (n) {
  const res = Array.from(Array(n), (v, k) => String(k + 1));
  for (let i = 0; i < res.length; i++) {
    let e = res[i]
    if (e % 3 === 0 && e % 5 === 0) {
      res[i] = "FizzBuzz";
    } else if (e % 5 === 0) {
      res[i] = "Buzz";
    } else if (e % 3 === 0) {
      res[i] = "Fizz";
    }
  }
  return res;
}

console.log(fizzBuzz1(15));

/**
 * mod(3)和mod(5)都等于0可以合并为mod(15) == 0
 * @param n
 * @return {string[]}
 */
const fizzBuzz2 = function (n) {
  const res = Array.from(Array(n), (v, k) => String(k + 1));
  for (let i = 0; i < res.length; i++) {
    let e = res[i]
    if (e % 15 === 0) {
      res[i] = "FizzBuzz";
    } else if (e % 5 === 0) {
      res[i] = "Buzz";
    } else if (e % 3 === 0) {
      res[i] = "Fizz";
    }
  }
  return res;
}
