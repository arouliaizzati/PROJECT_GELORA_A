// Turunan 1 dari LimbahAudit
public class LimbahOrganik extends LimbahAudit {
    private double kadarAirPersen;

    public LimbahOrganik(double beratKg, double kadarAirPersen) {
        super("Organik (Sisa Makanan)", beratKg);
        this.kadarAirPersen = kadarAirPersen;
    }

    @Override
    public double hitungEstimasiEmisi() {
        // faktor emisi limbah organik jika dibuang ke TPA (kg CO2e per kg)
        return beratKg * 0.5;
    }

    @Override
    public void prosesPengolahan() {
        System.out.println("-> Diproses menjadi kompos / pakan maggot (BSF).");
    }

    // ---- Method khusus milik LimbahOrganik ----
    public void konversiKompos() {
        double hasilKompos = beratKg * (1 - kadarAirPersen / 100) * 0.4;
        System.out.printf(java.util.Locale.US, "-> Estimasi kompos yang dihasilkan: %.2f kg%n", hasilKompos);
    }
}
