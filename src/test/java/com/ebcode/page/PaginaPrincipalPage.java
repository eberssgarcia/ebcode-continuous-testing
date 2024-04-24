package com.ebcode.page;

public class PaginaPrincipalPage extends BasePage {

    // Methods
    private String sectionLink = "//a[normalize-space()='%s' and @href]";
    private String elegirPlanButton = "//a[normalize-space()='Elegir Plan' and @href]";

    // Contructor
    public PaginaPrincipalPage() {
        super(driver);
    }

    public void navigateToFreeRangerTesters() {
        navigateTo("https://www.freerangetesters.com/");
        driver.manage().window().maximize();
    }

    public void clickOnSectionNavigationbar(String section) {
        // Reemplaza el marcador de posición en sectionLink con el nombre
        String xpathSection = String.format(sectionLink, section);
        clickElement(xpathSection);
    }

    public void clickOnElegirPlanButton() {
        clickElement(elegirPlanButton);
    }

}
