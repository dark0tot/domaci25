import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class CalculatorTest {
  private WebDriver driver;

  @BeforeClass
  public void setup() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\dark0\\IdeaProjects\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.get("https://testsheepnz.github.io/BasicCalculator.html");
  }

  @AfterClass
  public void afterClass() {
    driver.quit();
  }

  @BeforeMethod
  public void beforeMethod() {
    driver.get("https://testsheepnz.github.io/BasicCalculator.html");
  }

  @AfterMethod
  public void afterMethod() {
    WebElement clearButton = driver.findElement(By.id("clearButton"));
    clearButton.click();
  }

  @Test
  public void addTest() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("5");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("5");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(0);

    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "10";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void addTestBigNumbers() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("11500250");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("99650113");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(0);

    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "111150363";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void addTestFromMinusToZero() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("-5");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("5");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(0);

    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "0";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void addTestFromMinusAboveZero() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("-5");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("6");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(0);

    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "1";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void addTestAddZeroToNum() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("0");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("5");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(0);

    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "5";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void addTestZeros() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("0");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("0");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(0);

    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "0";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void addTestWithLetter() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("a");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("5");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(0);

    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void subtract() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("5");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("5");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(1);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "0";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void subtractMinus() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("5");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("15");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(1);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "-10";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void subtractMinusBigNum() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("1");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("1111111115");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(1);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "-1111111114";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void subtractMinusFromZero() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("0");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("23");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(1);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "-23";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void subtractMinusZero() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("13");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("0");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(1);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "13";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void subtractZeros() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("0");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("0");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(1);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "0";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void subtractWithLetter() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("5");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("a");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(1);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void multiply() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("5");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("5");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(2);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "25";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void multiplyMinusOneNumber() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("-1");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("5");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(2);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "-5";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void multiplyMinusBothNumbers() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("-15");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("-5");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(2);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "75";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void multiplyBigNumb() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("15500");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("15005");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(2);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "232577500";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void multiplyWithZero() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("0");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("5");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(2);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "0";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void multiplyZeros() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("0");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("0");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(2);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "0";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void multiplyWithLetters() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("a");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("5");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(2);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void divide() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("5");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("5");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(3);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "1";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void divideMinusOneNumber() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("-15");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("5");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(3);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "-3";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void divideMinusBothNumbers() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("-15");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("-5");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(3);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "3";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void divideByZero() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("5");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("0");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(3);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void divideBigNumbers() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("156461128");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("15034");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(3);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "10407.15";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertTrue(actualResult.contains(expResult));
  }

  @Test
  public void divideWithLetters() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("a");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("b");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(3);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void concatenate() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("5");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("5");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(4);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "55";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void concatenateMinus() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("-15");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("5");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(4);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "-155";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }

  @Test
  public void concatenateMinus2() {
    WebElement firstNumber = driver.findElement(By.id("number1Field"));
    firstNumber.sendKeys("5");
    WebElement secondNumber = driver.findElement(By.id("number2Field"));
    secondNumber.sendKeys("-15");

    Select operationDropdown = new Select(driver.findElement(By.id("selectOperationDropdown")));
    operationDropdown.selectByIndex(4);


    WebElement calculateButton = driver.findElement(By.id("calculateButton"));
    calculateButton.click();

    String expResult = "5-15";
    WebElement result = driver.findElement(By.id("numberAnswerField"));
    String actualResult = result.getAttribute("value");

    Assert.assertEquals(actualResult, expResult);
  }
}
