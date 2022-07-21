package PageObjects;

import TestCases.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;

public class LoginPage extends BaseClass
{
    By login = By.xpath("//button");
    By deloitte = By.xpath("//input[@value='Deloitte']");
    By email = By.xpath("//input[@type='email']");
    By next = By.xpath("//input[@value='Next']");
    By error_loading = By.xpath("//div[contains(text(),\"Error 500\")]");

    public LoginPage login_windows() throws InterruptedException
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(login));
        driver.findElement(login).click();

        js_click(deloitte);

        wait.until(ExpectedConditions.presenceOfElementLocated(email));
        driver.findElement(email).sendKeys(prop.getProperty("Email"));

        js_click(next);

        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
        loading_error();
        Thread.sleep(20000);
        return this;
    }
    public void login_mac() throws InterruptedException
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(login));
        driver.findElement(login).click();
        js_click(deloitte);
        wait.until(ExpectedConditions.presenceOfElementLocated(email));
        driver.findElement(email).sendKeys(prop.getProperty("Email"));
        js_click(next);
        Thread.sleep(10*1000);
        String login_url="https://"+prop.getProperty("Email")+":"+prop.getProperty("Password")+"@dttsts.deloitteresources.com/adfs/ls/wia?client-request-id=92435117-871a-450e-91eb-520551c30b1b&wa=wsignin1.0&wtrealm=urn%3afederation%3aMicrosoftOnline&wctx=LoginOptions%3D3%26estsredirect%3d2%26estsrequest%3drQQIARAAnZM5jONkAIXHZGYv2EMIcTZTbMXKGf8-45GQ8BHbGceJ4zhx7May4zM-YzvO0VJACbtU0FGCVkJUiAqJbqstVzRIWyEQ0tJtg8QMEgUtr3jN0-u-7_0O2kXO7wOc6tEkicCY5-IwDgIMpjEMgT2PRpY-IDyA4tXrt-69NeEevvvxnf5nv2snk59efe9rqBc1TVmfn505mybqerkD140TxnnYjZw68r047y6L7Ky4mtGz2Csrvy6LvPa_h6CnEPQrBP38yt0xc7VeVVHFB_-LzuMTCa8HzL-R5lMUGzoKq_eEAyxlO4QnCnSoHNy-wHNJgpmklPW9ASpYdbywOEMnKWJ-kY1THsZWKCVWKjWu-HW0GKw0pt6N3D7PAmaaB3XJDivAgjlBScC8mE9H7JRfyArHiwmrC1yzNXZTrZCqjNZRuMppchz3rEJ19vpkLeJTVdqsMZXJzGmyAqa2dORGJOcXI5_H1NlMW3syTwNuPuwnUogJs5mqTK1pKedhazVmag4qVLBlsMLnooqTZNjSQkxlbGqUcl-wEqJnCINwHxKxNbO35Z4LeZLwIsfQx7nNObUZuD42iocDMbBDIBaDnKF3s4UqIh6D-oBSV4u1ZSshPkaqAz0JM7ngcr89pAsbKXZzHGtXqiLG8tA_LNkNrfFqrgn9qS5kvbYcDtCD7VAkTAHPlNAqqmuNaLGNpSkRO6YtREq3SmClF5maWItlLEaOsqKs3OqtSbdi9CLtEVt8g25LxDBRMxVscdHmyGIIhiNJnzOkVO3LPMIKVxaEvtRGjcIxbjIQJn48TkYbf2WU6sbelcWamG8dlFU5PIwEbe8ajMeDHUpUWetSZiNnAUKnrRnormHQwqpqCkGlL1wkIXg1HQfixZColHoys1Wc55hQDRY4d0lV9z-MDdrMd0sxOKiqLXApVkQCsVU2EroEhicDtY0HOzvnyoQf7g2EaVVsbcX_PLvYd537GOk5OBGAS2XQJYx7IICdAGAw4bg-Tro0TaPgSeeNsiqCOPVP_cyJ09Oi9PPYe9aBnnferOJV7eR7J_3Q89Mibhr_Spynx9Bvx68hJ-c3bty6d_ft66dHL4-hr04uVcSkLx9-M57xj24_fufP5zePnpycsftFYjwI5w-QA8PLfhPrPpgsrR0epGuSpTbaSBNUve8eQP0Bfg4-vQa9uAZ9cv3oh5v_2-Ifbx-9vPPsr0fffvTL539IfwM1&cbcxt=&username="+prop.getProperty("userID")+"%40deloitte.com&mkt=&lc=";
        driver.get(login_url);
        Thread.sleep(10*1000);
        js_click(deloitte);
        Thread.sleep(10*1000);
        driver.navigate().refresh();
    }
    public LoginPage login_to_website() throws InterruptedException
    {
        if(prop.getProperty("System").equalsIgnoreCase("MAC"))
        {
            login_mac();
        }
        else if (prop.getProperty("System").equalsIgnoreCase("WIN"))
        {
            login_windows();
        }
        return this;
    }
    public LoginPage loading_error() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.presenceOfElementLocated(error_loading));
            driver.navigate().refresh();
        }
        catch(Exception ex){
            System.out.println("Page loaded successfully !!");
        }
        return this;
    }
}
