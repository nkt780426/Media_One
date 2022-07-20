package model;

import java.util.Date;

public class KhachHang {
	private String ten;
	private String maKh;
	private String diaChi;
	private Long sdt;
	private String gioiTinh;
	private Date ngaySinh;

	public KhachHang(String ten, String maKh, String diaChi, Long sdt, String gioiTinh, Date ngaySinh) {
		super();
		this.ten = ten;
		this.maKh = maKh;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
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

	public void setMaKh(String s) {
		this.maKh = s;
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

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
}
