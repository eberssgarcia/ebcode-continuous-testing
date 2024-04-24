package com.ebcode.page;

public class PaginaCursosPage extends BasePage {
    // Locator
    private String introduccionTestingLink = "//a[normalize-space()='Introducción al Testing de Software' and @href]";

    // Constructor
    public PaginaCursosPage() {
        super(driver);
    }

    // Methods
    public void clickIntroduccionTestingLink() {
        clickElement(introduccionTestingLink);
    }
}
