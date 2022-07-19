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
	//1.Kiem tra ma san pham có tồn tại không tra ve true neu ton tai
	public boolean maTonTai(String s) {
		if (dsSach.containsKey(s)) {
			return true;
		}
		if(dsDiaNhac.containsKey(s)) {
			return true;
		}
		if(dsDiaPhim.containsKey(s)) {
			return true;
		}
		return false;
	}
	//2.Tim kiem san pham theo ma (ham nay khong kiem tra nos co ton tai hay khong luc lam ham mian phai chu y
	public SanPham timKiemTheoMa(String s) {
		if(maTonTai(s)) {
			if(dsSach.containsKey(s)) {
				SanPham sanPham=dsSach.get(s);
				return sanPham;
			}
			if(dsDiaNhac.containsKey(s)) {
				SanPham sanPham=dsDiaNhac.get(s);
				return sanPham;
			}
			if(dsDiaPhim.containsKey(s)) {
				SanPham sanPham=dsDiaPhim.get(s);
				return sanPham;
			}
		}else {
			System.out.println("Ma san pham khong ton tai!");
			return null;
		}
		return null;
	}
}
