package com.ebcode.page;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    // Variables
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action; // instancia - clase de selenium

    static {
        // Configuración para Chrome
//        System.setProperty("webdriver.chrome.driver", "./drivers/win/chromedriver.exe");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--no-sandbox");
//        chromeOptions.addArguments("--disable-dev-shm-usage");
//        chromeOptions.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(chromeOptions);

        // Configuración para Firefox
        System.setProperty("webdriver.gecko.driver", "./drivers/firefox/geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--no-sandbox");
        firefoxOptions.addArguments("--disable-dev-shm-usage");
        driver = new FirefoxDriver(firefoxOptions);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Constructor
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Methods
    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }


    protected WebElement webDriverWait(WebElement element, int timeOnSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((long) timeOnSeconds));
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            return null; // O manejar de otra manera según tus necesidades
        }
    }


    protected void waitForElement(WebElement element, int timeOnSeconds) {
        this.webDriverWait(element, timeOnSeconds);
    }

    public void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void write(String locator, String textToWrite) {
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void clickElement(String locator) {
        Find(locator).click();
    }

    public String getTextFromElement(String locator) {
        return Find(locator).getText();
    }

    // Alert
    public void acceptAlert() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    public void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    // Assertions
    public String getAlertText() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            alert.accept(); // Acepta la alerta
            return alertText;
        } catch (TimeoutException e) {
            // No se presentó una alerta, puedes registrar esto si es necesario
            return null;
        }
    }

    // devuelve un valor entero, se crea una lista
    public int dropdownSize(String locator) {
        // Selecciono el locator de todas las marcas
        Select dropdown = new Select(Find(locator));
        // Crea una lista que contiene elemento web (WebElement)
        // y estamos opteniendo todas las opciones, esto con un select y .getOptions() nos trae todas las opciones del select.
        List<WebElement> dropdownOptions = dropdown.getOptions();
        // Retornamos la cantidad o valor de la lista.
        return dropdownOptions.size();
    }

    // Devolver todos los elementos de una lista
    public List<String> getDropdownValues(String locator) {
        Select dropdown = new Select(Find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> values = new ArrayList<>();
        for (WebElement option : dropdownOptions) {
            values.add(option.getText());
        }
        return values;
    }

    public void goToLinkText(String linktText) {
        driver.findElement(By.linkText(linktText)).click();
    }

    public void selectNthElement(String locator, int index) {
        List<WebElement> results = driver.findElements(By.xpath(locator));
        results.get(index).click();
    }


    public void selectFromDropdownByValue(String locator, String valueToSelect) {
        // Creamos una nueva instancia del objeto Select
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }

    public void hoverOverElement(String locator) {
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator) {
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator) {
        action.contextClick(Find(locator));
    }

    // mover el cursor del mouse al elemento especificado
    protected void moveToElement(WebElement element) {
        action.moveToElement(element).perform();
    }

    // Traer valores de una tabla de la columna y file 3.
    public String getVakueFromTable(String locator, int row, int colum) {
        String cellINeed = locator + "/table/tbody/tr[" + row + "]/td[" + colum + "]";
        // return por que es String y se requiere que devuelve un valor, el valor es con el .getText();
        return Find(cellINeed).getText();
    }

    // Pasar parametro para obtner valor - dinamico
    public void setValueOnTable(String locator, int row, int column, String stringToSend) {
        String cellToFill = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";
        // No hacemos return por que no devuelve nada.
        Find(cellToFill).sendKeys(stringToSend);
    }

    public void switchToiFrame(int iFrameIndex) {
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    // Boleanos
    public boolean elementEnabled(String locator) {
        return Find(locator).isEnabled();
    }

    public boolean elemtIsDisplay(String localtor) {
        return Find(localtor).isDisplayed();
    }

    public boolean elementIsSelected(String locator) {
        return Find(locator).isSelected();
    }

    // List - Listar todos los elementos
    public List<WebElement> bringMeAllElements(String locator) {
        // findElements nos devuelve una lista.
        // return para que nos devuelva los elementos de la lista
        return driver.findElements(By.className(locator));
    }

    // More methods
    public void jsClickElement(WebElement element) {
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click();", element);
    }

    protected WebElement waitUntilElementIsVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    protected void waitForElementAndClick(WebElement element, int timeOnSeconds) {
        this.webDriverWait(element, timeOnSeconds).click();
    }

    protected String waitForElementoAndGetText(WebElement element) {
        return this.waitUntilElementIsVisible(element).getText();
    }

    protected void waitForElementAndSendKey(WebElement element, int timeOnSeconds, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOnSeconds));
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
        visibleElement.sendKeys(value);
    }

    protected boolean isElementPresent(WebElement webElement) {
        try {
            webElement.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected void scrollToElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected String getHrefAttributeValue(WebElement locator) {
        return locator.getAttribute("href");
    }
}
