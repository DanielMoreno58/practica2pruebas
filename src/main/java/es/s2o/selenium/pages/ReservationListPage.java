package es.s2o.selenium.pages;

import es.s2o.selenium.domain.ReservationDTO;
import net.bytebuddy.asm.Advice;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.JavascriptExecutor;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static net.thucydides.core.pages.components.HtmlTable.inTable;

/**
 * Created by sacrists on 26.02.17.
 */

public class ReservationListPage extends PageObjectBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private ReservationPage reservationPage;

    public void acceptCookies(){
        LOGGER.debug("Accept coockies");
        reservationPage.btnAcceptCookies.click();
    }

    public void addInputOrigin(){
        String origin = "MAD";
        reservationPage.btnOrigin.click();
        typeInto(reservationPage.originInput, origin);
        reservationPage.originResult.click();
    }

    public void addInputDestination(){
        String destination = "BCN";
        typeInto(reservationPage.destinationInput, destination);
        reservationPage.destinationResult.click();
    }

    public void addOneWayTripSelect(){
        reservationPage.oneWayTripSelect.waitUntilEnabled();
        reservationPage.oneWayTripSelect.click();
    }

    public void moveToNextCalendarMonth(){
        reservationPage.moveToNextCalendarMonth.waitUntilEnabled();
        reservationPage.moveToNextCalendarMonth.click();
    }

    public void selectDate(){
        reservationPage.selectDate.waitUntilEnabled();
        reservationPage.selectDate.click();
    }

    public void searchFlight(){
        reservationPage.btnSearch.click();
    }

}
