package com.yogiyo.review.dto;

import lombok.Data;

/**
 * 리뷰의 페이지 처리를 담당한다
 * @author wooni
 *
 */
@Data
public class ReviewPagination {

	   private int rowsPerPage = 4;      // 한 화면에 표시할 데이터의 갯수         
	   private int pagesPerBlock = 5;    // 한 화면에 표시할 페이지번호의 갯수      
	   private int pageNo;               // 현재 페이지 번호                    
	   private int totalRows;            // 총 데이터 갯수                  
	   private int totalPages;           // 총 페이지 갯수                  
	   
	   public ReviewPagination(int pageNo, int totalRows) {
	      this.pageNo = pageNo;
	      this.totalRows = totalRows;
	      init();
	   }
	   
	   public ReviewPagination(int pageNo, int totalRows, int rowsPerPage) {
	      this.pageNo = pageNo;
	      this.totalRows = totalRows;
	      this.rowsPerPage = rowsPerPage;
	      init();
	   }

	   public ReviewPagination(int pageNo, int totalRows, int rowsPerPage, int pagesPerBlock) {
	      this.pageNo = pageNo;
	      this.totalRows = totalRows;
	      this.rowsPerPage = rowsPerPage;
	      this.pagesPerBlock = pagesPerBlock;
	      init();
	   }
	   
	   private void init() {
	      // 총 페이지 갯수
	      this.totalPages = (int) (Math.ceil((double) totalRows/rowsPerPage));
	      if (pageNo <= 0 || pageNo > totalPages) {
	         pageNo = 1;
	      }
	   } 
}
