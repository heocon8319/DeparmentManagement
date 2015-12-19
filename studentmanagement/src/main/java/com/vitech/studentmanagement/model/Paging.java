package com.vitech.studentmanagement.model;

import com.vitech.studentmanagement.utility.Utilities;

public class Paging {

	//amount of rows in database;
	private int totalRow;
	//total page of above rows; 
	private int totalPage;
	//current index;
	private int currentIndex;
	//amount of rows per page;
	private int rowPerPage = Utilities.ROWS_PER_PAGE;

	public Paging(int totalRow){
		this.totalRow = totalRow;
		this.totalPage = this.totalRow / this.rowPerPage;
		if(this.totalRow % this.rowPerPage != 0){
			this.totalPage+=1;
		}
	}
	
	public int startIndex(){
		return (this.currentIndex-1) * this.rowPerPage;
	}
	
	public int getTotalRow() {
		return totalRow;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public int getRowPerPage() {
		return rowPerPage;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
}
