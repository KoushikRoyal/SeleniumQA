package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
       WebDriver driver =new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
       driver.get("https://lms.kluniversity.in/login/index.php");
       driver.findElement(By.id("username")).sendKeys("2100031449");
       driver.findElement(By.id("password")).sendKeys("Kishore@1");
       driver.findElement(By.id("loginbtn")).click();


//      -------------Alert Methods--------------------------------------

       driver.navigate().to("https://alertwebsite.tiiny.site/");
       driver.findElement(By.id("alertBox")).click();
       Thread.sleep(3000);
       Alert alert = driver.switchTo().alert();
       alert.accept();
       driver.findElement(By.id("confirmBox")).click();
       alert.dismiss();
       driver.findElement(By.id("promptBox")).click();
       alert.getText();
       alert.sendKeys("");


//         ------------------ Multiple window control-------------------------------

       driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_4bp35ggexc_e&adgrpid=155259815433&hvpone=&hvptwo=&hvadid=674842289425&hvpos=&hvnetw=g&hvrand=16432712482640311160&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9040204&hvtargid=kwd-84077408&hydadcr=5652_2359469&gad_source=1");
       driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("chocolates");
       driver.findElement(By.id("nav-search-submit-button")).click();
       String parentWindow= driver.getWindowHandle();
       WebElement webElement=driver.findElement(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='KIT KAT']"));
       webElement.click();
       for(int i=0;i<3;i++)
       {

          driver.navigate().to("https://www.amazon.in/s?k=chocolates&ref=nb_sb_noss");
          webElement.click();
          Thread.sleep(3000);
       }
       Set<String> windows= driver.getWindowHandles();
       for(String window:windows)
       {
          driver.switchTo().window(window);
          System.out.println(window);
       }

      System.out.println(parentWindow);
      driver.quit();



//  ------------ javascriptexector with selenium to avoid any unflow control of the program like popups------

//       JavascriptExecutor js=(JavascriptExecutor)driver;
//       js.executeAsyncScript("Window,scrollBy(0,document.body.scrollHeight)");
//       js.executeScript("alert('lms was opened')");


//  --------------Taking screen shot Using selenium---------------------------------

       TakesScreenshot ts=(TakesScreenshot)driver;
       File src=ts.getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(src,new File("./Screenshot/screen.png"));
       System.out.println("screenshot done");

    }
}