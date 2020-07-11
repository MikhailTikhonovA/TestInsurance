package steps;

import org.junit.Assert;
import pages.InsuranceTravelFormingPolicyPage;
import java.util.HashMap;
import java.util.Map;
import static steps.BaseSteps.driver;

public class InsuranceTravelFormingPolicySteps {
    InsuranceTravelFormingPolicyPage insuranceTravelFormingPolicyPage = new InsuranceTravelFormingPolicyPage(driver);

    public void stepFillFieldOnFormingPage(String nameOfField, String value) {
        insuranceTravelFormingPolicyPage.fieldFiller(nameOfField, value);
    }

    public void stepFillFields(HashMap<String, String> data) {
        data.forEach(this::stepFillFieldOnFormingPage);
    }

    public String getActualValue(String name) {
        return insuranceTravelFormingPolicyPage.fieldChecker(name);
    }

    public void stepCheckerFields(Map<String, String> data) {
        data.forEach((key, value) -> Assert.assertEquals(value, getActualValue(key)));
    }

    public void stepConfirmChoice() {
        insuranceTravelFormingPolicyPage.confirmChoiceOnPage(driver);
    }

    public void stepCheckAlertObligatoryFields(String text) {
        insuranceTravelFormingPolicyPage.checkAlertObligatoryField(driver, text);
    }

}
