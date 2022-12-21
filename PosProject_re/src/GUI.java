import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JButton;
public class GUI {
        

    public static void display(String captcha) throws IOException {

        // GUI components declarations
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(181,195,206));
 
        JLabel lblCaptcha = new JLabel("Please Enter Captcha ", JLabel.CENTER);
        //lblCaptcha.setForeground(new Color(242,242,242));
        lblCaptcha.setFont(new Font("Tahoma", Font.BOLD , 17));
        
        JTextField enterCaptcha = new JTextField(13);
        enterCaptcha.setFont(new Font("맑은 고딕", Font.BOLD , 15));
        BufferedImage image = ImageIO.read(new File("./Text.png"));
        JLabel loadedImage = new JLabel(new ImageIcon(image));
        
        JButton btnBack = new JButton("BACK");
        btnBack.setPreferredSize(new Dimension(80, 30));
        btnBack.setBackground(new Color(108,122,137));
        btnBack.setForeground(new Color(228,241,254));
        btnBack.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        btnBack.addActionListener(e ->{
            frame.dispose();
            new LoginForm().setVisible(true);
        });

        JButton btnEnter = new JButton("ENTER");
        btnEnter.setPreferredSize(new Dimension(80, 30));
        btnEnter.setBackground(new Color(108,122,137));
        btnEnter.setForeground(new Color(228,241,254));
        btnEnter.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        btnEnter.addActionListener(e ->{
            String givenCaptcha = enterCaptcha.getText();

            if(captcha.equals(givenCaptcha)){
                frame.dispose();
                RegisterForm rgf = new RegisterForm();
                rgf.setSize(420, 510);
                rgf.setVisible(true);
                rgf.setLocationRelativeTo(null);
                rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }else{
                JOptionPane.showMessageDialog(null,"자동 가입 방지 문자가 다릅니다!");
                return;
            }
        });
       
        // Adding GUI components to panel
        panel.add(lblCaptcha);
        panel.add(loadedImage);
        panel.add(enterCaptcha);
        panel.add(btnBack);
        panel.add(btnEnter);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(270,200);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

    }
}
