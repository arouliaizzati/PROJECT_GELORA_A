public class LaporanKegiatan implements Dilaporkan {
    private String namaKegiatan;

    public LaporanKegiatan(String namaKegiatan) {
        this.namaKegiatan = namaKegiatan;
    }

    @Override
    public void buatLaporan() {
        System.out.println("Membuat laporan rekapitulasi untuk kegiatan: " + namaKegiatan);
    }

    @Override
    public void exportPDF() {
        System.out.println("Laporan '" + namaKegiatan + "' berhasil diekspor ke PDF.");
    }
}