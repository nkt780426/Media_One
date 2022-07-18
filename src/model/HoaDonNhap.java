package model;

public class HoaDonNhap {
	private String ngayNhap;
	private boolean check = false;
	private double giaMua;
	private double giaBan;
	private int soluongConLai=0;

	public HoaDonNhap(String ngayNhap, Boolean check, int soluongConLai) {
		this.ngayNhap = ngayNhap;
		this.check = check;
		this.soluongConLai = soluongConLai;
	}
	public String getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public boolean getCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public int getSoluongconlai() {
		return soluongConLai;
	}

	public void setSoluongconlai(int soluongConLai) {
		this.soluongConLai = soluongConLai;
	}

}