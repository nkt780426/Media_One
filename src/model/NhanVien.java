package model;

import java.util.Date;

public class NhanVien {
	private String ten;
	private String maNV;
	private String gioiTinh;
	private String diaChi;
	private Long sdt;
	private Date ngaySinh;
	private double luong;
	private int ngayNhanLuong;// bat loi neu ngay nhan luong ko tu 1-28

	public NhanVien(String ten, String maNV, String gioiTinh, String diaChi, Long sdt, Date ngaySinh, double luong,
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

	public Long getSdt() {
		return sdt;
	}

	public void setSdt(Long sdt) {
		this.sdt = sdt;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public int getNgayNhanLuong() {
		return ngayNhanLuong;
	}

	public void setNgayNhanLuong(int ngayNhanLuong) {
		this.ngayNhanLuong = ngayNhanLuong;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

}
