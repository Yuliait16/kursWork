package by.strategy;

public class ErrorAuthorisation implements ErrorStrategy{
    @Override
    public String validRegistration() {
        return "Неверный логин или пароль";
    }
}
