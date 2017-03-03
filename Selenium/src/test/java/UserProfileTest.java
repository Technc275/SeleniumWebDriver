import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

/**
 * Created by student on 03.03.2017.
 */
public class UserProfileTest {

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

    //---------------------------------------------------
    //Firstname
    @Test
    public void firstNameFormattDigitsTest(){

        //regular expression
        WebElement firstname = driver.findElement(By.cssSelector("input[name='firstname']"));

        firstname.sendKeys("012346");

        String text = firstname.getText();

        System.out.println(text);

        Assert.assertEquals(text,"");

    }
    @Test
    public void firstNameFormattSpesialSymbolsTest(){

        //regular expression
        WebElement firstname = driver.findElement(By.cssSelector("input[name='firstname']"));

        firstname.sendKeys("!@#$%^&*(");

        String text = firstname.getText();

        System.out.println(text);


        Assert.assertEquals(text,"");

    }

    @Test
    public void firstNameFormattMixTest(){

        //regular expression
        WebElement firstname = driver.findElement(By.cssSelector("input[name='firstname']"));

        firstname.sendKeys("Igor124Igor#$%^igor");

        String text = firstname.getText();

        System.out.println(text);
        /*
        try {
            code

        }catch{
            if any error in code

                    to do
        }
    */
        try {

            //Assert.assertEquals(text, "IgorIgorigor");
            //VS
            Assert.assertTrue(text.equals("IgorIgorigor"));

        }catch (Exception e){

            System.out.println("Some error happen");

        }

    }


    @Test

    public void firstNameFormattPositiveTest()
    {
        //regular expression
        WebElement firstname = driver.findElement(By.cssSelector("input[name='firstname']"));

        firstname.sendKeys("Hello");

        String text = firstname.getText();

        System.out.println(text);

        Assert.assertTrue(firstname.getText().equals("Hello"));
    }

    //Usability---------------------------------------------------

    @Test
    public void firstNameUsabilityTest() {



        WebElement firstname = driver.findElement(By.cssSelector("input[name='firstname']"));

         // visiable
        Assert.assertTrue(firstname.isDisplayed());

        // enable
        Assert.assertTrue(firstname.isEnabled());

        // position

        Point coordinates = firstname.getLocation(); //x y

        boolean is_ok=true;

        if ((coordinates.getX()<0)||(coordinates.getY()<0))
        {
            is_ok=false;
        }

        Assert.assertTrue(is_ok);




    }
    //-------------------------------------------------------------


    @Test

    public void firstNameLastNameUsabiltyGroup(){


        List<WebElement> name_textboxs = driver.findElements(By.cssSelector("div[id='content'] form div[class='control-group'] input"));

        for (WebElement textbox:name_textboxs
             ) {


            Assert.assertTrue(textbox.isDisplayed());
            Assert.assertTrue(textbox.isEnabled());
            Point coordinates = textbox.getLocation(); //x y

            boolean is_ok=true;

            if ((coordinates.getX()<0)||(coordinates.getY()<0))
            {
                is_ok=false;
            }

            Assert.assertTrue(is_ok);

        }

    }


}
