import java.util.Date;

public class JadwalEvent {
    private String idJadwal;
    private String idEvent;
    private Date tglMulai;
    private Date tglSelesai;
    private String tahapKegiatan;

    public JadwalEvent(String idJadwal, String idEvent) {
        this.idJadwal = idJadwal;
        this.idEvent = idEvent;
    }

    public void aturJadwal(Date tglMulai, Date tglSelesai, String tahapKegiatan) {
        this.tglMulai = tglMulai;
        this.tglSelesai = tglSelesai;
        this.tahapKegiatan = tahapKegiatan;
        System.out.println("Jadwal event diatur.");
    }
}
