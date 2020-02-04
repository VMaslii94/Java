package mentorship.testingParameters;

public class EnvVaraible {


    public static void main(String[] args) {


        //Get env properies
//        System.getenv().forEach((key, value) -> {
//            System.out.println(key + ":" + value);
//        });

//        System.getProperties().forEach((key, value) -> {
//            System.out.println(key + ":" + value);
//        });


        String prop = System.getProperty("MYPARAM1");
        System.out.println("Env parameter: "+prop);
    }
}



//1) in console go to folder where was this class
//2) execute:   java  -DMYPARAM1="my value" EnvVaraible.java