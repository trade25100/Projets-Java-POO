public class TestBibliotheque {
    public static void main(String[] args) {
        Bibliotheque b = new Bibliotheque();
        Livre l = new Livre("123", "Java", "Auteur");
        b.ajouterLivre(l);
        b.inscrireUtilisateur(new Utilisateur(1, "Alice"));
        assert b.rechercherLivres("java").size() == 1;
        b.emprunter("123", 1);
        assert !l.isDisponible();
        boolean erreur = false;
        try { b.emprunter("123", 1); } catch (IllegalStateException e) { erreur = true; }
        assert erreur;
        b.retourner("123");
        assert l.isDisponible();
        assert !b.getEmprunts().get(0).isActif();
        System.out.println("Tous les tests sont passés.");
    }
}
