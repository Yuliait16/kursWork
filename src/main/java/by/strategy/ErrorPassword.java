package by.strategy;

public class ErrorPassword implements ErrorStrategy{
    @Override
    public String validRegistration() {
        return "Пароль должен быть более 6 символов";
    }
}
