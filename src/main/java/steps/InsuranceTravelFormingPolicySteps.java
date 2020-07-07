package steps;

import pages.InsuranceTravelFormingPolicyPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class InsuranceTravelFormingPolicySteps extends BaseSteps {
    @Step("Поле {0} заполняется значением {1}")
    public void stepFillFieldOnFormingPage(String nameOfField, String value) {
        new InsuranceTravelFormingPolicyPage(driver).fieldFiller(nameOfField,value);
    }

    @Step("Заполнение полей")
    public void stepFillFields(HashMap<String,String> data){
        data.forEach(this::stepFillFieldOnFormingPage);
    }


}
