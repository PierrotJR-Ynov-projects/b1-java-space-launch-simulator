
# Artemis - Projet java B1 

Artemis est un simulateur de lancement spatial. Différents choix sont permis (lanceur, capsules ou boosters) avec un choix varié de missions. 

## Fonctionnalités

- Création de fusées personnalisées.
- Gestion de la compatibilité (missions habitées vs capsules cargo).
- Calcul dynamique du carburant nécessaire et de la charge utile (payload).
- Historique des lancements sauvegardé en format JSON.


## Lancement du projet

Pour lancer le projet, il est nécessaire de télécharger le projet sur l'ordinateur :
```bash
  git clone https://github.com/PierrotJR-Ynov-projects/b1-java-space-launch-simulator
```

Par la suite, il est nécessaire de se diriger dans le projet :

```bash
  cd b1-java-space-launch-simulator
```

Enfin il suffit de compiler puis lancer le projet : 

```bash
  javac -d out -sourcepath src src/main/java/artemis/main/Simulator.java
  
  
  java -cp out artemis.main.Simulator
```
## Architecture

```bash
b1-java-space-launch-simulator/
├── .gitignore
├── README.md
└── src/
    └── main/
        └── java/
            └── artemis/
                ├── main/
                │   └── Simulator.java # Coeur du projet 
                ├── model/ # Liste des différents modèles utilisés
                │   ├── Rocket.java
                │   ├── booster/
                │   │   ├── BE3.java
                │   │   ├── Booster.java
                │   │   ├── EAP.java
                │   │   └── SRB.java
                │   ├── capsule/
                │   │   ├── Apollo.java
                │   │   ├── Capsule.java
                │   │   ├── CargoDragon.java
                │   │   ├── CrewDragon.java
                │   │   └── Orion.java
                │   ├── launcher/
                │   │   ├── Ariane5.java
                │   │   ├── Falcon9.java
                │   │   ├── Launcher.java
                │   │   ├── SLS.java
                │   │   └── SaturneV.java
                │   └── mission/
                │       ├── ISS.java
                │       ├── Lune.java
                │       ├── Mars.java
                │       ├── Mission.java
                │       ├── Orbite.java
                │       └── Pluton.java
                └── service/ # Gère les différentes fonctions 
                    ├── LaunchController.java # Création de la fusée
                    └── SaveManager.java # Système de sauvegarde

```
## Diagramme UML

Voici la représentation schématique de la logique suivie lors du projet. 

![App Screenshot](https://uml.planttext.com/plantuml/png/hLZDRkCs4Bu7y3i8lcooKOmjYZrKM2pMiPsk0JinB6U1eYWAMc8S8XBfabIoQPfx-oXzZhnO-ICg8aNvByqbzlpFSBxXq5yO1vGNUTOvOdS8hm45UP1aWB4-vnGj2mx72S4n-XC67pf7dQDtmTdPMJ2z6hxyFHd5yekaha5o1rOmw0fZC4UibvCKPZtnYI62ky5JvoWGVs39E0K9rnw2gMORhlmx2p38OHJ4mZbUrUavm1YcKR0a98C0rraf4bdWHAXbn5RYo6_ife3PWC2R6vGWY7aKfAHOPl1LvDG4TroF9tIZ21tVeUKnRFDpKdVqPAho7B1RyZ24BA5epQNlasRify4AyaiHKojpgaAKx4Qf57zOHYmbx7efzW9ji7rXvoFbwfLxrl_qwOxZk7wofv9mR6M-9LtBsgJ0q3OdAOVRcmBAR7kIShYzAxf4t8bGqmwtESiARiFZjAJjQ_Dv0qWpKE3a5j8sb4vA_fjXceFlid-QO5EiSq8OXpGA4EPrrXeyJWX8VLfhYYJmcjWr8My3hnDHwCOHkjv3ssSRZWLIpWaks0K2IvGXZg2B5Aso4Sg8RKFoL8VVQdjQPID5hBeg_amdrwe_axbkn7YV8e3XHxj5IwBTezjBOXc-09cuTdwo3PV4DncE0IyeXjziouRwDjCJP-09mW46Ds4r0MjMPB0DgWFD_Z-GEeEK4Tn0Or9GAWP_2pSNGUm5r3BWRJXjUWsT64FBzoQO9W3tqrIh7kDbpOOuYdk2qdtkMYz2AkvKXEHdRiVse9wo7xvJKm6BRUDpJRACEF1KDDEOblW0q1KPKh1oRvqQmwz8uODNhw9xrQueSZKKgIQy2GrBFTmgD6YZvSZR3GJmky2Fql1VItlsinctTZytdUpUhWZV4B6JotkT7ROFZYhl1pJgJhV0-UX7-n05mNlUe_xC5XG4hs0yFtT6wVnyjwPmcc5EaZl8T-i5imX5rVvWJJuzgY8pi-gyfTaP9cAt_bGsmUTw_3eEfo-Q3iE66wiPG9fM7GOVgasb_730_AeMfHDVqdeGbIFwn9DvUQCfxwg1FFcRuz8FntWq_pOUR7WuCaZlHRyvnwXZ6n3CgHXUDhZbIC-I8WCSBWW7cUvNgWeUbONtzhQjfZ2mWnQ5VnI8mbHjNhQyGBL-D4RczUZtUmkJkm79rte9UDp5YkUIO2XNqUlQx6t4sOhkeRYHn4auS_D9l1KvIfw3uNW-6Yokvh_yFkilllhWKubUZ2UZ5YaHjV2qOyHXm8eaWN9Elcu2jI7gwNSAGIfpERPuxHC38EnqMgohIfmMgvAJAiVYDcGckLz_QyHHgqKY8kBm4ZwKERD4tli2ix7-O8R0Qsj7ZMOFLT7AuudgP-NDKWDjFfhq5-EhopWOlllwyizylEZ_FDAeCp-xVFfBo8b7kKEHxsg799_63ac_RHsYVfpA8Af7ewANBmANNExpBjaiumtw99QcpPAhBQjbnY7MjXMNK-qZ3aEj7TAwsHuKLTnZ3aLSM0v5t4pUge-2U36_7YokvsNPowlelIonoIiAkZzqBPQ9okPqF_Hwxxi1aJ6LpeM0A1wNFyDq_ST-lHXFnh7wgYDuxUrUxtDpfWgB1HSJYS6kArkV3vPOmuYKBeCMWa8bUsmNDCqZ9EzV_gNe1YdNDMUsEGQAUxW2DFM9rOnPSfsZBn2dHPxz1m00)


## Déclaration IA

L'intelligence artificielle a été utilisée pour quelques petites tâches. Elle a surtout été utilisée pour valider les différents attendus du PDF. 
- Aide sur la documentation java
- Correction sur le format JSON
- Analyse du code pour la recherche de différents bugs. 
- Aide sur la démarche à suivre pour régler les potentielles erreurs. 
## Auteur

Projet scolaire réalisé par :
- [@pnolann](https://github.com/pnolann)

