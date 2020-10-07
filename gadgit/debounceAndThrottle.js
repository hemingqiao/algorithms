/** 简单实现节流和防抖 **/


/*
debounce（防抖）：事件持续触发，但只有在事件停止触发n秒后才会执行回调。
 */

/**
 * 借助于定时器实现防抖，但是这个版本在首次触发事件后并不会执行回调
 *
 * @param callback
 * @param delay
 * @returns {function(...[*]=): void}
 */
function debounce(callback, delay) {
  let timeout;

  return function (...args) {
    const ctx = this; // 防止this值被改变，实际上下面使用了箭头函数，这一步不再是必须的了
    if (timeout) {
      clearTimeout(timeout);
    }
    timeout = setTimeout(
      () => {
        callback.apply(ctx, args);
      },
      delay
    );
  }
}


/**
 * 与上面的相比，添加了一个immediate参数来标记在首次触发事件后是否立即执行一次回调。
 * immediate为true，则会再首次出发时间后立即执行一次回调。
 *
 * @param callback
 * @param delay
 * @param immediate
 * @returns {function(...[*]=): void}
 */
function debounce(callback, delay, immediate) {
  let timeout;

  return function (...args) {
    const ctx = this;
    if (timeout) {
      clearTimeout(timeout);
    }
    if (immediate) {
      const callNow = !timeout;

      timeout = setTimeout(
        () => {
          callback.apply(ctx, args);
        },
        delay
      );

      /*
      // or
      timeout = setTimeout(
        () => {
          timeout = null; // 写成这样也是可以的，但是这样的话回调的执行依赖于再触发一次事件
        },
        delay
      );
      */

      if (callNow) {
        callback.apply(ctx, args);
      }
    } else {
      timeout = setTimeout(
        () => {
          callback.apply(ctx, args);
        },
        delay
      );
    }
  }
}


/*
throttle（防抖）：当事件持续触发时，每n秒执行一次回调。
通常使用定时器或者时间戳来实现节流。
 */


/**
 * 使用定时器实现节流。
 *
 * @param callback
 * @param delay
 * @returns {function(...[*]=): void}
 */
function throttle(callback, delay) {
  let timeout;

  return function (...args) {
    const ctx = this;
    if (!timeout) {
      timeout = setTimeout(
        () => {
          callback.apply(ctx, args);
          timeout = null;
        },
        delay
      );
    }
  }
}
