package steps;

import io.qameta.allure.Step;
import pages.TravelInsuranceSubMenuPage;

import static steps.BaseSteps.driver;

public class TravelInsuranceSubMenuSteps {
    TravelInsuranceSubMenuPage travelInsuranceSubMenuPage = new TravelInsuranceSubMenuPage(driver);

    @Step("Проверить заголовок меню {0}")
    public void stepCheckTitleCurrentSubmenu(String type) {
        travelInsuranceSubMenuPage.checkCurrentSubmenu(type, driver);
    }

    @Step("Запустить оформление полиса")
    public void stepStartProcessingPolicy() {
        travelInsuranceSubMenuPage.startProcessingPolicy();
    }

}
