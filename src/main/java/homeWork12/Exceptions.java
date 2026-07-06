package homeWork12;

public class Exceptions {
    // Базовое проверяемое исключение
    static class AirportServiceException extends Exception {
        public AirportServiceException(String message) {
            super(message);
        }
    }

    // Проверяемые исключения (Часть 2)
    static class FlightNotFoundException extends AirportServiceException {
        public FlightNotFoundException(String message) {
            super(message);
        }
    }

    static class OverweightBaggageException extends AirportServiceException {
        public OverweightBaggageException(String message) {
            super(message);
        }
    }

    static class BaggageTagPrintException extends AirportServiceException {
        public BaggageTagPrintException(String message) {
            super(message);
        }
    }

    // Непроверяемые исключения (Часть 3)
    static class InvalidPassengerNameException extends RuntimeException {
        public InvalidPassengerNameException(String message) {
            super(message);
        }
    }

    static class InvalidBaggageWeightException extends RuntimeException {
        public InvalidBaggageWeightException(String message) {
            super(message);
        }
    }

    // Критическая ошибка (Часть 4)
    static class ConveyorBeltMalfunctionError extends Error {
        public ConveyorBeltMalfunctionError(String message) {
            super(message);
        }
    }
}
