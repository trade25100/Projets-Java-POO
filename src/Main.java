import java.util.List;
import java.util.Scanner;
public class Main {
    private static final Bibliotheque bibliotheque = new Bibliotheque();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        bibliotheque.ajouterLivre(new Livre("9780134685991", "Effective Java", "Joshua Bloch"));
        bibliotheque.ajouterLivre(new Livre("9780132350884", "Clean Code", "Robert C. Martin"));
        bibliotheque.inscrireUtilisateur(new Utilisateur(1, "Alice"));
        while (true) {
            System.out.println("\n=== BIBLIOTHÈQUE ===\n1. Livres\n2. Ajouter un livre\n3. Rechercher\n4. Inscrire un utilisateur\n5. Emprunter\n6. Retourner\n7. Emprunts\n8. Utilisateurs\n0. Quitter");
            String choix = demander("Choix : ");
            try {
                switch (choix) {
                    case "1": afficher(bibliotheque.getLivres()); break;
                    case "2": bibliotheque.ajouterLivre(new Livre(demander("ISBN : "), demander("Titre : "), demander("Auteur : "))); System.out.println("Livre ajouté."); break;
                    case "3": afficher(bibliotheque.rechercherLivres(demander("Titre ou auteur : "))); break;
                    case "4": bibliotheque.inscrireUtilisateur(new Utilisateur(nombre("ID : "), demander("Nom : "))); System.out.println("Utilisateur inscrit."); break;
                    case "5": System.out.println("Emprunt créé : " + bibliotheque.emprunter(demander("ISBN : "), nombre("ID utilisateur : "))); break;
                    case "6": bibliotheque.retourner(demander("ISBN : ")); System.out.println("Livre retourné."); break;
                    case "7": afficher(bibliotheque.getEmprunts()); break;
                    case "8": afficher(bibliotheque.getUtilisateurs()); break;
                    case "0": System.out.println("À bientôt !"); return;
                    default: System.out.println("Choix inconnu.");
                }
            } catch (IllegalArgumentException | IllegalStateException e) { System.out.println("Erreur : " + e.getMessage()); }
        }
    }
    private static String demander(String question) { System.out.print(question); return scanner.nextLine().trim(); }
    private static int nombre(String question) { return Integer.parseInt(demander(question)); }
    private static void afficher(List<?> elements) { if (elements.isEmpty()) System.out.println("Aucun résultat."); else for (Object element : elements) System.out.println("- " + element); }
}
