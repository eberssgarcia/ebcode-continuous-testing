package com.ebcode.steps;


import com.ebcode.page.PaginaCursosPage;
import com.ebcode.page.PaginaFundamentosTestingPage;
import com.ebcode.page.PaginaPrincipalPage;
import com.ebcode.page.PaginaRegistroPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class FreeRangerSteps {

//    SoftAssert softAssert = new SoftAssert();

    // creando un objeto (o instancia) de la clase PaginaPrincipalPage.
    PaginaPrincipalPage paginaPrincipalPage = new PaginaPrincipalPage();
    PaginaFundamentosTestingPage paginaFundamentosTestingPage = new PaginaFundamentosTestingPage();
    PaginaCursosPage paginaCursosPage = new PaginaCursosPage();
    PaginaRegistroPage paginaRegistroPage = new PaginaRegistroPage();

    @Given("I navigate to free range testers")
    public void navigateToFreeRangerTesters() {
        paginaPrincipalPage.navigateToFreeRangerTesters();
    }

    @When("I go to {word} using the navigation bar")
    public void goToSectionBar(String section) {
        paginaPrincipalPage.clickOnSectionNavigationbar(section);
    }

    @And("select Introducción al Testing")
    public void navigateToIntro() {
        paginaFundamentosTestingPage.clickFundamentosTestingLink();
        paginaCursosPage.clickIntroduccionTestingLink();
    }

    @When("I select Elegir Plan")
    public void selectElegirPlan() {
        paginaPrincipalPage.clickOnElegirPlanButton();
    }

    @Then("I can validate the options in the checkout page")
    public void validateCheckoutPlans() {
        List<String> lista = paginaRegistroPage.returnPlanDropdownValues();
        List<String> listaEsperada = Arrays.asList("Academia: $16.99 / mes • 12 productos", "Academia: $176 / año • 12 productos", "Free: Gratis • 1 productos");

        Assert.assertEquals(listaEsperada, lista);

//        softAssert.assertEquals(listaEsperada, lista);
    }
}
