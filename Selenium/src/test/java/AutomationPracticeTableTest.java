import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.List;

/**
 * Created by student on 02.03.2017.
 */
public class AutomationPracticeTableTest {

    WebDriver driver;

    @Before

    public void openTestPage(){

        File path_to_exe = new File("C:\\Users\\student\\Desktop\\FirefoxPortable\\FirefoxPortable.exe");
        FirefoxBinary firefox_exe= new FirefoxBinary(path_to_exe);

        FirefoxProfile empty_profile = new FirefoxProfile();


        driver = new FirefoxDriver(firefox_exe,empty_profile);


        driver.get("http://toolsqa.com/automation-practice-table/");

    }



    @After
    public  void closeAutomationPracticeForm(){

       // driver.quit();
    }

@Ignore
    @Test
    public void findElementByPath(){

       List<WebElement> elements_with_h1 = driver.findElements(By.tagName("h1"));

       System.out.print(elements_with_h1.size());

        for (WebElement element: elements_with_h1
             ) {


            System.out.println(element.getText());

        }

        // find by container

        WebElement div_container = driver.findElement(By.id("content"));

        // search in container

        WebElement header = div_container.findElement(By.tagName("h1"));


        System.out.println(header.getText());

    }
@Ignore
    @Test
    public void findElementByPath2(){

        WebElement div_container_with_id = driver.findElement(By.id("content"));


        List<WebElement> inner_divs = div_container_with_id.findElements(By.tagName("div"));

        for (WebElement element:inner_divs
             ) {
            System.out.println(element.getAttribute("class"));
        }


        WebElement goal_div = inner_divs.get(0);

        WebElement link = goal_div.findElement(By.tagName("a"));

        System.out.println(link.getText());

    }
    @Ignore
    @Test
    public void socialLinkAligment(){

        //List<WebElement> social_links =.....

        WebElement div_with_id = driver.findElement(By.id("content"));
        List<WebElement> inner_divs = div_with_id.findElements(By.tagName("div"));

        WebElement goal_div = inner_divs.get(0);

        WebElement div_with_icons = goal_div.findElement(By.className("soc-ico"));

        List<WebElement> icons = div_with_icons.findElements(By.className("icon"));

        // double y_first_icon = icons.get(0).getLocation().getY();

        WebElement first_icon = icons.get(0);

        Point coordinates = first_icon.getLocation();

        double y_first_icon= coordinates.getY();

        boolean is_ok=true;


        for (WebElement icon: icons
             ) {

            double y = icon.getLocation().getY();

            if (y!=y_first_icon)
                is_ok=false;
        }


        //Assert.assertTrue(is_ok);
        Assert.assertEquals(is_ok,true);


    }

    @Ignore
    @Test
    public void findByXPath(){ //css

        //full path
        // body/div[1]/div[1]/header/div[1]/a

        // relative path

        // header
        //path //(two!!!)div[1]/a

        // body....div[1]/div[1]/div[1]/table/tbody/tr[1]/td[1]

        WebElement div_with_id = driver.findElement(By.id("content"));

        WebElement cell = div_with_id.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));

        System.out.print(cell.getText());

        WebElement table = div_with_id.findElement(By.tagName("tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        WebElement second_row=rows.get(1);

        List<WebElement> cells_in_second_row = second_row.findElements(By.tagName("td"));

        WebElement goal_cell = cells_in_second_row.get(1);

        System.out.print(goal_cell.getText());


    }

    @Test
    public void cssSelector(){

        driver.get("http://toolsqa.com/automation-practice-form/");
        // tag [type ='checkbox' ]
        List<WebElement> all_checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

        for (WebElement checkbox :all_checkboxes
             ) {
            System.out.println(checkbox.getAttribute("value"));
            checkbox.click();
        }


        List<WebElement> textboxes = driver.findElements(By.cssSelector("input[type='text']"));

        for (WebElement textbox :textboxes
                ) {

                if(textbox.isDisplayed()) {

                    if (textbox.isEnabled()) {

                        textbox.sendKeys("Hello");
                    }
                }

        }


    }


}
