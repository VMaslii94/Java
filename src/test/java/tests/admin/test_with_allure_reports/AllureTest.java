package tests.admin.test_with_allure_reports;

import io.qameta.allure.Description;
import mentorship.constants.CONSTANTS;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;

public class AllureTest {

    final String email = CONSTANTS.getFromHashMapByKey("email");// CONSTANTS.EMAIL;
    final String password = CONSTANTS.PASSWORD;

    //@Step("Bla bla {email} and password {password}")
    public static void checkSumStep(int num1, int num2, int expectedSum) {

       step("test");
        Assert.assertTrue(num1 + num2 == expectedSum, "Сумма слагаемых не соответствует ожидаемому значению");
    }


    @Test
    @Description("My description")
    public void simpleTest2() {

        checkSumStep(3, 2, 5);
        checkSumStep(5, 4, 9);
    }

}
