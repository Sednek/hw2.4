package validation;

import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class ValidationService {

    public static boolean validation(String login, String password, String confirmPassword) {
        try {
            return checkLogin(login) && checkPassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean checkLogin(String login) throws WrongLoginException {
        Data data = new Data();
        if (login == null || login.length() > 20) {
            throw new WrongLoginException("Длина логина не должна превышать 20 символов");
        }
        for (int i = 0; i < login.length(); i++) {
            if (!data.getValidationLogin().contains(login.substring(i, i + 1))) {
                throw new WrongLoginException("В логине используются некорректные символы - " + login.charAt(i));
            }
        }
        return true;
    }

    public static boolean checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        Data data = new Data();
        if (password == null || password.length() >= 20) {
            throw new WrongPasswordException("Длина пароля не должна превышать 20 символов");
        }
        for (int i = 0; i < password.length(); i++) {
            if (!data.getValidationPassword().contains(password.substring(i, i + 1))) {
                throw new WrongPasswordException("В пароле используются некорректные символы - " + password.charAt(i));
            }
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Введенные пароли не совпадают");
        }
        return true;
    }
}
