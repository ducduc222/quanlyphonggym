package quanlyphonggym.Util;

public class CheckSoDienThoai {
    public static boolean checkSoDienThoai(String stringPhoneNumber) {
        System.out.println(stringPhoneNumber);

        if (stringPhoneNumber.length() == 10 && stringPhoneNumber.matches("[0-9]+") && !stringPhoneNumber.isEmpty()) {
            System.out.println("Valid PhoneNumber string: "+stringPhoneNumber);
            return true;
        } else {
            System.out.println("Invalid PhoneNumber string: "+stringPhoneNumber);
            return false;
        }

    }
}
