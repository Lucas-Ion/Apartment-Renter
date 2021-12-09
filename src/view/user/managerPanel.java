package view.user;

import controller.managerController;
import controller.propertyController;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class managerPanel extends JPanel implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton getProperty;
    JButton getLandlord;
    JButton getReport;
    JTable table;
    final int PANEL_WIDTH = 700;
    final int PANEL_HEIGHT = 500;

    //    private ArrayList<ArrayList<String>> data;
    private String[][] data;
    private String[] column;

    public managerPanel() {
        propertyController propertyController = new propertyController();
        String[][] dataInput = propertyController.findProperties("Apartment", "2", "3", "true", "NE");
        String[] columnInput = { "Prop Type", "Num Bed", "Num bath", "Furnished", "Quadrant" };
        this.data = dataInput;
        this.column = columnInput;

        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setLayout(new FlowLayout());
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());

        table = new JTable(data, column);
        getProperty = new JButton("List of properties");
        getLandlord = new JButton("List of landlords");
        getReport = new JButton("Printout report");
        table.setBounds(30, 40, 200, 300);

        this.add(getProperty);
        this.add(getLandlord);
        this.add(getReport);
        container.add(table.getTableHeader(), BorderLayout.PAGE_START);
        container.add(table, BorderLayout.CENTER);
        this.add(container);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == getProperty){

        }

    }

}
