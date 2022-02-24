package es.s2o.selenium.stepsdefs.reservations;

import es.s2o.selenium.domain.ReservationDTO;
import es.s2o.selenium.pages.ReservationListPage;
import es.s2o.selenium.pages.ReservationPage;
import es.s2o.selenium.services.ReservationService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sacrists on 26.02.17.
 */
public class ReservationsStepdefs {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final String WEB_ROOT = "WEB_ROOT";
    private static final String HOME = "reservationList.html";

    @Steps
    private ReservationService reservationService;

    private ReservationListPage reservationListPage;
    private ReservationPage reservationPage;

    private List<ReservationDTO> reservations;

    @Before
    public void beforeScenario() {
        LOGGER.debug("beforeScenario starts");
        reservationService.addReservations(2);
    }

    @After
    public void afterScenario() {
        LOGGER.debug("afterScenario starts");
        reservationService.clean();
    }

    @Given("^I'm in the main page$")
    public void iMInTheMainPage() throws Throwable {
        LOGGER.debug("iMInTheReservationsPage starts");
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String baseUrl = variables.getProperty("WEB_ROOT");
        reservationPage.openAt(baseUrl);
    }

    @When("^I search for flight:$")
    public void iSearchForFlight(List<ReservationDTO> reservationDTOList) throws Throwable {
        LOGGER.debug("iRegisterTheFollowingReservations starts, list size:[{}]", reservationDTOList.size());
        reservations = reservationDTOList;
        reservationListPage.acceptCookies();
        reservationListPage.addInputOrigin();
        reservationListPage.addInputDestination();
        reservationListPage.addOneWayTripSelect();
        reservationListPage.moveToNextCalendarMonth();
        reservationListPage.moveToNextCalendarMonth();
        reservationListPage.selectDate();
        reservationListPage.searchFlight();
    }

    @Then("^I get the existing flight page$")
    public void iGetTheExistingFlightPage() throws Throwable {
        LOGGER.debug("iGetTheReservationInTheReservationsList starts");
    }
}
