package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class ZadaciTest {

    public static WebDriver driver;
    public static ChromeOptions options;

    private static final By userNameField = By.xpath("//input[@id='user-name']");
    private static final By passwordField = By.cssSelector("#password");
    private static final By loginButton = By.xpath("//input[@id='login-button']");

    private static final By firstNameField = By.xpath("//input[@id='first-name']");
    private static final By lastNameField = By.cssSelector("#last-name");
    private static final By postalCodeField = By.cssSelector("#postal-code");
    private static final By continueButton = By.xpath("//input[@id='continue']");
    private static final By checkoutButton = By.xpath("//button[@id='checkout']");
    private static final By finishButton = By.xpath("//button[@id='finish']");
    private static final By dodajUKorpuButton = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    private static final By otvoriKorpuButton = By.cssSelector(".shopping_cart_link");
    private static final By isprazniKorpuButton = By.xpath("//button[@id='remove-sauce-labs-backpack']");

    private static final By twitterSignUpButton = By.xpath("//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0'][normalize-space()='Sign up']");
    private static final By facebookLiteButton = By.cssSelector("a[title='Facebook Lite for Android.']");
    private static final By instagramJobsButton = By.xpath("//span[normalize-space()='Jobs']");

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
        goToSite("https://www.saucedemo.com/");
        login("standard_user", "secret_sauce");
    }

    @Test
    void zadatak2() {
        goToSite("https://www.saucedemo.com/");
        login("locked_out_user", "secret_sauce");
        text();
    }

    @Test
    void zadatak3() {
        goToSite("https://www.saucedemo.com/");
        login("problem_user", "secret_sauce");
    }

    @Test
    void zadatak4() {
        goToSite("https://www.saucedemo.com/");
        login("performance_glitch_user", "secret_sauce");
    }

    @Test
    void zadatak5() {
        goToSite("https://www.saucedemo.com/");
        login("standard_user", "code_comtrade");
        text();
    }
    @Test
    void zadatakKupovina() {
        goToSite("https://www.saucedemo.com/");
        login("standard_user", "secret_sauce");
        buy();
    }

    @Test
    void zadatakKorpa() {
        goToSite("https://www.saucedemo.com/");
        login("standard_user", "secret_sauce");
        korpa();
    }

    @Test
    void zadatakPraznaKorpa() {
        goToSite("https://www.saucedemo.com/");
        login("standard_user", "secret_sauce");
        korpa();
        praznaKorpa();
    }

    @Test
    void zadatakTwitter() {
        goToSite("https://twitter.com/");
        twitterSignUp();
    }

    @Test
    void zadatakFacebook() {
        goToSite("https://www.facebook.com/");
        facebookLite();
    }

    @Test
    void zadatakInstagram() {
        goToSite("https://www.instagram.com/");
        instagramJobs();
    }

    private static void goToSite(String url) {
        driver.get(url);
    }

    private static void login(String username, String password) {
        driver.findElement(userNameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    private static void buy() {
        driver.findElement(dodajUKorpuButton).click();
        driver.findElement(otvoriKorpuButton).click();
        driver.findElement(checkoutButton).click();
        driver.findElement(firstNameField).sendKeys("Milos");
        driver.findElement(lastNameField).sendKeys("Cica");
        driver.findElement(postalCodeField).sendKeys("22330");
        driver.findElement(continueButton).click();
        driver.findElement(finishButton).click();
    }

    private static void korpa() {
        driver.findElement(dodajUKorpuButton).click();
        driver.findElement(otvoriKorpuButton).click();
    }

    private static void praznaKorpa() {
        driver.findElement(isprazniKorpuButton).click();
    }

    private static void twitterSignUp() {
        driver.findElement(twitterSignUpButton).click();
    }

    private static void facebookLite() {
        driver.findElement(facebookLiteButton).click();
    }

    private static void instagramJobs() {
        driver.findElement(instagramJobsButton).click();
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