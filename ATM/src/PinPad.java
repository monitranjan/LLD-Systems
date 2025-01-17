import java.util.Scanner;

public class PinPad {
    private Scanner scanner = new Scanner(System.in);

    public String getPin(){
        return scanner.nextLine();
    }
}
