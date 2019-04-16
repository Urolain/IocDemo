package eazy;

/**
 * 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 示例：
 *      121 true  878
 *      -121 false
 */
public class PalindromeNumber {

    public static boolean isPalindromeNumber(int x) {

        //  负数显然不是回文数 特殊回文数0
        if (x < 0 || (x%10==0 && x != 0)) {
            return false;
        }

        //  思路1:直接利用整数翻转 要考虑翻转后是否存在整数溢出 >Integer.MAX_VALUE
        int temp = x;
        int val = 0;
        while(x > 0){
            val = x%10 + val*10;
            x /= 10;
        }

        return temp==val?true:false;

        //  思路2：翻转一半 这样就不用考虑整数溢出的情况了 如何知道反转数的位数已达一半？
        //         78655  --->78|556


    }
}
