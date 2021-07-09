package com.company;

public class NhanVienFullTime extends NhanVien{
    public NhanVienFullTime (String name, String id, boolean status, int luong) {
        super(name, id, status, luong);
    }

    @Override
    public String toString () {
        return "NhanVienFullTime{"
                +super.toString()+"}";
    }
    public int doanhthu(){
        return this.getLuong()*8;
    }
}
