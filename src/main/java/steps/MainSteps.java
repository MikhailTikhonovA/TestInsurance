package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps extends BaseSteps {
    @Step("Выбран пункт главного меню {0}")
    public void stepSelectTypeOfMainMenu(String type){
        new MainPage(driver).selectTypeOfMainMenu(type,actionsMoveOn);
    }

    @Step("Выбран вид страхования {0}")
    public void stepSelectSubtypeOfMainMenu(String type){
        new MainPage(driver).selectTypeOfSubMenu(type);
    }
}
