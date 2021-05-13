package by.strategy;

public class ErrorWarning implements ErrorStrategy{
    @Override
    public String validRegistration() {
        return "Пожалуйста, проверьте почту";
    }
}
