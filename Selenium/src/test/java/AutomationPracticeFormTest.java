import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

/**
 * Created by student on 28.02.2017.
 */
public class AutomationPracticeFormTest {


    // var

    WebDriver driver;

    @Before

    public void openAutomationPracticeForm(){

        File path_to_exe = new File("C:\\Users\\student\\Desktop\\FirefoxPortable\\FirefoxPortable.exe");
        FirefoxBinary firefox_exe= new FirefoxBinary(path_to_exe);

        FirefoxProfile empty_profile = new FirefoxProfile();


        driver = new FirefoxDriver(firefox_exe,empty_profile);


        driver.get("http://toolsqa.com/automation-practice-form/");

    }



    @After
    public  void closeAutomationPracticeForm(){

       driver.quit();
    }

    @Ignore
    @Test

    public void linkText(){

        WebElement link = driver.findElement(By.linkText("Link Test"));

        System.out.println(link.getAttribute("href"));

        link.click();

        // check if on correct page by header


        WebElement div_with_header = driver.findElement(By.id("content"));
        WebElement header = div_with_header.findElement(By.tagName("h1"));

        System.out.println(header.getText());

        Assert.assertEquals(header.getText(),"Automation Practice Table");

    }

    @Ignore
    @Test
    public void partialLinkText(){

        WebElement link = driver.findElement(By.partialLinkText("Partial"));


    }

    @Ignore
    @Test
    public void isSelectedTest(){

        List<WebElement> radiobuttons = driver.findElements(By.name("sex"));



        for (WebElement element: radiobuttons
             ) {


            // work with each radiobutton
            System.out.print(element.getAttribute("value"));

            System.out.println(element.isSelected());

            if (element.getAttribute("value").equals("Male")){

                element.click();
            }
        }
}


    @Ignore
    @Test
    public void isSelectedTest2(){


            List<WebElement> radiobuttons = driver.findElements(By.name("exp"));

            boolean is_one_selected =false;

        for (WebElement element:radiobuttons
             ) {

                if (element.isSelected()){

                    is_one_selected=true;
                }

                System.out.println(element.getAttribute("value"));
        }

        Assert.assertEquals(is_one_selected,false);

    }

    @Ignore
    @Test

    public void selectDropDownTest() throws InterruptedException {

        WebElement select_continent = driver.findElement(By.id("continents"));

        Select select_continent_control = new Select(select_continent);

        select_continent_control.selectByVisibleText("Europe");

        Thread.sleep(3000);

        select_continent_control.selectByIndex(3);


        List<WebElement> optionts_of_select =  select_continent_control.getOptions();

        for (WebElement option: optionts_of_select
             ) {

            System.out.println(option.getText());

        }

    }

    @Ignore
    @Test

    public void selectMultyTest() throws InterruptedException {

        WebElement list = driver.findElement(By.id("selenium_commands"));

        Select list_control = new Select(list);


        list_control.selectByIndex(0);

        Thread.sleep(3000);

        list_control.selectByIndex(2);

        Thread.sleep(3000);


        list_control.deselectAll();


        List<WebElement> selenium_commands = list_control.getOptions();

        for (WebElement commnad:selenium_commands
             ) {
            System.out.println(commnad.getText());
        }
    }


    @Test
    public  void usabilityTest(){

        WebElement first_name= driver.findElement(By.name("firstname"));

        WebElement last_name = driver.findElement(By.name("lastname"));

        Point first_name_coordinate = first_name.getLocation();

        Point last_name_coordinate= last_name.getLocation();


        System.out.println(first_name_coordinate.toString());
        System.out.println(last_name_coordinate.toString());

        Assert.assertEquals(first_name_coordinate.getY(),last_name_coordinate.getY());


    }

}
