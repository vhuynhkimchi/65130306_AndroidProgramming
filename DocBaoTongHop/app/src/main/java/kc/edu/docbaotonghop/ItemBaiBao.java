package kc.edu.docbaotonghop;

public class ItemBaiBao {
    private String tieuDeBaiBao;
    private String urlAnhDaiDien;
    private String thoiDiemBanTin;

    public ItemBaiBao(){

    }
    public ItemBaiBao(String tieuDeBaiBao, String urlAnhDaiDien, String thoiDiemBanTin) {
        this.tieuDeBaiBao = tieuDeBaiBao;
        this.urlAnhDaiDien = urlAnhDaiDien;
        this.thoiDiemBanTin = thoiDiemBanTin;
    }

    public String getTieuDeBaiBao() {
        return tieuDeBaiBao;
    }

    public void setTieuDeBaiBao(String tieuDeBaiBao) {
        this.tieuDeBaiBao = tieuDeBaiBao;
    }

    public String getUrlAnhDaiDien() {
        return urlAnhDaiDien;
    }

    public void setUrlAnhDaiDien(String urlAnhDaiDien) {
        this.urlAnhDaiDien = urlAnhDaiDien;
    }

    public String getThoiDiemBanTin() {
        return thoiDiemBanTin;
    }

    public void setThoiDiemBanTin(String thoiDiemBanTin) {
        this.thoiDiemBanTin = thoiDiemBanTin;
    }
}
