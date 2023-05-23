package selenide.demoqa;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class DemoQaTest extends TestBase  {

    private RegistrationPage registrationPage = new RegistrationPage();
    private ModalDialog modalDialog = new ModalDialog();
    private String state = TestData.state;
    private String city = TestData.city();

    @Tag("remote")
    @DisplayName("registration form test")
    @Owner("TimBart")
    @Test
    public void demoQaTest() {
       step("Open page", () -> {
           registrationPage
                   .openPage();
       });
       step("fill registration form", () ->{
            registrationPage
                    .fillFirstName(TestData.name)
                    .fillLastName(TestData.lastName)
                    .fillEmail(TestData.email)
                    .setGender(TestData.gender)
                    .setDate(TestData.day, TestData.month, TestData.year)
                    .setMobile(TestData.phoneNumber)
                    .chooseHobby(TestData.hobbies)
                    .uploadPic("test.png")
//                    .setSubject(TestData.subject)
                    .fillAddress(TestData.address)
                    .setStateAndCity(state, city)
                    .clickSubmitButton();
        });
       step("verify form", () -> {
           modalDialog
                   .checkTitleVisible()
                   .checkKeyValue("Student Name", TestData.name + " " + TestData.lastName)
                   .checkKeyValue("Student Email", TestData.email)
                   .checkKeyValue("Gender", TestData.gender)
                   .checkKeyValue("Mobile", TestData.phoneNumber)
                   .checkKeyValue("Date of Birth", String.format("%s %s,%s", TestData.day, TestData.month, TestData.year))
//                   .checkKeyValue("Subjects", TestData.subject)
                   .checkKeyValue("Hobbies", TestData.hobbies)
                   .checkKeyValue("Picture", "test.png")
                   .checkKeyValue("Address", TestData.address)
                   .checkKeyValue("State and City", state + " " + city);
       });


    }

    @Tag("testov")
    @Test
    void test1(){
    String browser = System.getProperty("browser", "chrome");
        System.out.println(browser);
    }
}
