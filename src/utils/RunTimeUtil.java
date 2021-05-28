package utils;

public class RunTimeUtil {
    private static String userId;
    private static String password;
    private static String typeOfUser;


    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        RunTimeUtil.password = password;
    }


    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        RunTimeUtil.userId = userId;
    }

    public static String getTypeOfUser() {
        return typeOfUser;
    }

    public static void setTypeOfUser(String typeOfUser) {
        RunTimeUtil.typeOfUser = typeOfUser;
    }
}
