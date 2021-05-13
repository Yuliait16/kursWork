package by.strategy;

public class ErrorEmail implements ErrorStrategy{
    @Override
    public String validRegistration() {
        return "Неверный e-mail или не существует";
    }
}
