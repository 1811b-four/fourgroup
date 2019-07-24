package com.jk.bo;


import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GoodsBo implements Serializable {

	private BigDecimal seckillPrice;

	private Integer stockCount;

	private Date startDate;

	private Date endDate;

	private Long id;

	private String goodsName;

	private String goodsTitle;

	private String goodsImg;

	private BigDecimal goodsPrice;

	private Integer goodsStock;

	private Date createDate;

	private Date updateDate;

	private String goodsDetail;

	private int miaoshaStatus = 0;
	private int remainSeconds = 0;

}
