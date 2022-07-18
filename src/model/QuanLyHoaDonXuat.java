package model;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

public class QuanLyHoaDonXuat {
	Scanner sc= new Scanner(System.in);
	private TreeMap<Date, HoaDonXuat> dshoadonxuat = new TreeMap<Date, HoaDonXuat>();

	public TreeMap<Date, HoaDonXuat> getDshoadonxuat() {
		return dshoadonxuat;
	}

	public void setDshoadonxuat(TreeMap<Date, HoaDonXuat> dshoadonxuat) {
		this.dshoadonxuat = dshoadonxuat;
	}
	//mua hang
	public void themHoaDonXuat() {
		try {
			System.out.println("Nhap so loai hang dinh mua: ");
			int soLoaiHang=sc.nextInt();
			for(int i=0;i<(soLoaiHang-1);i++) {
				while(true) {
					System.out.println("Nhap ma hang muon mua: ");
					String ma=sc.nextLine();
					if (dshoadonxuat.containsKey(ma)) {
						
						break;
					}else {
						System.out.print("Ma don hang khong ton tai!");
					}
				}
			}
		}catch (InputMismatchException e) {
			System.out.println("Ban da nhap sai xin vui long nhap lai!");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
