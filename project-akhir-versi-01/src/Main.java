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

        System.out.println("\n========== INTERFACE (Penerbitan Sertifikat GELORA) ==========");

        // Interface 1 saja
        LaporanKegiatan laporan = new LaporanKegiatan("Dies Natalis Fakultas Vokasi");
        laporan.buatSertifikat();
        laporan.exportPDF();

        System.out.println();

        // Interface 2 saja
        AuditFisik audit = new AuditFisik(true);
        audit.verifikasiData();
        System.out.println("Status audit fisik: " + audit.getStatusVerifikasi());

        System.out.println();

        // Implementasi Kedua Interface
        SertifikatKeberlanjutan sertifikat = new SertifikatKeberlanjutan("Seminar Nasional Lingkungan", true);
        sertifikat.buatSertifikat();
        sertifikat.exportPDF();
        sertifikat.verifikasiData();
        System.out.println("Status: " + sertifikat.getStatusVerifikasi());
    }
}