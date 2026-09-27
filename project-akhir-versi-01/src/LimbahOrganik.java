public class LimbahOrganik extends LimbahAudit {
    private double persentaseKelembapan;

    public LimbahOrganik(double beratKg, double persentaseKelembapan) {
        super(beratKg);
        this.persentaseKelembapan = persentaseKelembapan;
    }

    @Override
    public double hitungEstimasiEmisi() {
        return beratKg * 0.5;
    }

    @Override
    public void prosesPengolahan() {
        System.out.println("Limbah organik diproses melalui pengomposan anaerob/aerob.");
    }

    public void konversiKompos() {
        double hasilKompos = beratKg * 0.4;
        System.out.printf(java.util.Locale.US, "-> Estimasi kompos yang dihasilkan: %.2f kg%n", hasilKompos);
    }
}