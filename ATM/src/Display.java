import java.util.Scanner;

public class Display {
    private Scanner scanner = new Scanner(System.in);
    public void showMessage(String message){
        System.out.println(message);
    }

    public int getUserInput(){
        return scanner.nextInt();
    }
}
