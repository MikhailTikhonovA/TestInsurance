package steps;

import io.qameta.allure.Step;
import pages.MainPage;

import static steps.BaseSteps.actionsMoveOn;
import static steps.BaseSteps.driver;

public class MainMenuSteps {
    MainPage mainPage = new MainPage(driver);

    @Step("Выбран пункт главного меню {0}")
    public void stepSelectTypeOfMainMenu(String type) {
        mainPage.selectTypeOfMainMenu(type, actionsMoveOn);
    }

    @Step("Выбран вид страхования {0}")
    public void stepSelectSubtypeOfMainMenu(String type) {
        mainPage.selectTypeOfSubMenu(type);
    }
}
