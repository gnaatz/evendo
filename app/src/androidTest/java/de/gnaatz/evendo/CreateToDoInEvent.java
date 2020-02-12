package de.gnaatz.evendo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import de.gnaatz.evendo.model.Event;

import static org.junit.Assert.assertEquals;

public class CreateToDoInEvent {
    private String event;
    private String title;

    private String actualAnswer;

    @Given("(.*?) and (.*?) are input values")
    public void eventAndNameAreInputValues(String event, String title) {
        this.event = event;
        this.title = title;
    }

    @When("I create a ToDo in an event with this input")
    public void iCreateAToDoInAnEventWithThisInput() {
        this.actualAnswer = (! title.isEmpty()) ? "right" : "false";
    }

    @Then("(.*?) must be returned1")
    public void mustBeReturned(String answer) {
        assertEquals(answer, actualAnswer);
    }
}
