public class LimbahAnorganik extends LimbahAudit {
    @SuppressWarnings("FieldMayBeFinal")
    private String jenisMaterial;

    public LimbahAnorganik(double beratKg, String jenisMaterial) {
        super("Anorganik", beratKg);
        this.jenisMaterial = jenisMaterial;
    }

    @Override
    public double hitungEstimasiEmisi() {
        return beratKg * 1.8;
    }

    @Override
    public void prosesPengolahan() {
        System.out.println("Limbah anorganik jenis " + jenisMaterial + " dipilah untuk daur ulang.");
    }

    public double hitungNilaiDaurUlang() {
        if (jenisMaterial.equalsIgnoreCase("Plastik")) {
            return beratKg * 3000;
        } else if (jenisMaterial.equalsIgnoreCase("Kertas")) {
            return beratKg * 2000;
        }
        return beratKg * 1000;
    }
}