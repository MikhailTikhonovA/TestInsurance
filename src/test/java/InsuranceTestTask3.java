import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

public class InsuranceTestTask3 extends BaseSteps {


    @Test
    @Title("Страхование путешественников")
    public void testInsurance() {
        MainSteps mainSteps = new MainSteps();
        TravelInsuranceSubMenuSteps travelInsuranceSubMenuSteps = new TravelInsuranceSubMenuSteps();
        InsuranceTravelChosePolicySteps insuranceTravelChosePolicySteps = new InsuranceTravelChosePolicySteps();
        InsuranceTravelFormingPolicySteps insuranceTravelFormingPolicySteps = new InsuranceTravelFormingPolicySteps();

        HashMap<String, String> testData = new HashMap<>();
        testData.put("Фамилия застрахованного", "Petro");
        testData.put("Имя застрахованного", "Petr");
        testData.put("ДР застрахованного", "12.02.1990");
        testData.put("Фамилия страхуемого", "Петро");
        testData.put("Имя страхуемого", "Петр");
        testData.put("Отчество страхуемого", "Васильевич");
        testData.put("ДР страхуемого", "12.03.1990");
        testData.put("Серия паспорта С", "1212");
        testData.put("Номер паспорта С", "324546");
        testData.put("Дата выдачи паспорта С", "11.08.2019");
        testData.put("Организация выдавшая паспорт С", "УВД по г. Москва");

        mainSteps.stepSelectTypeOfMainMenu("Страхование");
        mainSteps.stepSelectSubtypeOfMainMenu("Страхование путешественников");
        travelInsuranceSubMenuSteps.stepCheckTitleCurrentSubmenu("Страхование путешественников");
        travelInsuranceSubMenuSteps.stepStartProcessingPolicy();
        insuranceTravelChosePolicySteps.stepSelectTypeOfInsuranceProtection("Минимальная");
        insuranceTravelChosePolicySteps.stepConfirmChoicePage();
        insuranceTravelFormingPolicySteps.stepFillFields(testData);
        insuranceTravelFormingPolicySteps.stepCheckerFields(testData);
        insuranceTravelFormingPolicySteps.stepConfirmChoice();
        insuranceTravelFormingPolicySteps.stepCheckAlertObligatoryFields("При заполнении данных произошла ошибка");

        // Не добавлен шаг проверки

    }

}
