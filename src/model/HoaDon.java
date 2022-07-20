package model;

import java.time.LocalDate;

public class HoaDon {
	private KhachHang khachHang;
	private String maSanPham;
	private LocalDate ngayMua;
	private double soLuong;

	public HoaDon(KhachHang khachHang, String maSanPham, LocalDate ngayMua, double soLuong) {
		super();
		this.khachHang = khachHang;
		this.maSanPham = maSanPham;
		this.ngayMua = ngayMua;
		this.soLuong = soLuong;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public LocalDate getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(LocalDate ngayMua) {
		this.ngayMua = ngayMua;
	}

	public double getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(double soLuong) {
		this.soLuong = soLuong;
	}

}