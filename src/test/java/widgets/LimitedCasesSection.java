package widgets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;


public class LimitedCasesSection {

    private SelenideElement justCaseContainer = $x("//section[2]");


    @Step
    public void selectItemByName(String name) {
        this.justCaseContainer.$x(".//a/p[.='" + name + "']").click();
    }
}