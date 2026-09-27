public class SertifikatKeberlanjutan implements Dilaporkan, Terverifikasi {
    private String namaKegiatan;
    private boolean auditSelesai;

    public SertifikatKeberlanjutan(String namaKegiatan, boolean auditSelesai) {
        this.namaKegiatan = namaKegiatan;
        this.auditSelesai = auditSelesai;
    }

    @Override
    public void buatLaporan() {
        System.out.println("Menyusun One-Page Sustainability Summary untuk: " + namaKegiatan);
    }

    @Override
    public void exportPDF() {
        System.out.println("Sertifikat Keberlanjutan '" + namaKegiatan + "' diterbitkan dalam format PDF + QR validasi.");
    }

    @Override
    public boolean verifikasiData() {
        return auditSelesai;
    }

    @Override
    public String getStatusVerifikasi() {
        return auditSelesai ? "Audit Selesai - Sertifikat Sah" : "Audit Belum Selesai - Ekspor Dinonaktifkan";
    }
}