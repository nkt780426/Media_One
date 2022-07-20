package model;

import java.time.LocalDate;

public class NhanVien {
	private String ten;
	private String maNV;
	private String gioiTinh;
	private String diaChi;
	private String sdt;
	private LocalDate ngaySinh;
	private double luong;
	private int ngayNhanLuong;
	public NhanVien(String ten, String maNV, String gioiTinh, String diaChi, String sdt, LocalDate ngaySinh, double luong,
			int ngayNhanLuong) {
		super();
		this.ten = ten;
		this.maNV = maNV;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.ngaySinh = ngaySinh;
		this.luong = luong;
		this.ngayNhanLuong = ngayNhanLuong;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	public int getNgayNhanLuong() {
		return ngayNhanLuong;
	}
	public void setNgayNhanLuong(int ngayNhanLuong) {
		this.ngayNhanLuong = ngayNhanLuong;
	}
	
}
