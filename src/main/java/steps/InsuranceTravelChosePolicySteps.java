package steps;

import io.qameta.allure.Step;
import pages.InsuranceTravelChosePolicyPage;

import static steps.BaseSteps.driver;

public class InsuranceTravelChosePolicySteps {
    InsuranceTravelChosePolicyPage insuranceTravelChosePolicyPage = new InsuranceTravelChosePolicyPage(driver);

    @Step("Выбирается вид покрытия {0}")
    public void stepSelectTypeOfInsuranceProtection(String kindOf) {
        insuranceTravelChosePolicyPage.selectTypeOfInsuranceProtection(kindOf);
    }

    @Step("Подтверждение выбранного покрытия")
    public void stepConfirmChoicePage() {
        insuranceTravelChosePolicyPage.confirmChoiceOnPage(driver);
    }
}
