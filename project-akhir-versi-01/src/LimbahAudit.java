public abstract class LimbahAudit {
    protected String namaLimbah;
    protected double beratKg;

    public LimbahAudit(String namaLimbah, double beratKg) {
        this.namaLimbah = namaLimbah;
        this.beratKg = beratKg;
    }


    public abstract double hitungEstimasiEmisi();

    public abstract void prosesPengolahan();

    public void tampilkanInfo() {
        System.out.printf(java.util.Locale.US, "Jenis Limbah  : %s%n", namaLimbah);
        System.out.printf(java.util.Locale.US, "Berat         : %.2f kg%n", beratKg);
        System.out.printf(java.util.Locale.US, "Estimasi CO2e : %.2f kg%n", hitungEstimasiEmisi());
    }
}