package model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class SanPham implements Serializable {
	private String maSp;
	private String tenSp;
	private int namPhatHanh;
	private int soLuong;
	private String theLoai;
	private double giaBuon;
	private double giaBan;

	public SanPham(String maSp, String tenSp, int namPhatHanh, int soLuong, String theLoai, double giaBuon,
			double giaBan) {
		super();
		this.maSp = maSp;
		this.tenSp = tenSp;
		this.namPhatHanh = namPhatHanh;
		this.soLuong = soLuong;
		this.theLoai = theLoai;
		this.giaBuon = giaBuon;
		this.giaBan = giaBan;
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

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public double getGiaBuon() {
		return giaBuon;
	}

	public void setGiaBuon(double giaBuon) {
		this.giaBuon = giaBuon;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

}
