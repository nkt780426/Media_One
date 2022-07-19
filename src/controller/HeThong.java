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
		System.out.println("1.Xem toan bo san pham:");
		System.out.println("2.Xem thong tin san pham theo ma:");
		System.out.println("3.Mua hang:");
		System.out.println("4.Xem thong tin ca nhan:");
		System.out.println("5.Cap nhat thong tin ca nhan:");
		System.out.println("6.Quay lai:");
	}

	public static void menuQuanLy() {
		System.out.println("");
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
				//Khach hang
				case 1:
					Scanner sc1 = new Scanner(System.in);
					try {
						menuKhachHang();
						System.out.println("Nhap lua chon: ");
						int luaChonKhachHang=sc1.nextInt();
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
				//Quan ly
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
