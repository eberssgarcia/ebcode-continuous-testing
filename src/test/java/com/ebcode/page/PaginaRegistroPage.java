package com.ebcode.page;

import java.util.List;

public class PaginaRegistroPage extends BasePage {

    private String planDropdown = "//select[@id='cart_cart_item_attributes_plan_with_interval']";

    public PaginaRegistroPage() {
        super(driver);
    }

    public List<String> returnPlanDropdownValues() {
        return getDropdownValues(planDropdown);
    }

}
