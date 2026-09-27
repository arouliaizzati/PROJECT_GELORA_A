public class AuditFisik implements Terverifikasi {
    @SuppressWarnings("FieldMayBeFinal")
    private boolean fotoBuktiAda;

    public AuditFisik(boolean fotoBuktiAda) {
        this.fotoBuktiAda = fotoBuktiAda;
    }

    @Override
    public void verifikasiData() {
        System.out.println("Memeriksa kelengkapan foto bukti audit fisik...");
    }

    @Override
    public String getStatusVerifikasi() {
        return fotoBuktiAda ? "Audit Fisik Terverifikasi (Foto Bukti Valid)" : "Audit Fisik Gagal (Foto Bukti Tidak Ada)";
    }
}