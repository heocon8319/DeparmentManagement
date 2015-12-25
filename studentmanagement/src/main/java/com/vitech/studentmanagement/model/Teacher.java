package com.vitech.studentmanagement.model;

public class Teacher {

	private String maNv;
	private String tenNv;
	private String namSinh;
	private String gioiTinh;
	private String diaChi;
	private String soDienThoai;
	private int luong;
	private int phuCap;
	private String quanHe;
	private String maNhiemVu;

	public Teacher() {

	}

	public String getMaNv() {
		return maNv;
	}

	public void setMaNv(String maNv) {
		this.maNv = maNv;
	}

	public String getTenNv() {
		return tenNv;
	}

	public void setTenNv(String tenNv) {
		this.tenNv = tenNv;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public int getLuong() {
		return luong;
	}

	public void setLuong(int luong) {
		this.luong = luong;
	}

	public int getPhuCap() {
		return phuCap;
	}

	public void setPhuCap(int phuCap) {
		this.phuCap = phuCap;
	}

	public String getQuanHe() {
		return quanHe;
	}

	public void setQuanHe(String quanHe) {
		this.quanHe = quanHe;
	}

	public String getMaNhiemVu() {
		return maNhiemVu;
	}

	public void setMaNhiemVu(String maNhiemVu) {
		this.maNhiemVu = maNhiemVu;
	}

	public Teacher(String maNv, String tenNv, String namSinh, String gioiTinh,
			String diaChi, String soDienThoai, int luong, int phuCap,
			String quanHe, String maNhiemVu) {
		this.maNv = maNv;
		this.tenNv = tenNv;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.luong = luong;
		this.phuCap = phuCap;
		this.quanHe = quanHe;
		this.maNhiemVu = maNhiemVu;
	}

}
