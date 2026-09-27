// Turunan 2 dari LimbahAudit
public class LimbahAnorganik extends LimbahAudit {
    private final String jenisMaterial;

    public LimbahAnorganik(double beratKg, String jenisMaterial) {
        super("Anorganik (" + jenisMaterial + ")", beratKg);
        this.jenisMaterial = jenisMaterial;
    }

    @Override
    public double hitungEstimasiEmisi() {
        return beratKg * 1.2;
    }

    @Override
    public void prosesPengolahan() {
        System.out.println("-> Disalurkan ke komunitas/bank sampah untuk didaur ulang.");
    }

    public double hitungNilaiDaurUlang() {
        double hargaPerKg = jenisMaterial.equalsIgnoreCase("Plastik") ? 2000 : 1000;
        return beratKg * hargaPerKg;
    }
}
