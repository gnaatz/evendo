package de.gnaatz.evendo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import de.gnaatz.evendo.model.Event;

import static org.junit.Assert.assertEquals;

public class CreateToDoInEvent {
    private String event;
    private String name;

    private String actualAnswer;

    @Given("(.*?) and (.*?) must be given")
    public void eventAndNameMustBeGiven(String event, String name) {
        this.event = event;
        this.name = name;
    }

    @When("I press the button to create a ToDo in an event")
    public void iPressTheButtonToCreateAToDoInAnEvent() {
        this.actualAnswer = (!(event.isEmpty() || name.isEmpty())) ? "right" : "wrong";
    }

    @Then("(.*?) must be returned1")
    public void shouldBeReturned(String answer) {
        assertEquals(answer, actualAnswer);
    }
}
