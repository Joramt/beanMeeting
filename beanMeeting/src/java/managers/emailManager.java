/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entities.User;
import service.GestionMail;

/**
 *
 * @author Ruben
 */
public class EmailManager {
	public static void sendMail(User user, String type) {
		String mailTo = user.getEmail();
		String sujet = "Confirmation de Commande.  No.";

		String message = "<div style='margin: 20px 60px; font-size: 120%'>";
		message += "<p>Bonjour " + user.getFirstname() + " " + user.getFirstname() + ",</p>";
                message += "Vous avez reçu un " + type;
//		message += "<P>Voici votre commande dans notre boutique.</p><br/>";
//		message += "<p>idCommande : " + commande.getId() + "</p>";
//		message += "<p>Date d'achat : " + commande.getDateTime() + "</p>";
//		message += "<p>Adresse à envoyer : " + user.getAdresse() + "</p>";
//		message += "<table border=1px><tr><td>idProduit</td><td>Nom de produit</td><td>Quantité</td><td>Prix</td><td>Prix subtotal</td></tr>";


		// on ecrit le panier
//		double total = 0;
//		for (HashMap.Entry<String, Produit> entry : panier.entrySet()) {
//			Produit produit = entry.getValue();
//
//			int id = produit.getId();
//			String nom = produit.getNom();
//			int quantite = produit.getQuatite();
//			double prix = produit.getPrix();
//			double subtotal = quantite * prix;
//			total += subtotal;
//
//			message += "<tr><td>" + id
//					+ "</td><td><a href=http://localhost:8080/TravailFinal/start?option=detail&idProduit=" + id + ">"
//					+ nom + "</a></td><td>" + quantite + "</td><td>" + money.format(prix) + "</td><td>"
//					+ money.format(subtotal) + "</td></tr>";
//		}
//
//		message += "</table><p>Prix total : " + money.format(total);
                message += "</p></div>";
		GestionMail.sendEmail(message, mailTo, sujet);
	}    
}
