public class LaporanKegiatan implements Dilaporkan {
    @SuppressWarnings("FieldMayBeFinal")
    private String namaKegiatan;

    public LaporanKegiatan(String namaKegiatan) {
        this.namaKegiatan = namaKegiatan;
    }

    @Override
    public void buatSertifikat() {
        System.out.println("Membuat Sertifikat Audit Sampah untuk kegiatan: " + namaKegiatan);
    }

    @Override
    public void exportPDF() {
        System.out.println("Mengeksport Sertifikat Audit Sampah ke format PDF");
    }
}