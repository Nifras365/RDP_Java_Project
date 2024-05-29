package Server;
import java.awt.Robot;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ReceiveScreen extends Thread{
    Socket socket = null;
    Robot robot = null;
    boolean continueLoop = true;
    public ReceiveScreen(Socket socket, Robot robot) {
        this.socket=socket;
        this.robot=robot;
        start();
    }
    public void run() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(socket.getInputStream());
            while(continueLoop) {
                int command = scanner.nextInt();
                switch (command) {
                    case -1 -> robot.mousePress(scanner.nextInt());
                    case -2 -> robot.mouseRelease(scanner.nextInt());
                    case -3 -> robot.keyPress(scanner.nextInt());
                    case -4 -> robot.keyRelease(scanner.nextInt());
                    case -5 -> robot.mouseMove(scanner.nextInt(), scanner.nextInt());
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}