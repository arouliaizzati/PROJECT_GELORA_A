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
        System.out.println("Register Panitia " + namaOrmawa);
    }

    public boolean login() {
        System.out.println("Panitia " + email + " login.");
        return true;
    }

    public void hitungEcoBudgeting() {
        System.out.println("Menghitung Eco Budgeting...");
    }

    public void inputTimbangan() {
        System.out.println("Input data timbangan...");
    }

    public void generateSertifikat() {
        System.out.println("Generate Sertifikat...");
    }

    public void tambahEvent(Event event) {
        this.daftarEvent.add(event);
    }
}
