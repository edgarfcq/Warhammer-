# Éditeur de liste d'armée pour jeu de plateau, Projet ISEN Java 3ème année

Ce projet est une application console permettant de concevoir des listes d'armées pour des jeux de plateau de type Wargame. 

---

## Fonctionnalités principales

1. **Créer une armée**  
   - Définir un nom pour l'armée.  
   - Spécifier une faction.  
   - Fixer un nombre maximal de points pour l'armée.

2. **Ajouter des groupes**  
   - Chaque groupe a un nom et un total de points correspondant à la somme des unités qu'il contient.  

3. **Ajouter des unités à un groupe**  
   - Deux types d'unités sont disponibles :
     - **Infanterie** : possède un nom, un coût en points, et un type (Soldat, Lourd, Spécial, Chef).
     - **Véhicule** : possède un nom, un coût en points, et un type (Transport ou Attaque). Les véhicules de type Transport ont une capacité de transport.  

4. **Consulter le récapitulatif de l'armée**  
   - Afficher les groupes, unités, points utilisés par chaque groupe et unité, ainsi que les points totaux de l'armée.  

5. **Supprimer des unités ou des groupes**  
   - Permet de supprimer des unités ou des groupes en spécifiant leur index.  
