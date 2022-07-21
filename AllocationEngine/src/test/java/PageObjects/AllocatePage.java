package PageObjects;

import TestCases.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;


public class AllocatePage extends BaseClass
{

    // common xpaths
    By MyPodsTab = By.xpath("//span[contains(text(),'My Pods')]");
    By nominate_btn = By.xpath("//tr[contains(@class,\"row-level-0 pointer\")][1]");
    By add_hasher = By.xpath("(//span[@class='anticon anticon-user-add'])[1]");
    By ConfirmNominationButton = By.xpath("//span[contains(text(),\"Confirm Nominations\")]");
    By nomination_with_count = By.xpath("(//article[@class='ant-typography'])[1]");
    By confirm_pod= By.xpath("//span[text()=\"Yes, Confirm\"]");
    By AllocationTab = By.xpath("//span[contains(text(),'Allocations')]");
    By filter = By.xpath("//span[@class=\"ant-badge\"]");
    By apply_btn = By.xpath("//span[contains(text(),\"Apply\")]");
    By reset_Btn = By.xpath("//span[contains(text(),\"Reset\")]");

    // saurabh xpath
    By selected_hasher= By.xpath("//tr[1]//h2[@class=\"name\"]");
    By allocation_tab = By.xpath("//div[text()=\"Allocation\"]");
    By view_response= By.xpath("//button[text()=\"View Responses\"]");
    By select= By.xpath("//button[text()=\"Select\"]");
    By close= By.xpath("//button[@aria-label=\"Close\"]");
    By ao_accept_pod= By.xpath("//span[text()=\"Confirm Pod\"]");
    By closed_tab= By.xpath("//div[contains(text(),\"Closed Pods\")]");
    By message= By.xpath("//div[@class=\"ant-message-notice\"]//span[2]");
    By search= By.xpath("//input[@class=\"ant-input\"]");
    By closeBtn= By.xpath("//span[contains(@class,\"close-circle\")]");
    By no_nomination_status = By.xpath("//div[text()=\"No other Nominations\"]");
    By bands= By.xpath("(//p[text()=\"Bands\"])//following::input[@type=\"search\"][1]");
    By page_size= By.xpath("//div[@class='nominate-modal']//descendant::input[@aria-label='Page Size']");

    //Chandana X-paths
    By SkillInFilter = By.xpath("//*[@class='ant-select-selection-item-content']");
    By SkillInWebPage = By.xpath("//span[@class='ant-select-selection-item-content']");
    By UpcomingPodsTab = By.xpath("//div[@id='rc-tabs-0-tab-upcomingPods']");
    By StatusOfUpcomingPod = By.xpath("//span[contains(text(),'UPCOMING')]");
    By StatusOfPod = By.xpath("//span[@data-status='ALLOCATION_READY']");
    By StatusOfPodAfterNominate = By.xpath("//span[contains(text(),'IN PROGRESS')]");
    By selectBands = By.xpath("(//div[@class='ant-select-selector'])[3]");
    By Band = By.xpath("(//p[text()=\"Bands\"])//following::input[@type=\"search\"][1]");
    By quick_allocate_Opn = By.xpath("(//span[@data-size='large'])[1]");
    By quick_allocate_opn1 = By.xpath("(//span[@data-size='large'])[2]");
    By quick_allocate_Btn = By.xpath("//span[contains(text(),'Quick Allocate')]");
    By radio_Btn = By.xpath("(//span[@class='ant-radio-inner'])[1]");
    By submit_Btn = By.xpath("//button[@type='submit']");
    By open_pod_xpath =  By.xpath("//div[@id= 'rc-tabs-0-tab-openPods']");
    By closed_pod_xpath = By.xpath("//div[@id= 'rc-tabs-0-tab-closedPods']");
    By upcoming_pod_xpath = By.xpath("//div[@id= 'rc-tabs-0-tab-upcomingPods']");
    By recent_podinlist_xpath = By.xpath("(//span[@class='id'])[1]");
    By allocation_tab_xpath = By.xpath("//span[contains(text(),'Allocations')]");
    By mynomination_tab_xpath = By.xpath("//span[contains(text(),'My Nominations')]");
    By nominate_btn1 = By.xpath("//tr[contains(@class,\"row-level-0 pointer\")][2]");
    By Allocated_Hasher = By.xpath("//div[@class='profile']");
    By confirmed_Status = By.xpath("//span[contains(text(),'CONFIRMED')]");

    public String name="";
    public Logger log= LogManager.getLogger(AllocatePage.class.getName());

    //saji action methods

    public AllocatePage get_title(){
        String title = driver.getTitle();
        System.out.println("Title of the Page is:"+""+title);
        Assert.assertEquals(title,"Allocation Engine");
        return this;
    }
    public AllocatePage visible_open_tab() {
        wait.until(ExpectedConditions.presenceOfElementLocated(open_pod_xpath));
        String open_pod =  driver.findElement(open_pod_xpath).getText();
        Assert.assertTrue(open_pod.contains("Open Pods"));
        return this;
    }
    public AllocatePage visible_closed_tab() {
        wait.until(ExpectedConditions.presenceOfElementLocated(closed_pod_xpath));
        String open_pod =  driver.findElement(closed_pod_xpath).getText();
        Assert.assertTrue(open_pod.contains("Closed Pods"));
        return this;
    }
    public AllocatePage visible_upcoming_tab(){
        wait.until(ExpectedConditions.presenceOfElementLocated(upcoming_pod_xpath));
        String open_pod =  driver.findElement(upcoming_pod_xpath).getText();
        Assert.assertTrue(open_pod.contains("Upcoming Pods"));
        return this;

    }
    public AllocatePage go_to_mynomination() throws InterruptedException {
        do_click(mynomination_tab_xpath);
        wait.until(ExpectedConditions.presenceOfElementLocated(mynomination_tab_xpath));
        String myNominationTab = driver.findElement(mynomination_tab_xpath).getText();
        Assert.assertEquals(myNominationTab,"My Nominations");

        return this;
    }
    public AllocatePage go_to_myPods() throws InterruptedException
    {
        Thread.sleep(5000);
        do_click(MyPodsTab);
        return this;
    }
    public AllocatePage Validate_MostRecentPod(String mostRecentPod)
    {
        String recentPod = driver.findElement(recent_podinlist_xpath).getText();
        Assert.assertEquals(recentPod,mostRecentPod);
        return this;
    }
    public AllocatePage Nominate_Second_Hasher() throws InterruptedException {
        do_click(nominate_btn1);
        return this;
    }
    public AllocatePage get_Allocated_Hasher() {
        boolean allocatedHasher = driver.findElement(Allocated_Hasher).isDisplayed();
        System.out.println(allocatedHasher);
        return this;
    }
    public AllocatePage get_confirmed_status(){
        wait.until(ExpectedConditions.presenceOfElementLocated(confirmed_Status));
        String confirmedStatus = driver.findElement(confirmed_Status).getText();
        System.out.println("status After Accept The Pod :"+""+confirmedStatus);
        Assert.assertEquals(confirmedStatus,"CONFIRMED");
        return this;
    }


    public AllocatePage click_allocationsTab() throws InterruptedException {
        log.info("click_allocationsTab");
        do_click(AllocationTab);
        String allocationTab = driver.findElement(allocation_tab_xpath).getText();
        //Assert.assertEquals(allocationTab, "Allocations");
        return  this;
    }
    public AllocatePage click_pod(String pod) throws InterruptedException {
        log.info("click_pod");
        new WebDriverWait(driver, 5).
                until(webDriver -> ((JavascriptExecutor) webDriver).
                        executeScript("return document.readyState").equals("complete"));
        driver.navigate().refresh();

        do_click(By.xpath("//span[text()=\""+pod+"\"]"));

        return  this;
    }
    public AllocatePage click_nominate_btn() throws InterruptedException {
        log.info("click_nominate_btn");
        do_click(nominate_btn);
        return this;
    }
    public AllocatePage click_add_hasher() throws InterruptedException {
        log.info("click_add_hasher");
        Thread.sleep(2000);
        do_click(add_hasher);      // adds 1st hasher
        return this;
    }
    public AllocatePage click_filter() throws InterruptedException {
        log.info("click_filter");
        js_click(filter);
        return this;
    }
    public AllocatePage click_reset() throws InterruptedException {
        log.info("click_reset");
        js_click(reset_Btn);
        return this;
    }
    public AllocatePage click_apply() throws InterruptedException {
        log.info("click_apply");
        js_click(apply_btn);
        return this;
    }

    // saurabh methods
    public AllocatePage reset_filter() throws InterruptedException {
        this.click_filter();
        this.click_reset();
        this.click_apply();

        return this;
    }

    public AllocatePage filter_b8_band() throws InterruptedException {
        js_click(filter);
        js_click(reset_Btn);

        wait.until(ExpectedConditions.presenceOfElementLocated(bands));
        WebElement yourOption = driver.findElement(bands);
        yourOption.sendKeys("B8");
        yourOption.sendKeys(Keys.RETURN);

        //Thread.sleep(2000);
        js_click(apply_btn);
        return this;
    }
    public AllocatePage change_page_size() throws InterruptedException {
        // change page size to 100 hashers
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //Scroll down till the bottom of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        System.out.println(page_size);
        wait.until(ExpectedConditions.presenceOfElementLocated(page_size));
        WebElement yourOption = driver.findElement(page_size);
        yourOption.sendKeys(Keys.DOWN);
        yourOption.sendKeys(Keys.DOWN);
        yourOption.sendKeys(Keys.DOWN);
        yourOption.sendKeys(Keys.DOWN);
        yourOption.sendKeys(Keys.RETURN);

        new WebDriverWait(driver, 20).
                until(webDriver -> ((JavascriptExecutor) webDriver).
                        executeScript("return document.readyState").equals("complete"));
        return this;
    }
    public AllocatePage nominate_unallocated_hasher() throws InterruptedException
    {
        int i = 0;
        boolean flag = true;
        String status="";
        while(flag)
        {
            i++;
            // scrollIntoView() to scroll to the element before it is clicked
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//img[contains(@src,\"view\")])[" + i + "]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath("(//img[contains(@src,\"view\")])[" + i + "]")));
            // get name of hasher
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//img[contains(@src,\"view\")])["+i+"]//ancestor::tr//div[@class=\"profile\"]//h2[@class=\"name\"]")));
            name = driver.findElement(By.xpath("(//img[contains(@src,\"view\")])["+i+"]//ancestor::tr//div[@class=\"profile\"]//h4[@class=\"email\"]")).getText();
            // click eye icon
            do_click(By.xpath("(//img[contains(@src,\"view\")])[" + i + "]"));
            //Thread.sleep(1000);
            try {
                WebDriverWait wait = new WebDriverWait(driver, 5);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//li[contains(@class,'list-item')])")));
                int status_size = driver.findElements(By.xpath("(//li[contains(@class,'list-item')])")).size();
                flag=false;
                for (int j = 1; j <= status_size; j++)
                {
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//li[contains(@class,'list-item')])[" + j + "]")));
                    status = driver.findElement(By.xpath("(//li[contains(@class,'list-item')])[" + j + "]")).getText();
                    if (status.contains("Allocated"))
                    {
                        System.out.println("already Allocated");
                        flag=true;
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("no nominations");
                wait.until(ExpectedConditions.presenceOfElementLocated(no_nomination_status));
                flag = false;
            }
        }
        // nominate the hasher
        do_click(By.xpath("(//span[contains(@class,\"anticon-user-add\")])["+i+"]"));
        return this;
    }
    public AllocatePage click_ConfirmNomination() throws InterruptedException
    {
        do_click(ConfirmNominationButton);
        return this;
    }

    public AllocatePage wait_for_message() throws InterruptedException
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(message));
        wait.until(driver -> ExpectedConditions.invisibilityOfElementLocated(message));
        return this;
    }
    public AllocatePage go_back() throws InterruptedException
    {
        Thread.sleep(1000);
        driver.navigate().back();
        return this;
    }

    public AllocatePage search_hasher(String hasher) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(search));
        driver.findElement(search).sendKeys(hasher);
        return this;
    }
    public AllocatePage nominate_hasher(String hasher) throws InterruptedException {
        js_click(By.xpath("//h4[text()=\""+hasher+"\"]//ancestor::tr//span[contains(@class,\"anticon-user-add\")]"));
        return this;
    }
    public AllocatePage close_search() throws InterruptedException {
        js_click(closeBtn);
        return this;
    }
    public AllocatePage wait_for_consideration() throws InterruptedException {
        // status of hashers changes to considered after 3 mins
        Thread.sleep(3*60*1000);
        driver.navigate().refresh();
        Thread.sleep(10000);
        driver.navigate().refresh();
        Thread.sleep(10000);
        return this;
    }
    public AllocatePage click_allocation_tab() throws InterruptedException {
        do_click(allocation_tab);
        return this;
    }
    public AllocatePage click_view_response() throws InterruptedException {
        do_click(view_response);
        return this;
    }
    public AllocatePage select_hasher() throws InterruptedException {
        js_click(select);
        // Thread.sleep(2000);
        return this;
    }
    public AllocatePage click_close() throws InterruptedException {
        do_click(close);
        return this;
    }
    public AllocatePage accept_pod() throws InterruptedException {
        do_click(ao_accept_pod);
        return this;
    }
    public AllocatePage click_confirm_pod() throws InterruptedException
    {
        wait.until(ExpectedConditions.elementToBeClickable(confirm_pod));
        js_click(confirm_pod);
        return this;
    }
    public AllocatePage click_closed_tab() throws InterruptedException {
        driver.navigate().refresh();
        do_click(closed_tab);
        return this;
    }
    public AllocatePage validate_count(int expected) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(nomination_with_count));
        int countAfter = Integer.parseInt(driver.findElement(nomination_with_count).getText().replaceAll("[\\D]", ""));
        Assert.assertEquals(countAfter , expected);
        return this;
    }
    public AllocatePage validate_selected_hasher() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(selected_hasher));
        String name = driver.findElement(selected_hasher).getText();
        Assert.assertNotEquals(name,"");
        return this;
    }
    public AllocatePage validate_already_allocated() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(message));
        String msg=  driver.findElement(message).getText();
        Assert.assertTrue(msg.contains("is already allocated to another POD"));
        return this;
    }
    public AllocatePage validate_closed_status(String pod) throws InterruptedException {
        String closed_pod_path ="(//span[text()=\""+pod+"\"]/ancestor::td)/following-sibling::td//span[text()=\"CLOSED\"]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(closed_pod_path)));
        String actual = driver.findElement(By.xpath(closed_pod_path)).getText();

        Assert.assertEquals(actual,"CLOSED");
        return this;
    }

    // chandana's action Methods
    public String SkillFilter() {

        driver.findElement(SkillInFilter).isDisplayed();
        return driver.findElement(SkillInFilter).getText();
    }
    public String SkillWebpage(){

        return driver.findElement(SkillInWebPage).getText();
    }
    public AllocatePage Verify_TheFilter()  {

        String SkillInFilter = SkillFilter();
        String SkillInWebPage = SkillWebpage();
        System.out.println("Skill in Filter:"+" "+SkillInFilter);
        System.out.println("Skill in WebPage:"+" "+SkillInWebPage);
        Assert.assertEquals(SkillInFilter,SkillInWebPage);
        return this;
    }
    public AllocatePage click_UpcomingPods() throws InterruptedException {
        do_click(UpcomingPodsTab);
        return this;

    }
    public AllocatePage verify_StatusAfterNominate() throws InterruptedException {

        String Status = get_StatusAfterNominate();
        System.out.println("Status of pod After Nominate:"+" "+Status);
        Assert.assertEquals(Status,"IN PROGRESS");
        return this;
    }
    public AllocatePage verify_StatusAfterConfigureThePod(){

        String Status = driver.findElement(StatusOfUpcomingPod).getText();
        System.out.println("Status After Configuration :"+" "+Status);
        Assert.assertEquals(Status,"UPCOMING");
        return this;


    }
    public AllocatePage verify_StatusOfPod(){
        String Status= get_StatusOfPod();
        System.out.println("Status of pod:"+""+Status);
        Assert.assertEquals(Status,"ALLOCATION READY");
        return this;

    }
    public AllocatePage click_ResetButton() throws InterruptedException {
        do_click(reset_Btn);
        return this;
    }
    public AllocatePage SelectBand(){
        driver.findElement(selectBands).click();
        return this;
    }
    public AllocatePage click_Band(){
        WebElement yourOption = driver.findElement(Band);
        yourOption.sendKeys(prop.getProperty("Band"));
        yourOption.sendKeys(Keys.RETURN);
        return this;
    }
    public String get_StatusOfPod()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(StatusOfPod));
        return driver.findElement(StatusOfPod).getText();
    }
    public String get_StatusAfterNominate() throws InterruptedException {

        return driver.findElement(StatusOfPodAfterNominate).getText();
    }
    //    public Allocate click_() throws InterruptedException {
//
//    }
    public AllocatePage click_Quick_Allocate_Opn() throws InterruptedException {
        js_click(quick_allocate_Opn);
        return this;
    }
    public AllocatePage click_Quick_Allocate_Opn1() throws InterruptedException {
        Thread.sleep(2000);
        js_click(quick_allocate_opn1);
        return this;
    }
    public AllocatePage click_Quick_Allocate_Btn() throws InterruptedException {
        js_click(quick_allocate_Btn);
        return this;
    }
    public AllocatePage click_Yes_Btn() throws InterruptedException {
        js_click(radio_Btn);
        return this;
    }
    public AllocatePage click_submit_Btn() throws InterruptedException {
        do_click(submit_Btn);
        return this;
    }
}

