package mentorship.core.DataProvider;

import org.testng.annotations.DataProvider;

public class Data {
    @DataProvider(name = "data-provider")

    public static Object[][] dataproviderMethod() {
        return new Object[][]{{ "myTestFirstName","firstValue", 15}, {
                "myTestLastName","secondValue", 45
        }};
    }
}

