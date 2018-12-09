package cc.duduhuo.jpa.jpatest.m1;

import javax.persistence.*;
import java.io.Serializable;

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/12/8 18:10
 * Description:
 * Remarks:
 * =======================================================
 */
@Entity
@Table(name = "t_other")
public class Other implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long otherId;

    private String o1;

    private Double o2;

    public Long getOtherId() {
        return otherId;
    }

    public void setOtherId(Long otherId) {
        this.otherId = otherId;
    }

    public String getO1() {
        return o1;
    }

    public void setO1(String o1) {
        this.o1 = o1;
    }

    public Double getO2() {
        return o2;
    }

    public void setO2(Double o2) {
        this.o2 = o2;
    }
}
