package notepad;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Font1 {

	private JFrame frame;
	static JList list;
	static JList list1;
    static int i;
    private JTextField textx;
	/**
	 * Launch the application.
	 */
	public static void font1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Font1 window = new Font1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Font1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 487, 297);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		DefaultListModel<String> l1=new DefaultListModel();
		l1.addElement("RED");
		l1.addElement("BLACK");
		l1.addElement("BLUE");                              
		l1.addElement("GREEN");
		l1.addElement("YELLOW");
		JList<String> list = new JList<>(l1);
		list.setFont(new Font("Tahoma", Font.BOLD, 19));
		list.setBounds(12, 75, 149, 165);
		frame.getContentPane().add(list);
		
		
		//list2 of size
		DefaultListModel<String> l2=new DefaultListModel<>();
		l2.addElement("8");
		l2.addElement("12");
		l2.addElement("14");
		l2.addElement("16");
		l2.addElement("20");
		l2.addElement("24");
		l2.addElement("28");
		l2.addElement("32");
		JList<String> list1 = new JList<>(l2);
		list1.setBounds(173, 75, 147, 130);
		frame.getContentPane().add(list1);
		
		
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 i=list.getSelectedIndex();
				//System.out.println(i);
				if(i==0)
				{
					Notepad1.textArea.setForeground(Color.RED);
				}
				else
				if(i==1)
				{
					Notepad1.textArea.setForeground(Color.BLACK);
				}
				else
					if(i==2)
					{
						Notepad1.textArea.setForeground(Color.BLUE);
					}
					else
						if(i==3)
						{
							Notepad1.textArea.setForeground(Color.GREEN);
						}
						else
							if(i==4)
							{
								Notepad1.textArea.setForeground(Color.YELLOW);
							}
				if(list1.getSelectedIndex()!=-1)
				{
				String local=list1.getSelectedValue();
				int x=size(local);
				Notepad1.textArea.setFont(new Font("Tahoma", Font.PLAIN, x));
				}
				
				
				//textfield size
				try
				{
					int k=Integer.parseInt(textx.getText());
					Notepad1.textArea.setFont(new Font("Tahoma", Font.PLAIN, k));
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"enter valid value in tect field");
				}
				frame.dispose();
			}
		});
		btnApply.setBounds(332, 175, 125, 65);
		frame.getContentPane().add(btnApply);
		
		JLabel lblSlectColor = new JLabel("Select");
		lblSlectColor.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblSlectColor.setBounds(23, -16, 125, 72);
		frame.getContentPane().add(lblSlectColor);
		
		JLabel lblColor = new JLabel("COLOR");
		lblColor.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblColor.setBounds(22, 13, 136, 72);
		frame.getContentPane().add(lblColor);
		
		JLabel label = new JLabel("Select");
		label.setFont(new Font("Tahoma", Font.BOLD, 27));
		label.setBounds(176, -16, 125, 72);
		frame.getContentPane().add(label);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblSize.setBounds(176, 13, 125, 72);
		frame.getContentPane().add(lblSize);
		
		textx = new JTextField();
		textx.setText("Or enter manually");
		textx.setBounds(173, 215, 147, 22);
		frame.getContentPane().add(textx);
		textx.setColumns(10);
		
		
	
	}
	public static int size(String local)
	{
		return Integer.parseInt(local);
		
	}
}
