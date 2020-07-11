package steps;

import pages.InsuranceTravelChosePolicyPage;

import static steps.BaseSteps.driver;

public class InsuranceTravelChosePolicySteps {
    InsuranceTravelChosePolicyPage insuranceTravelChosePolicyPage = new InsuranceTravelChosePolicyPage(driver);

    public void stepSelectTypeOfInsuranceProtection(String kindOf) {
        insuranceTravelChosePolicyPage.selectTypeOfInsuranceProtection(kindOf);
    }

    public void stepConfirmChoicePage() {
        insuranceTravelChosePolicyPage.confirmChoiceOnPage(driver);
    }
}
