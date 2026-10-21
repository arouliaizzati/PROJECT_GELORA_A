public class TitikSampah {
    private String idTitik;
    private String idEvent;
    private String namaLokasi;
    private float koordinatX;
    private float koordinatY;
    private String jenisTerpilah;

    public TitikSampah(String idTitik, String idEvent, String namaLokasi, float koordinatX, float koordinatY, String jenisTerpilah) {
        this.idTitik = idTitik;
        this.idEvent = idEvent;
        this.namaLokasi = namaLokasi;
        this.koordinatX = koordinatX;
        this.koordinatY = koordinatY;
        this.jenisTerpilah = jenisTerpilah;
    }

    public void tambahTitik() {
        System.out.println("Titik sampah ditambahkan: " + namaLokasi);
    }

    public void updateTitik() {
        System.out.println("Titik sampah diperbarui.");
    }
}
