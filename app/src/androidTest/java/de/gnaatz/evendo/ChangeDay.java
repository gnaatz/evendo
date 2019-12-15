package de.gnaatz.evendo;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class ChangeDay {
    private String newDay;

    private String actualAnswer;

    @Given("(.*?) is needed")
    public void newDayIsNeeded(String newDay) {
        this.newDay = newDay;
    }

    @When("I click on another Day")
    public void iClickOnAnotherDay() {
        this.actualAnswer = (!(newDay.isEmpty())) ? "right" : "wrong";
    }

    @Then("(.*?) might be returned3")
    public void mightBeReturned3(String answer) {
        assertEquals(actualAnswer, answer);
    }
}