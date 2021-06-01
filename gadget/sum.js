/*
// 假设有一台本地机器，无法做加减乘除运算（包括位运算），因此无法执行 a + b、a += 1 这样的 JS 代码，然后我们提供一个服务器端的 HTTP API，
可以传两个数字类型的参数，响应结果是这两个参数的和，这个 HTTP API 的 JS SDK（在本地机器上运行）的使用方法如下：

asyncAdd(3, 5, (err, result) => {
  console.log(result); // 8
});

// SDK 的模拟实现：

function asyncAdd(a, b, cb) {
  setTimeout(() => {
    cb(null, a + b);
  }, Math.floor(Math.random()*1000))
}

// 现在要求在本地机器上实现一个 sum 函数，支持以下用法：

(async () => {
  const result1 = await sum(1, 4, 6, 9, 2, 4);
  const result2 = await sum(3, 4, 9, 2, 5, 3, 2, 1, 7);
  const result3 = await sum(1, 6, 0, 5);
  console.log([result1, result2, result3]); // [26, 36, 12]
})();

// 要求 sum 能在最短的时间里返回以上结果
 */


// solution1，利用二分的思想
function asyncAdd(a, b, cb) {
  setTimeout(() => {
    cb(null, a + b);
  }, 100);
}

async function sum(...args) {
  let n = args.length;
  if (n === 0) return 0;
  if (n === 1) return args[0];
  if (n % 2 === 0) {
    let tasks = [];
    for (let i = 0; i < n; i += 2) {
      tasks.push(promiseAdd(args[i], args[i + 1]))
    }
    const ret = await Promise.all(tasks);
    return sum(...ret);
  } else {
    // let idx = Math.random() * n | 0; // 随机取[0, n - 1]内的一个下标
    // return sum(await sum(args.splice(idx, 1)[0], 0), await sum(...args));
    return sum(await sum(args.pop(), 0), await sum(...args));
  }
}

function promiseAdd(a, b) {
  return new Promise((resolve, reject) => {
    asyncAdd(a, b, (err, result) => {
      if (err) {
        reject(err);
      } else {
        resolve(result);
      }
    });
  });
}

(async function run() {
  console.time("start");
  let res = await sum(1, 2, 3, 4, 5, 6, 7);
  console.log(res);
  console.timeEnd("start");
})();


// solution2 利用回调，先同步发出所有请求，一旦有两个以上完成，接着发出请求
function asyncAdd(a, b, cb) {
  setTimeout(() => {
    cb(null, a + b);
  }, 100)
}

function sum(...args) {
  return new Promise((resolve, reject) => {
    if (args.length === 0) {
      return resolve(0);
    }
    run();

    function run() {
      let a, b;
      if (args.filter(e => e !== null).length > 1) {
        let idx1 = args.findIndex(e => e !== null);
        a = args.splice(idx1, 1)[0];
        let idx2 = args.findIndex(e => e !== null);
        b = args.splice(idx2, 1)[0];
        args.push(null); // 用来占位

        asyncAdd(a, b, (err, result) => {
          if (err) {
            reject(err);
          }
          for (let i = 0; i < args.length; i++) {
            if (args[i] === null) {
              args[i] = result; // 将占位元素替换
              break;
            }
          }
          if (args.filter(e => e !== null).length > 1) {
            run();
          } else if (args.length === 1 && args[0] !== null) {
            resolve(args[0]);
          }
        });

        run();
      } else if (args.length === 1 && args[0] !== null) {
        resolve(args[0]);
      }
    }
  });
}

(async function run() {
  console.time("start");
  let res = await sum(1,2,3,4,5,6,7,8);
  console.log(res);
  console.timeEnd("start");
})();
