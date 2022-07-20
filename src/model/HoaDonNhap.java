package model;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

public class HoaDonNhap extends HoaDon {
	private String giaBuon;

	public HoaDonNhap(KhachHang khachHang, String maSanPham, LocalDate ngayMua, double soLuong, String giaBuon) {
		super(khachHang, maSanPham, ngayMua, soLuong);
		this.giaBuon = giaBuon;
	}

	public String getGiaBuon() {
		return giaBuon;
	}

	public void setGiaBuon(String giaBuon) {
		this.giaBuon = giaBuon;
	}

	public String luuVaoData(HoaDonNhap hdn) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String dateFormat = hdn.getNgayMua().format(f);
		return hdn.getKhachHang() + "::" + hdn.getMaSanPham() + "::" + dateFormat + "::"
				+ String.format("%1f", hdn.getSoLuong()) + "::" + hdn.getGiaBuon();
	}
}