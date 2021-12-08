package view.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import view.user.managerPanel;



public class loginFrame extends JFrame implements ActionListener {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	loginPanel loginPanel;
	managerPanel managerPanel;

    public loginFrame(){

    	
    loginPanel = new loginPanel();
    managerPanel = new managerPanel();

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //this.setLayout(new FlowLayout());
    this.add(managerPanel);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
