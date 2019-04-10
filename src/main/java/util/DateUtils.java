package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wuyl
 */
public class DateUtils {

    private static final ThreadLocal<SimpleDateFormat> dataFormat = new ThreadLocal<SimpleDateFormat>(){

        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static String getCurrentDate() {
        return dataFormat.get().format(new Date());
    }

}
