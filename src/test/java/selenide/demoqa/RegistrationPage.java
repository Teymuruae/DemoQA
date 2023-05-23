package selenide.demoqa;

import com.codeborne.selenide.*;
import org.openqa.selenium.Keys;
import selenide.demoqa.components.CalendarDemoQa;

import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    private CalendarDemoQa calendar = new CalendarDemoQa();
    private String
            uri = "/automation-practice-form",
            h5Text = "Student Registration Form";
    private SelenideElement
            firstNameField = $("input#firstName"),
            lastNameField = $("input#lastName"),
            emailField = $("input#userEmail"),
            h5 = $x("//h5"),
            mobile = $("input#userNumber"),
            upload = $("input#uploadPicture"),
            address = $(Selectors.byTagName("textarea")),
            stateField = $x("//div[text() = 'Select State']"),
            cityField = $x("//div[text() = 'Select City']"),
//            subjectField = $("div.subjects-auto-complete__control"),
            subjectField = $("input#subjectsInput"),
            submitButton = $("button#submit");

    private ElementsCollection
            gender = $$x("//input[@type = 'radio']"),
            hobbies = $$("label.custom-control-label"),
            stateList = $$x("//div[contains(@id, 'react-select-3')]"),
            cityList = $$x("//div[contains(@id, 'react-select-4')]");


    public RegistrationPage openPage() {
        Selenide.open(uri);
        Selenide.executeJavaScript("$('footer').remove()");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        h5.shouldHave(Condition.text(h5Text));
        return this;
    }

    public RegistrationPage setGender(String pol) {
        gender.find(Condition.value(pol)).parent().click();
//        $x("//label[text() = 'Male']").parent().click();
        return this;
    }

    public RegistrationPage fillFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    public RegistrationPage fillLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public RegistrationPage fillEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    public RegistrationPage setDate(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setMobile(String number) {
        mobile.setValue(number);
        return this;
    }

    public RegistrationPage chooseHobby(String hobby) {
        hobbies.find(Condition.text(hobby)).parent().click();
        return this;
    }

    public RegistrationPage uploadPic(String path) {
        upload.uploadFromClasspath(path);
        return this;
    }

    public RegistrationPage fillAddress(String text) {
        address.sendKeys(text);
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateField.click();
        stateList.findBy(Condition.text(state)).click();
        cityField.click();
        cityList.findBy(Condition.text(city)).click();
        return this;
    }

    public RegistrationPage setSubject(String subject){
        subjectField.setValue(subject).press(Keys.TAB);
//        subjectField.sendKeys(subject,Keys.TAB);
        return this;
    }

    public RegistrationPage clickSubmitButton(){
        submitButton.click();
        return this;
    }


}
