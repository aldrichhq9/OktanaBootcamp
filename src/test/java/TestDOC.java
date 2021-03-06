import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.ListMethods;

import java.util.List;

import static utilities.Miscellaneous.highLighterMethod;
import static utilities.RandomEmail.randomEmail;

public class TestDOC extends Base{
    @BeforeTest
    public void initialize(){
        driver = initializeDriver();
        driver.get("https://demo.opencart.com/");
    }

    @Test
    public void testFindElementBy() throws InterruptedException {
        WebElement desktops = driver.findElement(By.linkText("Desktops"));
        highLighterMethod(driver,desktops);
        Thread.sleep(3000);
        WebElement shopping = driver.findElement(By.partialLinkText("Shopping"));
        highLighterMethod(driver,shopping);
        Thread.sleep(4000);
        WebElement macImage = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[1]/a/img"));
        highLighterMethod(driver,macImage);
        Thread.sleep(4000);
        WebElement components = driver.findElement(By.cssSelector("#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(3) > a"));
        highLighterMethod(driver,components);
        Thread.sleep(4000);
        driver.get("https://demo.opencart.com/index.php?route=account/register");
        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        highLighterMethod(driver,firstNameInput);
        Thread.sleep(4000);
        WebElement lastNameInput = driver.findElement(By.name("lastname"));
        highLighterMethod(driver,lastNameInput);
        Thread.sleep(4000);
    }

    @Test
    public void testListElementsBy(){
        List<WebElement> dropdownElements = driver.findElements(By.className("dropdown-toggle"));
        ListMethods.printListText(dropdownElements);

        List<WebElement> imagElements = driver.findElements(By.className("price"));
        ListMethods.printListText(imagElements);
    }

    @Test
    public void testElementAttributes(){
        String link;
        String src;
        WebElement software= driver.findElement(By.linkText("Software"));
        link=software.getAttribute("href");
        System.out.println(link);
        WebElement imgPhone= driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[1]/a/img"));
        src=imgPhone.getAttribute("alt");
        System.out.println(src);
    }

    @Test
    public void testForm() throws InterruptedException {
        WebElement myAccount=driver.findElement(By.linkText("My Account"));
        myAccount.click();
        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();
        WebElement firstNameInput=driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys("first name test");
        WebElement lastNameInput =driver.findElement(By.name("lastname"));
        lastNameInput.sendKeys("last name test");

        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
        emailInput.sendKeys(randomEmail());// llamar al metodo random email
        WebElement telephoneInput=driver.findElement(By.id("input-telephone"));
        telephoneInput.sendKeys("912345678");
        WebElement pwd1Input = driver.findElement(By.name("password"));
        pwd1Input.sendKeys("test1234");
        WebElement pdw2Input = driver.findElement(By.name("confirm"));
        pdw2Input.sendKeys("test1234");

        List<WebElement> rdtBtns = driver.findElements(By.name("newsletter"));
        rdtBtns.get(1).click();

        WebElement privacyCheckBox = driver.findElement(By.name("agree"));
        privacyCheckBox.click();

        WebElement continueBtn = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));
        continueBtn.click();

    }

    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
