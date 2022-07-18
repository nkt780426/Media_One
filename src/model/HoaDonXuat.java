package model;

import java.sql.Date;
import java.util.HashMap;

public class HoaDonXuat {
	private Date ngayMua;
	private KhachHang khachHang;
	private HashMap<Date,ThongTinSanPham> dsmua= new HashMap<Date,ThongTinSanPham>();
	public HoaDonXuat(Date ngayMua, KhachHang khachHang, HashMap<Date, ThongTinSanPham> dsmua) {
		super();
		this.ngayMua = ngayMua;
		this.khachHang = khachHang;
		this.dsmua = dsmua;
	}
	public Date getNgayMua() {
		return ngayMua;
	}
	public void setNgayMua(Date ngayMua) {
		this.ngayMua = ngayMua;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public HashMap<Date, ThongTinSanPham> getDsmua() {
		return dsmua;
	}
	public void setDsmua(HashMap<Date, ThongTinSanPham> dsmua) {
		this.dsmua = dsmua;
	}
}
