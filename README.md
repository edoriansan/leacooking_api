# Démarrage du projet Spring Boot en local

## Prérequis

Avant de démarrer le projet en local, assurez-vous de disposer des prérequis suivants :

- **Java 21 / JDK 21** : Le projet utilise Java 21, donc assurez-vous d'installer la version correcte du JDK sur votre machine. Vous pouvez télécharger la version officielle depuis [le site d'Oracle](https://www.oracle.com/java/technologies/javase-jdk21-downloads.html) ou utiliser une distribution open-source comme OpenJDK.

- **Maven** : Le projet utilise Maven pour la gestion des dépendances et la compilation. Vous pouvez vérifier que Maven est installé avec la commande `mvn -v`. Si ce n'est pas le cas, vous pouvez l'installer depuis [le site officiel de Maven](https://maven.apache.org/download.cgi).

- **Docker** : Nous utilisons Docker pour mettre en place les services nécessaires (PostgreSQL et PgAdmin). Assurez-vous que Docker est installé et fonctionnel. Si ce n'est pas le cas, vous pouvez l'installer depuis [le site de Docker](https://www.docker.com/get-started).

## Démarrage des services Docker

Pour démarrer les services nécessaires (PostgreSQL et PgAdmin), vous pouvez utiliser Docker Compose. Voici les étapes :

1. **Clonez le projet** ou assurez-vous que vous êtes dans le répertoire du projet.

2. **Lancez les services Docker** avec la commande suivante dans votre terminal :

   ```bash
   docker-compose up -d

3. **Créez la base de données** _leacooking_