package cc.duduhuo.jpa.jpatest.m1;

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/12/8 18:09
 * Description:
 * Remarks:
 * =======================================================
 */
public class ModuleWithOther extends Module {
    private String o1;
    private Double o2;

    public ModuleWithOther() {
    }

    public ModuleWithOther(Module module) {
        this.setModuleId(module.getModuleId());
        // this.setOther(module.getOther());
        this.setOtherId(module.getOtherId());
        this.setM1(module.getM1());
        this.setM2(module.getM2());
        this.setM3(module.getM3());
    }

    public ModuleWithOther(Module module, Other other) {
        this.setModuleId(module.getModuleId());
        // this.setOther(module.getOther());
        this.setOtherId(module.getOtherId());
        this.setM1(module.getM1());
        this.setM2(module.getM2());
        this.setM3(module.getM3());
        this.setO1(other.getO1());
        this.setO2(other.getO2());
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
