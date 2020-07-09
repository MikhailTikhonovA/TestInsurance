package steps;

import io.qameta.allure.Step;
import pages.TravelInsuranceSubMenuPage;

public class TravelInsuranceSubMenuSteps extends BaseSteps {

    @Step("Проверить заголовок меню {0}")
    public void stepCheckTitleCurrentSubmenu(String type){
        new TravelInsuranceSubMenuPage(driver).checkCurrentSubmenu(type,driver);
    }

    @Step("Запустить оформление полиса")
    public void stepStartProcessingPolicy(){
        new TravelInsuranceSubMenuPage(driver).startProcessingPolicy();
    }

}
