package model;

import java.util.Date;

public class HoaDon {
	private KhachHang khachHang;
	private String maSanPham;
	private Date ngayMua;
	private double soLuong;
	public HoaDon(KhachHang khachHang, String maSanPham, Date ngayMua, double soLuong) {
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
	public Date getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}
	public double getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(double soLuong) {
		this.soLuong = soLuong;
	}
	
}