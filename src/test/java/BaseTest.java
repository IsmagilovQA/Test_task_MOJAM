import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import widgets.Login;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        Configuration.startMaximized = true;
        //Configuration.fastSetValue = true;
        Configuration.holdBrowserOpen = false;

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://two.jcdev.ru/");
        new Login().authorizeViaSteam();
    }

    @AfterSuite(alwaysRun = true)
    void tearDown() {
        SelenideLogger.removeListener("allure");
        closeWebDriver();
    }
}
