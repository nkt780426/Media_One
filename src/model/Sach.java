package model;

public class Sach extends SanPham {
	private String tacGia;
	private String nhaXuatBan;
	

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
