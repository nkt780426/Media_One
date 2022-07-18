package model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLyKhachHang {
	private HashMap<String, KhachHang> dsKhachHang = new HashMap<>();
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

	public void themKhachHang() {
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

			this.setMaKh(khachHang);
			this.dsKhachHang.put(khachHang.getMaKh(), khachHang);
		} catch (InputMismatchException e) {
			System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
			this.themKhachHang();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void xoaKhachHang() {
		try {
			System.out.println("Nhap ma khach hang: ");
			String s = sc.nextLine();
			if (this.dsKhachHang.containsKey(s)) {
				this.dsKhachHang.remove(s);
			} else {
				System.out.println("Ma khach hang khong ton tai!");
			}
		} catch (InputMismatchException e) {
			System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
			this.xoaKhachHang();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void timKiemThongTinKhachHang() {
		System.out.println("Nhap ma khach hang: ");
		String maKhachHang = sc.nextLine();
		if (this.dsKhachHang.containsKey(maKhachHang)) {
			KhachHang khachHang = this.dsKhachHang.get(maKhachHang);
			System.out.println(khachHang);
		} else {
			System.out.println("Ma khach hang khong ton tai!");
		}
	}
	// Thieu 1 ham in toan bo danh sach khach hang nua: dung for-each va printf ra
	// man hinh
	// sua ham toString de in ra cho dep hon = xem lai youtube du an quan ly ban
	// hang luc dau y
}
