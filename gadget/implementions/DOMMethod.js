/*! *****************************************************************************
@author Heming
founded at 2021-01-05 17:07:44
created by WebStorm
description: 模拟DOM中的一些方法
***************************************************************************** */

class DOMMethod {
  getElementById(id) {
    const startNode = document.documentElement;
    return dfs(startNode, id);

    function dfs(startNode, id) {
      if (startNode.id === id) {
        return startNode;
      }
      for (let n of startNode.children) {
        let res = dfs(n, id);
        if (res) return n;
      }
      return null;
    }
  }

  /**
   * DOM元素上的getElementsByTagName方法搜索范围限定为该元素的子元素（后代）
   * @param startNode
   * @param tagName
   * @return {[]}
   */
  getElementsByTagName(startNode, tagName) {
    const ret = [];
    tagName = tagName.toUpperCase();
    dfs(startNode, tagName);
    return ret;

    function dfs(startNode, tagName) {
      if (startNode.nodeType === document.TEXT_NODE) {
        return;
      }
      for (let node of startNode.children) {
        if (node.tagName === tagName) ret.push(node);
        dfs(node, tagName);
      }
    }
  }

  // another version
  getElementsByTagName1(startNode, tagName) {
    let ret = [];
    if (startNode.nodeType === document.TEXT_NODE) {
      return [];
    } else {
      for (let node of startNode.children) {
        if (node.tagName.toLowerCase() === tagName) ret.push(node);
        ret = ret.concat(this.getElementsByTagName1(node, tagName));
      }
      return ret;
    }
  }
}
