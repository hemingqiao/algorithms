package src.graph.accountsmerge721;

import src.graph.UnionFindSet;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/18 13:01:19
 * description:
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素
 * 是 emails 表示该账户的邮箱地址。
 *
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于
 * 不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 *
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 输出：
 * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 *  
 *
 * 提示：
 *
 * accounts的长度将在[1，1000]的范围内。
 * accounts[i]的长度将在[1，10]的范围内。
 * accounts[i][j]的长度将在[1，30]的范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/accounts-merge
 *
 * 参考：https://leetcode-cn.com/problems/accounts-merge/solution/java-hao-shi-90nei-cun-50bing-cha-ji-fang-fa-by-wm/
 * 参考：https://leetcode-cn.com/problems/accounts-merge/solution/tu-jie-yi-ran-shi-bing-cha-ji-by-yexiso-5ncf/
 */
public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFindSet ufs = new UnionFindSet(n);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                // 如果两个账户下出现了相同的邮箱email，表明是同一个人，那么将账户A和账户B两个连通分量进行合并
                if (map.containsKey(email)) {
                    int index = map.get(email);
                    ufs.union(index, i);
                }
                map.put(email, i);
            }
        }
        Map<Integer, Set<String>> map1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int index = ufs.find(i);
            List<String> account = accounts.get(i);
            List<String> emails = account.subList(1, account.size());
            if (map1.containsKey(index)) {
                map1.get(index).addAll(emails);
            } else {
                map1.put(index, new TreeSet<>(emails));
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : map1.entrySet()) {
            List<String> temp = new LinkedList<>();
            int index = entry.getKey();
            String name = accounts.get(index).get(0);
            temp.add(name);
            temp.addAll(entry.getValue());
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> a1 = new ArrayList<>(){{
            add("John");
            add("johnsmith@mail.com");
            add("john00@mail.com");
        }};
        List<String> a2 = new ArrayList<>(){{
            add("John");
            add("johnnybravo@mail.com");
        }};
        List<String> a3 = new ArrayList<>(){{
            add("John");
            add("johnsmith@mail.com");
            add("john_newyork@mail.com");
        }};
        List<String> a4 = new ArrayList<>(){{
            add("Mary");
            add("mary@mail.com");
        }};
        List<List<String>> accounts = new ArrayList<>(){{
            add(a1);
            add(a2);
            add(a3);
            add(a4);
        }};
        List<List<String>> res = new Solution().accountsMerge(accounts);
        System.out.println(res);
    }
}
