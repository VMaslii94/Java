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


        // 1 option :
        String prop = System.getenv("MYPARAM1");
        // 2 option:        String prop = System.getProperty("CHROMEPATH");
        System.out.println("Env parameter: " + prop);
    }
}
// 1 option:
// Set in .bash_profile param like as  :  export MYPARAM="Testing1"

// 2 option:
//1) in console go to folder where was this class
//2) execute:   java  -DMYPARAM1="my value" EnvVaraible.java