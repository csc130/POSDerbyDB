import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.*;
public class SystemGUI{
	JFrame frame;
	JPanel screen, systemGrid, entry, sizepanel;
	static FoodItem [] appetizerOptions;
	static FoodItem [] entreeOptions;
	static FoodItem [] beverageOptions;
	static FoodItem [] dessertOptions;
	String [] sizes;
	@SuppressWarnings("rawtypes")
	static JComboBox sizechoice;
	Connection conn;
	JButton a1, a2, a3, a4, a5, a6, amore;
	JButton e1, e2, e3, e4, e5, e6, emore;
	JButton b1, b2, b3, b4, b5, b6, bmore;
	JButton d1, d2, d3, d4, d5, d6, dmore;
	JButton close, clear;
	int applength1, entlength1, bevlength1,deslength1 = 0;
	int applength, entlength, bevlength,deslength = 0;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SystemGUI(final Connection conn){
		
		GridLayout a = new GridLayout(2,2);
		frame = new JFrame("a");
		frame.setLayout(a);
		frame.setTitle("Food System");
		frame.setSize(1200,1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen = new JPanel();
		screen.setBackground(Color.WHITE);
		GridLayout q = new GridLayout(21,1);
		screen.setLayout(q);
		frame.add(screen);
		screen.revalidate();
		screen.repaint();
		
		systemGrid = new JPanel();
			systemGrid.setBackground(Color.CYAN);
			GridLayout b = new GridLayout(8,4);
			systemGrid.setLayout(b);
			

			systemGrid.add(new JLabel("Appetiezer:"));
			systemGrid.add(new JLabel("Entree:"));
			systemGrid.add(new JLabel("Beverage:"));
			systemGrid.add(new JLabel("Dessert:"));
			a1 = new JButton(appetizerOptions[applength1].getName());
			a2 = new JButton(appetizerOptions[applength1+1].getName());
			a3 = new JButton(appetizerOptions[applength1+2].getName());
			a4 = new JButton(appetizerOptions[applength1+3].getName());
			a5 = new JButton(appetizerOptions[applength1+4].getName());
			a6 = new JButton(appetizerOptions[applength1+5].getName());
			amore = new JButton("View More");
			amore.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
				if((appetizerOptions.length-(applength1+5))>6)
				{
					applength1 = applength1 + 6;
				}
				else
				{
					applength1 = appetizerOptions.length - 6;
				}
				a1.setText(appetizerOptions[applength1].getName());
				a2.setText(appetizerOptions[applength1+1].getName());
				a3.setText(appetizerOptions[applength1+2].getName());
				a4.setText(appetizerOptions[applength1+3].getName());
				a5.setText(appetizerOptions[applength1+4].getName());
				a6.setText(appetizerOptions[applength1+5].getName());
				systemGrid.revalidate();
				systemGrid.repaint();
				}
				});
			e1 = new JButton(entreeOptions[entlength1].getName());
			e2 = new JButton(entreeOptions[entlength1+1].getName());
			e3 = new JButton(entreeOptions[entlength1+2].getName());
			e4 = new JButton(entreeOptions[entlength1+3].getName());
			e5 = new JButton(entreeOptions[entlength1+4].getName());
			e6 = new JButton(entreeOptions[entlength1+5].getName());
			emore = new JButton("View More");
			emore.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
				if((entreeOptions.length-(entlength1+5))>6)
				{
					entlength1 = entlength1 + 6;
				}
				else
				{
					entlength1 = entreeOptions.length - 6;
				}
				e1.setText(entreeOptions[entlength1].getName());
				e2.setText(entreeOptions[entlength1+1].getName());
				e3.setText(entreeOptions[entlength1+2].getName());
				e4.setText(entreeOptions[entlength1+3].getName());
				e5.setText(entreeOptions[entlength1+4].getName());
				e6.setText(entreeOptions[entlength1+5].getName());
				systemGrid.revalidate();
				systemGrid.repaint();
				}
				});
			b1 = new JButton(beverageOptions[bevlength1].getName());
			b2 = new JButton(beverageOptions[bevlength1+1].getName());
			b3 = new JButton(beverageOptions[bevlength1+2].getName());
			b4 = new JButton(beverageOptions[bevlength1+3].getName());
			b5 = new JButton(beverageOptions[bevlength1+4].getName());
			b6 = new JButton(beverageOptions[bevlength1+5].getName());
			bmore = new JButton("View More");
			bmore.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
				if((beverageOptions.length-(bevlength1+5))>6)
				{
					bevlength1 = bevlength1 + 6;
				}
				else
				{
					bevlength1 = beverageOptions.length - 6;
				}
				b1.setText(beverageOptions[bevlength1].getName());
				b2.setText(beverageOptions[bevlength1+1].getName());
				b3.setText(beverageOptions[bevlength1+2].getName());
				b4.setText(beverageOptions[bevlength1+3].getName());
				b5.setText(beverageOptions[bevlength1+4].getName());
				b6.setText(beverageOptions[bevlength1+5].getName());
				systemGrid.revalidate();
				systemGrid.repaint();
				}
				});
			d1 = new JButton(dessertOptions[deslength1].getName());
			d2 = new JButton(dessertOptions[deslength1+1].getName());
			d3 = new JButton(dessertOptions[deslength1+2].getName());
			d4 = new JButton(dessertOptions[deslength1+3].getName());
			d5 = new JButton(dessertOptions[deslength1+4].getName());
			d6 = new JButton(dessertOptions[deslength1+5].getName());
			dmore = new JButton("View More");
			dmore.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if((dessertOptions.length-(deslength1+5))>6)
					{
					deslength1 = deslength1 + 6;
					}
					else
					{
						deslength1 = dessertOptions.length - 6;
					}
					d1.setText(dessertOptions[deslength1].getName());
					d2.setText(dessertOptions[deslength1+1].getName());
					d3.setText(dessertOptions[deslength1+2].getName());
					d4.setText(dessertOptions[deslength1+3].getName());
					d5.setText(dessertOptions[deslength1+4].getName());
					d6.setText(dessertOptions[deslength1+5].getName());
					systemGrid.revalidate();
					systemGrid.repaint();
				}
			});
			
			systemGrid.add(a1);
			a1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(appetizerOptions[applength1])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(e1);
			e1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(entreeOptions[entlength1])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(b1);
			b1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(beverageOptions[bevlength1])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(d1);
			d1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(dessertOptions[deslength1])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(a2);
			a2.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(appetizerOptions[applength1+1])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(e2);
			e2.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(entreeOptions[entlength1+1])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(b2);
			b2.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(beverageOptions[bevlength1+1])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(d2);
			d2.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(dessertOptions[deslength1+1])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(a3);
			a3.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(appetizerOptions[applength1+2])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(e3);
			e3.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(entreeOptions[entlength1+2])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(b3);
			b3.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(beverageOptions[bevlength1+2])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(d3);
			d3.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(dessertOptions[deslength1+2])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(a4);
			a4.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(appetizerOptions[applength1+3])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(e4);
			e4.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(entreeOptions[entlength1+3])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(b4);
			b4.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(beverageOptions[bevlength1+3])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(d4);
			d4.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(dessertOptions[deslength1+3])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(a5);
			a5.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(appetizerOptions[applength1+4])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(e5);
			e5.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(entreeOptions[entlength1+4])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(b5);
			b5.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(beverageOptions[bevlength1+4])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(d5);
			d5.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(dessertOptions[deslength1+4])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(a6);
			a6.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(appetizerOptions[applength1+5])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(e6);
			e6.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(entreeOptions[entlength1+5])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(b6);
			b6.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(beverageOptions[bevlength1+5])));
					screen.revalidate();
					screen.repaint();
				}
				
			});
			systemGrid.add(d6);
			d6.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					screen.add(new JLabel(reciptEntry(dessertOptions[deslength1+5])));
					screen.revalidate();
					screen.repaint();
					
				}
				
			});
			systemGrid.add(amore);
			systemGrid.add(emore);
			systemGrid.add(bmore);
			systemGrid.add(dmore);
		frame.add(systemGrid);
		//systemGrid.revalidate();
		//systemGrid.repaint();
		
		entry = new JPanel();
		entry.setBackground(Color.red);
		close = new JButton("Close");
		close.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.removeAll();
				frame.dispose();
				
			}
			
		});
		entry.add(close);
		clear = new JButton("Clear Recipt");
		clear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				screen.removeAll();
				screen.revalidate();
				screen.repaint();
				
			}
			
		});
		entry.add(clear);
		frame.add(entry);
		sizepanel = new JPanel();
		sizes = new String [] { "small", "medium", "large"};
		sizechoice = new JComboBox(sizes);
		sizepanel.add(new JLabel("Select Size : "));
		sizepanel.add(sizechoice);
		frame.add(sizepanel);
		
	}
	public static void getData(Connection conn){
		appetizerOptions = new FoodItem [6];
		int applength = 0;
		entreeOptions = new FoodItem [6];
		int entlength = 0;
		beverageOptions = new FoodItem [6];
		int bevlength = 0;
		dessertOptions = new FoodItem [6];
		int deslength = 0;
		FoodItem [] out = new FoodItem [10];
		out = DBSystem.readFromRecord(conn);
		for(int x = 0; x<out.length; x++)
		{
			if (out != null)
			{
				System.out.println(out[x].getCatagory());
				String type = out[x].getCatagory();
				if (type != null){
					
				
			if(type.equalsIgnoreCase("Appetizer"))
			{
				if(appetizerOptions.length == applength)
				{
					FoodItem [] temp = new FoodItem [appetizerOptions.length+1];
					for( int z = 0; z<appetizerOptions.length;z++){
						temp[z] = appetizerOptions[z];
					}
					appetizerOptions = temp;
				}
				appetizerOptions[applength] = out[x];
				applength++;
			}
			else if((out[x].getCatagory()).equalsIgnoreCase("Entree"))
			{
				if(entreeOptions.length == entlength)
				{
					FoodItem [] temp = new FoodItem [entreeOptions.length+1];
					for( int z = 0; z<entreeOptions.length;z++){
						temp[z] = entreeOptions[z];
					}
					entreeOptions = temp;
				}
				entreeOptions[entlength] = out[x];
				entlength++;
			}
			else if((out[x].getCatagory()).equalsIgnoreCase("Beverage"))
			{
				if(beverageOptions.length == bevlength)
				{
					FoodItem [] temp = new FoodItem [beverageOptions.length+1];
					for( int z = 0; z<beverageOptions.length;z++){
						temp[z] = beverageOptions[z];
					}
					beverageOptions = temp;
				}
				beverageOptions[bevlength] = out[x];
				bevlength++;
			}
			else if ((out[x].getCatagory()).equalsIgnoreCase("Dessert"))
			{
				if(dessertOptions.length == deslength)
				{
					FoodItem [] temp = new FoodItem [dessertOptions.length+1];
					for( int z = 0; z<dessertOptions.length;z++){
						temp[z] = dessertOptions[z];
					}
					dessertOptions = temp;
				}
				dessertOptions[deslength] = out[x];
				deslength++;
			}
		}
		}
		}
		//sort(appetizerOptions);
		//sort(entreeOptions);
		//sort(beverageOptions);
		//sort(dessertOptions);
	}
	public static void sort(FoodItem [] food )
	{
		for(int x=0; x<food.length-1;x++)
		{
			if( food[x].getName().compareTo(food[x+1].getName())<0)
			{
				swap(food[x], food[x+1]);
				if(x>2){
				x -= 2;}
				else if (x>1)
				{
					x -= 1;
				}
			}
		}
	}
	private static void swap(Object x, Object y) {
		Object temp = x;
		x = y;
		y = temp;
		
	}
	public static String reciptEntry(FoodItem food)
	{
		NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US); 
		String output = "";
		output += food.getName()+" : ";
		String size = (String) sizechoice.getSelectedItem();
		if (size.equals("small"))
		{
			output +=  n.format(food.getSmallPrice());
		}
		else if (size.equals("medium"))
		{
			output +=  n.format(food.getMedPrice());
		}
		else
		{
			output +=  n.format(food.getLargePrice());
		}
		return output;
	}
	public static void main(String[] args) {
		new SystemGUI(null);
	}

}

