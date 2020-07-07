package steps;

import pages.InsuranceTravelChosePolicyPage;
import ru.yandex.qatools.allure.annotations.Step;

public class InsuranceTravelChosePolicySteps extends BaseSteps {
    @Step("Выбирается вид покрытия {0}")
    public void stepSelectTypeOfInsuranceProtection(String kindOf){
        new InsuranceTravelChosePolicyPage(driver).selectTypeOfInsuranceProtection(kindOf);
    }

    @Step("Подтверждение выбранного покрытия")
    public void stepConfirmChoicePage(){
        new InsuranceTravelChosePolicyPage(driver).confirmChoiceOnPage(driver);
    }
}
