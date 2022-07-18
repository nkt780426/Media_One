package model;

import java.util.Arrays;

public class DiaPhim extends SanPham {
	private int thoiLuong;
	private String[] daoDien;
	private String[] dienVien;

	public DiaPhim(String maSp, String tenSp, int namPhatHanh, double giaBan, String theLoai, int thoiLuong,
			String[] daoDien, String[] dienVien) {
		super(maSp, tenSp, namPhatHanh, giaBan, theLoai);
		this.thoiLuong = thoiLuong;
		this.daoDien = daoDien;
		this.dienVien = dienVien;
	}

	public int getThoiLuong() {
		return thoiLuong;
	}

	public void setThoiLuong(int thoiLuong) {
		this.thoiLuong = thoiLuong;
	}

	public String[] getDaoDien() {
		return daoDien;
	}

	public void setDaoDien(String[] daoDien) {
		this.daoDien = daoDien;
	}

	public String[] getDienVien() {
		return dienVien;
	}

	public void setDienVien(String[] dienVien) {
		this.dienVien = dienVien;
	}

	public String toString() {
		return "DiaPhim [thoiLuong=" + thoiLuong + ", daoDien=" + Arrays.toString(daoDien) + ", dienVien="
				+ Arrays.toString(dienVien) + "]";
	}
}
