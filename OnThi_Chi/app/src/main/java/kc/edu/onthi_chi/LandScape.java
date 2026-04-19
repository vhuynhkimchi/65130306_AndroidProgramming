package kc.edu.onthi_chi;

public class LandScape {
    String landImageFileName;
    String landCation;
    String mota;

    public LandScape(String landImageFileName, String landCation, String mota) {
        this.landImageFileName = landImageFileName;
        this.landCation = landCation;
        this.mota = mota;
    }

    public String getLandImageFileName() {
        return landImageFileName;
    }

    public void setLandImageFileName(String landImageFileName) {
        this.landImageFileName = landImageFileName;
    }

    public String getLandCation() {
        return landCation;
    }

    public void setLandCation(String landCation) {
        this.landCation = landCation;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}

