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
			
			int a = sc.nextInt();
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
