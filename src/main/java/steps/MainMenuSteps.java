package steps;

import pages.MainPage;

import static steps.BaseSteps.actionsMoveOn;
import static steps.BaseSteps.driver;

public class MainMenuSteps {
    MainPage mainPage = new MainPage(driver);

    public void stepSelectTypeOfMainMenu(String type) {
        mainPage.selectTypeOfMainMenu(type, actionsMoveOn);
    }

    public void stepSelectSubtypeOfMainMenu(String type) {
        mainPage.selectTypeOfSubMenu(type);
    }
}
