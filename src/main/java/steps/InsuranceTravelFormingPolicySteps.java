package steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import pages.InsuranceTravelFormingPolicyPage;
import java.util.HashMap;
import java.util.Map;
import static steps.BaseSteps.driver;

public class InsuranceTravelFormingPolicySteps {
    InsuranceTravelFormingPolicyPage insuranceTravelFormingPolicyPage = new InsuranceTravelFormingPolicyPage(driver);

    @Step("Поле {0} заполняется значением {1}")
    public void stepFillFieldOnFormingPage(String nameOfField, String value) {
        insuranceTravelFormingPolicyPage.fieldFiller(nameOfField, value);
    }

    @Step("Заполнение полей")
    public void stepFillFields(HashMap<String, String> data) {
        data.forEach(this::stepFillFieldOnFormingPage);
    }

    @Step("Проверка поля {0}")
    public String getActualValue(String name) {
        return insuranceTravelFormingPolicyPage.fieldChecker(name);
    }

    @Step("Проверка полей")
    public void stepCheckerFields(Map<String, String> data) {
        data.forEach((key, value) -> Assert.assertEquals(value, getActualValue(key)));
    }

    @Step("Подтверждение шага")
    public void stepConfirmChoice() {
        insuranceTravelFormingPolicyPage.confirmChoiceOnPage(driver);
    }

    @Step("Проверка текста алерта{0}")
    public void stepCheckAlertObligatoryFields(String text) {
        insuranceTravelFormingPolicyPage.checkAlertObligatoryField(driver, text);
    }

}
