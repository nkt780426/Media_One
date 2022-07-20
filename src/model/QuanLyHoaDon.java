package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLyHoaDon {
	private QuanLySanPham quanLySanPham;
	private QuanLyNhanVien quanLyNhanVien;
	private ArrayList<HoaDonXuat> xuat = new ArrayList<>();
	private ArrayList<HoaDonNhap> nhap = new ArrayList<>();
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	public String header1 = String.format("%4s%15s%10s%8s%25s%20s", "Ma Khach Hang", "Ten", "Ma san pham", "So Luong",
			"Ngay Mua", "Gia Ban");
	public String header2 = String.format("%4s%15s%6s%15s%15s%25s", "Ma Khach Hang", "Ten", "Ma san pham", "So Luong",
			"Ngay Mua", "Gia Buon");
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
			e.printStackTrace();
		}
		return null;
	}

	// xuat toan bo hoa don xuat
	public void xuatToanBoHoaDonXuat() {
		System.out.println(header1);
		for (HoaDonXuat hoaDonXuat : xuat) {
			String row = String.format("%4s%15s%10%8s%25s%20s", hoaDonXuat.getKhachHang().getMaKh(),
					hoaDonXuat.getKhachHang().getTen(), hoaDonXuat.getMaSanPham(), hoaDonXuat.getSoLuong(),
					hoaDonXuat.getNgayMua(), hoaDonXuat.getGiaBan());
			System.out.println(row);
		}
	}

	// xuat toan bo hoa don nhap
	public void xuatToanBoHoaDonNhap() {
		System.out.println(header2);
		for (HoaDonNhap hoaDonNhap : nhap) {
			String row = String.format("%4s%15s%10%8s%25s%20s", hoaDonNhap.getKhachHang().getMaKh(),
					hoaDonNhap.getKhachHang().getTen(), hoaDonNhap.getMaSanPham(), hoaDonNhap.getSoLuong(),
					hoaDonNhap.getNgayMua(), hoaDonNhap.getGiaBuon());
			System.out.println(row);
		}
	}

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
	public void tinhLai() {
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
						+ tinhDoanhThu(date1, date2));
				double loiNhuan = tinhLaiTheoHoaDon(date1, date2)
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
	}
}
