import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestSuitParameters {

    @BeforeSuite
    public void Before(){
        System.out.println("Before all classes");
    }
    @AfterSuite
    public void After (){
        System.out.println("After all");
    }

}
