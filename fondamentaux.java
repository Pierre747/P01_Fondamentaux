/*
 * On va étudier :
 * - la syntaxe de Java
 * - Des variables et du type
 * 			prédéfinis(type valeur)
 * 			référence (type object)
 * - Les boucles
 * - Les tests if
 * - Quelques classes (string, DecimalFormat, BigDecimal, Vector, Treemap, ArrayList, ...)
 * - Les tableaux
 * - Le clonage
 * - Appel de méthodes et passage de paramètres
 * - JavaDoc
 * - var
 * - Différents opérateurs
 * - Etc... 
*/


package com.formation.poitiers;

/** Commentaire javadoc qui permet de documenter l'application, ses classes et ses méthodes.
 * 	Dans cette classe on étudie les aspects fondamentaux du language Java
 * @author Pierre
 * @version 4.3
 */

import static java.lang.System.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;

/**
 * 
 * @author Administrateur
 *
 */
public class fondamentaux {
	/**Le point d'entrée de l'application
	 * @param args: les arguments transmis à l'application
	 */
	
	// Si on survole le nom de la classe avec le pointeur, on voit le contenu javadoc dans un popup
	// On peux même ouvrir une vue javadoc comme ceci : dans Window / Show View / Other... / on va taper 'javadoc' dans le filtre puis on clique sur 'open' 
	// Pour obtenir la documentation javadoc : Project / Generate Javadoc...
	public static void main(String[] args) {
		System.out.println("Bonjour Eclipse");
		// avec import static de type java.lang.System, on peut simplifier	
		out.println("Bonjour Poitiers");
		
		// Java est un language fortement typé :
        // - Chaque variable doit être déclarée avant l'usage
		// - Les transformations de type (transtypage) sont strictement surveillées
		//	 Certaines transformations sont automatique: Exemple int => long, int => float
		//   On parle d'un cast implicite
		//   intv2 = 3;
		//   long v1 = v2;
		//   Le compilateur va prendre le contenu de v2 et le mettre dans v1
		
		//   D'autres doivent être imposés par le développeur, ex long => int:
		//   long v1 = 3;
		//   long v2 = v1;
		//   Là, ça ne passe pas, on doit donc préciser ceci :
		//   long v1 = 3;
		//   long v2 = (int)v1;
		
		//   D'autres cas sont strictement impossibles :
		//   String no = "3";
		//   int n = (int)no;
		
		//	 Variables de type prédéfini (ou variables de type valeur)
		//   int, long, float, double, char, boolean, byte
		
		int maPremiereVariable = 5;
		
		int maDeuxiemeVariable;
		
		maDeuxiemeVariable = 4;
		
		//   L'opérateur + est surchargé pour réaliser la concaténation de deux chaînes de caractères
		//   Le + transforme la valeur en chaîne de caratères en deux étapes :
		//      1 - maPremiereVariable est transformée en objet de type Integer (autoboxing)
		//      2 - La méthode toString() est appelée pour sortir le contenue de l'objet
		//          en format chaîne de caractères 
		
		String toto = "Mes variables sont " + maPremiereVariable;
		
		System.out.println(toto + " et " + maDeuxiemeVariable);
		
		Integer nbEnfants = 5; // Ceci est un autoboxing (mise en boîte, envelopper une valeur)
		
		// L'opération contraire :
		int leNombreEnfant = nbEnfants; // Ceci est un déballage automatique (unboxing)
		
		// Les classes Integer, Long, Float, etc... s'appellent des classes "wrapper" (boite, enveloppe)
		// Ces classes contiennent des méthodes utilitaires pour connaître la taille mémoire d'un entier
		// Long, Float, etc... les valeurs maximum et minimum, etc...
		
		System.out.println("Taille d'un entier : " + Integer.SIZE +
				"\n Valeur maximum d'un entier : " + Integer.MAX_VALUE +
				"\n Valeur minimum d'un entier : " + Integer.MIN_VALUE);
		
		int salaire = 2147483647 + 1;
		
		System.out.println("Salaire : " + salaire);
		
		System.out.println("Nombre d'enfants : " + nbEnfants);
		System.out.println("Nombre d'enfants : " + nbEnfants.toString()); // C'est la même chose que la ligne précédente car le compilateur le gère automatiquement
		
		// Étudier la précision du type Float (réel = valeur avec partie déciimale)
		// Attention : Toute valeur ayant une virgule est lue par le compilateur comme un Double, part défaut, d'où la ligne rouge.
		// Je dois donc lui préciser qu'il sagit d'un float en mettant soit (float) au début de la valeur ou le "f" à la fion de cette dernière.
//		float f1 = 0.123456789;
		float f2 = (float)0.123456789;
		float f3 = 0.123456789f;
		
//		Réel en double précision :
		double d1 = 0.123456789123456789;
		System.out.println(f2); // precision: 6 - 7 chiffres pour la partie décimale
		System.out.println(d1); // précision: 17 chiffres pour la partie décimale
		
		// On peut gérer le format de sortie d'une valeur en utilisant la classe DecimalFormat
		
		DecimalFormat df = new DecimalFormat("###0.000");
		
		// On va utiliser le format définit dans la variable df pour formatter la sortie de f1 :
		System.out.println("f2 formatté : " + df.format(f2) + " d2 formatté : " + df.format(d1));
		
		// Dans le cas suivant le résultat donné n'est pas suffisamment précis
		System.out.println("1.3 - 1.2 = " + (1.3 - 1.2)); // 1.3 - 1.2 = 0.10000000000000009
		
		// On va donc utiliser la classe BigDecimal qui utilise une string
		BigDecimal bd1 = new BigDecimal("1.3");
		
		BigDecimal bd2 = new BigDecimal("1.2");
		
		// Désormais, pour faire l'opération mathématique, je vais utiliser une méthode de la classe BigDecimal
		
		System.out.println("1.3 - 1.2 = " + bd1.subtract(bd2)); // 1.3 - 1.2 = 0.1
		
		boolean monBoolean = 1 > 3; // Dans ce cas, ça donnera false
		boolean monBoolean2 = true; // Là, c'est true (soit avec une valeur calculée, soit de façon explicite)
		
//		=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=--=-=-=-=--=-=-=-=

		// Le type char
		char c = 'A'; // On doit utiliser les simple quotes
		
		// derrière chaque caractère, il y a un code qui peut être affiché ou utiliser dans des opérations aritmétiques
		System.out.println("C = " + c + ", code = " + (int)c); // C = A, code = 65
		
		System.out.println("A + 3 = " + 'A' + 3); //A + 3 = A3
		// Pour éviter pourrait utiliser :
		System.out.println("A + 3 = " + (int)'A' + 3); // A + 3 = 653
		// Mais ça ne va pas, le bon ordre est :
		System.out.println("A + 3 = " + (char)((int)'A' + 3)); //A + 3 = D
		
		
//		=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=--=-=-=-=--=-=-=-=
		
		
		// Classe String
		
		String chaine = "Bonjour, j'aime Java, Javascript et l'île Java";
		// Pour trouver la permière occurrence de "Ja", son idex, sa position
		System.out.println("La position de 'Ja' dans la variable chaine : " + chaine.indexOf("Ja"));
		
		// Pour trouver toutes les positions de "Ja" dans la variable chaine
		// On va utiliser une boucle for indexée
		
		int pos = 0; // pos définie le début de la recherche avec indexOf
		
		for(;;){
			
			if(pos >= chaine.length())
				break;
			
			pos = chaine.indexOf("Ja", pos);
			// Pour vérifier si l'on a trouvé quelque chose, on va utiliser un if
			
			if(pos == -1)
				break; // Si rien n'est trouvé, je break et je sors
			
			System.out.println("La position de ma boucle for1 est " + pos + " ");
			
			pos++;
		}
		
//		=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-= //
		
		for(int p=0; ;p++){
			
			p = chaine.indexOf("Ja", p);
			// Pour vérifier si l'on a trouvé quelque chose, on va utiliser un if
			
			if(p == -1)
				break;
			else
				System.out.println("La position de ma boucle for 2 est " + p + " ");
			
		} // fin du for
		
//		=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-= //
		
		
		while(true)
		{
			pos = chaine.indexOf("Ja", pos);
			if(pos != -1)
				System.out.println("La position de ma boucle while est " + pos + " ");
			else
				break;
			
			pos++;
		}
		
		// Attention, les chaînes de caractères sont immuables. On ne peut pas les modifier.
		// Corolaire: Tout opération sur une chaîne va en créer une autre
		// L'ancienne chaîne continuera d'exister dans la mémoire mais ne sera plus accessible
		// Cela donne des fuites de mémoire.
		
		// Java gère ces fuites grâce a un Garbage Collector(GC)
		// Cet utilitaire est appelé automatiquement par Java lorsque l'application est à court de mémoire.
		// On peut le forcer, si on le désire, mais ce n'est pas conseillé car le GC consomme beaucoup de ressources processeur.
		
//		=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-= //
		
		// exemple de test if complet :
		
		float monSalaire = 1700;
		
		if(monSalaire < 1100)
		{
			System.out.println("Avec un salaire de " + monSalaire + "Vous avez droit à des aides sociales");
		} else if (monSalaire < 1500)
		{
			System.out.println("Avec un salaire de " + monSalaire + "Vous avez le droit à la gratuité du transport en commun");
		} else if(monSalaire < 2500)
		{
			System.out.println("Avec un salaire de " + monSalaire + "Vous avez le droit de payer des impôts");
		} else 
		{
			System.out.println("Avec un salaire de " + monSalaire + "La vie est belle pour vous");
		}
		
		
		// Commutateur switch
		switch(nbEnfants)
		{
			case 0:
				System.out.println("Vous n'avez pas d'enfants");
				break;
			case 1:
			case 2:
				System.out.println("Vous avez une belle famille");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println("Vous avez une famille nombreuse");
				break;
			default:
				System.out.println("Vous avez droit à des aides sociales");
				break;
				
		}
		
//		=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-= //
		
		// Les tableaux
		
		// Déclarer un tableau d'entiers
		
		int[] tb;
		
		// Désormais, je construis le tableau
		
		tb = new int [4];
				
		// le mot clé new va attribuer un espace mémoire
		// On va maintenant initialiser le tableau
		
		for(int i = 0; i < tb.length; i++) 
		{
			tb[i] = i + 1;
		}
		
		// On va afficher les éléments du tableau
		
		for(int i = 0; i < tb.length; i++)
		{
			System.out.println("tb[" + i + "]" + " = " + tb[i]);
		}
		
//		System.out.println("Les éléments du tableau affichés avec un for étendu (comme un foreach)");
		
//		int n = 0;
		
		// v va parcourir le tableau tb
//		for(int v : tb)
//		{
//			System.out.println("tb[" + n + "]" + " = " + tb[v]);
//			n++;
//			
//			System.out.println("tb[" + n++ + "]" + " = " + tb[v]);
//		}
		
		// Opérateur ++ et -- :
		int nb = 5;
		
		// nb++ est une abréviation de n = n + 1 : C'est une post incrémentation
		// L'incrémentation a lieu après l'opération en cours (ici, c'est le test de la valeur de nb)
		if(nb++ == 6)
			System.out.println("nb devrait être égal à 6, sa valeur réelle est bien " + nb);
		else
			System.out.println("nb n'est pas égal à 6, sa valeur réelle est " + nb);
		
		// remise à l'état initial de nb :
		
		nb = 5;
		// ++nb est une abréviation de n = n+1 : C'est une pré incrémentation
		// L'incrémentation a lieu, juste avant l'opération en cours (ici aussi, c'est le test de la valeur de nb)
		if(++nb == 6)
			System.out.println("nb devrait être égal à 6, sa valeur réelle est bien " + nb);
		else
			System.out.println("nb n'est pas égal à 6, sa valeur réelle est " + nb);
		
		
		// Autre méthode pour déclarer, créer et initialiser un tableau : l'agrégat de valeurs
		
		double[] temperatures = {
			12.5, -2.7, 25.2	
		};
		
		System.out.println("Les températures sont : ");
		for(double t : temperatures)
		{
			System.out.println(t);
		}
		
		
//		=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-= //
		
		
		// Java ne définit que des tableaux à deux dimensions.
		// Pour simuler des tableaux multidimensionnels, on utilise les tableaux de tableaux (Jagged Array)
		// les Jagged Array avec Java : https://www.geeksforgeeks.org/jagged-array-in-java/
		
		// On va créer un tableau triangulaire
		
		int[][] tb2dim;
		
		tb2dim = new int[4][];

		// Le premier tableau est créé mais pas initialisé
		
		// Initialisation du tableau primaire avec les tableaux de deuxième degré
		
		for(int i = 0; i < tb2dim.length; i++)
		{
			tb2dim[i] = new int[i+1];
		}
		
		// Désormais, on va peupler les tableaux du deuxième degré
		
		for(int i = 0; i < tb2dim.length; i++)
		{
			for(int j = 0; j < tb2dim[i].length; j++)
			{
				tb2dim[i][j] = (i+1) * (j+1);
			}
		}
		
		System.out.println("Contenu du tableau tb2dim :");
		
		for(int i = 0; i < tb2dim.length; i++)
		{
			for(int j = 0; j < tb2dim[i].length; j++)
			{
				System.out.print(tb2dim[i][j] + " ");
			}
			System.out.println(); // retour à la ligne, on passe au tableau suivant de deuxième niveau
		}
		
		
//		=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-= //
		
		
		// Créer un tableau de tableau avec un agrégat de valeurs
		
		double[][] longueurs = {
				{2, 3.5, 1.23},
				{1.8},
				{1.14, 3.2},
		};
		
		System.out.println("Le tableau de longueurs :");
		
		for(int i = 0; i < longueurs.length; i++)
		{
			for(int j = 0; j < longueurs[i].length; j++)
			{
				System.out.print(longueurs[i][j] + " ");
			}
			System.out.println(); // retour à la ligne, on passe au tableau suivant de deuxième niveau
		}
		
//		=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-= //
		
		System.out.println("Le tableau de nomsPrenoms :");
		
		// Exemple de tableau ayant le même nombre de colonnes sur toutes les lignes (comme une matrice)
		
		String[][] nomsPrenoms = {
				{"Macron", "Emmanuel"},
				{"Chirac", "Jacques"},
				{"Jospin", "Lionel"},
		};
		
		
//		=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-= //
		
		// Le clonage :
		// On va utiliser le tableau tb que l'on a crée précédemmant.
		// Disons que je désire changer une ou plusieurs valeurs de ce tableau
		// mais qu'avant je voudrais le sauvegarder en créant une copie pour
		// ne pas perdre les valeurs initiales
		
		int[] tbSauvegarde = tb; // je sauvegarde le tableau original
		
		tb[0] = 11; // je modifie la valeur initiale de tb[0]
		
		System.out.println("Les éléments du tableau tb après modification :");
		for(int v : tb)
		{
			System.out.println(v + " ");
		}
		
		System.out.println("\nLes éléments du tableau tbSauvegarde :");
		
		for(int v : tbSauvegarde)
		{
			System.out.println(v + " ");
		}
		
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		
		// Ici, on voit que cela ne marhe pas du côté du tableau sauvegardé.
		// Les valeurs des deux tableaux sont les mêmes car tb et tbSauvegarde pointent sur la même zone de mémoire.
		// Une modification sur l'un des deux impacte l'autre.
		
		// Pour réaliser une vraie sauvegarde, on a 2 possibilités :
		// 1 - Créer un tableau ayant la même dimension que le tableau à sauvegarder et y copier les valeurs à conserver.
		// 2 - Utiliser la méthode de clonage de Java : clone() 
		
		// Première possibilité :
		
		int[] tbSauvegarde2 = new int[tb.length];
		
		// on initialise le tableau
		
		for(int i = 0; i < tb.length; i++)
		{
			tbSauvegarde2[i] = tb[i];
		}
		
		tb[0] = 111;
		
		System.out.println("Les éléments du tableau tb après la deuxième modification :");
		
		for(int v : tb)
		{
			System.out.println(v + " ");
		}
		
		System.out.println("\nLes éléments du tableau tbSauvegarde2 :");
		
		for(int v : tbSauvegarde2)
		{
			System.out.println(v + " ");
		}
		
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		// Deuxième possibilité :
		// La méthode clone() qui fait une copie bit à bit de la zone de mémoire concernée
		
		int[] tbSauvegarde3 = tb.clone();
		
		tb[0] = 222;
		
		System.out.println("Les éléments du tableau tb après la troisième modification :");
		
		for(int v : tb)
		{
			System.out.println(v + " ");
		}
		
		System.out.println("\nLes éléments du tableau tbSauvegarde3 :");
		
		for(int v : tbSauvegarde3)
		{
			System.out.println(v + " ");
		}
		
		
//		=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-= //
		
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		
		// Quelques classes importantes :
		// La classe Vector : C'est une classe container générique qui stocke des informations 
		// L'opérateur diamant <> permet de préciser le type concret (Integer, ArrayList, TreeMap, Object, etc..)
	
		Vector<Object> container = new Vector<Object>(); // On peut aussi l'écrire comme ça depuis Java 8 :  new Vector<>();
		container.add(tbSauvegarde2);
		
		// TreeMap est un container qui associe des clés K à des valeurs V. Il peut être vu comme un dictionnaire.
		// Il est stucturé comme un arbre binaire de recherche.
		// Les types d'éléments génériques à préciser sont : le type de la clé et le type de la valeur attachée à la clé.
		
		TreeMap<String, String> arbre = new TreeMap<>();
		
		// On va peupler l'arbre avec put
		
		arbre.put("nom", "Durand");
		arbre.put("couleur", "violet");
		arbre.put("formation", "java");
		
		// On va récupérer les valeurs à partir de l'arbre
		
		System.out.println(arbre.get("couleur"));
		
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		
		// On rajoute l'arbre à l'intérieu du container :
		
		container.add(arbre);
		
		// Les tables de Hashage : Hashtable. 
		// Une Hashtable Java est un container qui possède des paires clé/valeur stockées. 
		// Hashtable est assez similaire à HashMap. 
		// La différence principale entre les deux est que Hashtable est synchronisée, tandis que HashMap ne l'est pas. 
		
		Hashtable<String, String> ht = new Hashtable<>();
		
		ht.put("06 95 07 24 21", "Valentin");
		ht.put("06 95 02 03 04", "Marie");
		ht.put("06 95 05 06 07", "Pierre");
		
		System.out.println("Le prénom de la personne qui a le numéro : 06 95 07 24 21 est " + ht.get("06 95 07 24 21"));
		
		container.add(ht);
		
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		
		System.out.println("Tout le contenu de ht");
		
		for(String cle : ht.keySet()) // keyset() fait appel à la collection des clés
		{
			System.out.println("cle: " + cle + " valeur : " + ht.get(cle));
		}
		
		// Pour l'exemple, on va créer un autre vecteur à stocker dans notre container
		Vector<Object> autreVecteur = new Vector<>();
		autreVecteur.add(3.5); // Le compileur va demander au runtime de stocker le 3.5 dans la mémoire vive grâce à l'auto boxing
		
		container.add(autreVecteur); // Désormais, je l'ajoute au permier vecteur : container.
		
		// On va désormais créer une méthode pour afficher le contenu de container
		
		afficherContenuVecteur(container, "");
		
		
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		
		
//		=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-= //
		
		
		// Je veux passer deux valeurs à une méthode et changer le contenu de ces variables
		int i1 = 1;
		int i2 = 2;
		
		System.out.println("Valeurs initiales : i1 = " + i1 + " i2 = " + i2);
		
		interchanger(i1, i2);
		
		System.out.println("Valeurs après changement : i1 = " + i1 + " i2 = " + i2);
		
		// On constate que i1 et i2 ont les mêmes valeurs après l'appel de la méthode interchanger()
		// Ceci est dû au fait que la méthode a changé les paramètres passés (a et b) et n'a pas touché les variables i1 et i2
		// Java transmet les paramètres par copie des valeurs et donc la méthode interchanger a changé de copie et non pas les valeurs elles-mêmes.
		
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		
		
		// Solutions possibles :
		// 1 - Utiliser un tableau.
		
		int[] tbi = {1, 2};
		
		System.out.println("Les valeurs initiales de tbi[0] sont : " + tbi[0] + " tbi[1] : " + tbi[1]);
		
		interchanger2(tbi); // On crée une nouvelle méthode et on lui passe le tableau
		
		System.out.println("Les valeurs après interchanger 2 de tbi[0] sont : " + tbi[0] + " tbi[1] : " + tbi[1]);
		
		// Cette fois, la méthode interchanger2 donne les résultats attendus car le passage du paramètre tb se fait par valeur.
		// C'est à dire que tb va contenir l'addresse mémoire du tbi donc la méthode travaille sur le même tableau que celui
		// qui contient la valeur a interchanger.
		
		
//		=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-= //
		
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		
		// Les opérateurs
		// - arithmétiques (+, -, *, /, % modulo)
		// - affectation (=, +=, -=, *=, /=, %=, ++, --, &=, |=, ^=, >>=, <<=)
		// - logique (&&, ||, ^) (^ = XOR, le ou expliscite)
		// - comparaison (==, !=, >, <, <=, >=)
		// - opérateurs sur bits (&, |, ^, ~, etc...)
		// En jugeant sur le nombre de valeurs qui sont affectées par l'opérateur, on trouve les opérateurs unaires, binaires et ternaires.
		// - Unaires : ils asgissent sur une valeur => ++ ou --. (ex: n++)
		// - Binaires : ils agissent sur deux valeurs => +, -, /, *, % (ex: a + b)
		// - Ternaires : valeur à tester ? si oui valeur a : sinon valeur b
		
		salaire = 900;
		String msg = salaire < 1000 ? "Vous avez droit à certaines aides sociales" : "Votre salaire vous suffit";
		
		System.out.println(msg);
		
		salaire = 3500;
		
		System.out.println(salaire < 1000 ? "Vous avez droit à certaines aides sociales" : "Votre salaire vous suffit");
		
		
		
//		=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-= //
		
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		
		// Le mot-clef var
		// Il permet d'éviter de donner un type à la variable que l'on veut stocker.
		
		var k = 2;
		
		// Le mot clé var demande au compilateur de trouver le type de la variable à partir de la valeur affectée.
		// Une fois le type trouvé, il ne peut plus être changé.
		
		// Je veux afficher le type de la variable k, donné par le compilateur
		System.out.println("Le type de la variable k est : " + ((Object)k).getClass().getName()); // java.lang.Integer

		// Si je veux stocker, dans la variable k, une valeur d'un autre type, le compilateur me signale un erreur.
		// k = "Pierre"; Type mismatch: cannot convert from String to int
		
//		=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-= //
		
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		
		// var et collections
		
		var amis = List.of("Pierre", "Marie");
		
		System.out.println("La liste des amis est composée de : " + amis);
		System.out.println("Le type de la liste est : " + amis.getClass().getName());
		
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		
		var annuaire = new Hashtable<String, String>();
		
		annuaire.put("Pierre", "01 23 45 67 89");
		annuaire.put("Marie", "01 22 33 44 55");
		
		System.out.println(annuaire);
		System.out.println(annuaire.get("Marie"));
		
		
//		=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-= //
		
		System.out.println();
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println();
		
		// var et les classes anonymes
		
		// On va d'abord créer une classe anonyme qui implémente l'interface Runnable.
		// Runnable est une interface qui impose la méthode run().
		// C'est donc cette méthode que je dois overrider.
		// On va ensuite créer une instance de cette classe anonyme (de ce thread).
		
		var monThread = new Runnable()
				{
					@Override
					public void run() {
						// Je veux afficher la date une fois par seconde, pendant 5 secondes
						long dateInitiale = new Date().getTime(); // Je récupère la date courante sous la forme d'un long 
						// contenant le nombre de millisecondes écoulées à partir du 01 / 01 / 1970 00:00 GMT
						long dateFinale = dateInitiale + 5000; // 5000 ms = 5 secondes
						
						// On initialise un compteur
						int compteur = 1;
						
						for(;;)
						{
							// Afficher la date courante
							System.out.println(compteur + " " + (new Date()));
							// Mettre le thread en attente
							try {
								Thread.sleep(1000);
							} catch (InterruptedException ex) { // On peut avoir plusieurs catch, chacun spécialisé. Aucun si finally est présent.
								ex.printStackTrace();
							} finally { // close optionnelle si au moins un catch est présent
//								System.out.println("Je passe par finally que je réussise ou que j'ai une erreur");
							}
							
							var dateCourante = new Date().getTime();
							
							if(dateCourante < dateFinale)
							{
								compteur++;
							} else {
								break;
							}
							
						}// fin du for
						
					} // fin du run
					
				};
		
		// On va lancer le thread, l'instance de la classe anonyme
				monThread.run();
				
				
				
				
//				=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-= //
				
				System.out.println();
				System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				System.out.println();
				
				// var et l'opérateur diamant <>
				// Plus haut, on a utilisé var annuaire = new Hashtable<String, String>()
				// Si je mets rien dans mes diamants, le type sera un Object
				
				var maListe = new ArrayList<>();
				
				// Si maintenant je veux écrire maListe.add(), je constate que l'assistant propose la méthode 
				// add(Object), donc les éléments à stocker dans mon ArrayList sont de type Object.
				
				
				
		System.out.println("\n Fin du main");
		
	}// fin main
	
	static void afficherContenuVecteur(Vector<?> depot, String indentation) // Avec le <?> le type sera définit plus tard. On met le type de retour void car la méthode ne retourne rien
	{
		System.out.println(indentation + "Le vecteur contient " + depot.size() + " éléments :");
		
		int i = 0;
		
		for( Object elementCourant : depot)
		{
			// On va analyser le type de l'élément courant
			System.out.println("les types sont " + indentation + elementCourant.getClass().getSimpleName()); // On prend la classe de l'élément courant grace à getClass() puis avec getSimpleName() on récupère le nom
			if(elementCourant instanceof int[])
			{
				System.out.println(indentation + "L'élément courant " + i + " est un tableau d'entier. Ses valeurs sont : ");
				System.out.println(indentation + "                        ");
				for(int v : (int[])elementCourant)
				{
					System.out.print(v + " ");
				}
				System.out.println();
			} else if(elementCourant instanceof Integer)
			{
				System.out.println(indentation + "L'élément courant " + i + " est un entier : " + (int[])elementCourant); // Je caste elementCourant
			} else if(elementCourant instanceof TreeMap)
			{
				System.out.println(indentation + "L'élément courant " + i + " est une TreeMap. Son contenu est : "); // Je caste elementCourant
				
				TreeMap<?, ?> tm = (TreeMap<?, ?>)elementCourant;
				
				// Désormais, on va récupérer les clés :
				
				Object[] lesCles = tm.keySet().toArray(); // set est une interface et je la transforme en un array
			
				for(Object cle : lesCles)
				{
					System.out.println(indentation + "                        " + "Clef : " + cle + ", valeur : " + tm.get(cle));
				}
				}else if(elementCourant instanceof Hashtable)
				{
					System.out.println(indentation + "L'élément courant " + i + " est une hashtable et son contenu est : ");
					Hashtable<?, ?> ht = (Hashtable<?, ?>)elementCourant;
					Object[] lesCles = ht.keySet().toArray();
					
					for(Object cle : lesCles)
					{
						System.out.println("cle: " + cle + " valeur : " + ht.get(cle));
					}
				} else if(elementCourant instanceof Vector)
				{
					System.out.println(indentation + "L'élément courant " + i + " est un vecteur et son contenu est : ");
					// Appel récursif de afficherContenuVecteur()
					afficherContenuVecteur((Vector<?>)elementCourant, indentation + "   ");
				}
				
			}
		} // Fin du for
	
		// On va essayer de marque cette méthode comme obsolète car elle ne fonctionne pas.
		// On va donc utiliser un commentaire JavaDoc avec un @deprecated
	/**
	 * Le but est d'interchanger les valeurs des valeurs passées en argument.
	 * @deprecated depuis la version interchanger2
	 * @see interchanger2(int[] tb)
	 * @param a Une valeur entière
	 * @param b Une valeur entière
	 */
	  static void interchanger(int a, int b) // le mot clé static me permet de dire que cela appartient à la classe
	  {
		int temp = b;
		b = a;
		a = temp;
	  }
	  /**
	   * Le but est d'interchanger les valeurs des valeurs passées en argument.
	   * @param tb
	   */
	  static void interchanger2(int[] tb)
	  {
		  int temp = tb[0];
		  tb[0] = tb[1];
		  tb[1] = temp;
	  }
	  
	
	} // fin classe

