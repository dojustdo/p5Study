package com.study.rabbitmq;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className: Merchant
 * @description: 公共的消息对象 生产者，消费者使用
 * @author: dxq
 * @date: 2021/2/24
 **/
@Data
@NoArgsConstructor
public class Merchant implements Serializable {
    private String name;

    public Merchant(String name){
        this.name = name;
    }
}
