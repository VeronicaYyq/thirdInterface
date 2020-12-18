
 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

 
import javax.imageio.ImageIO;


/**
 * 网上看到的一个验证码的一个demo，
 */
public class games {
 
    //!!!!!!!!!
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //构造BufferedImage图像对象
        //宽像素，高像素，色彩空间类型
 
        BufferedImage image=new BufferedImage(80, 32, BufferedImage.TYPE_BYTE_BINARY);
 
        //编辑图像
        //获取绘图对象
        Graphics g=image.getGraphics();
 
        //设置字体颜色
        g.setColor(Color.white);
 
        //设置字体
        g.setFont(new Font("SimSong",Font.ITALIC,20));
 
        //绘制字符串；
        String text="";
        for(int i=0;i<4;i++) {
            //*10不是乘十，而是确定随机数的范围。从0开始。
            text +=(int) (Math.random()*10);
        }
 
        //字符串输出内容，水平起始坐标，垂直起始坐标。
        g.drawString(text, 17, 24);
 
        //输出图像
        ImageIO.write(image, "png", new FileOutputStream("/Users/yuanyanqiu/Desktop/game.png"));
        System.out.println("生成成功");
    }
 
}