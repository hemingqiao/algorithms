/**
 * @param {number[]} citations
 * @return {number}
 */
const hIndex = function (citations) {
    // 将其发表的所有SCI论文按被引次数从高到低排序；
    // 从前往后查找排序后的列表，只要当前的引用量大于当前的索引值，则H指数加1，最后得到的结果即为最终的H指数。
    // from: wikipedia
    // 如果排序函数（对其两个参数）返回负值，表明第一个参数会排在第二个参数前面，如果返回正值，则第一个参数会排在第二个参数后面
    citations.sort((a, b) => b - a);
    let count = 0;
    for (let i = 0; i < citations.length; i++) {
        if (citations[i] > i) count++;
    }
    return count;
};
