package by.strategy;

public class ErrorName implements ErrorStrategy{
    @Override
    public String validRegistration() {
        return "Имя не должно содержать цифры и специальные символы";
    }
}
