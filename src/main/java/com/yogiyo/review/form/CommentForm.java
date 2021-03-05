package com.yogiyo.review.form;

import lombok.Data;

/**
 * 사장의 코멘트를 작성할때 받아오는 값
 * @author wooni
 *
 */
@Data
public class CommentForm {

	private String ownerNo;
	private String ownerComment;
}
