package model;

import java.util.Date;

public class HoaDonNhap extends HoaDon {
	private String giaBuon;

	public HoaDonNhap(KhachHang khachHang, String maSanPham, Date ngayMua, double soLuong, String giaBuon) {
		super(khachHang, maSanPham, ngayMua, soLuong);
		this.giaBuon = giaBuon;
	}

	public String getGiaBuon() {
		return giaBuon;
	}

	public void setGiaBuon(String giaBuon) {
		this.giaBuon = giaBuon;
	}
}