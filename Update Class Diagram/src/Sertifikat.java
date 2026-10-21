import java.time.LocalDate;

public class Sertifikat {
    private String idSertifikat;
    private String idEvent;
    private String kodeVerifikasi;
    private LocalDate tanggalTerbit;
    private String linkVerifikasi;
    private Event event;

    public Sertifikat(String idSertifikat, Event event, String kodeVerifikasi) {
        this.idSertifikat = idSertifikat;
        this.idEvent = event.getIdEvent();
        this.kodeVerifikasi = kodeVerifikasi;
        this.tanggalTerbit = LocalDate.now();
        this.linkVerifikasi = "https://gelora.local/verify/" + kodeVerifikasi;
        this.event = event;
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

