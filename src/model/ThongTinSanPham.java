package model;

public class ThongTinSanPham {
	private int soLuong;
	private int giaMua;
	public ThongTinSanPham(int soLuong, int giaMua) {
		super();
		this.soLuong = soLuong;
		this.giaMua = giaMua;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getGiaMua() {
		return giaMua;
	}
	public void setGiaMua(int giaMua) {
		this.giaMua = giaMua;
	}
	
}
