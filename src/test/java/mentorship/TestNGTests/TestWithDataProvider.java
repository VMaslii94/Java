package mentorship.TestNGTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWithDataProvider {

    @Test(dataProvider = "data-provider", dataProviderClass = mentorship.core.DataProvider.Data.class)

    public void printData(String name, String value, int age) {
        System.out.printf("This data from dataProfider class \n Name: %s, Value:%s, Age: %s", name, value, age);
        Assert.assertTrue(true);
    }
}
