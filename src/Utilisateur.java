public class Utilisateur {
    private final int id;
    private final String nom;
    public Utilisateur(int id, String nom) {
        if (id <= 0 || nom == null || nom.isBlank()) throw new IllegalArgumentException("Identifiant et nom invalides.");
        this.id = id; this.nom = nom.trim();
    }
    public int getId() { return id; }
    public String getNom() { return nom; }
    @Override public String toString() { return id + " - " + nom; }
}
