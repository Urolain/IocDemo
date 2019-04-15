package eazy;

/**
 * 整数反转
 * 如-98657 翻转为 -75698
 * 98659 翻转为95689
 * 7569350 翻转为539657
 */
public class ReverseInteger {

    public static int reverse(int x) {
        //  存放该整数的符号
        int temp = x;
        long val = 0L;
        x = Math.abs(x);
        while (x > 0) {
            //  取当前值的余,之前取到余值往前递进一位
            val = x%10 + val*10;
            //  缩进一位
            x = x/10;
        }

        if (val > Integer.MAX_VALUE || val < Integer.MIN_VALUE) {
            return 0;
        }
        //  还原符号
        if (temp > 0) {
            return (int) val;
        }else {
            return (int) -val;
        }

    }

}
