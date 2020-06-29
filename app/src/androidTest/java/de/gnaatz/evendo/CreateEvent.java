package de.gnaatz.evendo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class CreateEvent {
    private String title;

    private String actualAnswer;

    @Given("(.*?) is input value")
    public void titleIsInputValue(String title) {
        this.title = title;
    }

    @When("I create an event with this input")
    public void iCreateAnEventWithThisInput() {
        this.actualAnswer = (! title.isEmpty()) ? "right" : "false";
    }

    @Then("(.*?) shall be returned")
    public void shallBeReturned(String answer) {
        assertEquals(answer, actualAnswer);
    }
}
