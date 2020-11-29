/*! *****************************************************************************
@author Heming
founded at 2020-11-28 12:07:23
created by WebStorm
description: 深度对比两个对象内容是否相等
***************************************************************************** */

/**
 * 深度比较（未考虑循环引用）
 * @param {any} a
 * @param {any} b
 * @return {boolean}
 */
function deepEqual(a, b) {
  return _deepEqual(a, b);


  function _deepEqual(obj1, obj2) {
    // 获取对象自身的所有属性（包括不可枚举属性和Symbol属性）
    let keysA = Reflect.ownKeys(obj1);
    let keysB = Reflect.ownKeys(obj2);

    // 如果两者的属性个数不同，直接返回false
    if (keysA.length !== keysB.length) {
      return false;
    }

    // 如果一个对象拥有另一个对象所没有的属性，直接返回false
    for (let key of keysA) {
      if (!keysB.includes(key)) {
        return false;
      }
    }

    // 逐一判断对应的属性是否相同（内容）
    for (let key of keysA) {
      if (obj1[key] === null) {
        if (obj2[key] !== null) return false;
      } else {
        if (typeof obj1[key] === "object") {
          if (typeof obj2[key] !== "object") {
            // 如果obj2[key]不是对象的话，直接返回false
            return false;
          }
          // 否则，递归的比较obj1[key]和obj2[key]内容是否相等
          if (!_deepEqual(obj1[key], obj2[key])) {
            return false;
          }
        } else if (typeof obj1[key] === "function") {
          // 函数可以不予考虑
          if (obj1[key].toString() !== obj2[key].toString()) {
            return false;
          }
        } else {
          if (obj1[key] !== obj2[key]) {
            return false;
          }
        }
      }
    }

    return true;
  }
}

// let obj = {here: {is: "an"}, object: 2};
// console.log(deepEqual(obj, obj));
// let result = deepEqual(obj, {here: 1, object: 2});
// console.log(result);
// console.log(deepEqual(obj, {here: {is: "an"}, object: 2}));

// test
let a = {
  b: 32,
  c: 1024,
  d: {
    e: [64, 1024],
    f: function () {
      console.log("f");
    }
  },
  g: null,
  h: undefined,
  // [Symbol("foo")]: "symbol",
  i: ["end"],
};

let b = {
  b: 32,
  c: 1024,
  d: {
    e: [64, 1024],
    f: function () {
      console.log("f");
    }
  },
  g: null,
  h: undefined,
  // [Symbol("foo")]: "symbol",
  i: ["end"],
};

// 循环引用
a.R = a;
b.R = b;

// let res = deepEqual(a, b)
// console.log(res);


/**
 * 深度比较（考虑循环引用？）
 * @param {any} a
 * @param {any} b
 * @return {boolean}
 */
function deepEqualOpt(a, b) {
  const map1 = new Map();
  const map2 = new Map();
  return _deepEqualOpt(a, b);


  function _deepEqualOpt(obj1, obj2) {
    if (map1.has(obj1) && map2.has(obj2)) {
      return map1.get(obj1) === map2.get(obj2);
    } else {
      map1.set(obj1, obj1);
      map2.set(obj2, obj2);
    }

    // 获取对象自身的所有属性（包括不可枚举属性和Symbol属性）
    let keysA = Reflect.ownKeys(obj1);
    let keysB = Reflect.ownKeys(obj2);
    // let keysA = Object.keys(obj1);
    // let keysB = Object.keys(obj2);

    // 如果两者的属性个数不同，直接返回false
    if (keysA.length !== keysB.length) {
      return false;
    }

    // 如果一个对象拥有另一个对象所没有的属性，直接返回false
    for (let key of keysA) {
      if (!keysB.includes(key)) {
        return false;
      }
    }

    // 逐一判断对应的属性是否相同（内容）
    for (let key of keysA) {
      if (obj1[key] === null) {
        if (obj2[key] !== null) return false;
      } else {
        if (typeof obj1[key] === "object") {
          if (typeof obj2[key] !== "object") {
            // 如果obj2[key]不是对象的话，直接返回false
            return false;
          }
          // 否则，递归的比较obj1[key]和obj2[key]内容是否相等
          if (!_deepEqualOpt(obj1[key], obj2[key])) {
            return false;
          }
        } else if (typeof obj1[key] === "function") {
          // 函数可以不予考虑
          if (obj1[key].toString() !== obj2[key].toString()) {
            return false;
          }
        } else {
          if (obj1[key] !== obj2[key]) {
            return false;
          }
        }
      }
    }

    return true;
  }
}

// test
let res = deepEqualOpt(a, b);
console.log(res);
let obj = {here: {is: "an"}, object: 2};
console.log(deepEqualOpt(obj, obj));
let result = deepEqualOpt(obj, {here: 1, object: 2});
console.log(result);
console.log(deepEqualOpt(obj, {here: {is: "an"}, object: 2}));
