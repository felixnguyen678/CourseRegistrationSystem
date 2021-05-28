package utils;

public class StringUtil {
    public static boolean isLong(String str){
        try {
            Long.parseLong(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
