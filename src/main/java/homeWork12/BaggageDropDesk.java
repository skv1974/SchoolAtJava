package homeWork12;

public class BaggageDropDesk {
    private final String[] availableFlights;

    public BaggageDropDesk(String[] availableFlights) {
        this.availableFlights = availableFlights;
    }

    public BaggageTicket dropBaggage(String passengerName, String flightNumber, int baggageWeight)
            throws Exceptions.FlightNotFoundException, Exceptions.OverweightBaggageException, Exceptions.BaggageTagPrintException {

        // --- СИМУЛЯЦИЯ КРИТИЧЕСКОЙ ОШИБКИ (Часть 4) ---
        // Если вес багажа равен ровно 999 кг — это ломает ленту конвейера
        if (baggageWeight >= 999) {
            throw new Exceptions.ConveyorBeltMalfunctionError("КАТАСТРОФА: Лента конвейера заклинила и задымилась из-за сверхтяжелого груза!");
        }

        //Проверка имени пассажира (Runtime)
        if (passengerName == null || passengerName.trim().isEmpty()) {
            throw new Exceptions.InvalidPassengerNameException("Имя пассажира не может быть пустым или null!");
        }

        //Проверка корректности веса (Runtime)
        if (baggageWeight <= 0) {
            throw new Exceptions.InvalidBaggageWeightException("Вес багажа должен быть больше нуля! Передано: " + baggageWeight);
        }

        //Проверка наличия рейса (Проверяемое)
        boolean flightExists = false;
        for (String flight : availableFlights) {
            if (flight.equalsIgnoreCase(flightNumber)) {
                flightExists = true;
                break;
            }
        }
        if (!flightExists) {
            throw new Exceptions.FlightNotFoundException("Рейс " + flightNumber + " не найден в расписании.");
        }

        //Проверка на перевес (Проверяемое)
        if (baggageWeight > 23) {
            throw new Exceptions.OverweightBaggageException("Перевес! Максимальный вес 23 кг, а у вас: " + baggageWeight + " кг.");
        }

        //Имитация проблемы с принтером (Проверяемое)
        if ("AE-404".equalsIgnoreCase(flightNumber)) {
            throw new Exceptions.BaggageTagPrintException("Ошибка печати: нет кассовой ленты бирок на рейсе AE-404!");
        }

        //Если всё успешно passed:
        System.out.println(">>> Уважаемый(ая) " + passengerName + ", всё хорошо, счастливого пути!");

        return new BaggageTicket(passengerName, flightNumber, baggageWeight);
    }
}