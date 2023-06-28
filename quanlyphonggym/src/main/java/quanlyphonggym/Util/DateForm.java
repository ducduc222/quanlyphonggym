package quanlyphonggym.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateForm {
    public static String returnDateString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
}
