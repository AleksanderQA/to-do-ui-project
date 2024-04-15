package tl.todouiproject;



import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;


public class MainPageTest extends MainPageBase {

    MainPageBase mainPage = new MainPageBase();


    @Test
    @DisplayName("This test used as pattern for task creation and assert existing name of task ")
    public void createTask() {
        mainPage.setUp();
    }


    @Test
    @DisplayName("Clearing created task by clicking X button")
    public void clearTask(){

        mainPage.deleteTaskButton.shouldNotBe(visible);
        mainPage.taskCreationLabel.hover();
        mainPage.deleteTaskButton.shouldBe(visible).click();
        mainPage.taskCreationLabel.shouldNot(exist);
    }

    @Test
    @DisplayName("Clearing task as completed")
    public void createTaskAndClearThemAsCompleted(){
        mainPage.toggleButton.click();
        mainPage.clearCompleted.click();
        mainPage.taskCreationLabel.shouldNotBe(visible);
    }

    @Test
    @DisplayName("This test attempts to check functionality of Active, Completed and Clear Completed buttons")
    public void markOneOfTheTasksAsCompletedAndClearAsCompleted(){

        mainPage.createFewTasks.setValue(createRandomTaskName).pressEnter();
        mainPage.createFewTasks.setValue(createRandomTaskName).pressEnter();
        mainPage.secondTaskToggleButton.click();
        mainPage.completedSwitchButton.click();
        mainPage.clearCompleted.click();
        mainPage.activeSwitchButton.click();
    }
}
