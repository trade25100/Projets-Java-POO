import java.time.LocalDate;
public class Emprunt {
    private final Livre livre;
    private final Utilisateur utilisateur;
    private final LocalDate dateEmprunt;
    private LocalDate dateRetour;
    public Emprunt(Livre livre, Utilisateur utilisateur) {
        this.livre = livre; this.utilisateur = utilisateur; this.dateEmprunt = LocalDate.now();
    }
    public Livre getLivre() { return livre; }
    public Utilisateur getUtilisateur() { return utilisateur; }
    public LocalDate getDateEmprunt() { return dateEmprunt; }
    public LocalDate getDateRetour() { return dateRetour; }
    public boolean isActif() { return dateRetour == null; }
    void retourner() { if (!isActif()) throw new IllegalStateException("Livre déjà retourné."); dateRetour = LocalDate.now(); }
    @Override public String toString() { return utilisateur.getNom() + " -> " + livre.getTitre() + " (" + dateEmprunt + ", " + (isActif() ? "en cours" : "retourné le " + dateRetour) + ")"; }
}
