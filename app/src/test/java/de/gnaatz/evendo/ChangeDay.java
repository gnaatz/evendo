package de.gnaatz.evendo;

import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

public class ChangeDay {
    private String day;

    private String actualAnswer;

    @cucumber.api.java.en.Given("{string} is required")
    public void dayIsRequired(String day) {
        this.day = day;
    }

    @cucumber.api.java.en.When("I click on an other day")
    public void iClickOnAnOtherDay() {
        this.actualAnswer = (!(day.isEmpty())) ? "right" : "wrong";
    }

    @Then("{string} should be returned")
    public void shouldBeReturned(String answer) {
        assertEquals(answer, actualAnswer);
    }
}
