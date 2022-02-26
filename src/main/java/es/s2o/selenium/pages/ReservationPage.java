package es.s2o.selenium.pages;

import es.s2o.selenium.domain.FlightSearchDTO;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Daniel Alexis on 26.02.22.
 */

public class ReservationPage extends PageObjectBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "ensCloseBanner")
    private WebElementFacade btnAcceptCookies;

    @FindBy(className = "origin")
    private WebElementFacade btnOrigin;

    private WebElementFacade originInput;

    @FindBy(css = "#popup-list > vy-airports-li > li:nth-child(1)")
    private WebElementFacade originResult;

    private WebElementFacade destinationInput;

    @FindBy(css = "#popup-list > vy-airports-li > li.liStation")
    private WebElementFacade destinationResult;

    @FindBy(css = "#searchbar > div > vy-datepicker-popup > vy-datepicker-header > ul > li:nth-child(2) > label")
    private WebElementFacade oneWayTripSelect;

    @FindBy(className = "ui-datepicker-next")
    private WebElementFacade moveToNextCalendarMonth;

    @FindBy(xpath = "/html/body/div[4]/div[2]/flights-filter/div/div[2]/div/vy-datepicker-popup/vy-specificdates-datepicker/div/div[4]/table/tbody/tr[1]/td[3]/a")
    private WebElementFacade selectDate;

    @FindBy(id = "btnSubmitHomeSearcher")
    private WebElementFacade btnSearch;

    @Step
    public void acceptCookies(){
        btnAcceptCookies.click();
    }

    @Step
    public void addInputOrigin(FlightSearchDTO flightSearchDTO){
        btnOrigin.click();
        typeInto(originInput, flightSearchDTO.getOrigen());
        originResult.click();
    }

    @Step
    public void addInputDestination(FlightSearchDTO flightSearchDTO){
        typeInto(destinationInput, flightSearchDTO.getDestino());
        destinationResult.click();
    }

    @Step
    public void addOneWayTripSelect(){
        oneWayTripSelect.waitUntilEnabled();
        oneWayTripSelect.click();
    }

    @Step
    public void moveToNextCalendarMonth(){
        moveToNextCalendarMonth.waitUntilEnabled();
        moveToNextCalendarMonth.click();
    }

    @Step
    public void selectDate(FlightSearchDTO flightSearchDTO) throws ParseException {

        Date today = new Date();
        Date outboundDate = flightSearchDTO.getFechaIda();

        if (outboundDate.compareTo(today) > 0){
            LocalDate ldToday = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate ldOutboundDate = outboundDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            Period differenceMonths = Period.between(ldToday, ldOutboundDate);

            for(int i=0; i<differenceMonths.getMonths()-2; i++){
                moveToNextCalendarMonth();
            }
        }

        selectDate.waitUntilEnabled();
        selectDate.click();
    }

    @Step
    public void searchFlight(){
        btnSearch.click();
    }
}
