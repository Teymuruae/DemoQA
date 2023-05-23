package selenide.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    private static String browser = System.getProperty("browser", "chrome100");
    private static String browserSize = System.getProperty("size", "1920x1080");
    private static String remoteAddress = System
            .getProperty("selenoid", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
    static String baseUrl = System.getProperty("Url", "https://demoqa.com");


    @BeforeAll
    public static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = browserSize;
        Configuration.pageLoadTimeout = 10000;
        Configuration.baseUrl = baseUrl;
//        Configuration.holdBrowserOpen = true;
//        Configuration.browser = browser;
        Configuration.remote = remoteAddress;
        switcher(browser);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;

    }

    @BeforeEach
    public void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void tearDown() {
        Attachments.pageSource2();
        Attachments.attachScreenshot();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();

    }

    public static void switcher(String browser) {
        switch (browser) {
            case "chrome100":
                Configuration.browser = "chrome";
                Configuration.browserVersion = "100";
                break;
            case "chrome99":
                Configuration.browser = "chrome";
                Configuration.browserVersion = "99.0";
                break;
            case "fireFox97":
                Configuration.browser = "fireFox";
                Configuration.browserVersion = "97.0";
                break;
            case "fireFox98":
                Configuration.browser = "fireFox";
                Configuration.browserVersion = "98.0";
                break;
        }
    }
}
