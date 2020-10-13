/**
 * map 方法会返回一个新的数组，forEach 则不会返回新的数组。如果需要得到一个新的数组，则使用map，否则一般使用forEach
 *
 * @param callback
 * @param thisArg
 * @returns {*}
 */
Array.prototype.myMap = function (callback, thisArg) {
  return this.reduce((mappedArray, currentValue, index, array) => {
    mappedArray[index] = callback.call(thisArg, currentValue, index, array);
    return mappedArray;
  }, []);
}


// test
let array = [32, 1024, 64];
let resultArr = array.myMap((value, index, array) => {
  return {value: value, index: index, length: array.length};
});
console.log(resultArr);


// result:
// [
//   { value: 32, index: 0, length: 3 },
//   { value: 1024, index: 1, length: 3 },
//   { value: 64, index: 2, length: 3 }
// ]
