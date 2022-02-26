package es.s2o.selenium.pages;

import es.s2o.selenium.domain.FlightSearchDTO;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Daniel Alexis on 26.02.22.
 */

public class ReservationPage extends PageObjectBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "ensCloseBanner")
    public WebElementFacade btnAcceptCookies;

    @FindBy(className = "origin")
    public WebElementFacade btnOrigin;

    public WebElementFacade originInput;

    @FindBy(css = "#popup-list > vy-airports-li > li:nth-child(1)")
    public WebElementFacade originResult;

    public WebElementFacade destinationInput;

    @FindBy(css = "#popup-list > vy-airports-li > li.liStation")
    public WebElementFacade destinationResult;

    @FindBy(css = "#searchbar > div > vy-datepicker-popup > vy-datepicker-header > ul > li:nth-child(2) > label")
    public WebElementFacade oneWayTripSelect;

    @FindBy(className = "ui-datepicker-next")
    public WebElementFacade moveToNextCalendarMonth;

    @FindBy(xpath = "/html/body/div[4]/div[2]/flights-filter/div/div[2]/div/vy-datepicker-popup/vy-specificdates-datepicker/div/div[4]/table/tbody/tr[1]/td[3]/a")
    public WebElementFacade selectDate;

    @FindBy(id = "btnSubmitHomeSearcher")
    public WebElementFacade btnSearch;

    private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public void acceptCookies(){
        btnAcceptCookies.click();
    }

    public void addInputOrigin(FlightSearchDTO flightSearchDTO){
        btnOrigin.click();
        typeInto(originInput, flightSearchDTO.getOrigen());
        originResult.click();
    }

    public void addInputDestination(FlightSearchDTO flightSearchDTO){
        typeInto(destinationInput, flightSearchDTO.getDestino());
        destinationResult.click();
    }

    public void addOneWayTripSelect(){
        oneWayTripSelect.waitUntilEnabled();
        oneWayTripSelect.click();
    }

    public void moveToNextCalendarMonth(){
        moveToNextCalendarMonth.waitUntilEnabled();
        moveToNextCalendarMonth.click();
    }

    public void selectDate(FlightSearchDTO flightSearchDTO) throws ParseException {
        selectDate.waitUntilEnabled();
        selectDate.click();
    }

    public void searchFlight(){
        btnSearch.click();
    }
}
