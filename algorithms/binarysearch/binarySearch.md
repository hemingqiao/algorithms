# 二分查找中退出循环的条件以及如何处理左右指针

二分查找一般会定义两个指针，left和right，这两个指针界定了查找的区间。这个区间可以是左闭右开，即[left, right)；也可以是左闭右闭的，
如[left, rihgt]；这个搜索区间右边界的开闭会影响实现二分搜索算法的一些细节。

1、退出循环的条件

如果区间是左闭右开的，那么right一般取整个序列的长度（或者序列中元素的个数），因为最右边元素的索引往往是序列长度减去1，因为右边是开区间，
所以right可以取到序列的长度，又能够包含所有的元素，此时while循环的退出条件一般是left < right，因为右侧（right）是开区间，当退出
循环时，left == right，如果有必要，可以在退出循环后做一些判断。

在循环内部，如果mid处的元素值与目标值相同，可以直接返回，如果mid处的值大于target，此时left 可以变为 mid + 1，如果mid处的值小于target，
right变为mid，注意这里，right不是变为 mid - 1，这正是因为右侧是开区间，mid处的元素判断过了，左侧是闭区间，可以取到 mid + 1，
而右侧是开区间，如果变为 mid - 1，会取不到 mid - 1处的元素。

而如果区间是左闭右闭的，细节和上面又有不同，如 right 此时一般为可以取到的最大索引，也即序列长度减去1，退出循环的条件一般设为 left <= right
，而左右指针的移动，left -> mid + 1，而right -> mid - 1，因为此时右侧是闭区间，可以取到 mid - 1处的元素。

具体操作还是要视题目的具体内容而定。

2、二分搜索中值mid的写法

1、int mid = (left + right) / 2; 是初级写法，是有 bug 的，因为当 left 和 right 很大的时候，left + right 会发生整型溢出，变成负数；

2、int mid = left + (right - left) / 2; 是正确的写法，说明你考虑到了整型溢出的风险；

3、int mid = (low + high) >>> 1; 首先肯定是正确的写法，其实也是一个装 ❌ 的写法，理由上面已经叙述过了。

作者：liweiwei1419

链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower/solution/shi-fen-hao-yong-de-er-fen-cha-zhao-fa-mo-ban-pyth/


## 二分查找的js实现：

```js
// 在有序数组中寻找最小的插入位置
function sortedIndex(array, value) {
    let low = 0, high = array.length; // 插入位置可能是数组的末尾，因此将high初始化为length
    while (low < high) {
        let mid = (low + high) >>> 1;
        // 小于value的位置一定不是寻找的解
        if (array[mid] < value) {
            // 新的搜索区间为[mid + 1, high]
            low = mid + 1;
        } else {
            // array[mid]大于等于value时还需要继续向左进行查找
            // 因为数组中可能存在重复元素，而要求是寻找可能的最小的插入位置
            // 新的搜索区间为[low, high]
            high = mid;
        }
    }
    return high; // 退出循环时low == high，返回high和low均可
}

// 在有序数组中查找值
function sortedIndexOf(array, value) {
    let low = 0, high = array.length - 1;
    while (low < high) {
        let mid = (low + high) >>> 1;
        // 小于value的位置一定不是解
        if (array[mid] < value) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }
    return low;
}


/**
 * Uses a binary search to determine the lowest index at which value should be inserted into array in order to maintain its sort order.
 * @param array
 * @param value
 * @return {number}
 */
function sortedIndex(array, value) {
  let low = 0, high = array.length; // 插入位置可能是数组的末尾，因此将high初始化为length
  while (low < high) {
    let mid = (low + high) >>> 1;
    // 小于value的位置一定不是寻找的解
    if (array[mid] < value) {
      // 新的搜索区间为[mid + 1, high]
      low = mid + 1;
    } else {
      // array[mid]大于等于value时还需要继续向左进行查找
      // 因为数组中可能存在重复元素，而要求是寻找可能的最小的插入位置
      // 新的搜索区间为[low, high]
      high = mid;
    }
  }
  return high; // 退出循环时low == high，返回high和low均可
}

// /**
//  * 采取暴力破解
//  * 将 value 值插入到有序数组中 尽可能小的索引位置，以保证array的排序。
//  * @param array
//  * @param value
//  * @return {number|*}
//  */
// function sortedIndex(array, value) {
//   for (let i = 0; i < array.length; i++) {
//     if (array[i] >= value) {
//       return i;
//     }
//   }
//   return array.length;
// }


/**
 * This method is like _.sortedIndex except that it accepts iteratee which is invoked for value and each element of
 * array to compute their sort ranking. The iteratee is invoked with one argument: (value).
 * @param array
 * @param value
 * @param iteratee
 * @return {number}
 */
function sortedIndexBy(array, value, iteratee) {
  iteratee = transform(iteratee);
  const arrayCopy = array.map(val => iteratee(val));
  const valueCopy = iteratee(value);
  return sortedIndex(arrayCopy, valueCopy);
}


/**
 * This method is like _.indexOf except that it performs a binary search on a sorted array(有序数组).
 * @param array
 * @param value
 * @return {number}
 */
function sortedIndexOf(array, value) {
  // 与sortedIndex的不同之处在于此处查找上界为len - 1，保证了退出循环时得到的值一定是合法索引
  // 而sortedIndex的查找上界是len，所以对于某个大于数组中所有的值的value，退出循环时会得到len，此时已经越界，应该返回-1
  let low = 0, high = array.length - 1;
  while (low < high) {
    let mid = (low + high) >>> 1;
    // 小于value的位置一定不是解
    if (array[mid] < value) {
      low = mid + 1;
    } else {
      high = mid;
    }
  }
  // 如果low处对应的值不等于目标值value，返回-1
  if (array[low] === value) {
    return low;
  }
  return -1;
}


/**
 * This method is like _.sortedIndex except that it returns the highest index at which value should be inserted into
 * array in order to maintain its sort order.
 * @param array
 * @param value
 * @return {number}
 */
function sortedLastIndex(array, value) {
  let low = 0, high = array.length;
  while (low < high) {
    let mid = (low + high) >>> 1;
    // 寻找最大的插入位置，即寻找到值等于value的位置后仍需向右边移动
    // 与sortedIndex的不同之处就在于此处判断条件多了等于
    if (array[mid] <= value) {
      low = mid + 1;
    } else {
      high = mid;
    }
  }
  return low;
}


/**
 * This method is like _.sortedLastIndex except that it accepts iteratee which is invoked for value and each element
 * of array to compute their sort ranking. The iteratee is invoked with one argument: (value).
 * @param array
 * @param value
 * @param iteratee
 * @return {number}
 */
function sortedLastIndexBy(array, value, iteratee) {
  iteratee = transform(iteratee);
  const arrayCopy = array.map(val => iteratee(val));
  const valueCopy = iteratee(value);
  return sortedLastIndex(arrayCopy, valueCopy);
}


/**
 * This method is like _.lastIndexOf except that it performs a binary search on a sorted array.
 * @param array
 * @param value
 * @return {number}
 */
function sortedLastIndexOf(array, value) {
  let index = sortedLastIndex(array, value);
  if (array[index - 1] === value) {
    return index - 1;
  }
  return -1;
}
```
