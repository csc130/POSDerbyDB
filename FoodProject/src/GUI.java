import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI implements ActionListener{
	private JFrame frame;
	private JPanel passPanel;
	private JPanel runPanel;
	private JPanel adminpanel;
	private JTextField userField, pass;
	private JButton enter;
	@SuppressWarnings("unused")
	private ActionListener enterLis;
	@SuppressWarnings("unused")
	private ActionEvent e;
	private User [] users;
	
	public static void main(String[] args) {
		new GUI();

	}
	public GUI()
	{
		User dilbert = new User("Dilbert","P@$$w0rd",true);
		User user = new User("user","P@$$w0rd",false);
		users = new User [2];
		users[0] = dilbert;
		users[1] = user;
		frame = new JFrame("Frame");
		passPanel = new JPanel();
		frame.setVisible(true);
		frame.setBackground(Color.BLUE);
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(passPanel);
		{
			passPanel.setSize(300,300);
			passPanel.add(new JLabel("Username: "));
			userField = new JTextField(17);
			passPanel.add(userField);
			passPanel.add(new JLabel("Password:"));
			pass = new JTextField(17);
			passPanel.add(pass);
			enter = new JButton("Enter");
			enter.addActionListener(this);
			passPanel.add(enter);
		}
		{
			runPanel = new JPanel();
			runPanel.setSize(300,150);
			runPanel.add(new JLabel("Welcome"));
		}
		{
			adminpanel = new JPanel();
		}
	}


	//class enterLis implements ActionListener
	public void actionPerformed(ActionEvent e) {
		enter.setText("pressed");
		for (int x=0; x < users.length;x++)
		{
		if (userField.getText().equals(users[x]))
				{
					if (users[x].getPassword().equals(pass.getText()))
					{
						frame.setSize(600, 600);
						if (users[x].isAdmin())
						{
							frame.add(adminpanel);
						}
						else
						{
							frame.add(runPanel);
						}
					}
				}
		}
	}
}


