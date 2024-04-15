package tl.todouiproject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;

// page_url = https://www.jetbrains.com/
public class MainPageBase {

    String createRandomTaskName = RandomStringUtils.randomAlphanumeric(7);

    public SelenideElement deleteTaskButton = $x("//*[@data-testid ='todo-item-button']");
    public SelenideElement taskCreationLabel = $x("//*[@data-testid='todo-item-label']");
    public SelenideElement toggleButton = $x("//*[@data-testid = 'todo-item-toggle']");
    public SelenideElement secondTaskToggleButton = $x("(//*[@data-testid='todo-item-toggle'])[2]");
    public SelenideElement clearCompleted = $x("//*[@* = 'clear-completed']");
    public SelenideElement createFewTasks = $x("//*[@data-testid='text-input']");
    public SelenideElement completedSwitchButton = $x("//*[@href='#/completed']");
    public SelenideElement activeSwitchButton = $x("//*[@href='#/active']");





    @BeforeAll
    public static void setUpAll() {
        Configuration.browserCapabilities = new ChromeOptions();
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());

    }


    @BeforeEach
    public void setUp() {
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750

        Selenide.open("https://todomvc.com/examples/react/dist/");



        SelenideElement createTask = $x("//*[@*='text-input']");
        createTask.setValue(createRandomTaskName);
        createTask.shouldBe(Condition.visible);
        createTask.pressEnter();

        SelenideElement createdTask = $x("//*[@data-testid='todo-item-label']");
        createdTask.shouldHave(Condition.text(createRandomTaskName));
        createdTask.shouldBe(Condition.visible);

    }
}

