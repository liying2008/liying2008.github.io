package cc.duduhuo.multi.module.module1.po;

import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotNull;

/**
 * =======================================================
 * Author: liying - liruoer2008@yeah.net
 * Datetime: 2018/11/18 16:32
 * Description:
 * Remarks:
 * =======================================================
 */
public class Enc<T> {
    @NotNull
    private Integer code;
    @NotNull
    private String msg;
    @Nullable
    private T data;

    public Enc() {
    }

    public Enc(@NotNull Integer code, @NotNull String msg, @Nullable T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Nullable
    public T getData() {
        return data;
    }

    public void setData(@Nullable T data) {
        this.data = data;
    }
}