package font;

import java.awt.Font;
import java.io.File;

public class SetFont {

//	public static Font font;
//	public static Font font_1;
//	public static Font font1;
//	public static Font font2;

	public static Font font() {
		Font f1 = null;
		try {
			File fontStyle = new File("src/font/Roboto-Medium.ttf");
			f1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(11f);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f1;
	}

	public static Font font1_() {
		Font f1 = null;
		try {
			File fontStyle = new File("src/font/Roboto-Medium.ttf");
			f1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(14f);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f1;

	}

	public static Font font1() {
		Font f1 = null;
		try {
			File fontStyle = new File("src/font/Roboto-Medium.ttf");
			f1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(16f);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f1;
	}

	public static Font font2() {
		Font f1 = null;
		try {
			File fontStyle = new File("src/font/Roboto-Medium.ttf");
			f1 = Font.createFont(Font.TRUETYPE_FONT, fontStyle).deriveFont(22f);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f1;
	}

	public static Font fontTitle() {
		Font f = null;
		try {
			File fontStyle1 = new File("src/font/Oswald-Medium.ttf");
			f = Font.createFont(Font.TRUETYPE_FONT, fontStyle1).deriveFont(18f);
		} catch (Exception e) {
			System.out.println(e);
		}
		return f;
	}
}
