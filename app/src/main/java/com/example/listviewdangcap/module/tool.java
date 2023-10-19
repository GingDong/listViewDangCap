package com.example.listviewdangcap.module;

import java.io.Serializable;

public class tool implements Serializable {
        String TenChucNang;
        int LogoChucNang;
    public tool(){}
    public tool(String tenChucNang, int logoChucNang) {
        TenChucNang = tenChucNang;
        LogoChucNang = logoChucNang;
    }


    public String getTenChucNang() {
        return TenChucNang;
    }

    public int getLogoChucNang() {
        return LogoChucNang;
    }

    public void setTenChucNang(String tenChucNang) {
        TenChucNang = tenChucNang;
    }

    public void setLogoChucNang(int logoChucNang) {
        LogoChucNang = logoChucNang;
    }
}
