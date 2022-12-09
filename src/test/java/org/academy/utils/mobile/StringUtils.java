package org.academy.utils.mobile;

/**
 * The type String utils.
 */
public class StringUtils {
    /**
     * The constant URL.
     */
    public static final String URL = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
    /**
     * The constant FIRSTNAME.
     */
    public static final String FIRSTNAME = "pepita";
    /**
     * The constant LASTNAME.
     */
    public static final String LASTNAME = "perez";
    /**
     * The constant PASSWORD.
     */
    public static final String PASSWORD = "pepaperez123@";
    /**
     * The constant EMAIL.
     */
    public static final String EMAIL = getRandomEmail();
    private static String randomEmail = FIRSTNAME + "." + LASTNAME + (int) Math.floor(Math.random() * 10000) + "@email.com";

    /**
     * Gets random email.
     *
     * @return the random email
     */
    public static String getRandomEmail() {
        return randomEmail;
    }
}
