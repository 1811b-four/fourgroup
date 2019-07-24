package com.jk.model;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SeckillOrder implements Serializable {
    private Long id;

    private Long userId;

    private Long orderId;

    private Long goodsId;

}