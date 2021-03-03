import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static void checkPassword(String password) { // function which cheks the password if it is not matching with conditions outputs come message
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]3)[A-Za-z\\d@$!%*?&]{8,}$");
        Matcher matcher = pattern.matcher(password);
        boolean matchFound = matcher.find();
        if (!matchFound) {
            System.out.println("Your password does not match with requirements!\n Please be sure that your password\ncontains at least 1 uppercase letter, 1 lowercase letter, 1 digit, 1 special symbol(@,$,!,^) and length more or equal to 8.");
        }
    }
    public static void idCheck(String ID){
        char [] IDChar = ID.toCharArray();
        boolean firstPart = false;
        boolean secondPart = false;
        for (int i = 0;i < 7; ++i) {
            if ((IDChar[i] >= 48 && IDChar[i] <= 59)) {
                firstPart = true;
            }
        }
        for (int i = 0; i < 7;++i){
            if ((IDChar[i] >= 48 && IDChar[i] <= 59)){
                secondPart = true;
            }
        }
        if (firstPart && secondPart && IDChar[6] == '-' && ID.length() == 12){
            System.out.println("Your ID is correct");
        }
    }
}
