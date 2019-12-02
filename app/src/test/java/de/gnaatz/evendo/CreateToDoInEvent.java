package de.gnaatz.evendo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import de.gnaatz.evendo.model.Event;

import static junit.framework.TestCase.assertEquals;

public class CreateToDoInEvent {
    private String title;
    private Event event;

    private String actualAnswer;

    @Given("{string} and {Event} is required")
    public void titleAndEventIsRequired(String title, Event event) {
        this.title = title;
        this.event = event;
    }

    @When("I press the button to create a todo")
    public void iPressTheButtonToCreateATodo() {
        this.actualAnswer = "" + !(title.isEmpty());
    }

    @Then("{string} should be returned here")
    public void answerShouldBeReturned(String answer) {
        assertEquals(actualAnswer, answer);
    }
}
