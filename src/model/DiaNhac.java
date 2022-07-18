package model;

import java.util.Arrays;

public class DiaNhac extends SanPham {
	private int thoiLuong;
	private String[] caSy;
	private String[] danhsachBaiHat;
	public DiaNhac(String maSp, String tenSp, int namPhatHanh, double giaBan, String theLoai, int thoiLuong,
			String[] caSy, String[] danhsachBaiHat) {
		super(maSp, tenSp, namPhatHanh, giaBan, theLoai);
		this.thoiLuong = thoiLuong;
		this.caSy = caSy;
		this.danhsachBaiHat = danhsachBaiHat;
	}
	public int getThoiLuong() {
		return thoiLuong;
	}
	public void setThoiLuong(int thoiLuong) {
		this.thoiLuong = thoiLuong;
	}
	public String[] getCaSy() {
		return caSy;
	}
	public void setCaSy(String[] caSy) {
		this.caSy = caSy;
	}
	public String[] getDanhsachBaiHat() {
		return danhsachBaiHat;
	}
	public void setDanhsachBaiHat(String[] danhsachBaiHat) {
		this.danhsachBaiHat = danhsachBaiHat;
	}

	public String toString() {
		return "DiaNhac [thoiLuong=" + thoiLuong + ", caSy=" + Arrays.toString(caSy) + ", danhsachBaiHat="
				+ Arrays.toString(danhsachBaiHat) + "]";
	}
}
