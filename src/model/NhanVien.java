package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.NhanVien;

public class NhanVien {
	private String ten;
	private String maNV;
	private String gioiTinh;
	private String diaChi;
	private String sdt;
	private LocalDate ngaySinh;
	private double luong;
	private int ngayNhanLuong;// bat loi neu ngay nhan luong ko tu 1-28

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
	
	public String getNgaySinhString() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return ngaySinh.format(f);
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public int getNgayNhanLuong() {
		return ngayNhanLuong;
	}

	public void setNgayNhanLuong(int ngayNhanLuong) {
		if (ngayNhanLuong <= 28 && ngayNhanLuong > 0) {
			this.ngayNhanLuong = ngayNhanLuong;			
		} else {
			System.out.println("Ngay nhan luong phai thuoc tu [1-28]");
		}
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}
	
	public String luuVaoData() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String dateFormat = this.ngaySinh.format(f);
		return this.ten + "::" + this.maNV + "::" + this.gioiTinh + "::" + this.diaChi + "::" + this.sdt + "::" + dateFormat + "::"
				+ this.ngayNhanLuong + "::" + String.format("%1f", this.luong);
	}

	@Override
	public String toString() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String dateFormat = this.ngaySinh.format(f);
		return "NhanVien [ten=" + ten + ", maNV=" + maNV + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", sdt="
				+ sdt + ", ngaySinh=" + dateFormat + ", luong=" + luong + ", ngayNhanLuong=" + ngayNhanLuong + "]";
	}
}
