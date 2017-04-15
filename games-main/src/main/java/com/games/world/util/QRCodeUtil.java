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
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.games.world.Constants;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 二维码工具类
 * 
 */
public class QRCodeUtil {

	private static BufferedImage createImage(String content, InputStream logoin,
			boolean needCompress) throws Exception {
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, Constants.QRCODE_CHARSET);
		hints.put(EncodeHintType.MARGIN, 1);
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
				BarcodeFormat.QR_CODE, Constants.QRCODE_SIZE, Constants.QRCODE_SIZE, hints);
		int width = bitMatrix.getWidth();
		int height = bitMatrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000
						: 0xFFFFFFFF);
			}
		}
		// 插入图片
		QRCodeUtil.insertImage(image, logoin, needCompress);
		return image;
	}
	/**
	 * 插入LOGO
	 * 
	 * @param source
	 *            二维码图片
	 * @param imgPath
	 *            LOGO图片地址
	 * @param needCompress
	 *            是否压缩
	 * @throws Exception
	 */
	public static void insertImage(BufferedImage source, InputStream qrinstream,
			boolean needCompress) throws Exception {
//		if (!file.exists()) {
//			System.err.println(""+imgPath+"   该文件不存在！");
//			return;
//		}
		Image src = ImageIO.read(qrinstream);
		int width = src.getWidth(null);
		int height = src.getHeight(null);
		if (needCompress) { // 压缩LOGO
			if (width > Constants.QRCODE_LOGO_WIDTH) {
				width = Constants.QRCODE_LOGO_WIDTH;
			}
			if (height > Constants.QRCODE_LOGO_HEIGHT) {
				height = Constants.QRCODE_LOGO_HEIGHT;
			}
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
		int x = (Constants.QRCODE_SIZE - width) / 2;
		int y = (Constants.QRCODE_SIZE - height) / 2;
		graph.drawImage(src, x, y, width, height, null);
		Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
		graph.setStroke(new BasicStroke(3f));
		graph.draw(shape);
		graph.dispose();
	}
	
	
	public static void insertQrcodeToBg(BufferedImage source, InputStream qrinstream, int x, int y, int width,int height, boolean needCompress) throws Exception {
		Image src = ImageIO.read(qrinstream);
//		int width = src.getWidth(null);
//		int height = src.getHeight(null);
		if (needCompress) { // 压缩LOGO
//			if (width > Constants.QRCODE_HD_WIDTH) {
//				width = Constants.QRCODE_HD_WIDTH;
//			}
//			if (height > Constants.QRCODE_HD_HEIGHT) {
//				height = Constants.QRCODE_HD_HEIGHT;
//			}
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
//		Image src = ImageIO.read(qrinstream);
//		int width = src.getWidth(null);
//		int height = src.getHeight(null);
//		if (needCompress) { // 压缩LOGO
////			if (width > Constants.QRCODE_HD_WIDTH) {
////				width = Constants.QRCODE_HD_WIDTH;
////			}
////			if (height > Constants.QRCODE_HD_HEIGHT) {
////				height = Constants.QRCODE_HD_HEIGHT;
////			}
//			Image image = src.getScaledInstance(width, height,
//					Image.SCALE_SMOOTH);
//			BufferedImage tag = new BufferedImage(width, height,
//					BufferedImage.TYPE_INT_RGB);
//			Graphics g = tag.getGraphics();
//			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
//			g.dispose();
//			src = image;
//		}
		// 插入LOGO
		Graphics2D graph = source.createGraphics();
//		graph.drawImage(src, x, y, width, height, null);
//		Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
//		graph.setStroke(new BasicStroke(3f));
//		graph.draw(shape);
//		graph.dispose();
		graph.fillRect(0, 0, width, height);
		Font font = new Font("STZHONGS", Font.PLAIN, 72);
		graph.setFont(font);
		graph.setColor(Color.BLACK);
		
		FontMetrics fm = graph.getFontMetrics(font);
        java.awt.geom.Rectangle2D rect = fm.getStringBounds(text, graph);
        int textWidth = (int) (rect.getWidth());
        int textHeight = (int) (rect.getHeight());

//        int x = (width - textWidth) / 2;
//        int y = (height - textHeight) / 2 + fm.getAscent();

        graph.drawString(text, x, y);
        graph.dispose();
	}

	/**
	 * 生成二维码(内嵌LOGO)
	 * 
	 * @param content
	 *            内容
	 * @param imgPath
	 *            LOGO地址
	 * @param destPath
	 *            存放目录
	 * @param needCompress
	 *            是否压缩LOGO
	 * @throws Exception
	 */
	public static BufferedImage encode(String content, InputStream in, 
			boolean needCompress) throws Exception {
		return QRCodeUtil.createImage(content, in, needCompress);
	}

	/**
	 * 生成二维码(内嵌LOGO)
	 * 
	 * @param content
	 *            内容
	 * @param imgPath
	 *            LOGO地址
	 * @param destPath
	 *            存储地址
	 * @throws Exception
	 */
	public static BufferedImage encode(String content, InputStream in)
			throws Exception {
		return QRCodeUtil.encode(content, in, false);
	}

	/**
	 * 生成二维码
	 * 
	 * @param content
	 *            内容
	 * @param destPath
	 *            存储地址
	 * @param needCompress
	 *            是否压缩LOGO
	 * @throws Exception
	 */
	public static BufferedImage encode(String content, boolean needCompress) throws Exception {
		return QRCodeUtil.encode(content, null, needCompress);
	}

	/**
	 * 生成二维码
	 * 
	 * @param content
	 *            内容
	 * @param destPath
	 *            存储地址
	 * @throws Exception
	 */
	public static BufferedImage encode(String content) throws Exception {
		return QRCodeUtil.encode(content, null, false);
	}


	/**
	 * BufferedImage转换至byte[]格式
	 * @param bufImg 
	 * @return
	 * @throws Exception
	 */
	public static byte[] buf2byte(BufferedImage bufImg) throws Exception
	{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(bufImg, Constants.QRCODE_FORMAT_NAME, out);
        byte[] b = out.toByteArray();
        out.close();
        return b;
	}
	
	public static void main(String[] args) throws Exception {
//		String text = "http://www.y1da.com/oauth?p=mypg";
//		QiNiuUtils.uploadPublic(buf2byte(QRCodeUtil.encode(text, "E:/projects/eht-y1da/eht-y1da-wechat/src/main/resources/logo.jpg", true)), false);
//		QRCodeUtil.encode(text, "E:/projects/eht-y1da/eht-y1da-wechat/src/main/resources/logo.jpg", true);
	}
}
