import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class ButtonServer implements ActionListener {

    private static int totalButtonPresses;
    private static int totalPlayers;
    private int thisUserButtonPresses = 0;
    private static JFrame frame;
    private static JButton button;
    private static Object object = new Object();


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3002);
        JOptionPane.showMessageDialog(null, "Waiting for the user to connect. . .", "connection", JOptionPane.PLAIN_MESSAGE);
        serverSocket.accept();
        JOptionPane.showMessageDialog(null, "Connection successful", "connection", JOptionPane.PLAIN_MESSAGE);
            totalPlayers++;
            int yesNo = JOptionPane.showConfirmDialog(null, "Are you ready to start the game?", "yesNo", JOptionPane.YES_NO_OPTION);
            if (yesNo == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Farewell!", "goodByeMessage", JOptionPane.PLAIN_MESSAGE);
                return;
            } else {
                createGUI();
            }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        totalButtonPresses++;
        thisUserButtonPresses++;
        if (JOptionPane.NO_OPTION == JOptionPane.showConfirmDialog(null, "Do you want to press the button again?", "yesNo", JOptionPane.YES_NO_OPTION)) {
            frame.dispose();
            //do more
            System.out.print(totalButtonPresses);
        } else {
            frame.setVisible(true);
        }
    }

    public static void createGUI() {
        totalButtonPresses = 0;
        totalPlayers = 0;

        frame = new JFrame("ButtonFrame");
        frame.setSize(200,100);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        JButton button = new JButton("Push Me");
        button.setActionCommand("push");
        frame.add(button, BorderLayout.CENTER);
        button.addActionListener(new ButtonServer());
        frame.setVisible(true);
    }
}
