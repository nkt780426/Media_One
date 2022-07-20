package model;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class QuanLyNhanVien {
	private HashMap<String, NhanVien> dsNhanVien = new HashMap<String, NhanVien>();
	public String header = String.format("%10s%25s%25s%25s%30s%30s%25s%30s", "Ma", "Ten", "Gioi Tinh", "Ngay Sinh", "SDT",
			"Dia chi", "Luong", "Ngay nhan Luong");
	Scanner sc = new Scanner(System.in);

	public HashMap<String, NhanVien> getDsNhanVien() {
		return dsNhanVien;
	}

	public void setDsNhanVien(HashMap<String, NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	// them
	public void themNhanVien() {
		try {
			System.out.print("Nhap ten nhan vien: ");
			String ten = sc.nextLine();

			System.out.print("Nhap dia chi: ");
			String diaChi = sc.nextLine();

			System.out.print("Nhap so dien thoai: ");
			String sdt = sc.nextLine();

			if (Long.parseLong(sdt) <= 0) {
				throw new InputMismatchException();
			}

			System.out.print("Nhap gioi tinh (NAM or NU): ");
			String gioiTinh = sc.nextLine();

			System.out.print("Nhap ngay sinh(dd-MM-yyyy): ");
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate ngaySinh = LocalDate.parse(sc.nextLine(), df);

			System.out.print("Nhap luong: ");
			double luong = Double.parseDouble(sc.nextLine());

			System.out.print("Nhap ngay nhan luong (tu 1-28):");
			int ngayNhanLuong = Integer.parseInt(sc.nextLine());
			if (ngayNhanLuong < 1 || ngayNhanLuong > 28) {
				System.out.println("Ngay nhan luong tu [1-28] thoi!");
			}

			System.out.print("Nhap ma nhan vien: ");
			String maNhanVien = sc.nextLine();

			NhanVien nhanVien = new NhanVien(ten, maNhanVien, gioiTinh, diaChi, sdt, ngaySinh, luong, ngayNhanLuong);
			dsNhanVien.put(nhanVien.getMaNV(),nhanVien);
		} catch (InputMismatchException e) {
			System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	// xoa

	public void xoaNhanVien() {
		System.out.println("Nhap ma nhan vien muon xoa: ");
		String ma = sc.nextLine();
		if (dsNhanVien.containsKey(ma)) {
			dsNhanVien.remove(ma);
			System.out.println("Da xoa thanh cong!");
		} else {
			System.out.println("Khong ton tai ma nhan vien!");
		}
	}

	// xem theo ma
	public void xemNhanVien() {
		System.out.println("Nhap ma nhan vien: ");
		String ma = sc.nextLine();
		System.out.println("Thong tin nhan vien: ");
		if (this.dsNhanVien.containsKey(ma)) {
			NhanVien nhanVien = this.dsNhanVien.get(ma);
			System.out.println(header);
			String row = String.format("%10s%25s%25s%25s%30s%30s%25s%30s", nhanVien.getMaNV(), nhanVien.getTen(),
					nhanVien.getGioiTinh(), nhanVien.getNgaySinh(), nhanVien.getSdt(), nhanVien.getDiaChi(),
					nhanVien.getLuong(), nhanVien.getNgayNhanLuong());
			System.out.println(row);
		} else {
			System.out.println("Ma nhan vien khong ton tai!");
		}
	}

	// Xem toan bo nhan vien
	public void xemToanBo() {
		System.out.println("Danh sach nhan vien: ");
		System.out.println(header);
		for (Map.Entry<String, NhanVien> entry : dsNhanVien.entrySet()) {
			String row = String.format("%10s%25s%25s%25s%30s%30s%25s%30s", entry.getValue().getMaNV(),
					entry.getValue().getTen(), entry.getValue().getGioiTinh(), entry.getValue().getNgaySinh(),
					entry.getValue().getSdt(), entry.getValue().getDiaChi(), entry.getValue().getLuong(),
					entry.getValue().getNgayNhanLuong());
			System.out.println(row);
		}
	}

	// cap nhat
	public void capNhat() {
		System.out.println("Nhap ma nhan vien: ");
		String ma = sc.nextLine();
		if (dsNhanVien.containsKey(ma)) {
			dsNhanVien.remove(ma);
			themNhanVien();
		} else {
			System.out.println("Ma nhan vien khong ton tai!");
		}
	}
	// tinh tong luong

	public double tongLuong(Date date1, Date date2) {
		double tongLuong = 0;
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(date2);
		if (c1.get(Calendar.YEAR) != c2.get(Calendar.YEAR)) {
			for (Map.Entry<String, NhanVien> entry : dsNhanVien.entrySet()) {
				tongLuong += entry.getValue().getLuong();
			}
		} else {
			if (c1.get(Calendar.MONTH) != c2.get(Calendar.MONTH)) {
				for (Map.Entry<String, NhanVien> entry : dsNhanVien.entrySet()) {
					tongLuong += entry.getValue().getLuong();
				}
			} else {
				for (Map.Entry<String, NhanVien> entry : dsNhanVien.entrySet()) {
					if (c1.get(Calendar.DAY_OF_MONTH) <= entry.getValue().getNgayNhanLuong()
							&& entry.getValue().getNgayNhanLuong() <= c2.get(Calendar.DAY_OF_MONTH)) {
						tongLuong += entry.getValue().getLuong();
					}
				}
			}
		}
		return tongLuong;
	}

}
