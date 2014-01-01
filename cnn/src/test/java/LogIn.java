import org.testng.annotations.Test;
import qa.CnnBase;

import java.util.Iterator;
import java.util.Set;

public class LogIn extends CnnBase{
    @Test
    public void f() throws InterruptedException {

        Set<String> listOfWindow = driver.getWindowHandles();
        Iterator it = listOfWindow.iterator();
        String homeWindow = driver.getWindowHandle();
        clickByXpath(".//*[@id='hdr-auth']/ul/li[2]/a");
        listOfWindow = driver.getWindowHandles();
        it = listOfWindow.iterator();
        String popUpWindow1 = (String) it.next();
        driver.switchTo().window(popUpWindow1);
        clickByCss(".cnnOvrlyBtn.cnnBtnLogIn");
        listOfWindow = driver.getWindowHandles();
        it = listOfWindow.iterator();
        String popUpWindow2 = (String) it.next();
        driver.switchTo().window(popUpWindow2);
        typeByCss("#cnnOverlayEmail1l","motiurhmn@gmail.com");
        typeByCss("#cnnOverlayPwd","rahman2012");
        clickByCss(".cnnOvrlyBtn.cnnBtnLogIn");
        driver.switchTo().window(homeWindow);
        Thread.sleep(20000);

    }
} 