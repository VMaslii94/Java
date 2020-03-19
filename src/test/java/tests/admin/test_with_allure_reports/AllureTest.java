package tests.admin.test_with_allure_reports;

import io.qameta.allure.Description;
import mentorship.constants.CONSTANTS;
import mentorship.core.reporters.AllureReport;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.qameta.allure.Allure.step;

public class AllureTest {

    private static WebDriver webDriver;  // just for test
    final String email = CONSTANTS.getFromHashMapByKey("email");// CONSTANTS.EMAIL;
    final String password = CONSTANTS.PASSWORD;

    //@Step("Bla bla {email} and password {password}")
    public static void checkSumStep(int num1, int num2, int expectedSum) throws IOException, ParseException, InterruptedException, java.text.ParseException {

//        ConfigJsonClass myJsonClass = new ConfigJsonClass();
//        myJsonClass.readJSON();
//        myJsonClass.writeIntoJSON();

        step("test");
        AllureReport allureReport= new AllureReport(webDriver);
        allureReport.addTextIntoReport("GoogleText","Added new file into report");
        allureReport.addJSONFile("Added json File", "src/test/resources/files/Allure_JSON.json");
        Assert.assertTrue(num1 + num2 == expectedSum, "Сумма слагаемых не соответствует ожидаемому значению");
    }


    @Test
    @Description("My description")
    public void simpleTest2() throws IOException, ParseException, InterruptedException, java.text.ParseException {


        System.out.println("TTTEst");
        checkSumStep(3, 2, 5);
//        checkSumStep(5, 4, 9);
    }

}
