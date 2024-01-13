package com.proiect.testare.proiecttestare;


import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class HomePageTest {

    private WebDriver driver;
    private static final String BASE_URL = "http://localhost:8080/home";
    private static final String EN_LOCALE_PROP = "?lang=en";
    private static final String IT_LOCALE_PROP = "?lang=it";

    private static boolean allTestsPassed = true;

    private ResourceBundleMessageSource messageSource;

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        protected void failed(Throwable e, Description description) {
            HomePageTest.allTestsPassed = false;
        }
    };

    public HomePageTest() {

    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Diana\\Desktop\\geckodriver\\geckodriver.exe");
        this.driver = new FirefoxDriver();

        messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("lang/messages");
        messageSource.setDefaultEncoding("UTF-8");

    }

    @Test
    public void shouldLoadENMessages_whenENLocaleIsSelected() {
        // when
        this.driver.get(BASE_URL + EN_LOCALE_PROP);
        WebElement helloElement = driver.findElement(By.id("hello-element"));
        WebElement welcomeElement = driver.findElement(By.id("welcome-element"));

        // then
        Assert.assertEquals(helloElement.getText(), messageSource.getMessage("hello", null, Locale.ENGLISH));
        Assert.assertEquals(welcomeElement.getText(), messageSource.getMessage("welcome", null, Locale.ENGLISH));
    }

    @Test
    public void shouldLoadITMEssages_whenITLocaleIsSelected() {
        // when
        this.driver.get(BASE_URL + IT_LOCALE_PROP);
        WebElement helloElement = driver.findElement(By.id("hello-element"));
        WebElement welcomeElement = driver.findElement(By.id("welcome-element"));

        // then
        Assert.assertEquals(helloElement.getText(), messageSource.getMessage("hello", null, Locale.ITALIAN));
        Assert.assertEquals(welcomeElement.getText(), messageSource.getMessage("welcome", null, Locale.ITALIAN));
    }

    @After
    public void tearDown() {
        if (this.driver != null) {
            if (allTestsPassed) {
                this.driver.navigate().to("data:text/html, <html><body><h1>Test passed!</h1></body></html>");

                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException var2) {
                    var2.printStackTrace();
                }
            }

            this.driver.quit();
        }

    }

}
