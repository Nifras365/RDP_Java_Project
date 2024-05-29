package Client;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Start {
    static String port = "4907";

    public static void main(String[] args) {
        String ip = JOptionPane.showInputDialog("Please enter server ip");
        new Start().initialize(ip, Integer.parseInt(port));
    }

    public void initialize(String ip, int port) {
        try {
            Socket sc = new Socket(ip, port);
            System.out.println("Connecting to the server");
            Authentication framel;
            framel = new Authentication(sc);
            framel.setSize(300,80);
            framel.setLocation(500, 300);
            framel.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}