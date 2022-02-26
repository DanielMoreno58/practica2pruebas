package es.s2o.selenium.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class PageObjectBase extends PageObject {

    private EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();

    public EnvironmentVariables getVariables() {
        return variables;
    }

}
