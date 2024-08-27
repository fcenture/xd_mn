package com.agasa.xd_f371_v0_0_1.dto;

public class Nhap {
    private String dvNhap;
    private String dvVanChuyen;
    private String so;
    private String ngNhanHang;
    private String ngayNhap;
    private String tenXD;
    private String donGia;
    private String soLuong;

    public Nhap() {
    }

    public Nhap(String dvNhap, String dvVanChuyen, String so, String ngNhanHang, String ngayNhap, String tenXD, String donGia, String soLuong) {
        this.dvNhap = dvNhap;
        this.dvVanChuyen = dvVanChuyen;
        this.so = so;
        this.ngNhanHang = ngNhanHang;
        this.ngayNhap = ngayNhap;
        this.tenXD = tenXD;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public void setDvNhap(String dvNhap) {
        this.dvNhap = dvNhap;
    }

    public void setDvVanChuyen(String dvVanChuyen) {
        this.dvVanChuyen = dvVanChuyen;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public void setNgNhanHang(String ngNhanHang) {
        this.ngNhanHang = ngNhanHang;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setTenXD(String tenXD) {
        this.tenXD = tenXD;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getDvNhap() {
        return dvNhap;
    }

    public String getDvVanChuyen() {
        return dvVanChuyen;
    }

    public String getSo() {
        return so;
    }

    public String getNgNhanHang() {
        return ngNhanHang;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public String getTenXD() {
        return tenXD;
    }

    public String getDonGia() {
        return donGia;
    }

    public String getSoLuong() {
        return soLuong;
    }
}
