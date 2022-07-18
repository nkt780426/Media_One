package model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class SanPham implements Serializable {
	private String maSp;
	private String tenSp;
	private int namPhatHanh;
	private String theLoai;
	private ArrayList<HoaDonNhap> nhap = new ArrayList<>();

	public SanPham(String maSp, String tenSp, int namPhatHanh, double giaBan, String theLoai) {
		this.maSp = maSp;
		this.tenSp = tenSp;
		this.namPhatHanh = namPhatHanh;
		this.giaBan = giaBan;
		this.theLoai = theLoai;
	}

	public String getMaSp() {
		return maSp;
	}

	public void setMaSp(String maSp) {
		this.maSp = maSp;
	}

	public String getTenSp() {
		return tenSp;
	}

	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}

	public int getNamPhatHanh() {
		return namPhatHanh;
	}

	public void setNamPhatHanh(int namPhatHanh) {
		this.namPhatHanh = namPhatHanh;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

}
