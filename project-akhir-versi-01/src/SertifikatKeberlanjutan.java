public class SertifikatKeberlanjutan implements Dilaporkan, Terverifikasi {
    private String namaKegiatan;
    private boolean auditSelesai;

    public SertifikatKeberlanjutan(String namaKegiatan, boolean auditSelesai) {
        this.namaKegiatan = namaKegiatan;
        this.auditSelesai = auditSelesai;
    }

    @Override
    public void buatSertifikat() {
        System.out.println("Membuat Sertifikat Keberlanjutan Resmi untuk kegiatan: " + namaKegiatan);
    }

    @Override
    public void exportPDF() {
        System.out.println("Mengeksport Sertifikat Keberlanjutan (PDF dengan QR Code Verifikasi) untuk lampiran LPJ...");
    }

    @Override
    public void verifikasiData() {
        System.out.println("Memverifikasi keabsahan Sertifikat Keberlanjutan via sistem GELORA...");
    }

    @Override
    public String getStatusVerifikasi() {
        return auditSelesai ? "Sertifikat Keberlanjutan Valid & Terverifikasi" : "Belum Terverifikasi";
    }
}