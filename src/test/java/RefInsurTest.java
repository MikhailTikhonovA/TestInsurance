import org.junit.Assert;
import org.junit.Test;
import pages.InsuranceTravelChosePolicyPage;
import pages.InsuranceTravelFormingPolicyPage;
import pages.MainPage;
import pages.TravelInsuranceSubMenu;

public class RefInsurTest extends BaseTest {
    @Test
    public void newInsuranceTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.selectTypeOfMainMenu("Страхование", actionsMoveOn);
        mainPage.selectTypeOfSubMenu("Страхование путешественников");
        TravelInsuranceSubMenu travelInsuranceSubMenu = new TravelInsuranceSubMenu(driver);
        travelInsuranceSubMenu.checkCurrentSubmenu("Страхование путешественников", driver)
                              .startProcessingPolicy();
        InsuranceTravelChosePolicyPage insuranceTravelChosePolicyPage = new InsuranceTravelChosePolicyPage(driver);
        insuranceTravelChosePolicyPage.selectTypeOfInsuranceProtection("Минимальная");
        insuranceTravelChosePolicyPage.confirmChoiceOnPage(driver);
        InsuranceTravelFormingPolicyPage insuranceTravelFormingPolicyPage = new InsuranceTravelFormingPolicyPage(driver);
        insuranceTravelFormingPolicyPage.fieldFiller("Фамилия застрахованного", "Petro");
        insuranceTravelFormingPolicyPage.fieldFiller("Имя застрахованного", "Petr");
        insuranceTravelFormingPolicyPage.fieldFiller("ДР застрахованного", "12021990");
        insuranceTravelFormingPolicyPage.fieldFiller("Фамилия страхуемого", "Петро");
        insuranceTravelFormingPolicyPage.fieldFiller("Имя страхуемого", "Петр");
        insuranceTravelFormingPolicyPage.fieldFiller("Отчество страхуемого", "Васильевич");
        insuranceTravelFormingPolicyPage.fieldFiller("ДР страхуемого", "12031990");
        insuranceTravelFormingPolicyPage.fieldFiller("Серия паспорта С", "1212");
        insuranceTravelFormingPolicyPage.fieldFiller("Номер паспорта С", "324546");
        insuranceTravelFormingPolicyPage.fieldFiller("Дата выдачи паспорта С", "11082019");
        insuranceTravelFormingPolicyPage.fieldFiller("Организация выдавшая паспорт С", "УВД по г. Москва");
        Assert.assertEquals("Petro", insuranceTravelFormingPolicyPage.fieldChecker("Фамилия застрахованного"));
        Assert.assertEquals("Petr", insuranceTravelFormingPolicyPage.fieldChecker("Имя застрахованного"));
        Assert.assertEquals("12.02.1990", insuranceTravelFormingPolicyPage.fieldChecker("ДР застрахованного"));
        Assert.assertEquals("Петро", insuranceTravelFormingPolicyPage.fieldChecker("Фамилия страхуемого"));
        Assert.assertEquals("Петр", insuranceTravelFormingPolicyPage.fieldChecker("Имя страхуемого"));
        Assert.assertEquals("Васильевич", insuranceTravelFormingPolicyPage.fieldChecker("Отчество страхуемого"));
        Assert.assertEquals("12.03.1990", insuranceTravelFormingPolicyPage.fieldChecker("ДР страхуемого"));
        Assert.assertEquals("1212", insuranceTravelFormingPolicyPage.fieldChecker("Серия паспорта С"));
        Assert.assertEquals("324546", insuranceTravelFormingPolicyPage.fieldChecker("Номер паспорта С"));
        Assert.assertEquals("11.08.2019", insuranceTravelFormingPolicyPage.fieldChecker("Дата выдачи паспорта С"));
        Assert.assertEquals("УВД по г. Москва", insuranceTravelFormingPolicyPage.fieldChecker("Организация выдавшая паспорт С"));
        insuranceTravelFormingPolicyPage.confirmChoiceOnPage(driver);
        insuranceTravelFormingPolicyPage.checkAlertObligatoryField(driver, "При заполнении данных произошла ошибка");

    }
}
