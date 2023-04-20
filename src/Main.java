import validation.ValidationService;

public class Main {
    public static void main(String[] args) {
        String login = "Nikita_Demin";
        String pass = "123123lkjASD";
        String cpass = "123123lkjASD";

        System.out.println(ValidationService.validation(login, pass, cpass));
    }
}