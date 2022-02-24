package es.s2o.selenium.pages;

import es.s2o.selenium.domain.ReservationDTO;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

/**
 * Created by sacrists on 26.02.17.
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
}
