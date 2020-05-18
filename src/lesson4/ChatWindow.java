package lesson4;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ChatWindow extends JFrame {
    private JPanel rootPanel;
    private JPanel usrPanel;
    private JTextArea usrMsg;
    private JButton btnSend;
    private JTextArea flowChat;

    public ChatWindow() {
        setTitle("My Chat");
        setSize(300, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(rootPanel);

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usrMsg.append("\n");
                sendMsg();
            }
        });
        usrMsg.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    sendMsg();
            }
        });
    }

    private void sendMsg() {
        if (usrMsg.getText() != "\n") {
            flowChat.append(usrMsg.getText());
        }
        usrMsg.setText("");
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout(0, 0));
        usrPanel = new JPanel();
        usrPanel.setLayout(new BorderLayout(0, 0));
        rootPanel.add(usrPanel, BorderLayout.SOUTH);
        usrPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        usrMsg = new JTextArea();
        usrMsg.setForeground(new Color(-7292031));
        usrMsg.setLineWrap(true);
        usrMsg.setRows(1);
        usrMsg.setWrapStyleWord(true);
        usrPanel.add(usrMsg, BorderLayout.CENTER);
        btnSend = new JButton();
        btnSend.setText("Send");
        usrPanel.add(btnSend, BorderLayout.EAST);
        flowChat = new JTextArea();
        flowChat.setLineWrap(true);
        flowChat.setWrapStyleWord(true);
        rootPanel.add(flowChat, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }

}