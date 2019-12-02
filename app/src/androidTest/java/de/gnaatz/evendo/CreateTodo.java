package de.gnaatz.evendo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertEquals;

public class CreateTodo {
    private String title;

    private String actualAnswer;

    @Given("(.*?) is required")
    public void titleIsRequired(String title) {
        this.title = title;
    }

    @When("I press the button to create a todo")
    public void iPressTheButtonToCreateATodo() {
        this.actualAnswer = "" + !(title.isEmpty());
    }

    @Then("(.*?) should be returned3")
    public void answerShouldBeReturned(String answer) {
        assertEquals(actualAnswer, answer);
    }
}
