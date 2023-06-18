package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class ZadaciTest {

    public static WebDriver driver;
    public static ChromeOptions options;

    @BeforeAll
    static void init() {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver(options);
    }

    @Test
    void zadatak1() {
        login("standard_user", "secret_sauce");
    }

    @Test
    void zadatak2() {
        login("locked_out_user", "secret_sauce");
        text();
    }

    @Test
    void zadatak3() {
        login("problem_user", "secret_sauce");
    }

    @Test
    void zadatak4() {
        login("performance_glitch_user", "secret_sauce");
    }

    @Test
    void zadatak5() {
        login("standard_user", "code_comtrade");
        text();
    }
    @Test
    void zadatakKupovina() {
        login("standard_user", "secret_sauce");
        buy();
    }

    @Test
    void zadatakKorpa() {
        login("standard_user", "secret_sauce");
        korpa();
    }

    @Test
    void zadatakPraznaKorpa() {
        login("standard_user", "secret_sauce");
        korpa();
        praznaKorpa();
    }

    @Test
    void zadatakTwitter() {
        twitter();
    }

    @Test
    void zadatakFacebook() {
        facebook();
    }

    @Test
    void zadatakInstagram() {
        instagram();
    }

    private static void login(String username, String password) {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    private static void buy() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Milos");
        driver.findElement(By.cssSelector("#last-name")).sendKeys("Cica");
        driver.findElement(By.cssSelector("#postal-code")).sendKeys("22330");
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        driver.findElement(By.xpath("//button[@id='finish']")).click();
    }

    private static void korpa() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
    }

    private static void praznaKorpa() {
        driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();
    }

    private static void twitter() {
        driver.get("https://twitter.com/");
        driver.findElement(By.xpath("//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0'][normalize-space()='Sign up']")).click();
    }

    private static void facebook() {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.cssSelector("a[title='Facebook Lite for Android.']")).click();
    }

    private static void instagram() {
        driver.get("https://www.instagram.com/");
        driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > section:nth-child(1) > footer:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > a:nth-child(1) > span:nth-child(1)")).click();
    }

    private static void text() {
        System.out.println(driver.findElement(By.xpath("//h3[@data-test='error']")).getText());
    }

    @AfterEach
    void tearDown() {

    }

    @AfterAll
     static void exit() {
        driver.close();
    }
}