import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class LoginFrame extends JFrame implements ActionListener {

    Container container=getContentPane();
    JLabel passwordLabel=new JLabel("PASSWORD");
    JPasswordField passwordField=new JPasswordField();
    JButton loginButton=new JButton("LOGIN");
    JButton resetButton=new JButton("RESET");
    JCheckBox showPassword=new JCheckBox("Show Password");
    public static HashSet<String> passwords = new HashSet<>();


    LoginFrame()
    {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();//calling addActionEvent() method
    }
    public void setLayoutManager()
    {
        container.setLayout(null);
    }
    public void setLocationAndSize()
    {
        passwordLabel.setBounds(50,220,100,30);
        passwordField.setBounds(150,220,150,30);
        showPassword.setBounds(150,250,150,30);
        loginButton.setBounds(50,300,100,30);
        resetButton.setBounds(200,300,100,30);


    }
    public void addComponentsToContainer()
    {
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }
    public void addActionEvent()
    {
        //adding Action listener to components
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String pwdText;
            pwdText = passwordField.getText();
            if(LoginFrame.passwords.contains(pwdText)){
                JOptionPane.showMessageDialog(this, "Password found !!");
            }
            else{
                JOptionPane.showMessageDialog(this, "Password not found !!");
            }

        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            passwordField.setText("");
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }
    public static void readPasswords(String filename){
        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                LoginFrame.passwords.add(sCurrentLine);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LoginFrame frame=new LoginFrame();
        LoginFrame.readPasswords("rockyou.txt");
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(10,10,370,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
