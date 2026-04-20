package thigk2.vohuynhkimchi.thigk2_65130306;

public class DanhNhan {
    String danhnhanImageFileName;
    String name;
    String queQuan;

    public DanhNhan(String danhnhanImageFileName, String name, String queQuan) {
        this.danhnhanImageFileName = danhnhanImageFileName;
        this.name = name;
        this.queQuan = queQuan;
    }

    public String getDanhnhanImageFileName() {
        return danhnhanImageFileName;
    }

    public void setDanhnhanImageFileName(String danhnhanImageFileName) {
        this.danhnhanImageFileName = danhnhanImageFileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
}
