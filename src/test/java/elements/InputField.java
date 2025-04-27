package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;

public class InputField {
    private final SelenideElement element;

    public InputField(SelenideElement element) {
        this.element = element;
    }

    public InputField setValue(String value) {
        element.shouldBe(visible.because("Поле должно быть видно для ввода")).setValue(value);
        return this;
    }

    public InputField pressEnter() {
        element.pressEnter();
        return this;
    }
}
