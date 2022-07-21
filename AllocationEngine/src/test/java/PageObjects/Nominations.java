package PageObjects;

import TestCases.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Locale;

public class Nominations extends BaseClass
{
    // saurabh xpaths
    By MyNominationsTab = By.xpath("//span[contains(text(),'My Nominations')]");
    By first_Nomination= By.xpath("(//tr[contains(@class,'ant-table-row')])[1]");
    By Confirm_Nomination_btn= By.xpath("//button[@class='ant-btn ant-btn-primary opt']");
    By Opt_Out_btn= By.xpath("//button[@class='ant-btn ant-btn-default opt']");
    By yes_confirm_btn= By.xpath("//span[text()=\"Yes, Confirm\"]");
    By message= By.xpath("//div[@class=\"ant-message-notice\"]//span[2]");
    By error_message= By.xpath("//div[contains(@class,\"explain-error\")]");
    By optOutreason_btn= By.xpath("//input[@id=\"optOutReason\"]");
    By optOutOption= By.xpath("//div[contains(text(),'Tech Stack Mismatch') and contains(@class,\"option\")]");
    By optOutConfirm_btn= By.xpath("//span[text()='Confirm']");
    By status= By.xpath("//span[contains(@class,\"status\")]");
    By NominatedStatus = By.xpath("//span[contains(text(),'Nominated')]");
    By allocated_Status = By.xpath("//span[contains(text(),'Allocated')]");
    By cancelled_status = By.xpath("//span[contains(text(),'Cancelled')]");
    By navigate = By.xpath("//span[@class='anticon anticon-arrow-left']");
    By Considered_Status = By.xpath("//span[contains(text(),'Considered')]");
    By confirm_btn = By.xpath("//span[text()=\"Yes, confirm\"]");
    By response_time = By.xpath("//div[@class='time-rem']");
    By update_message = By.xpath("(//div[@class='action-wrapper']//following::div)[1]");


    public Nominations verify_dashboard() throws InterruptedException {

        wait.until(ExpectedConditions.presenceOfElementLocated(MyNominationsTab));
        String actual = driver.findElement(MyNominationsTab).getText();
        System.out.println("actual = "+actual);
        Assert.assertEquals(actual, "My Nominations");
        return this;

    }
    public Nominations Verify_StatusAfterNominating(){
        String Status = driver.findElement(NominatedStatus).getText();
        System.out.println("Status of pod After Nominating under OpenPods tab on PO dashBoard :"+" "+Status);
        Assert.assertEquals(Status,"NOMINATED");
        return this;
    }

    public Nominations click_MyNominationsTab() throws InterruptedException {
        do_click(MyNominationsTab);
        return  this;
    }

    public Nominations click_1st_Nomination() throws InterruptedException {
        do_click(first_Nomination);
        return  this;
    }
    public Nominations click_Confirm_Nomination_btn() throws InterruptedException {
        do_click(Confirm_Nomination_btn);
        return  this;
    }
    public Nominations click_Opt_Out_btn() throws InterruptedException {
        do_click(Opt_Out_btn);
        return  this;
    }
    public Nominations click_optOutreason_btn() throws InterruptedException {
        do_click(optOutreason_btn);
        return  this;
    }
    public Nominations select_optOutOption(String option) throws InterruptedException {

        String option_xpath="//div[contains(text(),\""+option+"\") and contains(@class,\"option\")]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(option_xpath)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath(option_xpath)));
        do_click(By.xpath(option_xpath));
        return  this;
    }
    public Nominations click_optOutConfirm_btn() throws InterruptedException {
        do_click(optOutConfirm_btn);
        return  this;
    }
    public Nominations click_yes_confirm_btn() throws InterruptedException {
        do_click(yes_confirm_btn);
        return  this;
    }
    public Nominations wait_for_message() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(message));
        wait.until(driver -> ExpectedConditions.invisibilityOfElementLocated(message));
        return this;
    }
    public Nominations go_back() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().back();
        return this;
    }
    public Nominations validate_success_msg() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(message));
        String actual = driver.findElement(message).getText();
        Assert.assertTrue(actual.contains("Success"));
        return this;
    }
    public Nominations validate_error_message() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(error_message));
        String actual = driver.findElement(error_message).getText();
        Assert.assertTrue(actual.contains("reason for Opting Out"));
        return  this;
    }
    public Nominations validate_optOut_status() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(status));
        String actual = driver.findElement(status).getText();
        actual = actual.toLowerCase(Locale.ROOT);
        System.out.println("text = "+actual);
        Assert.assertTrue(actual.contains("opted out"));
        return  this;
    }
//    public Nominations click_() throws InterruptedException {
//
//        return  this;
//    }
    //Chandana PageAction Methods

    public Nominations Verify_allocated_Status() {
        wait.until(ExpectedConditions.presenceOfElementLocated(allocated_Status));
        String Status = driver.findElement(allocated_Status).getText();
        System.out.println("Status After Confirming The Pod:"+" "+Status);
        Assert.assertEquals(Status,"ALLOCATED");
        return this;
    }
    public Nominations Verify_cancelled_status(){
        wait.until(ExpectedConditions.presenceOfElementLocated(cancelled_status));
        String Status = driver.findElement(cancelled_status).getText();
        System.out.println("Status After override The Hasher:"+" "+Status);
        Assert.assertEquals(Status,"CANCELLED");
        return this;

    }
    public Nominations refresh(){
        driver.navigate().refresh();
        return this;
    }
    //pooja Action Methods

    public Nominations click_Nominated_btn() throws InterruptedException {
        do_click(NominatedStatus);
        return this;
    }



    public Nominations Status_check() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(Considered_Status));
        String Considered_status = driver.findElement(Considered_Status).getText();
        Assert.assertTrue(Considered_status.contains("CONSIDERED"));

        return this;

    }

    public Nominations click_confirm() throws InterruptedException {
        do_click(confirm_btn);
        return this;
    }


    public Nominations Confirm_Nomination_disable_check() throws InterruptedException {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Confirm_Nomination_btn));
        WebElement confirmNomination = driver.findElement(Confirm_Nomination_btn);
        Assert.assertEquals(true, confirmNomination.isEnabled());
        return this;
    }

    public Nominations OptOut_disable_check() throws InterruptedException
    {
        Assert.assertTrue(Validate_OptOut_is_disabled());
        return this;
    }
    public Nominations Response_Time_check() throws InterruptedException {
        WebElement ResponseTime = driver.findElement(response_time);
        if (ResponseTime.isDisplayed()) {
            System.out.println("Response Time displaying");
        } else {
            System.out.println("Response time not displaying");
        }
        return this;
    }
    public Nominations Wait_for_Opt_Out_to_disable() throws InterruptedException
    {
        Thread.sleep(180*1000);
        refresh();

        Thread.sleep(120*1000);
        refresh();
        return this;
    }
    public boolean Validate_OptOut_is_disabled() throws InterruptedException
    {
        Assert.assertFalse(driver.findElement(Opt_Out_btn).isEnabled());
        return true;
    }
    public Nominations Validate_NominationButton_is_disabled() throws InterruptedException
    {
        Assert.assertFalse(driver.findElement(Confirm_Nomination_btn).isEnabled());
        return this;
    }
    public Nominations Validate_Update_Message(String expectedUser) throws InterruptedException
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(update_message));
        String updateMessage = driver.findElement(update_message).getText();
        System.out.println(updateMessage+" : "+"Last updated by "+expectedUser);
        Assert.assertTrue(updateMessage.contains("Last updated by "+expectedUser));
        return this;
    }
}
