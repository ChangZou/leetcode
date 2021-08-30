package lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.Map;

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


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
