/** 函数的柯里化 **/

/**
 * 使用es6+语法实现函数的柯里化
 *
 * @param fn
 * @param length
 * @returns {function(...[*]=)}
 */
function curry(fn, length = fn.length) {
  return function (...args) {
    if (length <= args.length) {
      return fn(...args);
    } else {
      return curry(curryAuxiliary(fn, ...args), length - args.length);
    }
  }
}

function curryAuxiliary(fn, ...args) {
  return function (...vars) {
    return fn(...args, ...vars);
  }
}


/**
 * 使用es5的语法实现函数的柯里化，实际上就是用es5的语法重新写了上面的方法
 *
 * @param fn
 * @param length
 * @returns {function(...[*]=)}
 */
function curry(fn, length) {
  length = length || fn.length;

  return function () {
    var args = [].slice.call(arguments);
    if (length <= args.length) {
      return fn.apply(this, args);
    } else {
      var combined = [fn].concat(args);
      return curry(curryAuxiliary.apply(this, combined), length - args.length);
    }
  }
}

function curryAuxiliary(fn) {
  var args = [].slice.call(arguments, 1);

  return function () {
    var vars = [].slice.call(arguments);
    return fn.apply(this, args.concat(vars));
  }
}


/**
 * 箭头函数形式
 *
 * @param fn
 * @param args
 * @returns {*}
 */
const curry = (fn, ...args) =>
  fn.length <= args.length
    ? fn(...args)
    : curry.bind(this, fn, ...args);


/**
 * 普通版本的柯里化，es5语法
 *
 * @param fn
 * @param args
 * @returns {function(...[*]=)}
 */
function curryNormal(fn, args) {
  var length = fn.length;
  args = args || [];

  return function () {
    var args_ = args.slice();
    for (var i = 0; i < arguments.length; i++) {
      args_.push(arguments[i]);
    }

    if (length <= args_.length) {
      return fn.apply(this, args_);
    } else {
      return curryNormal.call(this, fn, args_);
    }
  }
}
