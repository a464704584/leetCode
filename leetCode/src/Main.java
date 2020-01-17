import bean.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @创建者 CY
 * @创建时间 2020/1/17 10:29
 * @描述
 */
public class Main {
        volatile int a=1;
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{}));
    }


    public static ListNode addTwoNumber(ListNode l1,ListNode l2){
        ListNode result=new ListNode(0);
        ListNode currentNode=result;
        while (true){
            if (l1==null&&l2==null){
                return result;
            }
            if (l1==null){
                if (l2.val+currentNode.val>=10){
                    currentNode.next=new ListNode(1);
                    currentNode.val=(l2.val+currentNode.val)%10;
                    currentNode=currentNode.next;
                    l2=l2.next;
                    continue;
                }else {
                    currentNode.val=(l2.val+currentNode.val)%10;
                    currentNode.next=l2.next;
                    return result;
                }
            }

            if (l2==null){
                if (l1.val+currentNode.val>=10){
                    currentNode.next=new ListNode(1);
                    currentNode.val=(l1.val+currentNode.val)%10;
                    currentNode=currentNode.next;
                    l1=l1.next;
                    continue;
                }else {
                    currentNode.val=(l1.val+currentNode.val)%10;
                    currentNode.next=l1.next;
                    return result;
                }
            }

            if (l1!=null&&l2!=null){
                if (l1.val+l2.val+currentNode.val>=10){
                    currentNode.next=new ListNode(1);
                    currentNode.val=(l1.val+l2.val+currentNode.val)%10;
                    currentNode=currentNode.next;
                    l1=l1.next;
                    l2=l2.next;
                }else {
                    currentNode.val=(l1.val+l2.val+currentNode.val)%10;

                    l1=l1.next;
                    l2=l2.next;
                    if (l1!=null||l2!=null){
                        currentNode.next=new ListNode(0);
                        currentNode=currentNode.next;
                    }
                }
            }
        }
    }


    /**
     * 整数反转
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }

    /**
     * 回文数
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x<0 ||(x % 10 == 0 && x != 0)){
            return false;
        }
        int num=0;
        while (x>num){
            num=num*10+x%10;
            x=x/10;
        }
        if (x==num||x==num/10){
            return true;
        }
        return false;
    }


    /**
     * 罗马数 转阿拉伯数
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int num=0;
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        num=map.get(s.charAt(s.length()-1));
        int current=map.get(s.charAt(s.length()-1));
        for (int i=s.length()-2;i>=0;i--){
            if (current>map.get(s.charAt(i))){
                num=num-map.get(s.charAt(i));
            }else {
                num=num+map.get(s.charAt(i));
            }
            current=map.get(s.charAt(i));
        }
        return num;
    }


    /**
     * 最长公共前缀
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int min=strs[0].length();
        int minIndex=0;
        for (int i=1;i<strs.length;i++){
            if (strs[i].length()<min){
                minIndex=i;
            }
        }
        String prefix = strs[minIndex];
        for (int i = 0; i < strs.length; i++){
            if (minIndex==i){
               continue;
            }
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;

    }


    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        ListNode start=new ListNode(Integer.MIN_VALUE);
        ListNode c=start;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                c.next=l1;
                l1=l1.next;
            }else {
                c.next=l2;
                l2=l2.next;
            }
            c=c.next;
        }

        if (l1==null){
            c.next=l2;
        }else if (l2==null){
            c.next=l1;
        }

        return start.next;
    }
}
