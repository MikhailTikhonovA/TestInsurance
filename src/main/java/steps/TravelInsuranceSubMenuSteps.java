package steps;

import pages.TravelInsuranceSubMenuPage;

import static steps.BaseSteps.driver;

public class TravelInsuranceSubMenuSteps {
    TravelInsuranceSubMenuPage travelInsuranceSubMenuPage = new TravelInsuranceSubMenuPage(driver);

    public void stepCheckTitleCurrentSubmenu(String type) {
        travelInsuranceSubMenuPage.checkCurrentSubmenu(type, driver);
    }

    public void stepStartProcessingPolicy() {
        travelInsuranceSubMenuPage.startProcessingPolicy();
    }

}
