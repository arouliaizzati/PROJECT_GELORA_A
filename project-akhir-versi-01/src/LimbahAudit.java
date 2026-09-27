public abstract class LimbahAudit {
    protected double beratKg;

    public LimbahAudit(double beratKg) {
        this.beratKg = beratKg;
    }

    public abstract double hitungEstimasiEmisi();
    public abstract void prosesPengolahan();

    public void tampilkanInfo() {
        System.out.println("Berat limbah: " + beratKg + " kg");
    }
}