public class Main {
    public static void main(String[] args) {
        
        // =========================================================================
        // BAGIAN 1: DEMO ABSTRACT CLASS (LimbahAudit)
        // =========================================================================
        System.out.println("=== SISTEM GELORA: AUDIT DATA LIMBAH (ABSTRACT CLASS) ===");

        // Subclass 1: LimbahOrganik
        System.out.println("\n[1] Pengujian Limbah Organik");
        System.out.println("--------------------------------------------------");
        LimbahAudit organik = new LimbahOrganik(50, 70);
        organik.tampilkanInfo();
        organik.prosesPengolahan();
        System.out.printf(java.util.Locale.US, "Estimasi Emisi    : %.2f kg CO2-eq%n", organik.hitungEstimasiEmisi());
        ((LimbahOrganik) organik).konversiKompos();

        // Subclass 2: LimbahAnorganik
        System.out.println("\n[2] Pengujian Limbah Anorganik");
        System.out.println("--------------------------------------------------");
        LimbahAudit anorganik = new LimbahAnorganik(20, "Plastik");
        anorganik.tampilkanInfo();
        anorganik.prosesPengolahan();
        System.out.printf(java.util.Locale.US, "Estimasi Emisi    : %.2f kg CO2-eq%n", anorganik.hitungEstimasiEmisi());
        double nilaiDaurUlang = ((LimbahAnorganik) anorganik).hitungNilaiDaurUlang();
        System.out.printf(java.util.Locale.US, "Nilai Daur Ulang  : Rp %,.0f%n", nilaiDaurUlang);

        // =========================================================================
        // BAGIAN 2: DEMO INTERFACE (Penerbitan & Validasi Dokumen)
        // =========================================================================
        System.out.println("\n\n=== SISTEM GELORA: SERTIFIKASI KEBERLANJUTAN (INTERFACE) ===");

        // Interface 1 saja: Dilaporkan
        System.out.println("\n[A] Implementasi Interface 1 (Dilaporkan)");
        System.out.println("Objek: LaporanKegiatan");
        System.out.println("--------------------------------------------------");
        LaporanKegiatan laporan = new LaporanKegiatan("MPKMB SV IPB");
        laporan.buatSertifikat();
        laporan.exportPDF();

        // Interface 2 saja: Terverifikasi
        System.out.println("\n[B] Implementasi Interface 2 (Terverifikasi)");
        System.out.println("Objek: AuditFisik");
        System.out.println("--------------------------------------------------");
        AuditFisik audit = new AuditFisik(true);
        audit.verifikasiData();
        System.out.println("Status Verifikasi : " + audit.getStatusVerifikasi());

        // Implementasi Ganda: Dilaporkan & Terverifikasi
        System.out.println("\n[C] Implementasi Kedua Interface (Dilaporkan & Terverifikasi)");
        System.out.println("Objek: SertifikatKeberlanjutan");
        System.out.println("--------------------------------------------------");
        SertifikatKeberlanjutan sertifikat = new SertifikatKeberlanjutan("MPKMB SV IPB 63", true);
        sertifikat.buatSertifikat();
        sertifikat.exportPDF();
        sertifikat.verifikasiData();
        System.out.println("Status Verifikasi : " + sertifikat.getStatusVerifikasi());

        System.out.println("\n================================------------------");
        System.out.println(">>> Pengujian Program Selesai.");
    }
}