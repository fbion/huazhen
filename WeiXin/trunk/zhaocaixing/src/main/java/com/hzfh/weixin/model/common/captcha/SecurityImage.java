package com.hzfh.weixin.model.common.captcha;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Created by paul on 15-3-11.
 */


public class SecurityImage {
    /**
     * 生成验证码图片
     *
     * @param securityCode 验证码字符
     * @return BufferedImage  图片
     */
    public static BufferedImage createImage(String securityCode) {
//验证码长度
        int codeLength = securityCode.length();
//字体大小
        int fSize = 15;
        int fWidth = fSize + 1;
        //图片宽度
        int width = codeLength * fWidth + 6;
        //图片高度
        int height = fSize * 2 - 5;

        //图片
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.createGraphics();

        //设置背景色
        g.setColor(Color.WHITE);
        //填充背景,用白色填充
        g.fillRect(0, 0, width, height);

        //设置边框颜色
        g.setColor(Color.LIGHT_GRAY);
        //边框字体样式
        g.setFont(new Font("Arial", Font.BOLD, height - 2));//Arial
        //绘制边框
        g.drawRect(0, 0, width - 1, height - 1);


        //绘制噪点
        Random rand = new Random();
        //设置噪点颜色
        //g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < codeLength * 7; i++) {
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);
            g.setColor(new Color(rand.nextInt(255),
                    rand.nextInt(255), rand.nextInt(255)));
            //绘制1*1大小的矩形
            g.drawRect(x, y, 1, 1);
            //g.setColor(Color.LIGHT_GRAY);
        }

        /*Random rand = new Random();
        g.setColor(Color.BLACK);         
        for (int i = 0; i < 10; i++) {         
            int x = rand.nextInt(width);         
            int y = rand.nextInt(height);         
            int xl = rand.nextInt(12);         
            int yl = rand.nextInt(12);         
            g.drawLine(x, y, x + xl, y + yl);         
        }  */
        //绘制验证码
        int codeY = height - 6;
        //设置字体颜色和样式
        //g.setColor(new Color(19,148,246));
        g.setFont(new Font("宋体", Font.BOLD, fSize + 10));
        for (int i = 0; i < codeLength; i++) {
            g.setColor(new Color(rand.nextInt(255),
                    0, rand.nextInt(255)));
        	 /*g.setColor(new Color(255,
                     0, 255));*/
            g.drawString(String.valueOf(securityCode.charAt(i)),
                    i * 16 + 5, codeY);

        }
        //关闭资源
        g.dispose();

        return image;
    }

    /**
     * 返回验证码图片的流格式
     *
     * @param securityCode 验证码
     * @return ByteArrayInputStream 图片流
     */
    public static ByteArrayInputStream getImageAsInputStream(String securityCode) {
        BufferedImage image = createImage(securityCode);
        return convertImageToStream(image);
    }

    /**
     * 将BufferedImage转换成ByteArrayInputStream
     *
     * @param image 图片
     * @return ByteArrayInputStream 流
     */
    private static ByteArrayInputStream convertImageToStream(BufferedImage image) {
        ByteArrayInputStream inputStream = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] bImage = null;
        try {
            ImageIO.write(image, "jpeg", bos);
//            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
//            encoder.encode(image);

            bImage = bos.toByteArray();
            inputStream = new ByteArrayInputStream(bImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回输入流
        return inputStream;
    }
}
