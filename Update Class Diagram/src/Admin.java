import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Admin {
    private String idAdmin;
    private String namaAdmin;
    private String email;
    private String password;

    private final List<Event> eventDiverifikasi = new ArrayList<>();


    public Admin(String idAdmin, String namaAdmin, String email, String password) {
        this.idAdmin = idAdmin;
        this.namaAdmin = namaAdmin;
        this.email = email;
        this.password = password;
    }

    public void verifikasiEvent(Event event) {
        event.setVerifikator(this);
        event.setStatus(Event.DISETUJUI);
        if (!eventDiverifikasi.contains(event)) {
            eventDiverifikasi.add(event);
        }
        System.out.println("[Admin] Event '" + event.getNamaEvent() + "' disetujui.");
    }

    public boolean validasiAudit(Event event) {
        TimbanganSampah t = event.getTimbangan();
        if (t == null || !t.isValid()) {
            System.out.println("[Admin] Audit ditolak: data/foto bukti timbangan belum lengkap.");
            return false;
        }
        event.hitungDiversionRateAndKarbon();
        event.setStatus(Event.VERIFIED);
        System.out.println("[Admin] Audit event '" + event.getNamaEvent() + "' valid (VERIFIED).");
        return true;
    }


    public void approveSertifikat(Event event) {
        if (!Event.VERIFIED.equals(event.getStatus())) {
            System.out.println("[Admin] Approve ditolak: audit belum VERIFIED.");
            return;
        }
        event.terbitkanSertifikat();
        System.out.println("[Admin] Sertifikat event '" + event.getNamaEvent() + "' di-approve.");
    }
    
    public String getIdAdmin() { return idAdmin; }
    public String getNamaAdmin() { return namaAdmin; }
    public List<Event> getEventDiverifikasi() { return Collections.unmodifiableList(eventDiverifikasi); }
}