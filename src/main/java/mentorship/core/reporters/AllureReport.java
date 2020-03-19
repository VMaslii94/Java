package mentorship.core.reporters;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.qameta.allure.Allure.addAttachment;

public class AllureReport {

    //https://www.programcreek.com/java-api-examples/?api=io.qameta.allure.Attachment good info methods
    //https://javarevisited.blogspot.com/2015/09/how-to-read-file-into-string-in-java-7.html?m=1
    //https://www.youtube.com/watch?v=9ru0Ng3Dr6E

    WebDriver webDriver; //just for test

    public AllureReport(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void takeScreenshotIntoReport(String description) {
        try {
            Allure.addAttachment(description, new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addTextIntoReport(String text, String fileName)  {

        Allure.addAttachment(fileName, "text/plain", text);


    }

    public void addJSONFile(String fileName, String pathToFile) throws IOException {

        try {
            addAttachment(fileName,"application/json", new String(Files.readAllBytes(Paths.get(pathToFile)))  );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
