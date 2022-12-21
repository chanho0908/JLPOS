
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class ImageGenerator {

    public void Generate() throws IOException {
        // 아래 getString 메서드에서 임의 문자열 가져오기
        String text = getString();

        // 생성된 문자열을 보여주는 이미지를 만들어 문자열을 복사/붙여넣는 기능을 방지.
        BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        Font font = new Font("Arial", Font.BOLD, 30);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(text);
        int height = fm.getHeight();
        g2d.dispose();

        img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = img.createGraphics();
        g2d.setFont(font);
        fm = g2d.getFontMetrics();
        g2d.setColor(Color.BLACK);
        g2d.drawString(text, 0, fm.getAscent());
        g2d.dispose();
        try {
            ImageIO.write(img, "png", new File("Text.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            popup(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // CHARS의 문자에서 임의 문자열을 생성.
    public String getString() {
        String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder str = new StringBuilder();
        Random rnd = new Random();
        while (str.length() < 6) {
            int index = (int) (rnd.nextFloat() * CHARS.length());
            str.append(CHARS.charAt(index));
        }
        String generatedCaptcha = str.toString();
        return generatedCaptcha;
    }

    public static void popup(String text) throws IOException {
        GUI graphicInterface = new GUI();
        graphicInterface.display(text);
    }
}
