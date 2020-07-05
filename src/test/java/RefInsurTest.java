import org.junit.Test;
import pages.InsuranceTravelChosePolicyPage;
import pages.MainPage;
import pages.TravelInsuranceSubMenu;

public class RefInsurTest extends BaseTest{
    @Test
    public void newInsuranceTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.selectTypeOfMainMenu("Страхование", actionsMoveOn);
        mainPage.selectTypeOfSubMenu("Страхование путешественников");
        TravelInsuranceSubMenu travelInsuranceSubMenu = new TravelInsuranceSubMenu(driver);
        travelInsuranceSubMenu.checkCurrentSubmenu("Страхование путешественников",driver);
        travelInsuranceSubMenu.startProcessingPolicy();
        InsuranceTravelChosePolicyPage insuranceTravelChosePolicyPage = new InsuranceTravelChosePolicyPage(driver);
        insuranceTravelChosePolicyPage.selectTypeOfInsuranceProtection("Минимальная");
        insuranceTravelChosePolicyPage.confirmChoiceOnPage(driver);

    }
}
