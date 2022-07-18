package model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class SanPham implements Serializable {
	private String maSp;
	private String tenSp;
	private int namPhatHanh;
	private int soLuong;
	private String theLoai;
	private HoaDon don;
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
	public HoaDon getDon() {
		return don;
	}
	public void setDon(HoaDon don) {
		this.don = don;
	}
}
