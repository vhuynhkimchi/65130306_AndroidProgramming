package kc.edu.menunhahang;

public class MonAn {
    private String tenMonAn;
    private double donGia;
    private String moTa;
    private int hinhAnh;

    //ham tao

    public MonAn(String tenMonAn, double donGia, String moTa, int hinhAnh) {
        this.tenMonAn = tenMonAn;
        this.donGia = donGia;
        this.moTa = moTa;
        this.hinhAnh = hinhAnh;
    }

    //Cac getter va setter


    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
