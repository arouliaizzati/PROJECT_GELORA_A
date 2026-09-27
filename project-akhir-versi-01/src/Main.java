public class Main {
    public static void main(String[] args) {
        System.out.println("========== ABSTRACT CLASS: LimbahAudit ==========");

        LimbahAudit organik = new LimbahOrganik(50, 70);
        organik.tampilkanInfo();
        organik.prosesPengolahan();
        ((LimbahOrganik) organik).konversiKompos();

        System.out.println();

        LimbahAudit anorganik = new LimbahAnorganik(20, "Plastik");
        anorganik.tampilkanInfo();
        anorganik.prosesPengolahan();
        double nilaiDaurUlang = ((LimbahAnorganik) anorganik).hitungNilaiDaurUlang();
        System.out.printf(java.util.Locale.US, "-> Estimasi nilai daur ulang: Rp%.0f%n", nilaiDaurUlang);

        System.out.println("\n========== INTERFACE ==========");

        LaporanKegiatan laporan = new LaporanKegiatan("MPKMB 63 IPB UNIVERSITY");
        laporan.buatLaporan();
        laporan.exportPDF();

        System.out.println();

        AuditFisik audit = new AuditFisik(true);
        System.out.println("Status audit fisik: " + audit.getStatusVerifikasi());

        System.out.println();

        SertifikatKeberlanjutan sertifikat = new SertifikatKeberlanjutan("MPKMB 63 SEKOLAH VOKASI IPB UNIVERSITY", true);
        sertifikat.buatLaporan();
        sertifikat.exportPDF();
        System.out.println("Status: " + sertifikat.getStatusVerifikasi());
    }
}