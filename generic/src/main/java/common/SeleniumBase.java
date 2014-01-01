package common;

//core java api

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//selenium api
//testng api


/**
 * Created with IntelliJ IDEA.
 * User: rrt
 * Date: 12/21/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class SeleniumBase {
    public WebDriver driver = null;
    public String url = "http://www.cnn.com";

    //using sauce labs

    @Parameters({"username", "key", "os", "browser", "browserVersion"})
    @BeforeMethod
    public void setUp(@Optional("delowarhossain86") String username,
                      @Optional("6015f94e-de25-438c-8ac1-7e374a57aac8") String key,
                      @Optional("mac") String os,
                      @Optional("iphone") String browser,
                      @Optional("5.0") String browserVersion,
                      Method method) throws Exception {

        // Choose the browser, version, and platform to test
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setCapability("version", browserVersion);
        capabilities.setCapability("platform", Platform.valueOf(os));
        capabilities.setCapability("name", method.getName());
        // Create the connection to Sauce Labs to run the tests
        this.driver = new RemoteWebDriver(
                new URL("http://" + username + ":" + key + "@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);
        driver.navigate().to("http://www.cnn.com");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }
    //@BeforeClass
    public void beforeClass() throws FileNotFoundException {
        driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\config\\browser-driver\\chromedriver.exe");
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);
        driver.manage().window().maximize();

    }
    @BeforeMethod
    public void beforeMethod() {
    }

    //@AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    //get new driver
    public WebDriver getNewDriver(String browser){
        WebDriver driver1 = null;
        if(browser.equalsIgnoreCase("firefox")){
            driver1 = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("safari")){
            driver1 = new SafariDriver();
        }else if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\config\\browser-driver\\chromedriver.exe");
            driver1 = new ChromeDriver();
        }if(browser.equalsIgnoreCase("internetexplorer")){
            driver1 = new InternetExplorerDriver();
        }
        return driver1;
    }
    //helper methods start here
    //click element
    public void clickByCss(String locator){
        driver.findElement(By.cssSelector(locator)).click();
    }

    public void clickByXpath(String locator){
        driver.findElement(By.xpath(locator)).click();
    }
    public void clickById(String locator){
        driver.findElement(By.id(locator)).click();
    }
    public void clickByName(String locator){
        driver.findElement(By.name(locator)).click();
    }

    //type intput box
    public void typeByCss(String locator, String value){
        driver.findElement(By.cssSelector(locator)).clear();
        driver.findElement(By.cssSelector(locator)).sendKeys(value);

    }
    public void typeByXpath(String locator, String value){
        driver.findElement(By.xpath(locator)).sendKeys(value);

    }
    public void typeById(String locator, String value){
        driver.findElement(By.id(locator)).sendKeys(value);

    }
    public void typeByName(String locator, String value){
        driver.findElement(By.name(locator)).sendKeys(value);

    }

    //find webelement
    public WebElement getWebElement(String locator){
        WebElement element = driver.findElement(By.cssSelector(locator));
        return element;
    }
    public List<WebElement> getWebElements(String locator1,String locator2){
        List<WebElement> element = driver.findElement(By.cssSelector(locator1)).
                findElements(By.cssSelector(locator2));
        return element;
    }

    //find text
    public String findTextByCss(String locator){
        String text = "";
        text = driver.findElement(By.cssSelector(locator)).getText();
        return text;
    }
    public List<String> findListOfTextByCss(String locator1, String locator2){

        List<String> textList = new ArrayList<String>();
        List<WebElement> listOfElement = getWebElements(locator1,locator2);
        for(WebElement element:listOfElement){
            textList.add(element.getText());
        }

        return textList;
    }

    //enter Keys
    public void getKeys(String locator){
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }

    //navigate
    public void navigateBack(){
        driver.navigate().back();
    }
    public void reload(){
        driver.navigate().refresh();
    }

    //sleep
    public void sleep(int sec) throws InterruptedException{
        Thread.sleep(1000*sec);
    }

    //Alert Handling
    public void okAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void cancelAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    //select element by option
    public void selectElementByOption(String webElement, String value){
        Select select = new Select(driver.findElement(By.cssSelector(webElement)));
        select.selectByVisibleText(value);
    }

    //click by driver1
    public void clickByDriver1(WebDriver driver1, String locator){
        try{
            driver1.findElement(By.cssSelector(locator)).click();
        }catch(Exception ex1){
            try{
                driver1.findElement(By.xpath(locator)).click();
                ex1.printStackTrace();
            }catch(Exception ex2){

                driver1.findElement(By.id(locator)).click();
            }

        }
    }

    public List<String> findListOfTextByDriver1Css(WebDriver driver1, String locator1, String locator2){

        List<String> textList = new ArrayList<String>();
        List<WebElement> listOfElement = driver1.findElement(By.cssSelector(locator1)).
                findElements(By.cssSelector(locator2));
        for(WebElement element:listOfElement){
            textList.add(element.getText());
        }

        return textList;
    }

    //up load a file/image
    public void upLoad(String locator, String filePath){
        WebElement element = driver.findElement(By.cssSelector(locator));
        element.sendKeys(filePath);
    }

    //enter Keys
    public void pressAnyKey(String keys){
        Keyboard key = null;
        if(driver instanceof HasInputDevices){
            key = ((HasInputDevices) driver).getKeyboard();
        }else{
            Assert.fail();
        }
        key.sendKeys(keys);
    }

    //Synchronization
    public void waitUntilVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitUntilClickable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitUntilToBeSelected(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        Boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }
    //iframe
    public void iframeHandle(WebElement element){
        driver.switchTo().frame(element);
    }
    //link test
    public void getLinks(String locator){
        driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
    }
    //mouse hover
    public void mouseHover(String locator){
        WebElement element = driver.findElement(By.cssSelector(locator));
        Actions build = new Actions(driver);
        Actions hover = build.moveToElement(element);
        hover.perform();
    }
}