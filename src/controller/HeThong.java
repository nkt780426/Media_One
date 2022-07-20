package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.HoaDonXuat;
import model.KhachHang;
import model.QuanLyHoaDon;
import model.QuanLyKhachHang;
import model.QuanLyNhanVien;
import model.QuanLySanPham;

public class HeThong {

	public static void luaChon() {
		System.out.println("1.Ban la khach hang:");
		System.out.println("2.Ban la quan ly:");
		System.out.println("3.Thoat he thong:");
	}

	public static void menuKhachHang() {
		// Quan ly san pham
		System.out.println("1.Xem toan bo san pham:");
		System.out.println("2.Xem thong tin san pham theo ma:");
		// Quan ly khach hang+quan ly hoa don
		System.out.println("3.Mua hang:");
		// luc mua goi ham them khach hang
		// sau do hoi so loai hang muon mua va goi n lan hàm mua hàng
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
		// Quan ly khach hang+quan ly hoa don+quan ly nhan vien
		System.out.println("13.Tinh doanh thu va loi nhuan: ");
		System.out.println("14.Quay lai:");
	}

	public static void main(String[] args) {
		QuanLySanPham quanLySanPham = new QuanLySanPham();
		QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
		QuanLyHoaDon quanLyHoaDon = new QuanLyHoaDon();
		QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
		// doc toan bo dl tu phai vao cac mang
		int luaChon = 0;
		do {
			luaChon();
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap lua chon: ");
			try {
				luaChon = sc.nextInt();
				switch (luaChon) {
				// Khach hang
				case 1:
					try {
						menuKhachHang();
						System.out.println("Nhap lua chon: ");
						int luaChonKhachHang = sc.nextInt();
						switch (luaChonKhachHang) {
						case 1:

							break;
						case 2:

							break;
						case 3:
							KhachHang khachHang = quanLyKhachHang.themKhachHang();
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
							break;
						case 4:

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
					try {
						menuQuanLy();
						System.out.println("Nhap lua chon: ");
						int luaChonQuanLy = sc.nextInt();
						switch (luaChonQuanLy) {
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
							quanLyKhachHang.xemToanBo();
							break;
						case 7:
							quanLyKhachHang.xemKhachHang();
							break;
						case 8:
							quanLyNhanVien.xemToanBo();
							break;
						case 9:
							quanLyNhanVien.xemNhanVien();
							break;
						case 10:
							quanLyNhanVien.capNhat();
							break;
						case 11:
							quanLyNhanVien.themNhanVien();
							break;
						case 12:
							quanLyNhanVien.xoaNhanVien();
							break;
						case 13:
							System.out.println("------Nhap khoang thoi gian ban muon xem------");
							System.out.println("Chu y ngay 1 phai nho hon ngay 2");
							try {
								System.out.println("Ngay 1 (dd/MM/yyyy) : ");
								SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
								Date date1 = (Date) df.parse(sc.nextLine());

								System.out.println("Ngay 2 (dd/MM/yyyy) : ");
								Date date2 = (Date) df.parse(sc.nextLine());

								if(date1.before(date2)) {
									
									System.out.println();
									System.out.println("Doanh thu trong khoang thoi gian da nhap la: "
											+ quanLyHoaDon.tinhDoanhThu(date1, date2));
									double loiNhuan = quanLyHoaDon.tinhLaiTheoHoaDon(date1, date2)
											- quanLyNhanVien.tongLuong(date1, date2);
									if (loiNhuan < 0) {
										System.out.println("Lo: " + loiNhuan);
									}
									if (loiNhuan == 0) {
										System.out.println("Hoa von!");
									}
									if (loiNhuan > 0) {
										System.out.println("Lai: " + loiNhuan);
									}
								}else {
									throw new Exception();
								}
								
							} catch (Exception e) {
								System.out.println("Ban da nhap sai xin vui long nhap lai!");
							}
						case 14:
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
