function deepClone(obj) {
	const map = new Map(); // 解决循环引用问题

	function auxiliary(obj) {
		if (obj === null) {
			return null;
		}

		if (typeof obj === "object") {
			// 未考虑兼容Date、Number、String等类型实例对象，这些对象会被替换为空对象{}
			let newObj = Array.isArray(obj) ? [] : {};

			if (map.has(obj)) {
				return map.get(obj);
			}
			map.set(obj, newObj);

			// 不可枚举属性，Symbol类型属性均会被复制
			Reflect.ownKeys(obj).forEach(key => {
				newObj[key] = auxiliary(obj[key]);
			});

			return newObj;
		} else {
			return obj;
		}
	}

	return auxiliary(obj);
}


// test
let A = {
    a: 1,
    b: [1, 2, 3],
    c: {
        "0": 0
    },
    d: undefined,
    e: null,
    f: new Date()
};
A.A = A;
A.B = A;
A.c.C = A;

console.log(deepClone(A));

// result:
// <ref *1> {
//   a: 1,
//   b: [ 1, 2, 3 ],
//   c: { '0': 0, C: [Circular *1] },
//   d: undefined,
//   e: null,
//   f: {},
//   A: [Circular *1],
//   B: [Circular *1]
// }
