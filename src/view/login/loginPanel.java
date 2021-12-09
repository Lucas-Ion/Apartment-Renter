package view.login;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.*;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class loginPanel extends JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int PANEL_WIDTH = 700;
    final int PANEL_HEIGHT = 500;

    Image backgroundImage;
    JButton button;
    JTextField username;
    JTextField password;


    loginPanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.decode("#d387ff"));;
        
        // set flow layout for the frame
        this.setLayout(new FlowLayout());
       button = new JButton("Login");
       button.addActionListener(this);
       username = new JTextField();
       username.setPreferredSize(new Dimension(250,40));
        password = new JTextField();
        password.setPreferredSize(new Dimension(250,40));
        username.setForeground(Color.blue);
        password.setForeground(Color.blue);
        username.setBackground(Color.WHITE);
        password.setBackground(Color.WHITE);
        username.setText("Please enter your username");
        password.setText("Please enter your password");


        this.add(username);
        this.add(password);
        this.add(button);

        //backgroundImage = new ImageIcon("/Users/lucasion/Desktop/ENSF480/FinalProject/src/blue.jpg").getImage();

        this.setVisible(true);

    }


    public void paint(Graphics g){
        super.paint(g);

        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(backgroundImage, 0, 0 , null);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
        String user = username.getText();
        String pass = password.getText();
            System.out.println(user);
            System.out.println(pass);

            //if user exists in database -> get the password
            //if pass == password from the database
            //move to the next JPANEL in cardlayout
            //if not display error message and do nothing


        }

    }
}
