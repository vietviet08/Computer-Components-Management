package controller;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatToVND {
	public static String vnd(double soTien) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		return currencyVN.format(soTien);
	}
}
