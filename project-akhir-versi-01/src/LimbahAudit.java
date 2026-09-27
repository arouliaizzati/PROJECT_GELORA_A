public abstract class LimbahAudit {
    protected String jenis;
    protected double beratKg;

    public LimbahAudit(String jenis, double beratKg) {
        this.jenis = jenis;
        this.beratKg = beratKg;
    }

    public abstract double hitungEstimasiEmisi();
    public abstract void prosesPengolahan();

    public void tampilkanInfo() {
        System.out.println("Jenis Limbah: " + jenis + " | Berat: " + beratKg + " kg");
    }
}