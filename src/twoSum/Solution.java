package twoSum;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: TheSumOfTwoNumbers
 * @ClassName: main
 * @Author: Sober
 * @Description:
 * @Date: 2021/8/22 19:05
 * @Version: 0.0.1
 */
public class Solution {
    public static Integer[] twoSum(int[] nums, int target) {
        /**
         * @Method: twoSum
         * @Author: Sober
         * @Version: 0.0.1
         * @Description: 暴力破解
         * @param nums
         * @param target
         * @Return: int[]
         * @Exception:
         * @Date: 2021/8/22 19:11
         */
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new Integer[]{i,j};
                }
            }
        }
        return null;
    }

    public static Integer[] twoSum2(int[] nums, int target) {
        /**
         * @Method: twoSum2
         * @Author: Sober
         * @Version: 0.0.1
         * @Description: 因为默认只有一个解答，所以使用hash解法
         * @param nums
         * @param target
         * @Return: int[]
         * @Exception:
         * @Date: 2021/8/22 20:30
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int residue = target - nums[i];
            if (map.containsKey(residue)) {
                return new Integer[]{map.get(residue),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum2(nums, 9)));
    }

}