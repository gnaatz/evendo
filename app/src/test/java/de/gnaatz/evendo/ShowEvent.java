package de.gnaatz.evendo;

import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

public class ShowEvent {
    private String day;
    private String name;

    private String actualAnswer;

    @cucumber.api.java.en.Given("{string} and {string} are required")
    public void dayAndNameAreRequired(String day, String name) {
        this.day = day;
        this.name = name;
    }

    @cucumber.api.java.en.When("I press on the Event")
    public void iPressOnTheEvent() {
        this.actualAnswer = (!(day.isEmpty() || name.isEmpty())) ? "right" : "wrong";
    }

    @Then("{string} should be returned")
    public void shouldBeReturned(String answer) {
        assertEquals(answer, actualAnswer);
    }
}
