package PageObjects;

import TestCases.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.time.LocalDateTime;

public class PodsPlatformPage extends BaseClass
{
    public String pod_id="";

    By test_btn = By.xpath("(//a)[1]");
    By edit_btn = By.xpath("//span[text()=\"Edit Details\"]");
    By delivery_leader = By.xpath("//input[@id=\"Project Form_DeliveryLeader\"]");
    By project_manager = By.xpath("//input[@id=\"Project Form_ProjectManager\"]");
    By update_btn = By.xpath("//span[text()=\"Update\"]");
    By message = By.xpath("//div[@class=\"ant-message-notice\"]//span[2]");
    By new_config_btn = By.xpath("//span[text()=\" New Configuration\"]");
    By config_name = By.xpath("//input[@id='wrap_podConfigName']");
    By pod_size = By.xpath("//input[contains(@id,\"podSize\")]");
    By config_start_date = By.xpath("//input[@id='wrap_startDate']");
    By date_today = By.xpath("(//td[contains(@class,\"ant-picker-cell-today\")])[1]");
    By track= By.xpath("(//input[@class=\"ant-select-selection-search-input\"])[2]");
    By capability = By.xpath("(//input[@class=\"ant-select-selection-search-input\"])[3]");
    By skill_set = By.xpath("(//input[@class=\"ant-select-selection-search-input\"])[4]");
    // Java
    By save_config_btn = By.xpath("//span[contains(text(),\"Save Configuration\")]");
    By new_pod_btn = By.xpath("//span[contains(text(),\" New Pod\")]");
    By pod_name = By.xpath("//input[contains(@placeholder,\"Pod Name\")]");
    By onboard_date = By.xpath("//input[contains(@id,\"On-boarding\")]");
    //By onboard_date_today = By.xpath("(//td[contains(@class,\"ant-picker-cell-today\")])[1]");
    By onboard_date_today = By.xpath("//a[@class='ant-picker-today-btn']");
    By billing_date = By.xpath("//input[contains(@id,\"Billing start\")]");
    By billing_date_today = By.xpath("(//td[contains(@class,'ant-picker-cell-today')]//following::td//div)[1]");
    By billing_end_tommorow = By.xpath("((//td[contains(@class,'today')])[2]//following::div)[1]");

    By pod_SKU = By.xpath("//input[contains(@id,\"pod-template-1\")]");
    By pod_SKU_value = By.xpath("//div[contains(text(),\"Size: \") ]");
    By confirm_pod_btn = By.xpath("//button[@id=\"submitRoundBtn\" ]");
    By select_config = By.xpath("//input[@id=\"podconfiguration-1\" ]");
    By continue_btn = By.xpath("//span[text()=\"Continue\" ]");
    By confirm_btn = By.xpath("//span[text()=\"Confirm\" ]");
    By all_pods = By.xpath("(//div[@class=\"ant-space-item\"]//a)");
    By move_to_allocation_btn = By.xpath("//span[text()=\"Move to Allocation\"]");
    By pod_Size =  By.xpath("(//span[@aria-label='up'])[1]");
    By Count = By.xpath("(//span[@aria-label='up'])[2]");
//    By = By.xpath("");

    public void create_newpod() throws InterruptedException {
        Thread.sleep(7000);
        go_to_pods_platform();
        click_test_btn();
        click_edit_btn();
        set_delivery_leader();
        set_product_manager();
        click_update_btn();
        //wait_for_message();
        go_back();
        Thread.sleep(5000);
        click_new_config();
        set_config_name();
        set_config_name();
        click_config_start_date();
        set_todays_date();
        set_capability("SDET");
        set_track("SDET");
        set_skill("Java");
        click_save_config();
        //wait_for_message();
        click_new_pod();
        set_pod_name();
        click_onboard_date();
        set_onboard_start_date();
        click_billing_date();
        set_billing_start_date();
        set_SKU();
        click_confirm_pod_btn();
        select_config();
        click_continue_btn();
        click_confirm_btn();
        //wait_for_message();
        click_latest_created_pod();
        click_move_to_allocation();
        click_confirm_btn();
        go_to_allocation_engine();
    }
    public void create_newpod1() throws InterruptedException {
        Thread.sleep(7000);
        go_to_pods_platform();
        click_test_btn();
        click_edit_btn();
        set_delivery_leader();
        set_product_manager();
        click_update_btn();
        //wait_for_message();
        go_back();
        click_new_config();
        set_config_name();
        set_Pod_Size();
        click_config_start_date();
        set_todays_date();
        set_capability("SDET");
        set_track("SDET");
        Set_Count();
        set_skill("Java");
        click_save_config();
        //wait_for_message();
        click_new_pod();
        set_pod_name();
        click_onboard_date();
        set_onboard_start_date();
        click_billing_date();
        set_billing_start_date();
        set_SKU1();
        click_confirm_pod_btn();
        select_config();
        click_continue_btn();
        click_confirm_btn();
        //wait_for_message();
        click_latest_created_pod();
        click_move_to_allocation();
        click_confirm_btn();
        //wait_for_message();
        go_to_allocation_engine();
    }
    public PodsPlatformPage set_Pod_Size() throws InterruptedException
    {
        do_click(pod_Size);
        return this;
    }
    public PodsPlatformPage Set_Count() throws InterruptedException
    {
        do_click(Count);
        return this;
    }

    public PodsPlatformPage click_test_btn() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(test_btn));
        wait.until(ExpectedConditions.visibilityOfElementLocated(test_btn));

        driver.findElement(test_btn).click();
        return this;
    }

    public PodsPlatformPage click_edit_btn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(edit_btn));
        do_click(edit_btn);
        return this;
    }

    public PodsPlatformPage set_delivery_leader() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(delivery_leader));
        WebElement yourOption = driver.findElement(delivery_leader);
        yourOption.sendKeys(prop.getProperty("Email"));

        Thread.sleep(2000);
        yourOption.sendKeys(Keys.DOWN);
        yourOption.sendKeys(Keys.RETURN);
        return this;
    }

    public PodsPlatformPage set_product_manager() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(project_manager));
        WebElement yourOption = driver.findElement(project_manager);
        yourOption.sendKeys(prop.getProperty("Email"));

        Thread.sleep(2000);
        yourOption.sendKeys(Keys.DOWN);
        yourOption.sendKeys(Keys.RETURN);
        return this;
    }

    public PodsPlatformPage click_update_btn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(update_btn));
        do_click(update_btn);
        return this;
    }

    public PodsPlatformPage wait_for_message() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(message));
        wait.until(driver -> ExpectedConditions.invisibilityOfElementLocated(message));
        return this;
    }

    public PodsPlatformPage go_back() throws InterruptedException {
        driver.navigate().back();
        return this;
    }
    public PodsPlatformPage click_new_config() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(new_config_btn));
        do_click(new_config_btn);
        return  this;
    }

    public PodsPlatformPage set_config_name() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(config_name));
        do_click(config_name);
        driver.findElement(config_name).sendKeys("new_pod");
        Thread.sleep(3000);
        return  this;
    }
    public PodsPlatformPage click_config_start_date() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(config_start_date));
        driver.findElement(config_start_date).click();
        return  this;
    }
    public PodsPlatformPage set_todays_date() throws InterruptedException
    {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(date_today));
        do_click(date_today);
        return this;
    }
    public PodsPlatformPage set_capability(String str) throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(capability));
        WebElement yourOption = driver.findElement(capability);
        yourOption.sendKeys(str);
        yourOption.sendKeys(Keys.DOWN);
        yourOption.sendKeys(Keys.RETURN);
        return  this;
    }
    public PodsPlatformPage set_track(String str) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(track));
        Thread.sleep(5000);
        WebElement yourOption = driver.findElement(track);
        yourOption.sendKeys(str);
        Thread.sleep(5000);
        yourOption.sendKeys(Keys.DOWN);
        yourOption.sendKeys(Keys.RETURN);
        return  this;
    }
    public PodsPlatformPage set_skill(String str) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(skill_set));

        WebElement yourOption = driver.findElement(skill_set);
        yourOption.sendKeys(str);
        Thread.sleep(2000);
        yourOption.sendKeys(Keys.DOWN);
        yourOption.sendKeys(Keys.RETURN);
        return  this;
    }
    public PodsPlatformPage click_save_config() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(save_config_btn));
        do_click(save_config_btn);
        return  this;
    }
    public PodsPlatformPage click_new_pod() throws InterruptedException
    {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(new_pod_btn));
        do_click(new_pod_btn);
        return  this;
    }
    public PodsPlatformPage set_pod_name() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(pod_name));
        driver.findElement(pod_name).sendKeys("new_pod");
        return  this;
    }
    public PodsPlatformPage click_onboard_date() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(onboard_date));
        wait.until(ExpectedConditions.elementToBeClickable(onboard_date));
        do_click(onboard_date);
        return  this;
    }
    public PodsPlatformPage set_onboard_start_date() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(onboard_date_today));
        driver.findElement(onboard_date_today).click();
        return  this;
    }
    public PodsPlatformPage click_billing_date() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(billing_date));
        driver.findElement(billing_date).click();
        return  this;
    }
    public PodsPlatformPage set_billing_start_date() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(billing_end_tommorow));
        wait.until(ExpectedConditions.elementToBeClickable(billing_end_tommorow));
        do_click(billing_end_tommorow);
        return  this;
    }
    public PodsPlatformPage set_SKU() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(pod_SKU));

        WebElement yourOption = driver.findElement(pod_SKU);
        yourOption.sendKeys("1");
        Thread.sleep(2000);
        yourOption.sendKeys(Keys.DOWN);
        yourOption.sendKeys(Keys.DOWN);
        yourOption.sendKeys(Keys.RETURN);
        return  this;
    }
    public PodsPlatformPage set_SKU1() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(pod_SKU));

        WebElement yourOption = driver.findElement(pod_SKU);
        yourOption.sendKeys("2");
        Thread.sleep(2000);
        yourOption.sendKeys(Keys.DOWN);
        //yourOption.sendKeys(Keys.DOWN);
        yourOption.sendKeys(Keys.RETURN);
        return  this;
    }
    public PodsPlatformPage click_confirm_pod_btn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(confirm_pod_btn));
        do_click(confirm_pod_btn);
        return  this;
    }
    public PodsPlatformPage select_config() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(select_config));

        WebElement yourOption = driver.findElement(select_config);
        yourOption.click();
        Thread.sleep(2000);
        yourOption.sendKeys(Keys.DOWN);
        yourOption.sendKeys(Keys.RETURN);
        return  this;
    }
    public PodsPlatformPage click_continue_btn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(continue_btn));
        do_click(continue_btn);
        return  this;
    }
    public PodsPlatformPage click_confirm_btn() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(confirm_btn));
        do_click(confirm_btn);
        return  this;
    }
    public PodsPlatformPage click_latest_created_pod() throws InterruptedException {
        Thread.sleep(4000);         // as after 2 success messages it takes some time to display new pod
        //driver.navigate().refresh();

        wait.until(ExpectedConditions.presenceOfElementLocated(all_pods));
        int size = driver.findElements(all_pods).size();
        By latest_pod = By.xpath("(//div[@class=\"ant-space-item\"]//a)["+size+"]");
        pod_id = driver.findElement(latest_pod).getText();
        do_click(latest_pod);
        return this;
    }
    public PodsPlatformPage click_move_to_allocation() throws InterruptedException
    {
        wait.until(ExpectedConditions.elementToBeClickable(move_to_allocation_btn));
        do_click(move_to_allocation_btn);
        return this;
    }
    public PodsPlatformPage validate_move_to_allocation() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(message));
        String actual = driver.findElement(message).getText();

        Assert.assertTrue(actual.contains("success"));
        return this;
    }
//    public PodsPlatform click_() throws InterruptedException {
//        wait_and_click();
//        return this;
//        }


}
