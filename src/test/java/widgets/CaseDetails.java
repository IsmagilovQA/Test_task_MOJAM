package widgets;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class CaseDetails {

    @Step
    public ElementsCollection listOfItems() {
        $(".br__logged_text").scrollIntoView(false);
        return $$(".case-items__content>.case-items__item-title");
    }

    @Step
    public void clickFastBtn() {
        $("button.case-item__open-case-fast-btn").click();
    }

    @Step
    public String getDisplayedItemName() {
        return $(".case-win-block__name").getText();
    }
}
