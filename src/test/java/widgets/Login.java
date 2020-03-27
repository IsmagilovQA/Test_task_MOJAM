package widgets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class Login {

    private SelenideElement
            justCaseLoginBtn = $(".user__logged-out"),
            steamAccountName = $("#steamAccountName"),
            steamPassword = $("#steamPassword"),
            steamSubmitBtn = $("#imageLogin"),
            logoutIcon = $(".icon.icon-logout");


    @Step
    public void authorizeViaSteam() {
        String mainWindow = WebDriverRunner.getWebDriver().getWindowHandle();
        justCaseLoginBtn.click();
        switchTo().window(1);
        steamAccountName.val("pockemonme");
        steamPassword.val("Liza82Velik84");
        steamSubmitBtn.click();
        WebDriverRunner.getWebDriver().switchTo().window(mainWindow);
        logoutIcon.waitUntil(Condition.visible, 10000);
    }
}
