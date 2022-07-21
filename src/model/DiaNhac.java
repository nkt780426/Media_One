package model;

public class DiaNhac extends SanPham {
	private String thoiLuong;
	private String caSy;
	private String danhsachBaiHat;

	public DiaNhac(String maSp, String tenSp, int namPhatHanh, int soLuong, double giaBuon, double giaBan,
			String thoiLuong, String caSy, String danhsachBaiHat) {
		super(maSp, tenSp, namPhatHanh, soLuong, giaBuon, giaBan);
		this.thoiLuong = thoiLuong;
		this.caSy = caSy;
		this.danhsachBaiHat = danhsachBaiHat;
	}

	public String getThoiLuong() {
		return thoiLuong;
	}

	public void setThoiLuong(String thoiLuong) {
		this.thoiLuong = thoiLuong;
	}

	public String getCaSy() {
		return caSy;
	}

	public void setCaSy(String caSy) {
		this.caSy = caSy;
	}

	public String getDanhsachBaiHat() {
		return danhsachBaiHat;
	}

	public void setDanhsachBaiHat(String danhsachBaiHat) {
		this.danhsachBaiHat = danhsachBaiHat;
	}

	public String luuVaoData() {
		return this.getMaSp() + "::" + this.getTenSp() + "::" + String.format("%1d", this.getNamPhatHanh()) + "::"
				+ String.format("%1d", this.getSoLuong()) + "::" + String.format("%1f", this.getGiaBuon()) + "::"
				+ String.format("%1f", this.getGiaBan()) + this.thoiLuong + "::" + this.caSy + "::"
				+ this.danhsachBaiHat;
	}
}