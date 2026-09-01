package homeWork16.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import java.util.Map;

public class BookingSteps {

    @Given("в ресторане уже есть базовые столики")
    public void initialTables() {
        System.out.println("Шаг: Базовые столики инициализированы");
    }

    @Given("гость хочет забронировать столик на {int} человека")
    public void guestWantsTable(int guests) {
        System.out.println("Гость хочет забронировать на: " + guests);
    }

    @When("гость бронирует столик на {word}")
    public void bookTable(String time) {
        System.out.println("Бронирование на время: " + time);
    }

    @Then("бронирование должно быть подтверждено")
    public void bookingConfirmed() {
        System.out.println("Бронь подтверждена");
    }

    @Then("клиент должен получить отказ")
    public void bookingRefused() {
        System.out.println("Клиент получил отказ");
    }

    @Then("бронирование должно быть отменено")
    public void bookingCancelled() {
        System.out.println("Бронь отменена");
    }

    @Given("в ресторане есть столик вместимостью {int} человека")
    public void tableWithCapacity(int capacity) {
        System.out.println("Столик вместимостью: " + capacity);
    }

    @Given("у гостя есть активное бронирование")
    public void activeBooking() {
        System.out.println("Активное бронирование найдено");
    }

    @When("гость отменяет своё бронирование")
    public void cancelBooking() {
        System.out.println("Выполняется отмена");
    }

    @Then("результат должен быть {string}")
    public void checkResult(String result) {
        System.out.println("Ожидаемый результат: " + result);
    }

    @Given("в ресторане есть столики:")
    public void tablesDataTable(DataTable table) {
        System.out.println("Парсинг таблицы столиков:");
        for (Map<String, String> row : table.asMaps()) {
            System.out.println("Номер: " + row.get("номер") + ", Вместимость: " + row.get("вместимость"));
        }
    }

    @When("гость оставляет пожелание к брони:")
    public void guestWish(String wish) {
        System.out.println("Пожелание: " + wish);
    }
}