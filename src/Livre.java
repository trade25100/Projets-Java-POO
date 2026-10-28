public class Livre {
    private final String isbn;
    private final String titre;
    private final String auteur;
    private boolean disponible = true;

    public Livre(String isbn, String titre, String auteur) {
        if (isbn == null || isbn.isBlank() || titre == null || titre.isBlank() || auteur == null || auteur.isBlank())
            throw new IllegalArgumentException("Les champs du livre sont obligatoires.");
        this.isbn = isbn.trim(); this.titre = titre.trim(); this.auteur = auteur.trim();
    }
    public String getIsbn() { return isbn; }
    public String getTitre() { return titre; }
    public String getAuteur() { return auteur; }
    public boolean isDisponible() { return disponible; }
    void setDisponible(boolean disponible) { this.disponible = disponible; }
    @Override public String toString() { return titre + " - " + auteur + " (ISBN: " + isbn + ") [" + (disponible ? "Disponible" : "Emprunté") + "]"; }
}
