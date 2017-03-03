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

      // driver.quit();
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

    @Ignore
    @Test

    public void cssSelectorPath(){

        // table tbody tr[2] td[2]

        WebElement div = driver.findElement(By.id("content"));

       // WebElement textbox_first_name = div.findElement(By.cssSelector("form div input")); FEW ELEMENT

        List<WebElement> textboxs =  div.findElements(By.cssSelector("form div input"));


        for (WebElement textbox: textboxs
             ) {

            System.out.println(textbox.getAttribute("name"));
        }

        List<WebElement> textboxs2 =  div.findElements(By.cssSelector("form > div > input"));

        System.out.println("---------------------------------");

        for (WebElement textbox: textboxs2
                ) {

            System.out.println(textbox.getAttribute("name"));
        }

    }

    @Ignore
    @Test
    public  void cssSelectorPathAttribute(){

        WebElement div = driver.findElement(By.id("content"));



        List<WebElement> textboxs =  div.findElements(By.cssSelector("form div input[type='checkbox']"));

        for (WebElement textbox: textboxs
                ) {

            System.out.println(textbox.getAttribute("value"));
        }


    }

    @Ignore
    @Test
    public  void cssSelectorPathClass(){

        // tag.classname

        WebElement div = driver.findElement(By.id("content"));



        List<WebElement> textboxs =  div.findElements(By.cssSelector("form div.wpoi-filled input[type='checkbox']"));

        for (WebElement textbox: textboxs
                ) {

            System.out.println(textbox.getAttribute("value"));
        }


        // div.findElements(By.classname("icon"));
        List<WebElement> icons =  div.findElements(By.cssSelector(".icon"));

        for (WebElement textbox: textboxs
                ) {

            System.out.println(textbox.getAttribute("viewBox"));
        }



    }

    //1 xpath relation
    @Ignore
    @Test
    public  void getLastNameXpath(){

        WebElement div = driver.findElement(By.id("content"));
        WebElement textbox= div.findElement(By.xpath("//form/fieldset/div[1]/input[2]"));

        textbox.sendKeys("Hello");
    }

    @Ignore
    //2 css selector
    @Test
    public  void getLastNameCss(){

        WebElement div = driver.findElement(By.id("content"));
        WebElement textbox= div.findElement(By.cssSelector("input[name='lastname']"));

        textbox.sendKeys("Hello1");
    }

    @Ignore
    //3 inner block By.tag By.className
    @Test
    public  void getLastNameCommon(){

        WebElement div = driver.findElement(By.id("content"));
        List<WebElement> textboxs= div.findElements(By.tagName("input"));

        for (WebElement textbox:textboxs
             ) {

            if (textbox.getAttribute("name").equals("lastname")){
                textbox.sendKeys("Hello2");
            }

        }


    }


    //regular expression

    @Test
    public void cssSelecterStartWith(){
        //x ^= y x start with y  x= abxd   y=ab

        List<WebElement> radios = driver.findElements(By.cssSelector("[id^='exp']"));

        for (WebElement radio:radios
                ) {

            System.out.println(radio.getAttribute("value"));

        }
    }

    @Test
    public void cssSelecterEndWith(){
        //x $= y x start with y  x= abxd   y=xd

        List<WebElement> radios = driver.findElements(By.cssSelector("[id$='1']"));

        for (WebElement radio:radios
                ) {

            System.out.println(radio.getAttribute("id"));

        }
    }

}
