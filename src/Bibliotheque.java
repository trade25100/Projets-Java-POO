import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bibliotheque {
    private final List<Livre> livres = new ArrayList<>();
    private final List<Utilisateur> utilisateurs = new ArrayList<>();
    private final List<Emprunt> emprunts = new ArrayList<>();

    public void ajouterLivre(Livre livre) {
        if (livre == null) throw new IllegalArgumentException("Livre requis.");
        if (chercherParIsbn(livre.getIsbn()) != null) throw new IllegalArgumentException("ISBN déjà présent.");
        livres.add(livre);
    }
    public void inscrireUtilisateur(Utilisateur utilisateur) {
        if (utilisateur == null) throw new IllegalArgumentException("Utilisateur requis.");
        if (chercherUtilisateur(utilisateur.getId()) != null) throw new IllegalArgumentException("Identifiant déjà utilisé.");
        utilisateurs.add(utilisateur);
    }
    public Livre chercherParIsbn(String isbn) {
        for (Livre livre : livres) if (livre.getIsbn().equalsIgnoreCase(isbn)) return livre;
        return null;
    }
    public List<Livre> rechercherLivres(String motCle) {
        if (motCle == null) throw new IllegalArgumentException("Recherche invalide.");
        List<Livre> resultat = new ArrayList<>();
        for (Livre livre : livres) if (livre.getTitre().toLowerCase().contains(motCle.toLowerCase()) || livre.getAuteur().toLowerCase().contains(motCle.toLowerCase())) resultat.add(livre);
        return resultat;
    }
    public Utilisateur chercherUtilisateur(int id) {
        for (Utilisateur utilisateur : utilisateurs) if (utilisateur.getId() == id) return utilisateur;
        return null;
    }
    public Emprunt emprunter(String isbn, int utilisateurId) {
        Livre livre = chercherParIsbn(isbn);
        Utilisateur utilisateur = chercherUtilisateur(utilisateurId);
        if (livre == null) throw new IllegalArgumentException("Livre introuvable.");
        if (utilisateur == null) throw new IllegalArgumentException("Utilisateur introuvable.");
        if (!livre.isDisponible()) throw new IllegalStateException("Livre indisponible.");
        Emprunt emprunt = new Emprunt(livre, utilisateur);
        livre.setDisponible(false);
        emprunts.add(emprunt);
        return emprunt;
    }
    public void retourner(String isbn) {
        for (Emprunt emprunt : emprunts) {
            if (emprunt.isActif() && emprunt.getLivre().getIsbn().equalsIgnoreCase(isbn)) {
                emprunt.retourner(); emprunt.getLivre().setDisponible(true); return;
            }
        }
        throw new IllegalArgumentException("Aucun emprunt actif pour cet ISBN.");
    }
    public List<Livre> getLivres() { return Collections.unmodifiableList(livres); }
    public List<Utilisateur> getUtilisateurs() { return Collections.unmodifiableList(utilisateurs); }
    public List<Emprunt> getEmprunts() { return Collections.unmodifiableList(emprunts); }
}
