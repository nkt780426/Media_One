package model;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLyHoaDon {
	private QuanLySanPham quanLySanPham;
	ArrayList<HoaDonXuat> xuat = new ArrayList<>();
	ArrayList<HoaDonNhap> nhap = new ArrayList<>();
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	Scanner sc = new Scanner(System.in);

	public HoaDonXuat muaHang(KhachHang khachHang) {
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
						HoaDonNhap donNhap = new HoaDonNhap(khachHang, ma1, date, so, String.valueOf(quanLySanPham.getDsSach().get(ma1).getGiaBuon()));
						nhap.add(donNhap);
						HoaDonXuat donXuat = new HoaDonXuat(khachHang, ma1, date, so, String.valueOf(quanLySanPham.getDsSach().get(ma1).getGiaBan()));
						xuat.add(donXuat);
						return donXuat;
					} else {
						System.out.println("Khong co du hang!");
					}
				}else {
					System.out.println("Ma san pham khong ton tai!");
					return null;
				}
			}else {
				if(a==2) {
					System.out.println("Ma san pham: ");
					String ma2 = sc.nextLine();
					if (quanLySanPham.getDsDiaNhac().containsKey(ma2)) {
						System.out.println("Nhap so luong: ");
						int so = sc.nextInt();
						if (so <= quanLySanPham.getDsDiaNhac().get(ma2).getSoLuong()) {
							quanLySanPham.getDsDiaNhac().get(ma).getSoLuong() -= so;
							HoaDonNhap donNhap = new HoaDonNhap(khachHang, ma2, date, so, String.valueOf(quanLySanPham.getDsDiaNhac().get(ma2).getGiaBuon()));
							nhap.add(donNhap);
							HoaDonXuat donXuat = new HoaDonXuat(khachHang, ma2, date, so, String.valueOf(quanLySanPham.getDsDiaNhac().get(ma2).getGiaBan()));
							xuat.add(donXuat);
							return donXuat;
						} else {
							System.out.println("Khong co du hang!");
						}
					}else {
						System.out.println("Ma san pham khong ton tai!");
						return null;
					}
				}else {
					if(a==3) {
						System.out.println("Ma san pham: ");
						String ma3 = sc.nextLine();
						if (quanLySanPham.getDsDiaPhim().containsKey(ma3)) {
							System.out.println("Nhap so luong: ");
							int so = sc.nextInt();
							if (so <= quanLySanPham.getDsDiaPhim().get(ma3).getSoLuong()) {
								quanLySanPham.getDsDiaPhim().get(ma).getSoLuong() -= so;
								HoaDonNhap donNhap = new HoaDonNhap(khachHang, ma3, date, so, String.valueOf(quanLySanPham.getDsDiaPhim().get(ma3).getGiaBuon()));
								nhap.add(donNhap);
								HoaDonXuat donXuat = new HoaDonXuat(khachHang, ma3, date, so, String.valueOf(quanLySanPham.getDsDiaPhim().get(ma3).getGiaBan()));
								xuat.add(donXuat);
								return donXuat;
							} else {
								System.out.println("Khong co du hang!");
							}
						}else {
							System.out.println("Ma san pham khong ton tai!");
							return null;
						}
					}else {
						System.out.println("Ban da nhap sai gia tri vui long nhap lai!");
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
			for (HoaDonXuat hoaDonXuat : xuat) {
				if(hoaDonXuat.getNgayMua().compareTo(date1)>=0&& hoaDonXuat.getNgayMua().compareTo(date2)<=0) {
					doanhThu+=Double.parseDouble(hoaDonXuat.getGiaBan());
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
			for (HoaDonNhap hoaDonNhap : nhap) {
				if(hoaDonNhap.getNgayMua().compareTo(date1)>=0&& hoaDonNhap.getNgayMua().compareTo(date2)<=0) {
					lai+=Double.parseDouble(hoaDonNhap.getGiaBuon());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tinhDoanhThu(date1, date2)-lai;
	}
}
