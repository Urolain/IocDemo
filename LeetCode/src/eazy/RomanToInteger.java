package eazy;

/**
 * 罗马数字转整数
 * roman-to-integer
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 存在以下特殊使用
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 */
public class RomanToInteger {

    /**
     *  23ms 39.7MB
     * @param roman 罗马数字
     * @return 1~3999    I~MMMDCCCCLXXXXVIIII
     */
    public static int romanToInteger(String roman){
        //  用switch映射
        int result = 0;
        for (int i = 0; i < roman.length(); i++) {
            switch (roman.charAt(i)) {
                case 'M':
                    result += 1000;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'C':
                    result += 100;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'X':
                    result += 10;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'I':
                    result += 1;
                    break;
                default:
                    result += 0;
            }

            //  特殊情况单独处理
            if (i != 0 && (roman.charAt(i) == 'V' || roman.charAt(i) == 'X' ) && roman.charAt(i-1)== 'I') {
                //  IV 6 ---> 4  IX 11 ---> 9    6($^&%)=4 11($^&%*^)=9  6-2=4 11-2=9 n=n-1*2
                result -= 2;
            }

            if (i != 0 && (roman.charAt(i) == 'L' || roman.charAt(i) == 'C' ) && roman.charAt(i-1)== 'X') {
                result -= 20;
            }

            if (i != 0 && (roman.charAt(i) == 'D' || roman.charAt(i) == 'M' ) && roman.charAt(i-1)== 'C') {
                result -= 200;
            }
        }
        return result > 3999 ? 0:result;
    }
}
