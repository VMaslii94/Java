package mentorship.testingParameters;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameters  {
  //  public class parameters extends TestSuitParameters {

    public  void setParam (){
        System.setProperty("MYPARAM11", "Testing Value in Property");
    }


    @Test(groups = "first")
    public void getGradleParam(){
       setParam();

//        System.out.println(System.getProperty("java.home"));
//        System.out.println(System.getProperty("os.name"));
//        System.out.println(System.getProperty("user.name"));
//
//        //Get all properties from java as list
//        Properties props = System.getProperties();
//        props.list(System.out);

         String paramValue = System.getProperty("MYPARAM11");
         System.out.println("Param value : "+ paramValue);


    }
    @Parameters("user")
    @Test
    public void xmlParam (String user){
        System.out.println("Param is : " + user);
    }


    @Parameters("userName")
    @Test
    public void optionalParam (@Optional("my default params if in xml file no exist userName params")String userName){
        System.out.println("Optional param is : " + userName);
    }


    @Parameters({"user","age"})
    @Test
    public void multipleParams (String user, int age){
        System.out.println("User param is : " + user+ "Age param is : " + age);
    }
}
