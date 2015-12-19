package com.vitech.studentmanagement.model;

public class NhiemVu {

	private String maNhiemVu;
	private String tenNhiemVu;

	public NhiemVu(String maNhiemVu, String tenNhiemVu) {
		this.maNhiemVu = maNhiemVu;
		this.tenNhiemVu = tenNhiemVu;
	}

	public String getMaNhiemVu() {
		return maNhiemVu;
	}

	public void setMaNhiemVu(String maNhiemVu) {
		this.maNhiemVu = maNhiemVu;
	}

	public String getTenNhiemVu() {
		return tenNhiemVu;
	}

	public void setTenNhiemVu(String tenNhiemVu) {
		this.tenNhiemVu = tenNhiemVu;
	}
}
