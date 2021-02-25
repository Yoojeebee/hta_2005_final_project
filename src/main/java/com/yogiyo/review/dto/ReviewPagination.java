package com.yogiyo.review.dto;

import lombok.Data;

@Data
public class ReviewPagination {

	   private int rowsPerPage = 4;      // 한 화면에 표시할 데이터의 갯수         10
	   private int pagesPerBlock = 5;    // 한 화면에 표시할 페이지번호의 갯수      5
	   private int pageNo;               // 현재 페이지 번호                    8
	   private int blockNo;              // 현재 블록번호                      2
	   private int totalRows;            // 총 데이터 갯수                  123
	   private int totalPages;           // 총 페이지 갯수                  13
	   private int totalBlocks;          // 총 블록 갯수                     3
	   private int beginPage;            // 블록 시작 페이지번호               6
	   private int endPage;              // 블록 끝 페이지번호               10
	   
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
	      // 총 블록 갯수
	      this.totalBlocks = (int) (Math.ceil((double) totalPages/pagesPerBlock));
	      // 현재 페이지번호가 잘못된 값인 경우 무조건 현재 페이지번호를 1로 한다.
	      if (pageNo <= 0 || pageNo > totalPages) {
	         pageNo = 1;
	      }
	      // 현재 페이지번호가 속한 블록번호
	      blockNo = (int) (Math.ceil((double) pageNo/pagesPerBlock));
	      // 시작 페이지 번호
	      beginPage = (blockNo - 1)*pagesPerBlock + 1;
	      // 끝 페이지 번호
	      endPage = blockNo*pagesPerBlock;
	      if (blockNo == totalBlocks) {   // 맨마지막 블록인 경우
	         endPage = totalPages;      // 블록 끝 페이지번호를 총 페이지 갯수로 설정한다.
	      }
	   } 
}
