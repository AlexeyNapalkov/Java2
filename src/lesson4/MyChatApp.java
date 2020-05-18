package lesson4;

import javax.swing.*;

public class MyChatApp {
    public static void main(String[] args) {

SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        JFrame chatWindow = new ChatWindow();
        chatWindow.setVisible(true);
    }
});
    }
}
