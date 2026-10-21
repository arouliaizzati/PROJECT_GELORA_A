import java.util.ArrayList;
import java.util.List;

public class Admin {
    private String idAdmin;
    private String namaAdmin;
    private String email;
    private String password;

    // Relasi Memverifikasi: 1 Admin memverifikasi 0..* Event
    private List<Event> daftarEventVerifikasi = new ArrayList<>();

    public Admin(String idAdmin, String namaAdmin, String email, String password) {
        this.idAdmin = idAdmin;
        this.namaAdmin = namaAdmin;
        this.email = email;
        this.password = password;
    }

    public void verifikasiEvent(Event event) {
        System.out.println("Memverifikasi event: " + event.getNamaEvent());
        daftarEventVerifikasi.add(event);
    }

    public void validasiAudit() {
        System.out.println("Validasi audit...");
    }

    public void approveSertifikat() {
        System.out.println("Approve sertifikat...");
    }
}