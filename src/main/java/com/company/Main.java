package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dawid\\Downloads\\geckodriver-v0.30.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("https://login.wsb.pl/cas/login?service=https%3A%2F%2Fmoodle2.e-wsb.pl%2Flogin%2Findex.php%3FauthCAS%3DCAS");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"username2\"]"));
        element.sendKeys("gdx155532");
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        element2.sendKeys("95050805637");

        WebElement button = driver.findElement(By.xpath("//*[@id=\"login_button\"]"));
        button.click();


        driver.get("https://moodle2.e-wsb.pl/mod/quiz/view.php?id=4316361");
        WebElement button2 = driver.findElement(By.xpath("//*[starts-with(@id, 'single_button')]"));
        button2.click();
        WebElement button3 = driver.findElement(By.xpath("//*[@id=\"id_submitbutton\"]"));
        button3.click();




    }
}
