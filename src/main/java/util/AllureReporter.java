package util;

import gherkin.formatter.model.Result;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import steps.BaseSteps;

public class AllureReporter extends ru.yandex.qatools.allure.cucumberjvm.AllureReporter {

    @Override
    public void result(Result result) {
        if(result.getStatus().equals("failed")){
            takeScreenshot();
        }
        super.result(result);
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
