import javax.swing.*;
import java.util.IllegalFormatConversionException;
import java.io.*;
import java.net.*;
public class ButtonClient {
    public static void main(String[] args) {
        String socketName;
        String hostName;
        JOptionPane.showMessageDialog(null, "Hello user and welcome to the button game!", "Hello!", JOptionPane.PLAIN_MESSAGE);
        hostName = JOptionPane.showInputDialog(null, "Please enter the host name", "Socket", JOptionPane.QUESTION_MESSAGE);
        socketName = JOptionPane.showInputDialog(null, "Please enter the port number", "Socket", JOptionPane.QUESTION_MESSAGE);
        try {
            Socket socket = new Socket(hostName, Integer.parseInt(socketName));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "There was an error connecting to the server", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    }
}
