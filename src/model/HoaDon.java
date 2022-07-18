package model;

import java.util.Date;

public class HoaDon {
	private KhachHang khachHang;
	private String maSanPham;
	private Date ngayMua;
	private double soLuong;
	private HoaDonGiu donGiu;
	private HoaDonXuat donXuat;
	//trong class san pham dung cai nay
	public HoaDon(HoaDonGiu donNhap, HoaDonXuat donXuat) {
		super();
		this.donGiu = donNhap;
		this.donXuat = donXuat;
	}
	//trong class quan ly hoa don dung cai nay
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
	public HoaDonGiu getDonNhap() {
		return donGiu;
	}
	public void setDonNhap(HoaDonGiu donNhap) {
		this.donGiu = donNhap;
	}
	public HoaDonXuat getDonXuat() {
		return donXuat;
	}
	public void setDonXuat(HoaDonXuat donXuat) {
		this.donXuat = donXuat;
	}
}