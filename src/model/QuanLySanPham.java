package model;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class QuanLySanPham {
	private HashMap<String, Sach> dsSach= new HashMap<String, Sach>();
	private HashMap<String, DiaNhac> dsDiaNhac= new HashMap<String, DiaNhac>();
	private HashMap<String, DiaPhim> dsDiaPhim= new HashMap<String, DiaPhim>();
	Scanner sc = new Scanner(System.in);
	public HashMap<String, Sach> getDsSach() {
		return dsSach;
	}
	public void setDsSach(HashMap<String, Sach> dsSach) {
		this.dsSach = dsSach;
	}
	public HashMap<String, DiaNhac> getDsDiaNhac() {
		return dsDiaNhac;
	}
	public void setDsDiaNhac(HashMap<String, DiaNhac> dsDiaNhac) {
		this.dsDiaNhac = dsDiaNhac;
	}
	public HashMap<String, DiaPhim> getDsDiaPhim() {
		return dsDiaPhim;
	}
	public void setDsDiaPhim(HashMap<String, DiaPhim> dsDiaPhim) {
		this.dsDiaPhim = dsDiaPhim;
	}
	//1.Kiem tra ma san pham có tồn tại không tra ve true neu ton tai
	public boolean maTonTai(String s) {
		if (dsSach.containsKey(s)) {
			return true;
		}
		if(dsDiaNhac.containsKey(s)) {
			return true;
		}
		if(dsDiaPhim.containsKey(s)) {
			return true;
		}
		return false;
	}
	//2.Tim kiem san pham theo ma (ham nay khong kiem tra no co ton tai hay khong luc lam ham mian phai chu y
	public SanPham timKiemTheoMa(String s) {
		if(maTonTai(s)) {
			if(dsSach.containsKey(s)) {
				SanPham sanPham=dsSach.get(s);
				return sanPham;
			}
			if(dsDiaNhac.containsKey(s)) {
				SanPham sanPham=dsDiaNhac.get(s);
				return sanPham;
			}
			if(dsDiaPhim.containsKey(s)) {
				SanPham sanPham=dsDiaPhim.get(s);
				return sanPham;
			}
		}else {
			System.out.println("Ma san pham khong ton tai!");
			return null;
		}
		return null;
	}
	//them san pham: nguoi dung lua chon them sach hoac them dia phim hoac them dia nhac
	public void themSanPham(){
		System.out.println("1.Them  sach ");
		System.out.println("2.Them dia phim ");
		System.out.println("3.Them dia nhac ");
		try {
			int luachon = sc.nextInt();
			switch (luachon) {
			case 1:
				themSach();
				break;
			case 2:
				themDiaPhim();
				break;
			case 3:
				themDiaNhac();
				break;
					default:
				break;
			}
		}  catch (InputMismatchException ei) {
			System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}		
	public void themSach() {
		System.out.println("Nhap thong tin san pham: ");
		try {
			System.out.println("Ma san pham" );
			String maSp = sc.nextLine();
			
			System.out.println("Ten san pham: ");
			String tenSP = sc.nextLine();
			
			
			System.out.println("Nam phat hanh: ");
			int namPhatHanh = sc.nextInt();
			
			System.out.println("Gia buon: ");
			double giaBuon = sc.nextDouble();
			
			System.out.println("Gia ban: ");
			double giaBan = sc.nextDouble();
			
			System.out.println("So luong: ");
			int soLuong = sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("Nha xuat ban: ");
			String nhaXuatBan = sc.nextLine();
			
			System.out.println("Tac gia: ");
			String tacGia = sc.nextLine();
			
			Sach sach = new Sach(maSp, tenSP, namPhatHanh, soLuong, giaBuon, giaBan, tacGia, nhaXuatBan);
			this.dsSach.put(maSp, sach);
		} catch (InputMismatchException ei) {
			System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public void themDiaPhim() {
		System.out.println("Nhap thong tin san pham: ");
		try {
			System.out.println("Ma san pham" );
			String maSp = sc.nextLine();
			
			System.out.println("Ten san pham: ");
			String tenSP = sc.nextLine();
			
			System.out.println("Nam phat hanh: ");
			int namPhatHanh = sc.nextInt();
			
			System.out.println("Gia buon: ");
			double giaBuon = sc.nextDouble();
			
			System.out.println("Gia ban: ");
			double giaBan = sc.nextDouble();
			
			System.out.println("So luong: ");
			int soLuong = sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("Dao dien: ");
			String daoDien = sc.nextLine();
			
			System.out.println("Dien vien: ");
			String dienVien = sc.nextLine();

			DiaPhim diaPhim = new DiaPhim(maSp, tenSP, namPhatHanh, soLuong, tenSP, giaBuon, giaBan, soLuong, daoDien, dienVien);
			this.dsDiaPhim.put(maSp, diaPhim);
			
		} catch (InputMismatchException ei) {
			System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public void themDiaNhac() {
		System.out.println("Nhap thong tin san pham: ");
		try {
			System.out.println("Ma san pham" );
			String maSp = sc.nextLine();
			
			System.out.println("Ten san pham: ");
			String tenSP = sc.nextLine();
					
			System.out.println("Nam phat hanh: ");
			int namPhatHanh = sc.nextInt();
			
			System.out.println("Gia buon: ");
			double giaBuon = sc.nextDouble();
			
			System.out.println("Gia ban: ");
			double giaBan = sc.nextDouble();
			
			System.out.println("So luong: ");
			int soLuong = sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("Ca sy: ");
			String caSy = sc.nextLine();
			
			System.out.println("Tac gia: ");
			String tacGia = sc.nextLine();
			
			DiaNhac diaNhac = new DiaNhac(maSp, tenSP, namPhatHanh, soLuong, giaBuon, giaBan, soLuong, caSy, tacGia);
			this.dsDiaNhac.put(maSp, diaNhac);
		} catch (InputMismatchException ei) {
			System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public void xoaSanPham() {
		try {
			System.out.println("Nhap ma san pham: ");
			String maSp = sc.nextLine();
			if(maTonTai(maSp)) {
				SanPham sanPham = timKiemTheoMa(maSp);
				if(sanPham instanceof Sach) {
					dsSach.remove(maSp);
				}
				if(sanPham instanceof DiaPhim) {
					dsDiaPhim.remove(maSp);
				}
				if(sanPham instanceof DiaNhac) {
					dsDiaNhac.remove(maSp);
				}						
			}else  {
				System.out.println(" San pham khong ton tai");
			}		
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
	public void capNhatThongTinSanPham() {
		xoaSanPham();
		themSanPham();
	}
 	public void hienThiToanBoSanPham() {
		System.out.println("1.Hien thi  sach ");
		System.out.println("2.Hien thi dia phim ");
		System.out.println("3.Hien thi dia nhac ");
		try {
			int luachon = sc.nextInt();
			switch (luachon) {
			case 1:
				hienThiSach();
				break;
			case 2:
				hienThiDiaPhim();
				break;
			case 3:
				hienThiDiaNhac();
				break;
					default:
				break;
			}
		}  catch (InputMismatchException ei) {
			System.out.println("Ban da nhap sai gia tri, xin vui long nhap lai");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public void  hienThiSach() {
		System.out.println("Danh sach san pham");
		String  header = String.format("%s%15s%30s%15s%15s%15s%15s%15s", "Ma san pham" +"Ten san pham"+"Nam phat hanh"+"So luong"+"Gia buon"+"Gia ban"+"Tac gia"+"Nha xuat ban");
		System.out.println(header);
		for (Map.Entry<String, Sach> entry : dsSach.entrySet()) {
			String row = String.format("%s%15s%30s%15s%15s%15s%15s%15s",entry.getValue().getMaSp(),entry.getValue().getTenSp(),entry.getValue().getNamPhatHanh(), entry.getValue().getSoLuong(), entry.getValue().getGiaBuon(), entry.getValue().getGiaBan(), entry.getValue().getTacGia(), entry.getValue().getNhaXuatBan() );
			System.out.println(row);
		}
	}
	public void hienThiDiaPhim() {
		System.out.println("Danh sach san pham");
		String  header = String.format("%s%15s%30s%15s%15s%15s%15s%15s", "Ma san pham" +"Ten san pham"+"Nam phat hanh"+"So luong"+"Gia buon"+"Gia ban"+"Dao dien"+"Dien vien");
		System.out.println(header);
		for (Map.Entry<String, DiaPhim> entry : dsDiaPhim.entrySet()) {
			String row = String.format("%s%15s%30s%15s%15s%15s%15s%15s",entry.getValue().getMaSp(),entry.getValue().getTenSp(),entry.getValue().getNamPhatHanh(), entry.getValue().getSoLuong(), entry.getValue().getGiaBuon(), entry.getValue().getGiaBan(), entry.getValue().getDaoDien(), entry.getValue().getDienVien() );
			System.out.println(row);
		}
	}
	public void hienThiDiaNhac() {
		System.out.println("Danh sach san pham");
		String  header = String.format("%s%15s%30s%15s%15s%15s%15s%15s", "Ma san pham" +"Ten san pham"+"Nam phat hanh"+"So luong"+"Gia buon"+"Gia ban"+"Ca sy"+"Danh sach bai hat");
		System.out.println(header);
		for (Map.Entry<String, DiaNhac> entry : dsDiaNhac.entrySet()) {
			String row = String.format("%s%15s%30s%15s%15s%15s%15s%15s",entry.getValue().getMaSp(),entry.getValue().getTenSp(),entry.getValue().getNamPhatHanh(), entry.getValue().getSoLuong(), entry.getValue().getGiaBuon(), entry.getValue().getGiaBan(), entry.getValue().getCaSy(), entry.getValue().getDanhsachBaiHat() );
			System.out.println(row);
		}
	}

	public void hienThiThongTinSanPham() {
		try {
			System.out.println("Nhap ma san pham: ");
			String maSp = sc.nextLine();
			if(maTonTai(maSp)) {
				SanPham sanPham = timKiemTheoMa(maSp);
				if(sanPham instanceof Sach) {
					Sach sach = this.dsSach.get(maSp);
					String  header = String.format("%s%15s%30s%15s%15s%15s%15s%15s", "Ma san pham" +"Ten san pham"+"Nam phat hanh"+"So luong"+"Gia buon"+"Gia ban"+"Tac gia"+"Nha xuat ban");
					System.out.println(header);
					String row = String.format("%s%15s%30s%15s%15s%15s%15s%15s", sach.getMaSp(), sach.getTenSp(), sach.getNamPhatHanh(), sach.getSoLuong(), sach.getGiaBuon(), sach.getGiaBan(), sach.getTacGia(), sach.getNhaXuatBan());
                    System.out.println(row);
				}
				if(sanPham instanceof DiaPhim) {
					DiaPhim diaPhim  = this.dsDiaPhim.get(maSp);
					String  header = String.format("%s%15s%30s%15s%15s%15s%15s%15s", "Ma san pham" +"Ten san pham"+"Nam phat hanh"+"So luong"+"Gia buon"+"Gia ban"+"Dao dien"+"Dien vien");
					System.out.println(header);
					String row = String.format("%s%15s%30s%15s%15s%15s%15s%15s", diaPhim.getMaSp(), diaPhim.getTenSp(), diaPhim.getNamPhatHanh(), diaPhim.getSoLuong(), diaPhim.getGiaBuon(), diaPhim.getGiaBan(), diaPhim.getDaoDien(), diaPhim.getDienVien());
                    System.out.println(row);
				}
				if(sanPham instanceof DiaNhac) {
					DiaNhac diaNhac  = this.dsDiaNhac.get(maSp);
					String  header = String.format("%s%15s%30s%15s%15s%15s%15s%15s", "Ma san pham" +"Ten san pham"+"Nam phat hanh"+"So luong"+"Gia buon"+"Gia ban"+"Ca sy"+"Danh sach bai hat");
					System.out.println(header);
					String row = String.format("%s%15s%30s%15s%15s%15s%15s%15s", diaNhac.getMaSp(), diaNhac.getTenSp(), diaNhac.getNamPhatHanh(), diaNhac.getSoLuong(), diaNhac.getGiaBuon(), diaNhac.getGiaBan(), diaNhac.getCaSy(), diaNhac.getDanhsachBaiHat());
                    System.out.println(row);
								}						
			}else  {
				System.out.println(" San pham khong ton tai");
			}		
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
}
