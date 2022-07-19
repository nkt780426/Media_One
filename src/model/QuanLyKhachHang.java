package model;

import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class QuanLyKhachHang {
	private HashMap<String, KhachHang> dsKhachHang = new HashMap<>();
	public String header = String.format("%4s%15s%6s%15s%15s%25s", "Ma", "Ten", "Gioi Tinh", "Ngay Sinh", "SDT",
			"Dia chi");
	Scanner sc = new Scanner(System.in);

	public HashMap<String, KhachHang> getDsKhachHang() {
		return dsKhachHang;
	}

	public void setDsKhachHang(HashMap<String, KhachHang> dsKhachHang) {
		this.dsKhachHang = dsKhachHang;
	}

	public void setMaKh(KhachHang khachHang) {
		// he thong tu tao ma cho khach hang
		// ma= chu cuoi cung cua ten+ chu dau tien cua dia chi+ 2 so cuoi cung
		// cua sdt(co thay doi)
		String s1 = Character.toString(khachHang.getTen().charAt(khachHang.getTen().length() - 1));
		String s2 = Character.toString(khachHang.getDiaChi().charAt(0));
		Long a = khachHang.getSdt();
		while (true) {
			String s3 = a.toString().substring(a.toString().length() - 3);
			String s = s1 + s2 + s3;
			if (dsKhachHang.containsKey(s)) {
				a += 1;
			} else {
				khachHang.setMaKh(s);
				break;
			}
		}
	}

	public KhachHang themKhachHang() {
		try {
			System.out.println("Nhap ten khach hang: ");
			String ten = sc.nextLine();

			System.out.println("Nhap dia chi: ");
			String diaChi = sc.nextLine();

			System.out.println("Nhap so dien thoai: ");
			Long sdt = sc.nextLong();

			System.out.println("Nhap gioi tinh: ");
			String gioiTinh = sc.nextLine();

			System.out.println("Nhap ngay sinh(dd-MM-yyyy): ");
			SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date ngaySinh = (Date) df.parse(sc.nextLine());

			KhachHang khachHang = new KhachHang(ten, diaChi, sdt, gioiTinh, ngaySinh);

			setMaKh(khachHang);
			dsKhachHang.put(khachHang.getMaKh(), khachHang);
			return khachHang;
		} catch (InputMismatchException e) {
			System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void xemKhachHang() {
		System.out.println("Nhap ma khach hang: ");
		String maKhachHang = sc.nextLine();
		System.out.println("Thong tin khach hang: ");
		if (this.dsKhachHang.containsKey(maKhachHang)) {
			KhachHang khachHang = this.dsKhachHang.get(maKhachHang);
			System.out.println(header);
			String row = String.format("%4s%15s%6s%15s%15s%25s", khachHang.getMaKh(), khachHang.getTen(),
					khachHang.getGioiTinh(), khachHang.getNgaySinh(), khachHang.getSdt(), khachHang.getDiaChi());
			System.out.println(row);
		} else {
			System.out.println("Ma khach hang khong ton tai!");
		}
	}

	public void xemToanBo() {
		System.out.println("Danh sach khach hang");
		System.out.println(header);
		for (Map.Entry<String, KhachHang> entry : dsKhachHang.entrySet()) {
			String row = String.format("%4s%15s%6s%15s%15s%25s", entry.getValue().getMaKh(), entry.getValue().getTen(),
					entry.getValue().getGioiTinh(), entry.getValue().getNgaySinh(), entry.getValue().getSdt(), entry.getValue().getDiaChi());
			System.out.println(row);
		}
	}
}
