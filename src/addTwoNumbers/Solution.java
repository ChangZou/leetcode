package addTwoNumbers;


/**
 * @ProjectName: leetcode
 * @Package: addTwoNumbers
 * @ClassName: Solution
 * @Author: Sober
 * @Description:
 * @Date: 2021/8/22 20:40
 * @Version: 0.0.1
 */

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return val+",";
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * @Method: addTwoNumbers
         * @Author: Sober
         * @Version: 0.0.1
         * @Description: 本身数字顺序就是倒序的，即从首位开始相加进位加在后一位即可得出答案
         * @param l1
         * @param l2
         * @Return: addTwoNumbers.Solution.ListNode
         * @Exception:
         * @Date: 2021/8/22 21:14
         */
        ListNode head,tail;
        head = tail = new ListNode(0);
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0 ){
            int num = (l1 != null ? l1.val:0) + (l2 != null ? l2.val:0) + carry;
            carry = num / 10;
            tail.next = new ListNode(num % 10);
            tail  = tail.next;
            l1 = l1 != null ? l1.next:null;
            l2 = l2 != null ? l2.next:null;
        }
        return head.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        addTwoNumbers(l1,l2);
    }
}