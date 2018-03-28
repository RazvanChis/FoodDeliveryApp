import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import view.LoginView;
import view.RegisterView;

public class Main {

	public static void main(String[] args) {
		
		final JFrame parentFrame = new JFrame("Food Delivery");
		final JButton loginButton = new JButton("Login");
		final JButton registerButton = new JButton("Register");

		parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		parentFrame.setSize(300, 200);
		parentFrame.setLayout(new FlowLayout());
		parentFrame.getContentPane().add(loginButton);
		parentFrame.getContentPane().add(registerButton);
		parentFrame.setVisible(true);

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView loginView = new LoginView(parentFrame);
				loginView.setVisible(true);
			}
		});
		registerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			RegisterView registerView = new RegisterView(parentFrame);
			registerView.setVisible(true);
			}
		});
	}
}
