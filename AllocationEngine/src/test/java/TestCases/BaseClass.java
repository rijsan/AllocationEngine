package TestCases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties prop;

    @BeforeMethod
    public static WebDriver initialSetup()
    {
        // start chrome with given url
        load_properties_file();
        if(prop.getProperty("System").equalsIgnoreCase("MAC"))
        {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver");
        }
        else
        {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
        }
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("Url"));

        wait = new WebDriverWait(driver, 40);
        return driver;
    }
    @BeforeTest
    public static void create_screenShot_folder() throws IOException {
        String filepath = System.getProperty("user.dir")+"\\Screenshots\\";
        File file = new File(filepath);
        FileUtils.deleteDirectory(file);
        file.delete();

        File f1 = new File(System.getProperty("user.dir")+"\\Screenshots\\");
        //Creating a folder using mkdir() method
        boolean bool = f1.mkdir();
    }
    public void do_click(By element) throws InterruptedException {

        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        driver.findElement(element).click();
        Thread.sleep(1000);
    }
    public void js_click(By element) throws InterruptedException {

        wait.until(ExpectedConditions.presenceOfElementLocated(element));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                driver.findElement(element));

        new WebDriverWait(driver, 20).
                until(webDriver -> ((JavascriptExecutor) webDriver).
                        executeScript("return document.readyState").equals("complete"));

        Thread.sleep(1000);
    }
    public static void load_properties_file()
    {
        File file = new File(System.getProperty("user.dir")+"/src/test/GlobalData.properties");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void go_to_allocation_engine() throws InterruptedException
    {
        Thread.sleep(4000);
        driver.get("https://dna-staging.hashedin.com/allocation/allocate");
    }
    public void go_to_pods_platform() throws InterruptedException
    {
        driver.get("https://dna-staging.hashedin.com/pods/requests/PR-134");
    }
    @AfterMethod
    public void closeBrowser()
    {
        // close browser
        driver.close();
    }
    /*public static WebDriver driver;
    public String username = "rijsanyal@deloitte.com";
    public String baseURL = "https://dna-staging.hashedin.com/allocation/allocate/";
    public static Logger logger;
    public static WebDriverWait wait;
    public static Properties prop;

    @BeforeMethod
    public static WebDriver initialSetup(){         // start chrome with given url

        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();

        load_properties_file();
        driver.get(prop.getProperty("Url"));

        wait = new WebDriverWait(driver, 40);
        return driver;
    }
    @BeforeClass
    public static void setup()
    {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        prop = new Properties();

        driver.get("https://dna-staging.hashedin.com/allocation/allocate");

        //driver.manage().timeouts().implicitlyWait(20, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //return driver;

        *//*logger = Logger.getLogger("AllocationEngine");
        PropertyConfigurator.configure("Log4j.properties");*//*
    }
    @AfterClass
    public static void teardown()
    {
        driver.quit();
    }
    public void js_click(By element) throws InterruptedException {
        System.out.println(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                driver.findElement(element));
        Thread.sleep(1000);
    }
    public void do_click(By element) throws InterruptedException {
        System.out.println(element);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        driver.findElement(element).click();
        Thread.sleep(1000);
    }
    public static void load_properties_file()
    {
        File file = new File(System.getProperty("user.dir")+"/src/test/GlobalData.properties");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    *//*public static void load_properties_file(){
        File file = new File(System.getProperty("user.dir")+"/src/test/Config.properties");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*//*
    public void go_to_allocation_engine() throws InterruptedException {
        driver.get("https://dna-staging.hashedin.com/allocation/allocate");
    }
    public void go_to_pods_platform() throws InterruptedException {
        driver.get("https://dna-staging.hashedin.com/pods/requests/PR-87");
    }*/
}
