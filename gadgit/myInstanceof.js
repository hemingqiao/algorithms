/** 对instanceof的简单实现 **/


/**
 * A instanceof B 的原理就是判断B的原型对象是否存在于A的原型链上
 *
 * @param A
 * @param B
 * @returns {boolean}
 * @constructor
 */
function MyInstanceof(A, B) {
  var rightPrototype = B.prototype;
  var leftProto = Object.getPrototypeOf(A);

  while (true) {
    if (rightPrototype == null) {
      throw new Error();
    }

    if (leftProto == null) {
      return false;
    }

    if (leftProto === rightPrototype) {
      return true;
    }
    leftProto = Object.getPrototypeOf(leftProto);
  }
}
