package model;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class QuanLyNhanVien {
	private HashMap<String, NhanVien> dsNhanVien = new HashMap<String, NhanVien>();
	public String header = String.format("%4s%15s%6s%15s%15s%25s%15s%8s", "Ma", "Ten", "Gioi Tinh", "Ngay Sinh", "SDT",
			"Dia chi", "Luong", "Ngay nhan Luong");
	Scanner sc = new Scanner(System.in);

	public HashMap<String, NhanVien> getDsNhanVien() {
		return dsNhanVien;
	}

	public void setDsNhanVien(HashMap<String, NhanVien> dsNhanVien) {
		this.dsNhanVien = dsNhanVien;
	}

	// them
	public NhanVien themNhanVien() {
		try {
			System.out.println("Nhap ten nhan vien: ");
			String ten = sc.nextLine();

			System.out.println("Nhap dia chi: ");
			String diaChi = sc.nextLine();
			
			sc.nextLine();
			System.out.println("Nhap so dien thoai: ");
			Long sdt = sc.nextLong();
			if (sdt <= 0)
				throw new InputMismatchException();

			System.out.println("Nhap gioi tinh: ");
			String gioiTinh = sc.nextLine();

			System.out.println("Nhap ngay sinh(dd-MM-yyyy): ");
			SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date ngaySinh = (Date) df.parse(sc.nextLine());

			System.out.println("Nhap luong: ");
			double luong = sc.nextDouble();

			System.out.println("Nhap ngay nhan luong (tu 1-28):");
			int ngayNhanLuong = sc.nextInt();

			System.out.println("Nhap ma nhan vien: ");
			String maNhanVien = sc.nextLine();
			if (dsNhanVien.containsKey(maNhanVien))
				throw new InputMismatchException();

			NhanVien nhanVien = new NhanVien(ten, maNhanVien, gioiTinh, diaChi, sdt, ngaySinh, luong, ngayNhanLuong);

			dsNhanVien.put(nhanVien.getMaNV(), nhanVien);
			return nhanVien;
		} catch (InputMismatchException e) {
			System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
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
			String row = String.format("%4s%15s%6s%15s%15s%25s%15s%8s", nhanVien.getMaNV(), nhanVien.getTen(),
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
			String row = String.format("%4s%15s%6s%15s%15s%25s%15s%8s", entry.getValue().getMaNV(),
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
			try {
				System.out.println("Nhap ten nhan vien: ");
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

				System.out.println("Nhap luong: ");
				double luong = sc.nextDouble();

				System.out.println("Nhap ngay nhan luong (tu 1-28):");
				int ngayNhanLuong = sc.nextInt();

				System.out.println("Nhap ma nhan vien: ");
				String maNhanVien = sc.nextLine();
				if (dsNhanVien.containsKey(maNhanVien))
					throw new InputMismatchException();

				NhanVien nhanVien = new NhanVien(ten, maNhanVien, gioiTinh, diaChi, sdt, ngaySinh, luong,
						ngayNhanLuong);

				dsNhanVien.put(nhanVien.getMaNV(), nhanVien);
			} catch (InputMismatchException e) {
				System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
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
