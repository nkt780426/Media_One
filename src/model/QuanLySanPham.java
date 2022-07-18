package model;

import java.util.HashMap;

public class QuanLySanPham {
	private HashMap<String, Sach> dsSach= new HashMap<String, Sach>();
	private HashMap<String, DiaNhac> dsDiaNhac= new HashMap<String, DiaNhac>();
	private HashMap<String, DiaPhim> dsDiaPhim= new HashMap<String, DiaPhim>();
	public HashMap<String, Sach> getDsSach() {
		return dsSach;
	}
	public void setDsSach(HashMap<String, Sach> dsSach) {
		this.dsSach = dsSach;
	}
	public HashMap<String, DiaNhac> getDsDiaNhac() {
		return dsDiaNhac;
	}
	public void setDsDiaNhac(HashMap<String, DiaNhac> dsDiaNhac) {
		this.dsDiaNhac = dsDiaNhac;
	}
	public HashMap<String, DiaPhim> getDsDiaPhim() {
		return dsDiaPhim;
	}
	public void setDsDiaPhim(HashMap<String, DiaPhim> dsDiaPhim) {
		this.dsDiaPhim = dsDiaPhim;
	}
}
