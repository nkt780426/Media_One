package model;

import java.util.Date;

public class HoaDonXuat extends HoaDon {
	private String giaBan;

	public HoaDonXuat(KhachHang khachHang, String maSanPham, Date ngayMua, double soLuong, String giaBan) {
		super(khachHang, maSanPham, ngayMua, soLuong);
		this.giaBan = giaBan;
	}

	public String getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(String giaBan) {
		this.giaBan = giaBan;
	}

}