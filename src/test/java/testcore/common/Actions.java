package testcore.common;

import org.testng.Assert;

public class Actions {
    /**
     * Assert equals.
     */
    public static void assertEquals(Object actual, Object expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }
}
