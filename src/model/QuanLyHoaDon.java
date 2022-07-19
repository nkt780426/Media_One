package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLyHoaDon {
	private QuanLySanPham quanLySanPham;
	private ArrayList<HoaDonXuat> xuat = new ArrayList<>();
	private ArrayList<HoaDonNhap> nhap = new ArrayList<>();
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	Scanner sc = new Scanner(System.in);

	public ArrayList<HoaDonXuat> getXuat() {
		return xuat;
	}

	public void setXuat(ArrayList<HoaDonXuat> xuat) {
		this.xuat = xuat;
	}

	public ArrayList<HoaDonNhap> getNhap() {
		return nhap;
	}

	public void setNhap(ArrayList<HoaDonNhap> nhap) {
		this.nhap = nhap;
	}

	// mua hang
	public HoaDonXuat muaHang(KhachHang khachHang) {
		try {
			System.out.println("Nhap ngay mua theo định dạng (dd/MM/yyyy) : ");
			Date date = df.parse(sc.nextLine());
			System.out.println("Nhap ma san pham: ");
			String ma = sc.nextLine();
			if (quanLySanPham.timKiemTheoMa(ma) == null) {
				System.out.println("Ma san pham khong ton tai!");
			} else {
				SanPham sanPham = quanLySanPham.timKiemTheoMa(ma);
				if (sanPham instanceof Sach) {
					Sach sach = (Sach) sanPham;
					System.out.println("Nhap so luong muon mua: ");
					int soLuong = sc.nextInt();
					if (soLuong > sach.getSoLuong()) {
						System.out.println("Khong du hang!");
					} else {
						int a = sach.getSoLuong();
						sach.setSoLuong(a - soLuong);
						HoaDonNhap donNhap = new HoaDonNhap(khachHang, ma, date, soLuong,
								String.valueOf(quanLySanPham.getDsSach().get(ma).getGiaBuon()));
						nhap.add(donNhap);
						HoaDonXuat donXuat = new HoaDonXuat(khachHang, ma, date, soLuong,
								String.valueOf(quanLySanPham.getDsSach().get(ma).getGiaBan()));
						xuat.add(donXuat);
						return donXuat;
					}
				}
				if (sanPham instanceof DiaPhim) {
					DiaPhim diaPhim = (DiaPhim) sanPham;
					System.out.println("Nhap so luong muon mua: ");
					int soLuong = sc.nextInt();
					if (soLuong > diaPhim.getSoLuong()) {
						System.out.println("Khong du hang!");
					} else {
						int a = diaPhim.getSoLuong();
						diaPhim.setSoLuong(a - soLuong);
						HoaDonNhap donNhap = new HoaDonNhap(khachHang, ma, date, soLuong,
								String.valueOf(quanLySanPham.getDsDiaPhim().get(ma).getGiaBuon()));
						nhap.add(donNhap);
						HoaDonXuat donXuat = new HoaDonXuat(khachHang, ma, date, soLuong,
								String.valueOf(quanLySanPham.getDsDiaPhim().get(ma).getGiaBan()));
						xuat.add(donXuat);
						return donXuat;
					}
				}
				if (sanPham instanceof DiaNhac) {
					DiaNhac diaNhac = (DiaNhac) sanPham;
					System.out.println("Nhap so luong muon mua: ");
					int soLuong = sc.nextInt();
					if (soLuong > diaNhac.getSoLuong()) {
						System.out.println("Khong du hang!");
					} else {
						int a = diaNhac.getSoLuong();
						diaNhac.setSoLuong(a - soLuong);
						HoaDonNhap donNhap = new HoaDonNhap(khachHang, ma, date, soLuong,
								String.valueOf(quanLySanPham.getDsDiaNhac().get(ma).getGiaBuon()));
						nhap.add(donNhap);
						HoaDonXuat donXuat = new HoaDonXuat(khachHang, ma, date, soLuong,
								String.valueOf(quanLySanPham.getDsDiaNhac().get(ma).getGiaBan()));
						xuat.add(donXuat);
						return donXuat;
					}
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Ban da nhap sai xin vui long nhap lai!");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	// xuat toan bo hoa don xuat

	// xuat toan bo hoa don nhap

	// tinhDoanhThu
	public double tinhDoanhThu(Date date1, Date date2) {
		double doanhThu = 0;
		try {
			for (HoaDonXuat hoaDonXuat : xuat) {
				if (hoaDonXuat.getNgayMua().compareTo(date1) >= 0 && hoaDonXuat.getNgayMua().compareTo(date2) <= 0) {
					doanhThu += Double.parseDouble(hoaDonXuat.getGiaBan());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return doanhThu;
	}

	// TinhLaitheohoadon
	public double tinhLaiTheoHoaDon(Date date1, Date date2) {
		double lai = 0;
		try {
			for (HoaDonNhap hoaDonNhap : nhap) {
				if (hoaDonNhap.getNgayMua().compareTo(date1) >= 0 && hoaDonNhap.getNgayMua().compareTo(date2) <= 0) {
					lai += Double.parseDouble(hoaDonNhap.getGiaBuon());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tinhDoanhThu(date1, date2) - lai;
	}
}
