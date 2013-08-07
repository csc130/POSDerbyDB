import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.*;


public class AddGUI {
Connection conn;
JFrame frame;
JPanel screen, systemGrid, entry;
JButton add, close;
JTextField name, catagory, smallprice, medprice, largeprice;
String inName, inCatagory;
double inSmallPrice, inMedPrice, inLargePrice;
FoodItem returning;
	public AddGUI(final Connection conn)
	{
		GridLayout a = new GridLayout(2,1);
		frame = new JFrame("a");
		frame.setLayout(a);
		frame.setTitle("Food Add System");
		frame.setSize(1100, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		screen = new JPanel();
		screen.setBackground(Color.WHITE);
		screen.add(new JLabel("Name :"));
		name = new JTextField(12);
		screen.add(name);
		screen.add(new JLabel("Catagory :"));
		catagory = new JTextField(12);
		screen.add(catagory);
		screen.add(new JLabel("Small Price :$"));
		smallprice = new JTextField(12);
		screen.add(smallprice);
		screen.add(new JLabel("Medium Price :$"));
		medprice = new JTextField(12);
		screen.add(medprice);
		screen.add(new JLabel("Large Price :$"));
		largeprice = new JTextField(12);
		screen.add(largeprice);
		frame.add(screen);
		entry = new JPanel();
		entry.setBackground(Color.CYAN);
		add = new JButton("add");
		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				inName = name.getText();
				inCatagory = catagory.getText();
				inSmallPrice = (Double.parseDouble(smallprice.getText()));
				inMedPrice = (Double.parseDouble(medprice.getText()));
				inLargePrice = (Double.parseDouble(largeprice.getText()));
				returning = new FoodItem(inName, inCatagory, inSmallPrice, inMedPrice, inLargePrice);
				DBSystem.createRecord(conn, returning);
			}	
		});
		entry.add(add);
		close = new JButton("Close");
		close.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.removeAll();
				frame.dispose();
				
			}
			
		});
		entry.add(close);
		frame.add(entry);
		entry.revalidate();
		entry.repaint();
		
	
	}
	public static void main (String [] args){
		new AddGUI(null);
		
	}
}
