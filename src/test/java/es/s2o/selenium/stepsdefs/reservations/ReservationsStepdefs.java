package es.s2o.selenium.stepsdefs.reservations;

import es.s2o.selenium.domain.FlightSearchDTO;
import es.s2o.selenium.pages.ReservationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sacrists on 26.02.17.
 */
public class ReservationsStepdefs {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private ReservationPage reservationPage;
    private List<FlightSearchDTO> flightSearchList;

    @Given("^I'm in the main page$")
    public void iMInTheMainPage() throws Throwable {
        LOGGER.debug("iMInTheMainPage starts");
        String baseUrl = reservationPage.getVariables().getProperty("WEB_ROOT");
        reservationPage.openAt(baseUrl);
    }

    @And("I Accept Cookies$")
    public void iAcceptCookies() throws Throwable {
        LOGGER.debug("iAcceptCookies starts");
        reservationPage.acceptCookies();
    }

    @When("^I search for flight with the following data:$")
    public void iSearchForFlightWithTheFollowingData(FlightSearchDTO flightSearchDTO) throws Throwable {
        LOGGER.debug("iSearchForFlight starts", flightSearchDTO);
        reservationPage.addInputOrigin(flightSearchDTO);
        reservationPage.addInputDestination(flightSearchDTO);
        reservationPage.addOneWayTripSelect();
        reservationPage.moveToNextCalendarMonth();
        reservationPage.moveToNextCalendarMonth();
        reservationPage.selectDate(flightSearchDTO);
        reservationPage.searchFlight();
    }

    @Then("^I get the existing flight page$")
    public void iGetTheExistingFlightPage() throws Throwable {
        LOGGER.debug("iGetTheExistingFlightPage starts");
    }
}
