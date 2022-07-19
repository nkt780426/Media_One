package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.QuanLyHoaDon;
import model.QuanLyKhachHang;
import model.QuanLyNhanVien;
import model.QuanLySanPham;

public class HeThong {
	QuanLySanPham quanLySanPham = new QuanLySanPham();
	QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
	QuanLyHoaDon quanLyHoaDon = new QuanLyHoaDon();
	QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();

	public static void luaChon() {
		System.out.println("1.Ban la khach hang:");
		System.out.println("2.Ban la quan ly:");
		System.out.println("3.Thoat he thong:");
	}

	public static void menuKhachHang() {
		// Quan ly san pham
		System.out.println("1.Xem toan bo san pham:");
		System.out.println("2.Xem thong tin san pham theo ma:");
		System.out.println("3.Mua hang:");
			//luc mua goi ham them khach hang
			//sau do hoi so loai hang muon mua va goi n lan hàm mua hàng
		System.out.println("4.Quay lai:");
	}

	public static void menuQuanLy() {
		// Quan ly san pham
		System.out.println("1.Xem toan bo san pham: ");
		System.out.println("2.Xem thong tin san pham theo ma: ");
		System.out.println("3.Cap nhat thong tin san pham:");
		System.out.println("4.Them san pham moi: ");
		System.out.println("5.Xoa san pham");
		// Quan ly khach hang
		System.out.println("6.Xem toan bo khach hang: ");
		System.out.println("7.Xem thong tin khach hang theo ma:");
		// Quan ly nhan vien
		System.out.println("8.Xem toan bo nhan vien: ");
		System.out.println("9.Xem thong tin nhan vien theo ma: ");
		System.out.println("10.Cap nhat thong tin nhan vien");
		System.out.println("11.Them nhan vien: ");
		System.out.println("12.Xoa nhan vien: ");
		System.out.println("13.Quay lai:");
	}

	public static void main(String[] args) {
		// doc toan bo dl tu phai vao cac mang
		int luaChon = 0;
		do {
			Scanner sc = new Scanner(System.in);
			luaChon();
			System.out.println("Nhap lua chon: ");
			try {
				luaChon = sc.nextInt();
				switch (luaChon) {
				// Khach hang
				case 1:
					Scanner sc1 = new Scanner(System.in);
					try {
						menuKhachHang();
						System.out.println("Nhap lua chon: ");
						int luaChonKhachHang = sc1.nextInt();
						switch (luaChon) {
						case 1:

							break;
						case 2:

							break;
						case 3:

							break;
						case 4:

							break;
						case 5:

							break;
						case 6:
							break;
						default:
							System.out.println("Ban da nhap sai xin vui long nhap lai:");
							break;
						}
					} catch (InputMismatchException e) {
						System.out.println("Ban da nhap sai xin vui long nhap lai!");
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				// Quan ly
				case 2:

					break;
				default:
					System.out.println("Ban da nhap sai xin vui long nhap lai!");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Ban da nhap sai xin vui long nhap lai!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (luaChon != 3);
		// luu toan bo du lieu vao file
		System.out.println("Cam on ban da su dung he thong!");
	}
}
