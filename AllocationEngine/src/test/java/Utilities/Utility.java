package Utilities;

import TestCases.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class Utility extends BaseClass
{
    public static ExtentReports extent;
    public  ExtentReports getReportObject()
    {
        String reportPath=System.getProperty("user.dir")+"/Reports/reportExtent.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("UI Testing Results");
        reporter.config().setDocumentTitle("Test Results");
        extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Rijul, Saurabh, Chandana, Rakesh, Pooja, Saji");
        return extent;
    }
    public String takeScreenShot(String pageName)throws InterruptedException
    {
        try {
            TakesScreenshot scrnShot =((TakesScreenshot)driver);
            File SrcFile=scrnShot.getScreenshotAs(OutputType.FILE);
            File DestFile=new File(System.getProperty("user.dir")+"/Screenshots/"+ts+"/"+pageName+".png");

            //Copy file at destination
            FileUtils.copyFile(SrcFile, DestFile);
            String path = System.getProperty("user.dir")+"/Screenshots/"+ts+"/"+pageName+".png";
            System.out.println("path 1 "+path);
            return path;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
