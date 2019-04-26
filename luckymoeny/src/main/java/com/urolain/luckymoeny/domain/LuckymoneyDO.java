package com.urolain.luckymoeny.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 红包实体类
 */

@Entity
@Table(name = "luckymoney_record")
public class LuckymoneyDO {

    /**
     * id 主键
     * GeneratedValue定义主键自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 发送者
     */
    @Column
    private Long sender;

    /**
     * 领取者
     */
    @Column
    private Long Recipient;

    /**
     * 金额
     */
    @Column
    private BigDecimal money;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSender() {
        return sender;
    }

    public void setSender(Long sender) {
        this.sender = sender;
    }

    public Long getRecipient() {
        return Recipient;
    }

    public void setRecipient(Long recipient) {
        Recipient = recipient;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
