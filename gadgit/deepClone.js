/** 深拷贝的两种不完全实现 **/


/**
 * 使用map来解决循环应用的问题
 *
 * @param obj
 * @returns {null|[]|{}}
 */
function deepCopy(obj) {
  const map = new Map(); // 用以解决循环引用的问题

  function _deepCopy(obj) {
    if (obj === null) {
      return null;
    }

    if (typeof obj === "object") {
      if (map.has(obj)) {
        return map.get(obj);
      }

      // 未考虑兼容Date类型等，这些对象会被统一转为空对象{}
      let newObj = Array.isArray(obj) ? [] : {};
      map.set(obj, newObj);

      // 会拷贝对象自身的所有属性，包括不可枚举属性和Symbol属性
      Reflect.ownKeys(obj).forEach(key => {
        newObj[key] = _deepCopy(obj[key]);
      });

      return newObj;
    } else {
      return obj;
    }
  }

  return _deepCopy(obj);
}


/**
 * 使用数组来解决循环引用的问题
 *
 * @param obj
 * @returns {null|[]|{}}
 */
function deepClone(obj) {
  const copied_objs = []; // 解决循环引用的问题

  function _deepClone(obj) {
    if (obj === null) {
      return null;
    }

    if (typeof obj === "object") {
      for (let i = 0; i < copied_objs.length; i++) {
        if (copied_objs[i].source === obj) {
          return copied_objs[i].target;
        }
      }

      let newObj = Array.isArray(obj) ? [] : {};
      copied_objs.push({source: obj, target: newObj});

      Reflect.ownKeys(obj).forEach(key => {
        newObj[key] = _deepClone(obj[key]);
      });

      return newObj;
    } else {
      return obj;
    }
  }

  return _deepClone(obj);
}


let A = {
  a: {
    name: "qihui",
    age: 24,
    hobbies: ["basketball", "lol", "oil", {home: "连城", work: "quanzhou"}]
  },
  b: null,
  c: undefined,
  d: String("hello"),
  e: "hello",
  [Symbol("f")]() {
    console.log("in symbol");
  },
  g: new Date()
}

A.A = A;
console.log(deepCopy(A));
console.log(deepClone(A));


// result
// <ref *1> {
//   a: {
//     name: 'qihui',
//     age: 24,
//     hobbies: [ 'basketball', 'lol', 'oil', [Object] ]
//   },
//   b: null,
//   c: undefined,
//   d: 'hello',
//   e: 'hello',
//   g: {},
//   A: [Circular *1],
//   [Symbol(f)]: [Function: [f]]
// }
// <ref *1> {
//   a: {
//     name: 'qihui',
//     age: 24,
//     hobbies: [ 'basketball', 'lol', 'oil', [Object] ]
//   },
//   b: null,
//   c: undefined,
//   d: 'hello',
//   e: 'hello',
//   g: {},
//   A: [Circular *1],
//   [Symbol(f)]: [Function: [f]]
// }
