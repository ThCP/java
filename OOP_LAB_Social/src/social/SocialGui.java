package social;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SocialGui extends JFrame {
	private static final long serialVersionUID = 1L;

	public JLabel l1 = new JLabel("ID:");
	public JTextField id = new JTextField("",10);
	public JButton login = new JButton("Login");
	public JLabel name = new JLabel("<user name>");
	public JList<String> friends = new JList<>();
	public JPanel upper = new JPanel();
	public JPanel lower= new JPanel();
	
	private Social myFacebook;
	
	public SocialGui(Social m){
				
				myFacebook = m;
		
				setTitle ("MyFacebook");
				
				upper.setLayout(new FlowLayout());
				upper.add(l1);
				upper.add(id);
				upper.add(login);
				
				
				
				lower.setLayout(new BorderLayout());
				lower.add(name, BorderLayout.NORTH);
				lower.add(friends, BorderLayout.CENTER);
				lower.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
				
				name.setHorizontalAlignment(JTextField.CENTER);
				name.setBorder(BorderFactory.createEmptyBorder(0,0,10,10));
				
				
				add(upper, BorderLayout.NORTH);
				add(lower, BorderLayout.CENTER);
				//add(friends, BorderLayout.SOUTH);
				
				login.addActionListener(a -> updateUserFriendsList());
				id.addKeyListener(new KeyListener(){
					
					@Override
					public void keyPressed(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyReleased(KeyEvent arg0) {
						if (arg0.getKeyCode() == KeyEvent.VK_ENTER){
							updateUserFriendsList();
						}
					}

					@Override
					public void keyTyped(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
					
				});
				
				setSize(400,400);
				setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				setVisible(true);
	}

	private void updateUserFriendsList() {
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		String userId = id.getText();
		try {
			String user = myFacebook.getPerson(userId);
			
			name.setText(user);
			
			for (String p : myFacebook.listOfFriends(userId)) {
				listModel.addElement(p);
			}
			friends.setModel(listModel);
			
		} catch (NoSuchCodeException e){
			name.setText("<user name>");
			JOptionPane.showMessageDialog(null, e.getMessage(), "Login Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
}
