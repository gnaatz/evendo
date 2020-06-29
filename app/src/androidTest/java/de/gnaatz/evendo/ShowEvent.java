package de.gnaatz.evendo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class ShowEvent {
    private String event;

    private String actualAnswer;

    @Given("(.*?) shall be given")
    public void dayShallBeGiven(String event) {
        this.event = event;
    }

    @When("I click on an event")
    public void iClickOnAnEvent() {
        this.actualAnswer = (!(event.isEmpty())) ? "right" : "false";
    }

    @Then("(.*?) should be shown")
    public void shouldBeShown(String answer) {
        assertEquals(answer, actualAnswer);
    }
}
