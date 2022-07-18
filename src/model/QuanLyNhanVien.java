package model;

import java.util.HashMap;

public class QuanLyNhanVien {
	private HashMap<String, NhanVien> dsNhanVien = new HashMap<String, NhanVien>();
	public HashMap<String, NhanVien> getDsNhanVien() {
		return dsNhanVien;
	}

	public void setDsNhanVien(HashMap<String, NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	public void setMaNV(NhanVien nhanVien) {
		// he thong tu tao ma cho khach hang
		// ma= chu cuoi cung cua ten+ chu dau tien cua dia chi+ 2 so cuoi cung
		// cua sdt(co thay doi)
		String s1 = Character.toString(nhanVien.getTen().charAt(nhanVien.getTen().length() - 1));
		String s2 = Character.toString(nhanVien.getDiaChi().charAt(0));
		Long a = nhanVien.getSdt();
		while (true) {
			String s3 = a.toString().substring(a.toString().length() - 3);
			String s = s1 + s2 + s3;
			if (dsNhanVien.containsKey(s)) {
				a += 1;
			} else {
				nhanVien.setMaNV(s);
				break;
			}
		}
	}
	public void themNhanVien(NhanVien nhanVien) {
		setMaNV(nhanVien);
		dsNhanVien.put(nhanVien.getMaNV(), nhanVien);
	}

	public void xoaNhanVien(NhanVien nhanVien) {
		this.dsNhanVien.put(nhanVien.getMaNV(), nhanVien);
	}

}
