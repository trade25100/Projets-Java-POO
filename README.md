# Projet 01 — Gestion d’une bibliothèque (version finale)

Application Java 17+ en console, sans dépendances externes.

## Fonctionnalités
- Ajouter et rechercher des livres par titre, auteur ou ISBN
- Inscrire des utilisateurs
- Emprunter et retourner des livres
- Empêcher les emprunts simultanés et les doublons ISBN/ID
- Afficher les disponibilités et l’historique des emprunts
- Validation des données et gestion des exceptions

## Exécuter
Depuis le dossier `bibliotheque-version-finale` :

```bash
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

## Tests
```bash
java -ea -cp out TestBibliotheque
```

Les données sont conservées en mémoire pendant l’exécution, sans base de données.
