package model;

import java.util.ArrayList;
import java.util.Date;


import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class QuanLyKhachHang {
	private HashMap<String, KhachHang> dsKhachHang = new HashMap<>();
	private QuanLyHoaDon quanLyHoaDon;
	public String header = String.format("%4s%15s%6s%15s%15s%25s", "Ma", "Ten", "Gioi Tinh", "Ngay Sinh", "SDT",
			"Dia chi");
	Scanner sc = new Scanner(System.in);

	public HashMap<String, KhachHang> getDsKhachHang() {
		return dsKhachHang;
	}

	public void setDsKhachHang(HashMap<String, KhachHang> dsKhachHang) {
		this.dsKhachHang = dsKhachHang;
	}

	public KhachHang themKhachHang() {
		try {
			System.out.println("Nhap ten khach hang: ");
			String ten = sc.nextLine();
			
			System.out.println("Nhap dia chi: ");
			String diaChi = sc.nextLine();

			System.out.println("Nhap so dien thoai: ");
			Long sdt = sc.nextLong();
			if (sdt<=0) throw new InputMismatchException();

			sc.nextLine();
			System.out.println("Nhap gioi tinh: ");
			String gioiTinh = sc.nextLine();

			System.out.println("Nhap ngay sinh(dd/MM/yyyy): ");
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date ngaySinh = (Date) df.parse(sc.nextLine());

			System.out.println("Nhap ma khach hang: ");
			String maKhachHang= sc.nextLine();
			if(dsKhachHang.containsKey(maKhachHang)) throw new InputMismatchException();
			
			KhachHang khachHang = new KhachHang(ten, maKhachHang, diaChi, sdt, gioiTinh, ngaySinh);

			dsKhachHang.put(khachHang.getMaKh(), khachHang);
			return khachHang;
		} catch (InputMismatchException e) {
			System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai!");
		} catch (Exception e) {
			e.printStackTrace();
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
	public void muaHang() {
		KhachHang khachHang = themKhachHang();
		System.out.println("Nhap so loai hang muon mua: ");
		int a = sc.nextInt();
		if (a <= 0)
			throw new InputMismatchException();
		ArrayList<HoaDonXuat> hoaDonXuat = new ArrayList<HoaDonXuat>();
		for (int i = 1; i <= a; i++) {
			HoaDonXuat donXuat = quanLyHoaDon.muaHang(khachHang);
			hoaDonXuat.add(donXuat);
		}
		System.out.println("Danh sach don hang: ");
		System.out.println(quanLyHoaDon.header1);
		for (HoaDonXuat donXuat : hoaDonXuat) {
			if (hoaDonXuat != null) {
				String row = String.format("%4s%15s%10%8s%25s%20s",
						donXuat.getKhachHang().getMaKh(), donXuat.getKhachHang().getTen(),
						donXuat.getMaSanPham(), donXuat.getSoLuong(), donXuat.getNgayMua(),
						donXuat.getGiaBan());
				System.out.println(row);
			}
		}
	}
}
