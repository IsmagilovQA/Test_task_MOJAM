import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.Test;
import widgets.CaseDetails;
import widgets.LimitedCasesSection;

import static com.codeborne.selenide.Condition.text;

public class Tests extends BaseTest {

    @Test
    public void testCaseItemExistsInCaseCollection() {
        new LimitedCasesSection().selectItemByName("Mandalorian");
        CaseDetails caseDetails = new CaseDetails();
        ElementsCollection itemList = caseDetails.listOfItems();
        caseDetails.clickFastBtn();
        String displayedItem = caseDetails.getDisplayedItemName();
        itemList.findBy(text(displayedItem)).shouldHave(text(displayedItem));
    }
}