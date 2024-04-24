package com.ebcode.page;

public class PaginaFundamentosTestingPage extends BasePage {

    // Locator
    private String fundamentosTestingLink = "//a[normalize-space()='Fundamentos del Testing' and @href]";

    // Constructor
    public PaginaFundamentosTestingPage() {
        super(driver);
    }

    // Methods
    public void clickFundamentosTestingLink() {
        clickElement(fundamentosTestingLink);
    }
}
