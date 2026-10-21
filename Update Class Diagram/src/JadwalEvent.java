import java.time.LocalDate;

public class JadwalEvent {
    private String idJadwal;
    private Event event;
    private LocalDate tglMulai;
    private LocalDate tglSelesai;
    private String tahapKegiatan;

    JadwalEvent(String idJadwal, Event event, LocalDate tglMulai, LocalDate tglSelesai, String tahapKegiatan) {
        this.idJadwal = idJadwal;
        this.event = event;
        this.tglMulai = tglMulai;
        this.tglSelesai = tglSelesai;
        this.tahapKegiatan = tahapKegiatan;
    }

    public void aturJadwal(LocalDate mulai, LocalDate selesai, String tahap) {
        if (selesai.isBefore(mulai)) {
            throw new IllegalArgumentException("Tanggal selesai tidak boleh sebelum tanggal mulai");
        }
        this.tglMulai = mulai;
        this.tglSelesai = selesai;
        this.tahapKegiatan = tahap;
        System.out.println("[Jadwal] " + event.getNamaEvent() + ": " + mulai + " s/d " + selesai + " (" + tahap + ")");
    }

    public String getIdJadwal() { return idJadwal; }
    public LocalDate getTglMulai() { return tglMulai; }
    public LocalDate getTglSelesai() { return tglSelesai; }
    public String getTahapKegiatan() { return tahapKegiatan; }
}
