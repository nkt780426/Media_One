package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class KhachHang {
	private String ten;
	private String maKh;
	private String gioiTinh;
	private String diaChi;
	private String sdt;
	private LocalDate ngaySinh;

	public KhachHang(String ten, String maKh, String gioiTinh, String diaChi, String sdt, LocalDate ngaySinh) {
		super();
		this.ten = ten;
		this.maKh = maKh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.ngaySinh = ngaySinh;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMaKh() {
		return maKh;
	}

	public void setMaKh(String maKh) {
		this.maKh = maKh;
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

	public String luuVaoData() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String dateFormat = this.ngaySinh.format(f);
		return this.ten + "::" + this.maKh + "::" + this.gioiTinh + "::" + this.diaChi + "::" + this.sdt + "::" + dateFormat;
	}
}
