# Artemis - Simulateur de Lancement Spatial (Java)

**Artemis** est un simulateur de lancement spatial en ligne de commande développé en Java. Ce projet permet de construire et de simuler le lancement de fusées en sélectionnant différents composants de la fusée. Du lanceur au choix de la mission, tout en passant par le choix de la capsule ou l'ajout de différents boosters. 

1. **Contexte :** Ce programme a été réalisé dans le cadre d'un projet scolaire. ( POO en Java B1 Ynov ) 
2. **Dépôt GitHub :** [Voir le projet sur GitHub](https://github.com/PierrotJR-Ynov-projects/b1-java-space-launch-simulator)

---

## 1. Fonctionnalités

- **Création personnalisée :**
    - **Lanceurs :** Ariane 5, Falcon 9, SLS, Saturne V.
    - **Capsules :** Apollo, Cargo Dragon, Crew Dragon, Orion.
    - **Boosters :** BE-3, EAP, SRB.
    - **Missions :** ISS, Lune, Mars, Orbite, Pluton.
- **Vérifications et règles :**
    - Validation de la compatibilité des vols habités.
    - Calcul de la masse totale et du carburant requis pour accomplir la mission.
    - Vérification de la capacité en carburant du lanceur.
- **Système d'événements aléatoires :**
    - Probabilité d'échec ou d'explosion au décollage en fonction de la fiabilité du lanceur.
- **Sauvegarde et historique :**
    - Sauvegarde automatique des lancements dans un fichier local (`data/save.json`).
    - Possibilité de consulter l'historique de tous les lancements.

## 2. Architecture du projet

L'application est structurée autour d'une architecture orientée objet :

```text
📦 src/main/java/artemis
 ┣ 📂 main
 ┃ ┗ 📜 Simulator.java        # Menu et interactions utilisateur.
 ┣ 📂 model
 ┃ ┣ 📂 booster               # Liste des boosters.
 ┃ ┣ 📂 capsule               # Liste des capsules
 ┃ ┣ 📂 launcher              # Liste des lanceurs.
 ┃ ┣ 📂 mission               # Liste des missions.
 ┃ ┗ 📜 Rocket.java           # Modèle permettant l'assemblage de la fusée.
 ┗ 📂 service
   ┣ 📜 LaunchController.java # Gère la logique.
   ┗ 📜 SaveManager.java      # Gère les différentes sauvegardes ( enregistement et lecture )
```

## 3. Installation et exécution

### 1. Prérequis
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) 8 ou supérieur.
- [Git](https://git-scm.com/) (optionnel, pour récupérer le projet).

### 2. Cloner le projet

Avant de lancer l'application, récupérez le code source sur votre machine :
```bash
git clone https://github.com/PierrotJR-Ynov-projects/b1-java-space-launch-simulator.git
cd b1-java-space-launch-simulator
```

### 3. Lancer l'application

**Méthode 1 : Via un IDE (Recommandé)**
La façon la plus simple de tester le projet est de l'ouvrir avec un IDE (comme IntelliJ IDEA, Eclipse ou VS Code). Ouvrez simplement le fichier `src/main/java/artemis/main/Simulator.java` et cliquez sur le bouton "Run" (Lecture). L'IDE s'occupera de tout configurer.

**Méthode 2 : Via le terminal (Ligne de commande)**
Si vous préférez utiliser le terminal, placez-vous à la racine du projet et exécutez ces deux commandes simples :

1. Compilez le projet (Java trouvera automatiquement les autres fichiers) :
   ```bash
   javac -d bin -sourcepath src/main/java src/main/java/artemis/main/Simulator.java
   ```
2. Lancez le simulateur :
   ```bash
   java -cp bin artemis.main.Simulator
   ```

## 4. Aperçu de l'utilisation

Au lancement, vous arrivez sur le **Menu Principal** :
1. **Création d'un nouveau lancement :** Suivez les étapes pour nommer votre fusée, choisir le lanceur, la capsule, ajouter des boosters et choisir votre mission.
   Le simulateur analysera la fusée, évaluera le coût, vérifiera le carburant et tentera le lancement !
2. **Historique des missions :** Permet de relire toutes les missions enregistrées (depuis `data/save.json`).
3. **Quitter :** Ferme l'application en douceur.

---