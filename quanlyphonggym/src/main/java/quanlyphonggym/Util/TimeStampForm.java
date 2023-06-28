package quanlyphonggym.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStampForm {
    public static String returnTimeStampString(long timestamp) {
//        timestamp = new Date().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return dateFormat.format(new Date(timestamp));
    }
}
