package com.hellofresh.challenge.cartpayment;

import static org.assertj.core.api.Assertions.assertThat;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPaymentPageQuestions extends UIInteractionSteps {

  public void verifyOrderConfirmationMessage() {
    String heading = waitForCondition().until(
        ExpectedConditions.visibilityOfElementLocated(CartPaymentPage.PAGE_HEADING)).getText();

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat("ORDER CONFIRMATION".equalsIgnoreCase(heading)).isTrue();
    softly.assertThat($(CartPaymentPage.CONFIRMATION_MESSAGE).getText())
        .contains("Your order on My Store is complete.");
    softly.assertAll();
  }

  public void confirmLastOrderingStep() {
    $(CartPaymentPage.SHIPPING_STEP_COMPLETED).isDisplayed();
    $(CartPaymentPage.LAST_STEP).isDisplayed();
  }

  public void verifyUserInOrderConfirmationPage() {
    assertThat(
        getDriver().getCurrentUrl().contains("?controller=order-confirmation"))
        .isTrue();
  }
}