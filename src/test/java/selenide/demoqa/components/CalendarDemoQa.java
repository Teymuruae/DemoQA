package selenide.demoqa.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class CalendarDemoQa {
    private SelenideElement
            calendarField = $("input#dateOfBirthInput"),
            monthElement = $("select.react-datepicker__month-select"),
            yearElement = $("select.react-datepicker__year-select");

    ElementsCollection
    dayElement = $$x("//div[not(contains(@class, 'day--outside-month')) and contains(@class, 'react-datepicker__day--')]");



    public void setDate(String day, String month, String year) {
        calendarField.click();
        monthElement.selectOption(month);
        yearElement.selectOption(year);
        dayElement.find(Condition.text(day)).click();

    }
}
