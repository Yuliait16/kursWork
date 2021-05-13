package by.strategy;

public class ErrorInvalidEmail implements ErrorStrategy{
    @Override
    public String validRegistration() {
        return "Пользователя с таким email не существует";
    }
}
