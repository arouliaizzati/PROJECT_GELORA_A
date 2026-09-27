public class AuditFisik implements Terverifikasi {
    private boolean fotoBuktiAda;

    public AuditFisik(boolean fotoBuktiAda) {
        this.fotoBuktiAda = fotoBuktiAda;
    }

    @Override
    public boolean verifikasiData() {
        return fotoBuktiAda;
    }

    @Override
    public String getStatusVerifikasi() {
        return fotoBuktiAda ? "Terverifikasi" : "Ditolak - Foto Bukti Belum Lengkap";
    }
}