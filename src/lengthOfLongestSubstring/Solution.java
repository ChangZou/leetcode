package lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Package: lengthOfLongestSubstring
 * @ClassName: Solution
 * @Author: Sober
 * @Description:
 * @Date: 2021/8/22 21:59
 * @Version: 0.0.1
 */
public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int present = 0;
        int head = 0;
        Map<Character,Integer> c = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (!c.containsKey(s.charAt(i))){
                present++;
            }else {
                if (head <= c.get(s.charAt(i))){
                    head = c.get(s.charAt(i));
                    if (max < present){
                        max = present;
                    }
                    present = i - c.get(s.charAt(i));
                }else {
                    present++;
                }
            }
            c.put(s.charAt(i),i);
        }
        return Math.max(max, present);
    }

    public static int lengthOfLongestSubstring1(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
