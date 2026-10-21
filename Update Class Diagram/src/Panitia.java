import java.util.ArrayList;
import java.util.List;

public class Panitia {
    private String idPanitia;
    private String namaOrmawa;
    private String email;
    private String password;
    private String noTelepon;

    
    private List<Event> daftarEvent = new ArrayList<>();

    public Panitia(String idPanitia, String namaOrmawa, String email, String password, String noTelepon) {
        this.idPanitia = idPanitia;
        this.namaOrmawa = namaOrmawa;
        this.email = email;
        this.password = password;
        this.noTelepon = noTelepon;
    }

    public void register() {
        System.out.println("[Panitia] " + namaOrmawa + " terdaftar dengan email " + email);
    }

    public boolean login(String emailInput, String passwordInput) {
        return email.equals(emailInput) && password.equals(passwordInput);
    }

    // Relasi "Mengelola"
    public void kelolaEvent(Event event) {
        if (!daftarEvent.contains(event)) {
            daftarEvent.add(event);
            event.setPanitia(this);
        }
    }

    public void hitungEcoBudgeting(Event event) {
        event.hitungEstimasiSampah();
        System.out.println("[Eco-Budgeting] " + event.getNamaEvent() + " -> " + event.getRekLogistikTempatSampah());
    }

    public void inputTimbangan(Event event, float organik, float daurUlang, float residu, String fotoBukti) {
        if (!daftarEvent.contains(event)) {
            throw new IllegalArgumentException("Event bukan milik panitia ini");
        }
        event.catatTimbangan(organik, daurUlang, residu, fotoBukti);
    }

    public void generateSertifikat(Event event) {
        if (event.getSertifikat() == null) {
            System.out.println("[Panitia] Sertifikat belum bisa dibuat: menunggu approval Admin.");
            return;
        }
        event.getSertifikat().generateSertifikat();
    }

    public String getIdPanitia() { return idPanitia; }
    public String getNamaOrmawa() { return namaOrmawa; }
    public List<Event> getDaftarEvent() { return Collections.unmodifiableList(daftarEvent); }
}
