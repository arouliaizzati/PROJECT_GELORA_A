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
        System.out.println("Sertifikat berhasil digenerate.");
    }

    public boolean verifikasiKeabsahan() {
        System.out.println("Verifikasi keabsahan sertifikat...");
        return true;
    }
}
