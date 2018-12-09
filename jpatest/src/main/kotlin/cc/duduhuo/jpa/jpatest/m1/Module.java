package cc.duduhuo.jpa.jpatest.m1;

import javax.persistence.*;
import java.io.Serializable;

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/12/8 18:07
 * Description:
 * Remarks:
 * =======================================================
 */
@Entity
@Table(name = "t_module")
public class Module implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moduleId;

    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name = "other_id")
    // private Other other;

    private Long otherId;

    private String m1;

    private String m2;

    private Integer m3;

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    // public Other getOther() {
    //     return other;
    // }
    //
    // public void setOther(Other other) {
    //     this.other = other;
    // }


    public Long getOtherId() {
        return otherId;
    }

    public void setOtherId(Long otherId) {
        this.otherId = otherId;
    }

    public String getM1() {
        return m1;
    }

    public void setM1(String m1) {
        this.m1 = m1;
    }

    public String getM2() {
        return m2;
    }

    public void setM2(String m2) {
        this.m2 = m2;
    }

    public Integer getM3() {
        return m3;
    }

    public void setM3(Integer m3) {
        this.m3 = m3;
    }
}
