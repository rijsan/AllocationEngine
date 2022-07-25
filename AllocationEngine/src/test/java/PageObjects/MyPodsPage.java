package PageObjects;

import TestCases.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MyPodsPage extends BaseClass
{
    // common xpaths
    By nominationWindow = By.xpath("//div[@class='ant-modal-content']");
    By confidenceLevel = By.xpath("//div[@title='High']");
    By po_select= By.xpath("//span[@class='anticon anticon-check-circle']");
    By MyPodsTab = By.xpath("//span[contains(text(),'My Pods')]");
    By confirm_pod= By.xpath("//span[text()=\"Yes, Confirm\"]");
    By message= By.xpath("//div[@class=\"ant-message-notice\"]//span[2]");

    // saurabh xpaths
    By po_accept_pod= By.xpath("//span[text()='Accept and Close']");
    By nomination_with_count = By.xpath("(//article[@class='ant-typography'])[1]");
    By zero_nominations= By.xpath("//td[6]//button");
    By close= By.xpath("//button[@aria-label=\"Close\"]");
    By closed_status = By.xpath("//span[text()=\"CLOSED\"]");
    By closed_tab= By.xpath("//div[contains(text(),\"Closed Pods\")]");
    By AllocationTab = By.xpath("//span[contains(text(),'Allocations')]");
    By MyNominationsTab = By.xpath("//span[contains(text(),'My Nominations')]");

    //Chandana X-paths
    By consideredStatus = By.xpath("//span[contains(text(),'Considered')]");
    By RespondedStatus = By.xpath("//span[contains(text(),'Responded')]");
    By AllocationReadyStatus = By.xpath("//span[contains(text(),'ALLOCATION READY')]");
    By InProgressStatus = By.xpath("//span[contains(text(),'IN PROGRESS')]");
    By CommentsField = By.xpath("//textarea[@class='ant-input']");
    By choose_confidence =  By.xpath("(//td[@class='ant-table-cell'])//input[@type='search']");
    By myPodsNomination = By.xpath("//Span[@class='nomination-with-count']");
    By MessageBeforeNominate = By.xpath("//div[@class='message-for-allocation-ready']");

    //Saji
    By nomination_with_count_2 = By.xpath("(//article[@class='ant-typography'])[2]");

    public int count=0;

    // common action methods
    public MyPodsPage nominate_second_hasher() throws InterruptedException
    {
        do_click(nomination_with_count_2);
        return this;
    }

    public MyPodsPage click_MyPods()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(MyPodsTab));
        Actions act =  new Actions(driver);
        act.moveToElement(driver.findElement(MyPodsTab)).click().perform();
        return this;
    }
    public MyPodsPage click_allocationsTab() throws InterruptedException
    {

        do_click(AllocationTab);
        return  this;
    }
    public MyPodsPage click_MyNominationsTab() throws InterruptedException
    {
        do_click(MyNominationsTab);
        return  this;
    }
    public MyPodsPage get_title()
    {
        String title = driver.getTitle();
        System.out.println("Title of the Page is:"+""+title);
        Assert.assertEquals(title,"Allocation Engine");
        return this;
    }
    public MyPodsPage click_pod(String pod) throws InterruptedException
    {
        new WebDriverWait(driver, 5).
                until(webDriver -> ((JavascriptExecutor) webDriver).
                        executeScript("return document.readyState").equals("complete"));
        driver.navigate().refresh();

        do_click(By.xpath("//span[text()=\""+pod+"\"]"));
        return this;
    }
    public MyPodsPage click_nominate() throws InterruptedException
    {
        wait.until(ExpectedConditions.elementToBeClickable(zero_nominations));
        do_click(zero_nominations);
        return this;
    }
    public MyPodsPage click_nominations() throws InterruptedException {
        do_click(nomination_with_count);
        return this;
    }
    public MyPodsPage click_choose_confidence() throws InterruptedException
    {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(choose_confidence));
        do_click(choose_confidence);
        //WebElement yourOption = driver.findElement(nominationWindow);
//        Actions action = new Actions(driver);
//        Thread.sleep(5000);
//        action.sendKeys(Keys.TAB);
//        action.sendKeys(Keys.TAB);
//        action.sendKeys(Keys.DOWN);
//        action.sendKeys(Keys.ENTER);
        return this;
    }
    public MyPodsPage provide_ConfidenceLevel() throws InterruptedException
    {
        js_click(confidenceLevel);
        return this;
    }

    public MyPodsPage select_hasher() throws InterruptedException {
        do_click(po_select);
        return this;
    }
    public MyPodsPage wait_for_consideration() throws InterruptedException {
        // status of hashers changes to considered after 3 mins
        Thread.sleep(3*60*1000);
        driver.navigate().refresh();
        Thread.sleep(10000);
        driver.navigate().refresh();
        Thread.sleep(10000);
        return this;
    }

    // saurabh Action Methods
    public MyPodsPage close_feedback() throws InterruptedException {
        do_click(close);
        Thread.sleep(2000);
        return this;
    }
    public MyPodsPage accept_pod() throws InterruptedException
    {
        wait.until(ExpectedConditions.elementToBeClickable(po_accept_pod));
        do_click(po_accept_pod);
        return this;
    }
    public MyPodsPage click_confirm_pod() throws InterruptedException
    {
        wait.until(ExpectedConditions.elementToBeClickable(confirm_pod));
        js_click(confirm_pod);
        return this;
    }

    public MyPodsPage go_back() throws InterruptedException {
        driver.navigate().back();
        return this;
    }

    public MyPodsPage count_nominations() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(nomination_with_count));
        count = Integer.parseInt(driver.findElement(nomination_with_count).getText().replaceAll("[\\D]", ""));
        return this;
    }
    public MyPodsPage wait_for_message() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(message));
        wait.until(driver -> ExpectedConditions.invisibilityOfElementLocated(message));
        System.out.println(message);

        return this;
    }
    public MyPodsPage validate_count(int expected) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(nomination_with_count));
        int countAfter = Integer.parseInt(driver.findElement(nomination_with_count).getText().replaceAll("[\\D]", ""));
        Assert.assertEquals(countAfter , expected);
        return this;
    }

    public MyPodsPage validate_confirmed_status(String pod) throws InterruptedException {
        String status ="(//span[text()=\""+pod+"\"]/ancestor::td)/following-sibling::td//span[text()=\"CONFIRMED\"]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(status)));
        String actual = driver.findElement(By.xpath(status)).getText();

        Assert.assertEquals(actual,"CONFIRMED");
        return this;
    }
    public MyPodsPage validate_closed_status() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(closed_status));
        String actual=  driver.findElement(closed_status).getText();
        Assert.assertEquals(actual,"CLOSED");
        return this;
    }

    public MyPodsPage validate_closed_status_in_closed_tab(String pod) throws InterruptedException {
        String status ="(//span[text()=\""+pod+"\"]/ancestor::td)/following-sibling::td//span[text()=\"CLOSED\"]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(status)));
        String actual = driver.findElement(By.xpath(status)).getText();

        Assert.assertEquals(actual,"CLOSED");
        return this;
    }
    public MyPodsPage click_closed_tab() throws InterruptedException {
        driver.navigate().refresh();
        do_click(closed_tab);
        return this;
    }

    public MyPodsPage validate_success_msg() throws InterruptedException {

        wait.until(ExpectedConditions.presenceOfElementLocated(message));
        String actual = driver.findElement(message).getText();
        Assert.assertEquals(actual,"Successful");
        return this;
    }

    // chandana Action Methods
    public MyPodsPage verify_NewPods(){
        String Status = driver.findElement(AllocationReadyStatus).getText();
        System.out.println("Status of New Pod Under open pods tab in PO dashboard:"+" "+Status);
        Assert.assertEquals(Status,"ALLOCATION READY");
        return this;
    }
    public MyPodsPage Verify_Message(){
        String Message = driver.findElement(MessageBeforeNominate).getText();
        System.out.println("message before Starting the Nomination:"+" "+Message);
        Assert.assertEquals(Message,"Waiting for Allocation Owner to start nominating Hashers");
        return this;
    }
    public MyPodsPage Verify_StatusAfterNominating(){
        String Status = driver.findElement(InProgressStatus).getText();
        System.out.println("Status of pod After Nominating under OpenPods tab on PO dashBoard :"+" "+Status);
        Assert.assertEquals(Status,"IN PROGRESS");
        return this;
    }
    public MyPodsPage click_MyPodsNomination() throws InterruptedException {
        do_click(myPodsNomination);
        return this;
    }

    public MyPodsPage Comments() throws InterruptedException {
        WebElement ele = driver.findElement(CommentsField);
        ele.sendKeys(prop.getProperty("Comments"));
        return this;
    }
    public MyPodsPage Verifying_TheConsideredStatus(){
        wait.until(ExpectedConditions.presenceOfElementLocated(consideredStatus));
        String Status = driver.findElement(consideredStatus).getText();
        System.out.println("Status After Complete the Nomination is:"+" "+Status);
        Assert.assertEquals(Status,"CONSIDERED");
        return this;
    }
    public MyPodsPage Verify_StatusResponded(){

        String Status = driver.findElement(RespondedStatus).getText();
        System.out.println("Status After giving Confidence Level:"+" "+Status);
        Assert.assertEquals(Status,"RESPONDED");
        return this;
    }
//    public MyPods click_() throws InterruptedException {
//        return this;
//    }
}
