package core.Reporters;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Map;

public class CustomReporter implements IReporter {
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
                               String outputDirectory) {

        //Iterating over each suite included in the test
        for (ISuite suite : suites) {

            //Following code gets the suite name
            String suiteName = suite.getName();
             outputDirectory =  "$/Users/vladmaslii/IdeaProjects/TestingProject/src/test/java";
            //Getting the results for the said suite
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult sr : suiteResults.values()) {
                ITestContext tc = sr.getTestContext();
                System.out.println("Suit Name: " + suiteName + "and Test name : " + tc.getName());
                System.out.println("Passed tests.Count: "   + tc.getPassedTests().getAllResults().size());
                System.out.println("Failed tests.Count: '"  + tc.getFailedTests().getAllResults().size()+" and names:"+ tc.getFailedTests().getAllMethods());
                System.out.println("Skipped tests.Count: '" + tc.getSkippedTests().getAllResults().size()+" and names:" + tc.getSkippedTests().getAllMethods());
            }
        }
    }


}
