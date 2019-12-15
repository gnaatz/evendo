package de.gnaatz.evendo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class ShowEvent {
    private String day;
    private String name;

    private String actualAnswer;

    @Given("(.*?) shall be given")
    public void dayShallBeGiven(String day) {
        this.day = day;
    }

    @When("I click on an event")
    public void iClickOnAnEvent() {
        this.actualAnswer = (!(day.isEmpty())) ? "right" : "wrong";
    }

    @Then("(.*?) should be shown")
    public void shouldBeReturned(String answer) {
        assertEquals(answer, actualAnswer);
    }
}
