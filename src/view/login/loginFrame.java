package view.login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class loginFrame extends JFrame implements ActionListener {


    loginPanel loginPanel;

    public loginFrame(){


    loginPanel = new loginPanel();

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //this.setLayout(new FlowLayout());
    this.add(loginPanel);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
