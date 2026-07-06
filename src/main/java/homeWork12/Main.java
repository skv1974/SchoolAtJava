package homeWork12;

public class Main {
    public static void main(String[] args) {
        String[] flights = {"SU-123", "TK-777", "KC-909", "AE-404"};
        BaggageDropDesk desk = new BaggageDropDesk(flights);

        // Тесты для проверки всех сценариев
        runScenario(desk, "Николай Жильцов", "SU-123", 18);  // 1. Успех
        runScenario(desk, "Алевтина Петрова", "NY-999", 15);  // 2. Рейс не найден
        runScenario(desk, "Артем Герасин", "TK-777", 30);  // 3. Перевес
        runScenario(desk, "Константин Смотров", "AE-404", 20);   // 4. Проблема с принтером
        runScenario(desk, null, "KC-909", 12);            // 5. Некорректное имя (null)
        runScenario(desk, "Александр Кузьмичев", "SU-123", -5);  // 6. Некорректный вес (отрицательный)
    }

    private static void runScenario(BaggageDropDesk desk, String name, String flight, int weight) {
        System.out.println("Тестируем параметры: [" + name + ", " + flight + ", " + weight + " кг]");
        try {
            BaggageTicket ticket = desk.dropBaggage(name, flight, weight);
            System.out.println("УСПЕХ: Бирка успешно выдана -> " + ticket);

        } catch (Exceptions.FlightNotFoundException e) {
            System.out.println("ВНИМАНИЕ: " + e.getMessage() + " (Действие: Попросить пассажира проверить билет)");

        } catch (Exceptions.OverweightBaggageException e) {
            System.out.println("ВНИМАНИЕ: " + e.getMessage() + " (Действие: Направить на кассу доплаты за перевес)");

        } catch (Exceptions.BaggageTagPrintException e) {
            System.out.println("ВНИМАНИЕ: " + e.getMessage() + " (Действие: Вызвать IT-специалиста для перезагрузки принтера)");

        } catch (Exceptions.InvalidPassengerNameException e) {
            System.out.println("КРИТИЧЕСКИЙ БАГ (Runtime): " + e.getMessage());

        } catch (Exceptions.InvalidBaggageWeightException e) {
            System.out.println("ВНИМАНИЕ! КРИТИЧЕСКИЙ БАГ (Runtime): " + e.getMessage());

        } catch (Exceptions.AirportServiceException e) {
            System.out.println("ВНИМАНИЕ! Общая ошибка сервиса аэропорта: " + e.getMessage());
        }
        System.out.println("--------------------------------------------------\n");
    }
}