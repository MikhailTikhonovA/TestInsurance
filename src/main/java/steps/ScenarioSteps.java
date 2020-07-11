package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {
    MainMenuSteps mainMenuSteps = new MainMenuSteps();
    TravelInsuranceSubMenuSteps travelInsuranceSubMenuSteps = new TravelInsuranceSubMenuSteps();
    InsuranceTravelChosePolicySteps insuranceTravelChosePolicySteps = new InsuranceTravelChosePolicySteps();
    InsuranceTravelFormingPolicySteps insuranceTravelFormingPolicySteps = new InsuranceTravelFormingPolicySteps();

    @When("^выбран пункт главного меню \"(.*)\"$")
    public void stepSelectTypeOfMainMenu(String menuItem) {
        mainMenuSteps.stepSelectTypeOfMainMenu(menuItem);
    }

    @When("^выбран тип страхования - \"(.*)\"$")
    public void stepSelectSubtypeOfMainMenu(String subtypeItem) {
        mainMenuSteps.stepSelectSubtypeOfMainMenu(subtypeItem);
    }

    @Then("^проверка отображения заголовка меню - \"(.*)\"$")
    public void stepCheckTitleCurrentSubMenu(String title){
        travelInsuranceSubMenuSteps.stepCheckTitleCurrentSubmenu(title);
    }

    @When("^нажать на кнопку запуска оформления полиса$")
    public void  stepStartProcessing(){
        travelInsuranceSubMenuSteps.stepStartProcessingPolicy();
    }

    @When("^выбран тип покрытия - \"(.*)\"$")
    public void stepSelectTypeOfInsuranceProtection(String typeName){
        insuranceTravelChosePolicySteps.stepSelectTypeOfInsuranceProtection(typeName);
    }

    @When("^нажать на кнопку перехода на следующий шаг оформления$")
    public void stepConfirmChoiceOnPage(){
        insuranceTravelChosePolicySteps.stepConfirmChoicePage();
    }

    @When("^заполняются поля формы:$")
    public void stepFillFields(DataTable dataTable){
        dataTable.asMap(String.class, String.class)
                .forEach((key,value)-> insuranceTravelFormingPolicySteps.stepFillFieldOnFormingPage(key,value));
    }

    @Then("^проверка заполненных полей:$")
    public void stepCheckFilledFields(DataTable dataTable){
        dataTable.asMap(String.class, String.class)
                .forEach((key,value)-> insuranceTravelFormingPolicySteps.stepCheckerFields(dataTable.asMap(String.class,String.class)));
    }

    @When("^нажать на кнопку подтверждения$")
    public void stepConfirmChoiceOnPageForm(){
        insuranceTravelFormingPolicySteps.stepConfirmChoice();
    }

    @Then("^проверить текст алерта на странице - \"(.*)\"$")
    public void stepCheckAlertOnPage(String text){
        insuranceTravelFormingPolicySteps.stepCheckAlertObligatoryFields(text);
    }

}
