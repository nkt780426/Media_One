package model;

public class Sach extends SanPham {
	private String tacGia;
	private String nhaXuatBan;

	public Sach(String maSp, String tenSp, int namPhatHanh, double giaBan, String theLoai, String tacGia,
			String nhaXuatBan) {
		super(maSp, tenSp, namPhatHanh, giaBan, theLoai);
		this.tacGia = tacGia;
		this.nhaXuatBan = nhaXuatBan;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public String toString() {
		return "Sach [tacGia=" + tacGia + ", nhaXuatBan=" + nhaXuatBan + "]";
	}

}