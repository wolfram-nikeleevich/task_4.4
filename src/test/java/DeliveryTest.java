import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryTest {

    @Test
    void shouldRegisterCardDelivery() {
        Configuration.holdBrowserOpen = true;

        open("http://localhost:9999/");
        $("[data-test-id=\"city\"] .input__control").setValue("Уфа");
        $("[data-test-id=\"date\"] .input__control").setValue("16.09.2022");
        $("[data-test-id=\"name\"] .input__control").setValue("Петр Иванов");
        $("[data-test-id=\"phone\"] .input__control").setValue("+79876543210");
        $(".checkbox__text").click();
        $(".button__text").click();
        $(withText("Успешно!")).should(visible, Duration.ofSeconds(15));
    }
}
