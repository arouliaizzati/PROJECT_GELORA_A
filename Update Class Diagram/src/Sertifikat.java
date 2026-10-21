import java.time.LocalDate;
import java.util.Date;

public class Sertifikat {
    private String idSertifikat;
    private String idEvent;
    private String kodeVerifikasi;
    private Date tanggalTerbit;
    private String linkVerifikasi;

    public Sertifikat(String idSertifikat, String idEvent, String kodeVerifikasi, Date tanggalTerbit, String linkVerifikasi) {
        this.idSertifikat = idSertifikat;
        this.idEvent = idEvent;
        this.kodeVerifikasi = kodeVerifikasi;
        this.tanggalTerbit = tanggalTerbit;
        this.linkVerifikasi = linkVerifikasi;
    }

    public void generateSertifikat() {
        System.out.println("[Sertifikat] PDF + QR dibuat untuk '" + event.getNamaEvent()
                + "' | terbit " + tanggalTerbit + " | " + linkVerifikasi);
    }

    public boolean verifikasiKeabsahan(String kode) {
        return kodeVerifikasi.equals(kode);
    }

    public String getIdSertifikat() { return idSertifikat; }
    public String getKodeVerifikasi() { return kodeVerifikasi; }
    public LocalDate getTanggalTerbit() { return tanggalTerbit; }
}

