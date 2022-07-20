package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class QuanLyHoaDon {
	private QuanLyKhachHang quanLyKhachHang;
	private QuanLySanPham quanLySanPham;
	private QuanLyNhanVien quanLyNhanVien;
	private ArrayList<HoaDonXuat> xuat = new ArrayList<>();
	private ArrayList<HoaDonNhap> nhap = new ArrayList<>();
	public String header1 = String.format("%10s%25s%20s%25s%25s%20s", "Ma Khach Hang", "Ten", "Ma san pham", "So Luong",
			"Ngay Mua", "Gia Ban");
	public String header2 = String.format("%10s%25s%20s%25s%25s%20s", "Ma Khach Hang", "Ten", "Ma san pham", "So Luong",
			"Ngay Mua", "Gia Buon");
	Scanner sc = new Scanner(System.in);

	Path p1 = Paths.get("./data/HoaDonXuat.txt");
	Path p2 = Paths.get("./data/HoaDonNhap.txt");

	public HoaDonXuat castToHoaDonXuat(String[] line) {
		try {
			DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			HoaDonXuat hdx = new HoaDonXuat(line[0], line[1], line[2], line[3], line[4], LocalDate.parse(line[5], f));
			return hdx;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public QuanLyHoaDon() throws IOException {
		ArrayList<String> khList = (ArrayList<String>) Files.readAllLines(p);

		khList.stream().forEach((e) -> {
			String[] code = e.split("::");
			//them vao danh sach
		});
	}

	private void confirmData() {
		List<String> temp = new ArrayList<>();
		for (Map.Entry<String, KhachHang> e : dsKhachHang.entrySet()) {
			temp.add(e.getValue().luuVaoData(e.getValue()));
		}
		try {
			Files.write(p, temp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// mua hang
	public HoaDonXuat muaHang(KhachHang khachHang) {
		LocalDate ngayMua;
		while (true) {
			try {
				System.out.print("Nhap Mua(dd-MM-yyyy): ");
				DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate ngayMua1 = LocalDate.parse(sc.nextLine(), df);
				ngayMua = ngayMua1;
				break;
			} catch (DateTimeParseException e) {
				System.out.println("Ngay thang nam sai dinh dang!");
			}
		}
		String maSanPham;
		while (true) {
			System.out.print("Nhap ma san pham: ");
			String maSanPham1 = sc.nextLine();
			if (quanLySanPham.timKiemTheoMa(maSanPham1) == null) {
				System.out.println("Ma san pham khong ton tai, xin vui long nhap lai!");
			} else {
				maSanPham = maSanPham1;
				break;
			}

		}
		SanPham sanPham = quanLySanPham.timKiemTheoMa(maSanPham);
		if (sanPham instanceof Sach) {
			Sach sach = (Sach) sanPham;
			int soLuong;
			while (true) {
				try {

					System.out.println("Nhap so luong muon mua: ");

					int soLuong1 = sc.nextInt();
					if (soLuong1 > sach.getSoLuong()) {
						System.out.println("Khong du hang, xin vui long nhap lai!");
					} else {
						soLuong = soLuong1;
						break;
					}
				} catch (InputMismatchException e) {
					System.out.println("Ban da nhap sai hoac so luong hang ban nhap qua lon, xin vui long nhap lai!");
				}
			}
			int a = sach.getSoLuong();
			sach.setSoLuong(a - soLuong);
			HoaDonNhap donNhap = new HoaDonNhap(khachHang, maSanPham, ngayMua, soLuong,
					String.valueOf(quanLySanPham.getDsSach().get(maSanPham).getGiaBuon()));
			nhap.add(donNhap);
			HoaDonXuat donXuat = new HoaDonXuat(khachHang, maSanPham, ngayMua, soLuong,
					String.valueOf(quanLySanPham.getDsSach().get(maSanPham).getGiaBan()));
			xuat.add(donXuat);
			return donXuat;
		}
		if (sanPham instanceof DiaPhim) {
			DiaPhim diaPhim = (DiaPhim) sanPham;
			int soLuong;
			while (true) {
				try {

					System.out.println("Nhap so luong muon mua: ");

					int soLuong1 = sc.nextInt();
					if (soLuong1 > diaPhim.getSoLuong()) {
						System.out.println("Khong du hang, xin vui long nhap lai!");
					} else {
						soLuong = soLuong1;
						break;
					}
				} catch (InputMismatchException e) {
					System.out.println("Ban da nhap sai hoac so luong hang ban nhap qua lon, xin vui long nhap lai!");
				}
			}
			int a = diaPhim.getSoLuong();
			diaPhim.setSoLuong(a - soLuong);
			HoaDonNhap donNhap = new HoaDonNhap(khachHang, maSanPham, ngayMua, soLuong,
					String.valueOf(quanLySanPham.getDsSach().get(maSanPham).getGiaBuon()));
			nhap.add(donNhap);
			HoaDonXuat donXuat = new HoaDonXuat(khachHang, maSanPham, ngayMua, soLuong,
					String.valueOf(quanLySanPham.getDsSach().get(maSanPham).getGiaBan()));
			xuat.add(donXuat);
			return donXuat;
		}
		if (sanPham instanceof DiaNhac) {
			DiaNhac diaNhac = (DiaNhac) sanPham;
			int soLuong;
			while (true) {
				try {

					System.out.println("Nhap so luong muon mua: ");

					int soLuong1 = sc.nextInt();
					if (soLuong1 > diaNhac.getSoLuong()) {
						System.out.println("Khong du hang, xin vui long nhap lai!");
					} else {
						soLuong = soLuong1;
						break;
					}
				} catch (InputMismatchException e) {
					System.out.println("Ban da nhap sai hoac so luong hang ban nhap qua lon, xin vui long nhap lai!");
				}
			}
			int a = diaNhac.getSoLuong();
			diaNhac.setSoLuong(a - soLuong);
			HoaDonNhap donNhap = new HoaDonNhap(khachHang, maSanPham, ngayMua, soLuong,
					String.valueOf(quanLySanPham.getDsSach().get(maSanPham).getGiaBuon()));
			nhap.add(donNhap);
			HoaDonXuat donXuat = new HoaDonXuat(khachHang, maSanPham, ngayMua, soLuong,
					String.valueOf(quanLySanPham.getDsSach().get(maSanPham).getGiaBan()));
			xuat.add(donXuat);
			return donXuat;
		}
	}

	// xuat toan bo hoa don xuat
	public void xuatToanBoHoaDonXuat() {
		System.out.println(header1);
		for (HoaDonXuat hoaDonXuat : xuat) {
			String row = String.format("%10s%25s%20s%25s%25s%20s", hoaDonXuat.getKhachHang().getMaKh(),
					hoaDonXuat.getKhachHang().getTen(), hoaDonXuat.getMaSanPham(), hoaDonXuat.getSoLuong(),
					hoaDonXuat.getNgayMua(), hoaDonXuat.getGiaBan());
			System.out.println(row);
		}
	}

	// xuat toan bo hoa don nhap
	public void xuatToanBoHoaDonNhap() {
		System.out.println(header2);
		for (HoaDonNhap hoaDonNhap : nhap) {
			String row = String.format("%10s%25s%20s%25s%25s%20s", hoaDonNhap.getKhachHang().getMaKh(),
					hoaDonNhap.getKhachHang().getTen(), hoaDonNhap.getMaSanPham(), hoaDonNhap.getSoLuong(),
					hoaDonNhap.getNgayMua(), hoaDonNhap.getGiaBuon());
			System.out.println(row);
		}
	}

	// tinhDoanhThu
	public double tinhDoanhThu(LocalDate date1, LocalDate date2) {
		double doanhThu = 0;
		for (HoaDonXuat hoaDonXuat : xuat) {
			if (hoaDonXuat.getNgayMua().compareTo(date1) >= 0 && hoaDonXuat.getNgayMua().compareTo(date2) <= 0) {
				doanhThu += Double.parseDouble(hoaDonXuat.getGiaBan());
			}
		}
		return doanhThu;
	}

	// TinhLaitheohoadon
	public double tinhLaiTheoHoaDon(LocalDate date1, LocalDate date2) {
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
		return tinhDoanhThu(date1, date2) - tinhLaiTheoHoaDon(date1, date2);
	}

	public void tinhLai() {
		System.out.println("------Nhap khoang thoi gian ban muon xem------");
		System.out.println("Chu y ngay 1 phai nho hon ngay 2");
		LocalDate date1;
		LocalDate date2;
		while (true) {
			try {
				System.out.println("Ngay 1 (dd-MM-yyyy) : ");
				DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate date11 = LocalDate.parse(sc.nextLine(), df);

				System.out.println("Ngay 2 (dd-MM-yyyy) : ");
				LocalDate date21 = LocalDate.parse(sc.nextLine(), df);
				if (date11.isBefore(date21)) {
					date1 = date11;
					date2 = date21;
					break;
				} else {
					System.out.println("Ngay 1 phai truoc ngay 2 vui long nhap lai!");
				}
			} catch (DateTimeParseException e) {
				System.out.println("Ngay thang nam sai dinh dang!");
			}
		}

		System.out.println();
		System.out.println("Doanh thu trong khoang thoi gian da nhap la: " + tinhDoanhThu(date1, date2));
		double loiNhuan = tinhLaiTheoHoaDon(date1, date2) - quanLyNhanVien.tongLuong(date1, date2);
		if (loiNhuan < 0) {
			System.out.println("Lo: " + loiNhuan);
		}
		if (loiNhuan == 0) {
			System.out.println("Hoa von!");
		}
		if (loiNhuan > 0) {
			System.out.println("Lai: " + loiNhuan);
		}
	}
}
