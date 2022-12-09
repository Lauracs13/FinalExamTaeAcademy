package org.academy.utils.mobile;

public class StringUtils {
    public static final String URL = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
    public static final String FIRSTNAME = "pepita";
    public static final String LASTNAME = "perez";
    public static final String PASSWORD = "pepaperez123@";
    public static final String EMAIL = getRandomEmail();
    private static String randomEmail = FIRSTNAME + "." + LASTNAME + (int) Math.floor(Math.random() * 10000) + "@email.com";

    public static String getRandomEmail() {
        return randomEmail;
    }
}
