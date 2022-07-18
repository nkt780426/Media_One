package model;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLyHoaDon {
	private QuanLySanPham quanLySanPham;
	ArrayList<HoaDon> hoaDons = new ArrayList<>();
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	Scanner sc = new Scanner(System.in);

	public void muaHang(KhachHang khachHang) {
		try {
			System.out.println("Nhap ngay mua theo định dạng (dd/MM/yyyy) : ");
			Date date = df.parse(sc.nextLine());
			System.out.println("Nhap loai san pham muon mua (sach=1),(dianhac=2),(diaphim=3): ");
			int a = sc.nextInt();
			if (a == 1) {
				System.out.println("Ma san pham: ");
				String ma1 = sc.nextLine();
				if (quanLySanPham.getDsSach().containsKey(ma1)) {
					System.out.println("Nhap so luong: ");
					int so = sc.nextInt();
					if (so <= quanLySanPham.getDsSach().get(ma1).getSoLuong()) {
						quanLySanPham.getDsSach().get(ma).getSoLuong() -= so;
						HoaDon don = new HoaDon(khachHang, ma1, date, so);
						hoaDons.add(don);
					} else {
						System.out.println("Khong co du hang!");
					}
				} else {
					if (a == 2) {
						System.out.println("Ma san pham: ");
						String ma2 = sc.nextLine();
						System.out.println("Nhap so luong: ");
						int so = sc.nextInt();
						if (so <= quanLySanPham.getDsSach().get(ma2).getSoLuong()) {
							quanLySanPham.getDsDiaNhac().get(ma2).getSoLuong() -= so;
							HoaDon don = new HoaDon(khachHang, ma2, date, so);
							hoaDons.add(don);
						} else {
							System.out.println("Khong co du hang!");
						}
					} else {
						if (a == 3) {
							System.out.println("Ma san pham: ");
							String ma3 = sc.nextLine();
							System.out.println("Nhap so luong: ");
							int so = sc.nextInt();
							if (so <= quanLySanPham.getDsDiaNhac().get(ma3).getSoLuong()) {
								quanLySanPham.getDsDiaPhim().get(ma3).getSoLuong() -= so;
								HoaDon don = new HoaDon(khachHang, ma3, date, so);
							} else {
								System.out.println("Khong co du hang!");
							}
						} else {
							System.out.println("Ban da nhap sai vui long nhap lai!");
						}
					}
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Ban da nhap sai xin vui long nhap lai!");
		} catch (ParseException e) {
			System.out.println("Ban da nhap sai dinh dang ngay xin vui long nhap lai!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public double tinhDoanhThu(Date date1, Date date2) {
		double doanhThu = 0;
		try {
			for (HoaDon hoaDon : hoaDons) {
				if (hoaDon.getNgayMua().compareTo(date1) >= 0 && hoaDon.getNgayMua().compareTo(date2) <= 0) {
					doanhThu += hoaDon.getDonXuat().getGiaBan();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return doanhThu;
	}

	public double tinhLai(Date date1, Date date2) {
		double lai = 0;
		try {
			for (HoaDon hoaDon : hoaDons) {
				if (hoaDon.getNgayMua().compareTo(date1) >= 0 && hoaDon.getNgayMua().compareTo(date2) <= 0) {
					lai += hoaDon.getDonXuat().getGiaBan() - hoaDon.getDonNhap().getGiaBuon();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lai;
	}
}
