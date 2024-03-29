import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;


public class DownloadGeneList {
    //TEST DATA

    static String BASE_URL = "https://orcs.thebiogrid.org/";

    static WebDriver driver;
    static int wait = 3;

    //UI ELEMENTS
    By search_type = By.xpath(".//select[@id='searchType']");
    By value = By.xpath(".//option[@value='id']");
    By search = By.xpath(".//input[@id='search']");
    By search_organisms = By.xpath(".//select[@name='organism']");
    By organism_id = By.xpath(".//option[@value='9606']");
    By organism_id_green_monkey = By.xpath(".//option[@value='60711']");
    By organism_id_mouse = By.xpath(".//option[@value='10090']");
    By search_button = By.xpath(".//button[@type='submit']");
    By gene_checkboxAPOE = By.xpath(".//input[@value='348']");
    By gene_checkboxA2M = By.xpath(".//input[@value='2']");
    By gene_checkboxTREM2 = By.xpath(".//input[@value='54209']");
    By gene_checkboxTREM2_monkey = By.xpath(".//input[@value='103221524']");
    By gene_checkboxTREM2_mouse = By.xpath(".//input[@value='83433']");
    By download_checked = By.xpath(".//a[@id='downloadChecked']");
    By submit_button = By.xpath(".//button[@id='submitDownloadBtn']");
    By download_format = By.xpath(".//select[@id='downloadFormat']");
    By format_matrix = By.xpath(".//option[@value='7']");


    @BeforeAll
    static void registerDriver() {
        ChromeOptions op = new ChromeOptions();
        op.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(op);
        driver.get(BASE_URL);
    }

    @AfterAll
    static void closeDriver() {
        driver.close();
    }

    @Test
    void downloadGeneListAPOETabType() {
        String GENE_NAME = "APOE";
        driver.navigate().refresh();
        driver.navigate().to(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(search_type).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(value).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        WebElement element = driver.findElement(search);
        System.out.println(element);
        element.sendKeys(GENE_NAME);
        driver.findElement(search_organisms).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(organism_id).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(search_button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        List<WebElement> elements  = driver.findElements(By.xpath(".//a[@href='https://orcs.thebiogrid.org/Gene/348']"));
        Assertions.assertEquals(GENE_NAME,elements.get(0).getText());
        driver.findElement(gene_checkboxAPOE).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        WebElement gene_APOE_click = driver.findElement(gene_checkboxAPOE);
        boolean gene_APOE_chosen = gene_APOE_click.isSelected();
        Assertions.assertTrue(gene_APOE_chosen);
        driver.findElement(download_checked).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        String expectedButtonText = "Submit";
        String actualButtonText = driver.findElement(By.xpath(".//button[@id='submitDownloadBtn']")).getText();
        Assertions.assertEquals(expectedButtonText, actualButtonText);
        driver.findElement(submit_button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        String expectedHref = "https://orcs.thebiogrid.org/downloads/bef4c61e07b2a66cf84675dcf140ecfa/bef4c61e07b2a66cf84675dcf140ecfa.zip";
        String actualHref = driver.findElement(By.xpath(".//a[@id='downloadFileBtn']")).getAttribute("href");
        String expDownloadFileText = "Download Your File";
        String actualDownloadFileText = driver.findElement(By.xpath(".//button[@class='btn btn-lg btn-warning marginLeftSm marginTopSm marginBotSm']")).getText();
        Assertions.assertEquals(expectedHref, actualHref);
        Assertions.assertEquals(expDownloadFileText, actualDownloadFileText);
    }

    @Test
    void downloadGeneListAPOEMatrixType() {
        String GENE_NAME = "APOE";
        driver.navigate().refresh();
        driver.navigate().to(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(search_type).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(value).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        WebElement element = driver.findElement(search);
        System.out.println(element);
        element.sendKeys(GENE_NAME);
        driver.findElement(search_organisms).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(organism_id).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(search_button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        List<WebElement> elements  = driver.findElements(By.xpath(".//a[@href='https://orcs.thebiogrid.org/Gene/348']"));
        Assertions.assertEquals(GENE_NAME,elements.get(0).getText());
        driver.findElement(gene_checkboxAPOE).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(download_checked).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(download_format).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(format_matrix).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        String expectedButtonText = "Submit";
        String actualButtonText = driver.findElement(By.xpath(".//button[@id='submitDownloadBtn']")).getText();
        Assertions.assertEquals(expectedButtonText, actualButtonText);
        driver.findElement(submit_button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        String expectedHref = "https://orcs.thebiogrid.org/downloads/15367f50b73802186345841f22a808e7/15367f50b73802186345841f22a808e7.zip";
        String actualHref = driver.findElement(By.xpath(".//a[@id='downloadFileBtn']")).getAttribute("href");
        String expDownloadFileText = "Download Your File";
        String actualDownloadFileText = driver.findElement(By.xpath(".//button[@class='btn btn-lg btn-warning marginLeftSm marginTopSm marginBotSm']")).getText();
        Assertions.assertEquals(expectedHref, actualHref);
        Assertions.assertEquals(expDownloadFileText, actualDownloadFileText);
    }

    @Test
    void downloadGeneListA2MTabType() {
        String GENE_NAME2 = "A2M";
        driver.navigate().refresh();
        driver.navigate().to(BASE_URL);
        driver.findElement(search_type).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(value).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        WebElement element = driver.findElement(search);
        System.out.println(element);
        element.sendKeys(GENE_NAME2);
        driver.findElement(search_organisms).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(organism_id).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(search_button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        List<WebElement> elements = driver.findElements(By.xpath(".//a[@href='https://orcs.thebiogrid.org/Gene/2']"));
        Assertions.assertEquals(GENE_NAME2, elements.get(0).getText());
        driver.findElement(gene_checkboxA2M).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(download_checked).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        String expectedButtonText = "Submit";
        String actualButtonText = driver.findElement(By.xpath(".//button[@id='submitDownloadBtn']")).getText();
        Assertions.assertEquals(expectedButtonText, actualButtonText);
        driver.findElement(submit_button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        String expectedHref = "https://orcs.thebiogrid.org/downloads/8a4516197fbae60dc0f87614c89dcf8c/8a4516197fbae60dc0f87614c89dcf8c.zip";
        String actualHref = driver.findElement(By.xpath(".//a[@id='downloadFileBtn']")).getAttribute("href");
        String expDownloadFileText = "Download Your File";
        String actualDownloadFileText = driver.findElement(By.xpath(".//button[@class='btn btn-lg btn-warning marginLeftSm marginTopSm marginBotSm']")).getText();
        Assertions.assertEquals(expectedHref, actualHref);
        Assertions.assertEquals(expDownloadFileText, actualDownloadFileText);
    }

    @Test
    void downloadGeneListA2MMatrixType() {
        String GENE_NAME2 = "A2M";
        driver.navigate().refresh();
        driver.navigate().to(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(search_type).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(value).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        WebElement element = driver.findElement(search);
        element.sendKeys(GENE_NAME2);
        driver.findElement(search_organisms).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(organism_id).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(search_button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        List<WebElement> elements = driver.findElements(By.xpath(".//a[@href='https://orcs.thebiogrid.org/Gene/2']"));
        Assertions.assertEquals(GENE_NAME2, elements.get(0).getText());
        driver.findElement(gene_checkboxA2M).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(download_checked).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(download_format).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(format_matrix).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        String expectedButtonText = "Submit";
        String actualButtonText = driver.findElement(By.xpath(".//button[@id='submitDownloadBtn']")).getText();
        Assertions.assertEquals(expectedButtonText, actualButtonText);
        driver.findElement(submit_button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        String expectedHref = "https://orcs.thebiogrid.org/downloads/7dfb943a20d0c8d806a800cde3a055d6/7dfb943a20d0c8d806a800cde3a055d6.zip";
        String actualHref = driver.findElement(By.xpath(".//a[@id='downloadFileBtn']")).getAttribute("href");
        String expectedDownloadFileText = "Download Your File";
        String actualDownloadFileText = driver.findElement(By.xpath(".//button[@class='btn btn-lg btn-warning marginLeftSm marginTopSm marginBotSm']")).getText();
        Assertions.assertEquals(expectedHref, actualHref);
        Assertions.assertEquals(expectedDownloadFileText, actualDownloadFileText);
    }

    @Test
    void downloadGeneListTREM2TabType() {
        String GENE_NAME3 = "TREM2";
        driver.navigate().refresh();
        driver.navigate().to(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(search_type).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(value).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        WebElement element = driver.findElement(search);
        System.out.println(element);
        element.sendKeys(GENE_NAME3);
        driver.findElement(search_organisms).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(organism_id).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(search_button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        List<WebElement> elements = driver.findElements(By.xpath(".//a[@href='https://orcs.thebiogrid.org/Gene/54209']"));
        Assertions.assertEquals(GENE_NAME3,elements.get(0).getText());
        driver.findElement(gene_checkboxTREM2).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(download_checked).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(download_format).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        String expectedButtonText = "Submit";
        String actualButtonText = driver.findElement(By.xpath(".//button[@id='submitDownloadBtn']")).getText();
        Assertions.assertEquals(expectedButtonText, actualButtonText);
        driver.findElement(submit_button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        String expectedHref = "https://orcs.thebiogrid.org/downloads/8ad8d9b989d26111d6e1a70f1388d262/8ad8d9b989d26111d6e1a70f1388d262.zip";
        String actualHref = driver.findElement(By.xpath(".//a[@id='downloadFileBtn']")).getAttribute("href");
        String expectedDownloadFileText = "Download Your File";
        String actualDownloadFileText = driver.findElement(By.xpath(".//button[@class='btn btn-lg btn-warning marginLeftSm marginTopSm marginBotSm']")).getText();
        Assertions.assertEquals(expectedHref, actualHref);
        Assertions.assertEquals(expectedDownloadFileText, actualDownloadFileText);
    }

    @Test
    void downloadGeneListTREM2MatrixType() {
        String GENE_NAME3 = "TREM2";
        driver.navigate().refresh();
        driver.navigate().to(BASE_URL);
        driver.findElement(search_type).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(value).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        WebElement element = driver.findElement(search);
        System.out.println(element);
        element.sendKeys(GENE_NAME3);
        driver.findElement(search_organisms).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(organism_id).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(search_button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        List<WebElement> elements = driver.findElements(By.xpath(".//a[@href='https://orcs.thebiogrid.org/Gene/54209']"));
        Assertions.assertEquals(GENE_NAME3,elements.get(0).getText());
        driver.findElement(gene_checkboxTREM2).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(download_checked).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(download_format).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(format_matrix).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        String expectedButtonText = "Submit";
        String actualButtonText = driver.findElement(By.xpath(".//button[@id='submitDownloadBtn']")).getText();
        Assertions.assertEquals(expectedButtonText, actualButtonText);
        driver.findElement(submit_button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        String expectedHref = "https://orcs.thebiogrid.org/downloads/f9658a32f71a1aaf118cd0bd1bf4c67d/f9658a32f71a1aaf118cd0bd1bf4c67d.zip";
        String actualHref = driver.findElement(By.xpath(".//a[@id='downloadFileBtn']")).getAttribute("href");
        String expectedDownloadFileText = "Download Your File";
        String actualDownloadFileText = driver.findElement(By.xpath(".//button[@class='btn btn-lg btn-warning marginLeftSm marginTopSm marginBotSm']")).getText();
        Assertions.assertEquals(expectedHref, actualHref);
        Assertions.assertEquals(expectedDownloadFileText, actualDownloadFileText);
    }

    @Test
    void downloadGeneListTREM2TabFormatMonkey() {
        String GENE_NAME3 = "TREM2";
        driver.navigate().refresh();
        driver.navigate().to(BASE_URL);
        driver.findElement(search_type).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(value).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        WebElement element = driver.findElement(search);
        System.out.println(element);
        element.sendKeys(GENE_NAME3);
        driver.findElement(search_organisms).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(organism_id_green_monkey).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(search_button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        List<WebElement> elements = driver.findElements(By.xpath(".//a[@href='https://orcs.thebiogrid.org/Gene/103221524']"));
        Assertions.assertEquals(GENE_NAME3,elements.get(0).getText());
        driver.findElement(gene_checkboxTREM2_monkey).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(download_checked).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(download_format).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        String expectedButtonText = "Submit";
        String actualButtonText = driver.findElement(By.xpath(".//button[@id='submitDownloadBtn']")).getText();
        Assertions.assertEquals(expectedButtonText, actualButtonText);
        driver.findElement(submit_button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        String expectedHref = "https://orcs.thebiogrid.org/downloads/324bae092cc14bb295a7146fc7cb4344/324bae092cc14bb295a7146fc7cb4344.zip";
        String actualHref = driver.findElement(By.xpath(".//a[@id='downloadFileBtn']")).getAttribute("href");
        String expectedDownloadButtonText = "Download Your File";
        String actualDownloadButtonText = driver.findElement(By.xpath(".//button[@class='btn btn-lg btn-warning marginLeftSm marginTopSm marginBotSm']")).getText();
        Assertions.assertEquals(expectedHref, actualHref);
        Assertions.assertEquals(expectedDownloadButtonText, actualDownloadButtonText);
    }

    @Test
    void downloadGeneListTREM2MatrixFormatMonkey() {
        String GENE_NAME3 = "TREM2";
        driver.navigate().refresh();
        driver.navigate().to(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(search_type).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(value).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        WebElement element = driver.findElement(search);
        System.out.println(element);
        element.sendKeys(GENE_NAME3);
        driver.findElement(search_organisms).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(organism_id_green_monkey).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(search_button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        List<WebElement> elements = driver.findElements(By.xpath(".//a[@href='https://orcs.thebiogrid.org/Gene/103221524']"));
        Assertions.assertEquals(GENE_NAME3,elements.get(0).getText());
        driver.findElement(gene_checkboxTREM2_monkey).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(download_checked).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(download_format).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(format_matrix).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        String expectedButtonText = "Submit";
        String actualButtonText = driver.findElement(By.xpath(".//button[@id='submitDownloadBtn']")).getText();
        Assertions.assertEquals(expectedButtonText, actualButtonText);
        driver.findElement(submit_button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        String expectedHref = "https://orcs.thebiogrid.org/downloads/b24400dac09e324d9a85b1c228dbe993/b24400dac09e324d9a85b1c228dbe993.zip";
        String actualHref = driver.findElement(By.xpath(".//a[@id='downloadFileBtn']")).getAttribute("href");
        String expectedDownloadButtonText = "Download Your File";
        String actualDownloadButtonText = driver.findElement(By.xpath(".//button[@class='btn btn-lg btn-warning marginLeftSm marginTopSm marginBotSm']")).getText();
        Assertions.assertEquals(expectedHref, actualHref);
        Assertions.assertEquals(expectedDownloadButtonText, actualDownloadButtonText);
    }

    @Test
    void downloadGeneListTREM2TabFormatMouse() {
        String GENE_NAME3 = "Trem2";
        driver.navigate().refresh();
        driver.navigate().to(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(search_type).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(value).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        WebElement element = driver.findElement(search);
        System.out.println(element);
        element.sendKeys(GENE_NAME3);
        driver.findElement(organism_id_mouse).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(search_button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        List<WebElement> elements = driver.findElements(By.xpath(".//a[@href='https://orcs.thebiogrid.org/Gene/83433']"));
        Assertions.assertEquals(GENE_NAME3,elements.get(0).getText());
        driver.findElement(gene_checkboxTREM2_mouse).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(download_checked).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        driver.findElement(download_format).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        String expectedButtonText = "Submit";
        String actualButtonText = driver.findElement(By.xpath(".//button[@id='submitDownloadBtn']")).getText();
        Assertions.assertEquals(expectedButtonText, actualButtonText);
        driver.findElement(submit_button).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        String expectedHref = "https://orcs.thebiogrid.org/downloads/2e7b3864ef302405b9139d49b0020066/2e7b3864ef302405b9139d49b0020066.zip";
        String actualHref = driver.findElement(By.xpath(".//a[@id='downloadFileBtn']")).getAttribute("href");
        String expectedButtonDownloadText = "Download Your File";
        String actualButtonDownloadText = driver.findElement(By.xpath(".//button[@class='btn btn-lg btn-warning marginLeftSm marginTopSm marginBotSm']")).getText();
        Assertions.assertEquals(expectedHref, actualHref);
        Assertions.assertEquals(expectedButtonDownloadText, actualButtonDownloadText);
        // comment
    }
}