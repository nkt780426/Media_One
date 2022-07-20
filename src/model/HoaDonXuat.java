package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HoaDonXuat extends HoaDon {
	private String giaBan;

	public HoaDonXuat(KhachHang khachHang, String maSanPham, LocalDate ngayMua, double soLuong, String giaBan) {
		super(khachHang, maSanPham, ngayMua, soLuong);
		this.giaBan = giaBan;
	}

	public String getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(String giaBan) {
		this.giaBan = giaBan;
	}

	public String luuVaoData(HoaDonXuat hdx) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String dateFormat = hdx.getNgayMua().format(f);
		return hdx.getKhachHang() + "::" + hdx.getMaSanPham() + "::" + dateFormat + "::"
				+ String.format("%1f", hdx.getSoLuong()) + "::" + hdx.getGiaBan();
	}
}