package selenide.demoqa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;


public class ModalDialog {
    private SelenideElement
            modalTitle = $("div.modal-title");
          ElementsCollection values = $$x("//tbody//tr//td");

    public ModalDialog checkKeyValue(String key, String value) {
        values.findBy(Condition.text(key))
                .parent().$x("td[2]").shouldHave(Condition.text(value));
        return this;
    }

    public ModalDialog checker(String key, String value){
        $x(String.format("//tbody//tr//td[text() = '%s']//following-sibling::td", key))
                .shouldHave(Condition.text(value));
        return this;
    }

    public ModalDialog checkTitleVisible() {
        modalTitle.shouldBe(Condition.visible);
        return this;
    }
}
