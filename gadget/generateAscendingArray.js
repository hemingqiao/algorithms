/* 尽量不适用循环语句，从给定的一个数，生成一个升序数组。如给定 5，返回 [1,2,3,4,5] */

const ge = n => Array.from(Array(n), (v, k) => k + 1);

/**
 * 不使用循环语句，就使用递归
 *
 * @param n
 * @returns {[]}
 */
function gene(n) {
  let result = [];

  (function fn() {
    result.unshift(n--);
    if (n) {
      fn();
    }
  })();

  return result;
}

console.log(ge(10));
console.log(gene(10));

// log
// [
//   1, 2, 3, 4,  5,
//   6, 7, 8, 9, 10
// ]
// [
//   1, 2, 3, 4,  5,
//   6, 7, 8, 9, 10
// ]


/**
 * 使用generator进行递归
 * @param n
 * @returns {any}
 */
function ascending(n) {
  return [...generate(n)];

  function* generate(n) {
    if (n > 0) {
      yield* generate(n - 1);
      yield n;
    }
  }
}

console.log(ascending(10));

// log
// [
//   1, 2, 3, 4,  5,
//   6, 7, 8, 9, 10
// ]


/* 下面这种方法使用了循环语句，不过非常巧妙 */

Number.prototype[Symbol.iterator] = function* () {
  let times = this.valueOf();
  let i = 0;
  while (times--) {
    yield ++i;
  }
}

const generateArray = n => [...n];

console.log(generateArray(10));

// log
// [
//   1, 2, 3, 4,  5,
//   6, 7, 8, 9, 10
// ]

/* -------------------------------函数链式调用------------------------------- */

const add = sum => {
  const fn = n => add(sum + n);
  fn.valueOf = () => sum;
  return fn;
}

console.log(add(0));
console.log(add(0)(1));
console.log(+add(0));
console.log(+add(0)(1)(2));

// log
// [Function: fn] { valueOf: [Function] }
// [Function: fn] { valueOf: [Function] }
// 0
// 3

// update
const add = (...args) => {
  const fn = (...vars) => add(...args, ...vars);
  fn.valueOf = () => args.reduce((prev, curr) => prev + curr);
  return fn;
}

console.log(+add(1, 2)(3, 4)(5));
console.log(+add(1, 2, 3)(4));

// log
// 15
// 10
