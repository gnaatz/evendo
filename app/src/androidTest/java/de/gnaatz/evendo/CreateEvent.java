package de.gnaatz.evendo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class CreateEvent {
    private String day;
    private String name;

    private String actualAnswer;

    @Given("(.*?) and (.*?) are required")
    public void dayAndNameAreRequired(String day, String name) {
        this.day = day;
        this.name = name;
    }

    @When("I press the button to create an event")
    public void iPressTheButtonToCreateAnEvent() {
        this.actualAnswer = (!(day.isEmpty() || name.isEmpty())) ? "right" : "wrong";
    }

    @Then("(.*?) shall be returned")
    public void shouldBeReturned(String answer) {
        assertEquals(answer, actualAnswer);
    }
}
