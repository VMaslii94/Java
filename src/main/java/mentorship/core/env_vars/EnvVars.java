package mentorship.core.env_vars;

public class EnvVars {

    public static String CHROME_DRIVER_PATH = System.getProperty("CHROMEPATH");
    public static String FIREFOX_DRIVER_PATH = System.getProperty("FIREFOXPATH");
    public static boolean HEADLESS = false;
    public static int WAIT_TIMEOUT = 60;

    static {
        setChromeDriverPath();
        setFirefoxDriverPath();
        setHeadless();
    }

    private static void setChromeDriverPath() {
        if (CHROME_DRIVER_PATH == null) {
            CHROME_DRIVER_PATH = "src/test/resources/drivers/chromedriver";
            //  Log.warn("chrome.driver.path is not set!!! Using '" + CHROME_DRIVER_PATH + "' by default");
        }
        //Log.info("chrome.driver.path is: " + CHROME_DRIVER_PATH);

    }

    private static void setFirefoxDriverPath() {
        if (FIREFOX_DRIVER_PATH == null) {
            FIREFOX_DRIVER_PATH = "src/test/resources/drivers/geckodriver";
            //   Log.warn("firefox.driver.path is not set!!! Using '" + FIREFOX_DRIVER_PATH + "' by default");
        }
        //  Log.info("firefox.driver.path is: " + FIREFOX_DRIVER_PATH);
    }

    private static void setHeadless() {
        if (System.getProperty("HEADLESS") != null) {
            HEADLESS = Boolean.parseBoolean(System.getProperty("HEADLESS"));
        } else if (System.getProperty("HEADLESS") == null && !HEADLESS) {
            HEADLESS = false;
        } else if (System.getProperty("HEADLESS") == null && HEADLESS) {
            HEADLESS = true;
        } else {
            HEADLESS = false;
        }

    }


}

