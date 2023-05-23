package selenide.other;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {

    @BeforeAll
    public static void beforeAll(){
//        WebDriverManager.chromedriver().setup();
        Configuration.pageLoadStrategy = "eager";
//        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    public void setUp(){
        SelenideLogger.addListener("allure", new AllureSelenide());
//        Selenide.open("https://demoqa.com/automation-practice-form");
    }
}
