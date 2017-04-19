package com.games.world.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * 二维码工具类
 * 
 */
public class QRCodeUtil {

	
	public static void insertQrcodeToBg(BufferedImage source, InputStream qrinstream, int x, int y, int width,int height, boolean needCompress) throws Exception {
		Image src = ImageIO.read(qrinstream);
		if (needCompress) { // 压缩LOGO
			Image image = src.getScaledInstance(width, height,
					Image.SCALE_SMOOTH);
			BufferedImage tag = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			src = image;
		}
		// 插入LOGO
		Graphics2D graph = source.createGraphics();
		graph.drawImage(src, x, y, width, height, null);
		Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
		graph.setStroke(new BasicStroke(3f));
		graph.draw(shape);
		graph.dispose();
	}
	
	@SuppressWarnings("unused")
	public static void insertFontToBg(BufferedImage source,String text, int x, int y, int width,int height, boolean needCompress) throws Exception {
		Graphics2D graph = source.createGraphics();
		graph.fillRect(0, 0, width, height);
		Font font = new Font("STZHONGS", Font.PLAIN, 72);
		graph.setFont(font);
		graph.setColor(Color.BLACK);
		FontMetrics fm = graph.getFontMetrics(font);
        java.awt.geom.Rectangle2D rect = fm.getStringBounds(text, graph);
        int textWidth = (int) (rect.getWidth());
        int textHeight = (int) (rect.getHeight());
        graph.drawString(text, x, y);
        graph.dispose();
	}


	
	public static void main(String[] args) throws Exception {
//		String text = "http://www.y1da.com/oauth?p=mypg";
//		QiNiuUtils.uploadPublic(buf2byte(QRCodeUtil.encode(text, "E:/projects/eht-y1da/eht-y1da-wechat/src/main/resources/logo.jpg", true)), false);
//		QRCodeUtil.encode(text, "E:/projects/eht-y1da/eht-y1da-wechat/src/main/resources/logo.jpg", true);
	}
}
