package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dawid\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");

        //Open selenium and login site
        WebDriver driver = new FirefoxDriver();
        driver.get("https://login.wsb.pl/cas/login?service=https%3A%2F%2Fmoodle2.e-wsb.pl%2Flogin%2Findex.php%3FauthCAS%3DCAS");
        //Input and submit credentials
        WebElement element = driver.findElement(By.xpath("//*[@id=\"username2\"]"));
        element.sendKeys("gdx155532");
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        element2.sendKeys("95050805637");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"login_button\"]"));
        button.click();

        //Find quiz
        driver.get("https://moodle2.e-wsb.pl/mod/quiz/view.php?id=4316361");
        WebElement button2 = driver.findElement(By.xpath("//*[starts-with(@id, 'single_button')]"));
        button2.click();

        TimeUnit.SECONDS.sleep(2);

        //Enter quiz even when attempt is active
        try {
            WebElement button3 = driver.findElement(By.xpath("//*[@id=\"id_submitbutton\"]"));
            button3.click();
        }catch (NoSuchElementException e){}


        //Click checkbox and radio. Fill text field.
        List<WebElement> element3 = driver.findElements(By.xpath("//*[starts-with(@id, 'q6')]"));
        for(WebElement elemntListy : element3){
            try
            {
                elemntListy.click();
                elemntListy.sendKeys("a");
            }catch (Exception e){}
        }

        //End test
        WebElement button4 = driver.findElement(By.xpath("//*[@id=\"mod_quiz-next-nav\"]"));
        button4.click();

        //Submit test
        WebElement button5 = driver.findElement(By.xpath("//*[text()='Zatwierdź wszystkie i zakończ']"));
        button5.click();
    }
}
