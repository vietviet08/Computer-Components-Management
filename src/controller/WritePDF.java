
package controller;

import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.itextpdf.layout.borders.Border;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;

import color.SetColor;
import dao.AccountDAO;
import dao.ChiTietPhieuNhapDAO;
import dao.NhaPhanPhoiDAO;
import dao.PhieuNhapDAO;
import dao.PhieuXuatDAO;
import font.SetFont;
import model.ChiTietPhieu;
import model.PhieuNhap;
import model.PhieuXuat;
import view.LoginForm;

public class WritePDF {

	DecimalFormat formatter = new DecimalFormat("###,###,###");
	SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyy hh:mm:ss aaa");
	Document document = new Document();
	FileOutputStream file;
	JFrame jf = new JFrame();
	FileDialog fd = new FileDialog(jf, "Xuất pdf", FileDialog.SAVE);
	Font fontData;
	Font fontTitle;
	Font fontHeader;

	public WritePDF() {
//		try {
//			fontData = new Font(
//					BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11,
//					Font.NORMAL);
//			fontTitle = new Font(
//					BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25,
//					Font.NORMAL);
//			fontHeader = new Font(
//					BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11,
//					Font.NORMAL);
//		} catch (DocumentException | FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException ex) {
//			Logger.getLogger(WritePDF.class.getName()).log(Level.SEVERE, null, ex);
//		}
	}

	public void chooseURL(String url) {
		try {
			document.close();
			document = new Document();
			file = new FileOutputStream(url);
			PdfWriter writer = PdfWriter.getInstance(document, file);
			document.open();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Khong tim thay duong dan file " + url);
		} catch (DocumentException ex) {
			JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
		}
	}

	public void setTitle(String title) {
		try {
			Paragraph pdfTitle = new Paragraph(new Phrase(title, fontTitle));
			pdfTitle.setAlignment(Element.ALIGN_CENTER);
			document.add(pdfTitle);
			document.add(Chunk.NEWLINE);
		} catch (DocumentException ex) {
			ex.printStackTrace();
		}
	}

	private String getFile(String name) {
		fd.pack();
		fd.setSize(800, 600);
		fd.validate();
		Rectangle rect = jf.getContentPane().getBounds();
		double width = fd.getBounds().getWidth();
		double height = fd.getBounds().getHeight();
		double x = rect.getCenterX() - (width / 2);
		double y = rect.getCenterY() - (height / 2);
		Point leftCorner = new Point();
		leftCorner.setLocation(x, y);
		fd.setLocation(leftCorner);
		fd.setFile(name + ".pdf");
		fd.setVisible(true);
		String url = fd.getDirectory() + fd.getFile();
		if (url.equals("null")) {
			return null;
		}
		return url;
	}

	public void writePhieuNhap(String mapn) {
		String url = "";
		try {
			fd.setTitle("In phiếu nhập");
			fd.setLocationRelativeTo(null);
			url = getFile(mapn);
			if (url == null) {
				return;
			}
			file = new FileOutputStream(url);
			document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();

			PdfPTable firstLine = new PdfPTable(2);
			firstLine.setWidths(new float[] { 60, 90 });
			firstLine.setWidthPercentage(100);

			PdfPCell cellTime = new PdfPCell(new Phrase(formatDate.format(new Date()), SetFont.fontTNR()));
			cellTime.setHorizontalAlignment(Element.ALIGN_LEFT);
			cellTime.setBorder(0);

			PdfPCell cellCopyright = new PdfPCell(
					new Phrase("© Copyright 2023 - NGUYỄN QUỐC VIỆT - 23CE.B029", SetFont.fontTNR()));
			cellCopyright.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cellCopyright.setBorder(0);

			firstLine.addCell(cellTime);
			firstLine.addCell(cellCopyright);

			document.add(firstLine);

			new Chunk(new VerticalPositionMark());
			document.add(Chunk.NEWLINE);

			Paragraph title = new Paragraph(new Phrase("PHIẾU NHẬP HÀNG", SetFont.fontTNRBoldTitle()));
			title.setAlignment(Element.ALIGN_CENTER);
			document.add(title);

			PhieuNhap pn = PhieuNhapDAO.getInstance().selectById(mapn);
			Paragraph idPhieu = new Paragraph(new Phrase("Số hóa đơn: " + pn.getIdPhieu(), SetFont.fontTNR()));
			idPhieu.setAlignment(Element.ALIGN_CENTER);
			document.add(idPhieu);

			document.add(Chunk.NEWLINE);

			new Chunk(new VerticalPositionMark());

			Paragraph info = new Paragraph();
			info.setPaddingTop(30);
			info.setIndentationLeft(40);
			info.setFont(SetFont.fontTNR());
			info.add("\nNhà phân phối: " + NhaPhanPhoiDAO.getInstance().selectById(pn.getIdNPP()).getTenNPP());
			info.add("\nĐịa chỉ: " + NhaPhanPhoiDAO.getInstance().selectById(pn.getIdNPP()).getDiaChi());
			info.add("\nEmail: " + NhaPhanPhoiDAO.getInstance().selectById(pn.getIdNPP()).getEmail());
			info.add("\nSĐT: " + NhaPhanPhoiDAO.getInstance().selectById(pn.getIdNPP()).getSdt());
			document.add(info);
			document.add(Chunk.NEWLINE);

			PdfPTable pdfTable = new PdfPTable(5);
			pdfTable.setWidths(new float[] { 10f, 35f, 15f, 15f, 15f });

			PdfPCell cell1 = new PdfPCell(new Phrase("STT", SetFont.fontTNRBold()));
			cell1.setBackgroundColor(new BaseColor(98, 181, 244));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(cell1);

			PdfPCell cell2 = new PdfPCell(new Phrase("Tên hàng", SetFont.fontTNRBold()));
			cell2.setBackgroundColor(new BaseColor(98, 181, 244));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(cell2);

			PdfPCell cell3 = new PdfPCell(new Phrase("Số Lượng", SetFont.fontTNRBold()));
			cell3.setBackgroundColor(new BaseColor(98, 181, 244));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(cell3);

			PdfPCell cell4 = new PdfPCell(new Phrase("Đơn giá", SetFont.fontTNRBold()));
			cell4.setBackgroundColor(new BaseColor(98, 181, 244));
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(cell4);

			PdfPCell cell5 = new PdfPCell(new Phrase("Thành tiền", SetFont.fontTNRBold()));
			cell5.setBackgroundColor(new BaseColor(98, 181, 244));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfTable.addCell(cell5);

			int j = 1;
			PdfPCell cellSTT;
			PdfPCell cellTenSP;
			PdfPCell cellSL;
			PdfPCell cellDonGia;
			PdfPCell cellTongTien;

			for (ChiTietPhieu ctpn : ChiTietPhieuNhapDAO.getInstance().selectAllById(mapn)) {
				cellSTT = new PdfPCell(new Phrase(j + "", SetFont.fontTNR()));
				cellSTT.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfTable.addCell(cellSTT);

				cellTenSP = new PdfPCell(new Phrase("null", SetFont.fontTNR()));
				pdfTable.addCell(cellTenSP);

				cellSL = new PdfPCell(new Phrase(ctpn.getSoLuong() + "", SetFont.fontTNR()));
				cellSL.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfTable.addCell(cellSL);

				cellDonGia = new PdfPCell(
						new Phrase(String.valueOf(formatter.format(ctpn.getDonGia())), SetFont.fontTNR()));
				cellDonGia.setHorizontalAlignment(Element.ALIGN_RIGHT);
				pdfTable.addCell(cellDonGia);

				cellTongTien = new PdfPCell(
						new Phrase(formatter.format(ctpn.getSoLuong() * ctpn.getDonGia()), SetFont.fontTNR()));
				cellTongTien.setHorizontalAlignment(Element.ALIGN_RIGHT);
				pdfTable.addCell(cellTongTien);

				j++;
			}

			PdfPTable tableTotal = new PdfPTable(2);
			tableTotal.setWidths(new float[] { 75f, 15f });

			PdfPCell cellTongCong = new PdfPCell(new Phrase("Tổng cộng:", SetFont.fontTNRBold()));
			cellTongCong.setHorizontalAlignment(Element.ALIGN_CENTER);
			tableTotal.addCell(cellTongCong);

			PdfPCell cellTien = new PdfPCell(
					new Phrase(String.valueOf(formatter.format(pn.getTongTien())), SetFont.fontTNRBold()));
			cellTien.setHorizontalAlignment(Element.ALIGN_RIGHT);
			tableTotal.addCell(cellTien);

			document.add(pdfTable);
			document.add(tableTotal);
			document.add(Chunk.NEWLINE);

			Date now = new Date();
			Paragraph location = new Paragraph(new Phrase(
					"Đà Nẵng, ngày " + now.getDate() + " tháng " + now.getMonth() + 1 + " năm " + now.getYear(),
					SetFont.fontTNRBold()));
			location.setAlignment(Element.ALIGN_RIGHT);
			document.add(location);

			Paragraph nguoiLapPhieu = new Paragraph(new Phrase("NGƯỜI LẬP PHIẾU", SetFont.fontTNRBold()));
			nguoiLapPhieu.setAlignment(Element.ALIGN_RIGHT);
			document.add(nguoiLapPhieu);

			document.close();
			JOptionPane.showMessageDialog(null, "Ghi file thành công " + url);
			openFile(url);

		} catch (DocumentException | FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
		}
	}

	private void openFile(String file) {
		try {
			File path = new File(file);
			Desktop.getDesktop().open(path);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void writePhieuXuat(String mapn) {
		String url = "";
		try {
			fd.setTitle("In phiếu Xuất");
			fd.setLocationRelativeTo(null);
			url = getFile(mapn);
			if (url == null) {
				return;
			}
			file = new FileOutputStream(url);
			document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();

			setTitle("THÔNG TIN PHIẾU XUẤT");

			PhieuXuat pn = PhieuXuatDAO.getInstance().selectById(mapn);

			Paragraph para1 = new Paragraph(new Phrase("Mã phiếu: " + mapn, fontData));
			Paragraph para2 = new Paragraph(
					new Phrase("Thời gian tạo: " + formatDate.format(pn.getThoiGianTao()), fontData));
			Paragraph para3 = new Paragraph(new Phrase(
					"Người tạo: " + AccountDAO.getInstance().selectById(pn.getNguoiTao()).getFullName(), fontData));
			para1.setIndentationLeft(40);
			para2.setIndentationLeft(40);
			para3.setIndentationLeft(40);
			document.add(para1);
			document.add(para2);
			document.add(para3);
			document.add(Chunk.NEWLINE);// add hang trong de tao khoang cach

			// Tao table cho cac chi tiet cua hoa don
			PdfPTable pdfTable = new PdfPTable(6);
			pdfTable.setWidths(new float[] { 5f, 10f, 30f, 15f, 5f, 15f });
			PdfPCell cell;

			// Set headers cho table chi tiet
			pdfTable.addCell(new PdfPCell(new Phrase("Mã máy", fontHeader)));
			pdfTable.addCell(new PdfPCell(new Phrase("Tên máy", fontHeader)));
			pdfTable.addCell(new PdfPCell(new Phrase("Đơn giá", fontHeader)));
			pdfTable.addCell(new PdfPCell(new Phrase("SL", fontHeader)));
			pdfTable.addCell(new PdfPCell(new Phrase("Tổng tiền", fontHeader)));

			for (int i = 0; i < 5; i++) {
				cell = new PdfPCell(new Phrase(""));
				pdfTable.addCell(cell);
			}

			// Truyen thong tin tung chi tiet vao table
//			for (ChiTietPhieu ctpn : ChiTietPhieuXuatDAO.getInstance().selectAll(mapn)) {
//				MayTinh mt = MayTinhDAO.getInstance().selectById(ctpn.getMaMay());
//				pdfTable.addCell(new PdfPCell(new Phrase(ctpn.getMaMay(), fontData)));
//				pdfTable.addCell(new PdfPCell(new Phrase(mt.getTenMay(), fontData)));
//				pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(mt.getGia()) + "đ", fontData)));
//				pdfTable.addCell(new PdfPCell(new Phrase(String.valueOf(ctpn.getSoLuong()), fontData)));
//				pdfTable.addCell(
//						new PdfPCell(new Phrase(formatter.format(ctpn.getSoLuong() * mt.getGia()) + "đ", fontData)));
//			}
			document.add(pdfTable);
			document.add(Chunk.NEWLINE);
			Paragraph paraTongThanhToan = new Paragraph(
					new Phrase("Tổng thanh toán: " + formatter.format(pn.getTongTien()) + "đ", fontData));
			paraTongThanhToan.setIndentationLeft(300);
			document.add(paraTongThanhToan);
			document.close();
			JOptionPane.showMessageDialog(null, "Ghi file thành công: " + url);
			openFile(url);

		} catch (DocumentException | FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
		}

	}
}
