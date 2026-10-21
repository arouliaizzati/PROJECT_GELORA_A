public class Pengunjung {
    private String idPengunjung;
    private String email;

    public Pengunjung(String idPengunjung, String email) {
        this.idPengunjung = idPengunjung;
        this.email = email;
    }

    public void lihatPetaSampah() {
        System.out.println("Pengunjung melihat Peta Sampah.");
    }

    public String getIdPengunjung() { return idPengunjung; }
}
