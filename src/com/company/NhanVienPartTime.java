package com.company;

public class NhanVienPartTime extends NhanVien {
    public int soGio;


    public double doanhthu () {
        return getLuong() * soGio;
    }

    public NhanVienPartTime (String name, String id, boolean status, int luong, int soGio) {
        super(name,id, status, luong);
        this.soGio = soGio;
    }

    public NhanVienPartTime (String name,String id, boolean status, int luong) {
        super(name,id, status, luong);
    }



    @Override
    public String toString () {
        return "NhanVienPartTime{" +super.toString()+
                "soGio=" + soGio +
                '}';
    }
}

