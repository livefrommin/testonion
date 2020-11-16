import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.example.ConfProperties;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class test {
    public WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void CSVReader1by1() throws IOException, CsvValidationException {
        WebElement formElement = driver.findElement(By.xpath("//input[@id]"));
        List<WebElement> input = formElement.findElements(By.xpath("//input[@id]"));
        CSVReader csvRead = new CSVReader(new FileReader("D:\\file.csv"));
        String[] row = null;

        try {
            String[] data;
            while ((data = csvRead.readNext()) != null) {
                for (int a = 0; a < input.size(); a++) {
                    input.get(a).sendKeys(data[a]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void CSVReader1toall() throws IOException, CsvValidationException {
        WebElement formElement = driver.findElement(By.xpath("//input[@id]"));
        List<WebElement> input = formElement.findElements(By.xpath("//input[@id]"));
        CSVReader csvRead = new CSVReader(new FileReader("D:\\file.csv"));
        String[] row = null;

        try {
            String[] data;
            while ((data = csvRead.readNext()) != null) {
                for (int a = 0; a < input.size(); a++) {
                    input.get(a).sendKeys(data[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void CSVReaderallto1() throws IOException, CsvValidationException {
        WebElement formElement = driver.findElement(By.xpath("//input[@id]"));
        List<WebElement> input = formElement.findElements(By.xpath("//input[@id]"));
        CSVReader csvRead = new CSVReader(new FileReader("D:\\file.csv"));
        String[] row = null;

        try {
            String[] data;
            while ((data = csvRead.readNext()) != null) {
                for (int a = 0; a < input.size(); a++) {
                    input.get(0).sendKeys(data[a]);
                    input.get(0).clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void CSVReaderalltoall() throws IOException, CsvValidationException {
        WebElement formElement = driver.findElement(By.xpath("//input[@id]"));
        List<WebElement> input = formElement.findElements(By.xpath("//input[@id]"));
        CSVReader csvRead = new CSVReader(new FileReader("D:\\file.csv"));
        String[] row = null;

        try {

            String[] data;
            while ((data = csvRead.readNext()) != null) {
                for (int a = 0; a < input.size(); a++) {
                    for (int b = 0; b < data.length; b++) {
                         input.get(a).sendKeys(data[b]);
                        Thread.sleep(1000);
                       input.get(a).clear(); }
                   }
                }
            } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}