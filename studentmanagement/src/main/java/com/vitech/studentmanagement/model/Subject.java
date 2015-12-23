package com.vitech.studentmanagement.model;

public class Subject {

	private String maMH;
	private String tenMH;
	private int soTinChi;
	private int nam;
	private int hocKy;

	public Subject(){
		
	}
	
	public Subject(String maMH, String tenMH, int soTinChi, int nam, int hocKy) {
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.soTinChi = soTinChi;
		this.nam = nam;
		this.hocKy = hocKy;
	}

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public int getSoTinChi() {
		return soTinChi;
	}

	public void setSoTinChi(int soTinChi) {
		this.soTinChi = soTinChi;
	}

	public int getNam() {
		return nam;
	}

	public void setNam(int nam) {
		this.nam = nam;
	}

	public int getHocKy() {
		return hocKy;
	}

	public void setHocKy(int hocKy) {
		this.hocKy = hocKy;
	}
}
