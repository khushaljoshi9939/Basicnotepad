package notepad;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.Action;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import java.awt.Scrollbar;
import java.awt.ScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSplitPane;

public class Notepad1 {
	public static JTextArea  textArea;
	private JFrame frame;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	public static JLabel label;
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notepad1 window = new Notepad1();
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
	public Notepad1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(100, 100, d.width, d.height);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
	JScrollPane scrollpane=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scrollpane);
		
		textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String s=textArea.getText();
				String s1[]=s.split(" ");
				
				for(String x:s1)
				{
				if(x.equals("khushal"))
				{
					textArea.setForeground(Color.RED);
				}
				else label.setText(" ");
				}
				label.setText("Total words are "+s1.length );
			}
		});
	
		
		
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 27));
		textArea.setBounds(0, 35, 1260, 604);
		//frame.getContentPane().add(textArea);
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(135, 206, 250));
		menuBar.setBounds(0, 0, 1260, 38);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setBackground(new Color(0, 255, 255));
		mnNewMenu.setFont(new Font("Calibri", Font.BOLD, 23));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmOpen = new JMenuItem("open");
		mntmOpen.setAction(action_1);
		mnNewMenu.add(mntmOpen);
		
		JMenuItem mntmSaveAs = new JMenuItem("save as");
		mntmSaveAs.setAction(action);
		mnNewMenu.add(mntmSaveAs);
		
		JMenu mnView = new JMenu("view");
		mnView.setForeground(Color.BLACK);
		mnView.setFont(new Font("Calibri", Font.BOLD, 23));
		menuBar.add(mnView);
		
		JMenuItem mntmCharactercount = new JMenuItem("CharacterCount");
		mntmCharactercount.setAction(action_3);
		mnView.add(mntmCharactercount);
		
		JMenuItem mntmWordcount = new JMenuItem("WordCount");
		mntmWordcount.setAction(action_2);
		mnView.add(mntmWordcount);
		
		JMenuItem mntmFontcolor = new JMenuItem("FontCustomize");
		mntmFontcolor.setAction(action_4);
		mnView.add(mntmFontcolor);
		
		label = new JLabel("");
		label.setBackground(new Color(255, 235, 205));
		label.setFont(new Font("Tahoma", Font.BOLD, 22));
		label.setBounds(0, 642, 1260, 55);
		frame.getContentPane().add(label);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Save as");
			putValue(SHORT_DESCRIPTION, "It will save the file");
		}
		public void actionPerformed(ActionEvent e) {
			String s=textArea.getText();
			String name=JOptionPane.showInputDialog(" enter file name such as ex.txt");
			try {
				Saveas.saveas1(s, name);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Open");
			putValue(SHORT_DESCRIPTION, "Open new file");
		}
		public void actionPerformed(ActionEvent e) {
			String o=JOptionPane.showInputDialog("enter .txt file with extension");
			try {
				Open1.open11(o);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "WordCount");
			putValue(SHORT_DESCRIPTION, "count the words\n and display on bottom of window");
		}
		public void actionPerformed(ActionEvent e) {
		String s=textArea.getText();
		String s1[]=s.split(" ");
        label.setText(" Word count is "+Integer.toString(s1.length));		
		
		
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "CharCount");
			putValue(SHORT_DESCRIPTION, "count the character\n and display on bottom of window");
		}
		public void actionPerformed(ActionEvent e) {
			String s=textArea.getText();
			String s1[]=s.split(" ");
	       
			int count=0;
			for(String x:s1)
			{
			count= count+(x.length());	
			}
			label.setText("Character count is "+Integer.toString(count));
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Font color");
			putValue(SHORT_DESCRIPTION, "Font customization");
		}
		public void actionPerformed(ActionEvent e) {
			Font1.font1();
			
		}
	}
}
