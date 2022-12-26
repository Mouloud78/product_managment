import { NodeWithI18n } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Categorie } from '../model/categorie.model';
import { Produit } from '../model/produit.model';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  //Déclaration d'un tableau vide de type Produit
  produits : Produit[];
  //Déclaration d'un tableau vide de type Categorie
  categories : Categorie[];
  //Déclaration d'une variable de type Produit (! accepte les undefind)
  produit! : Produit;


  constructor() {
    this.categories=[
      {
        idCat : 1,
        nomCat : "PC"
      },
      {
        idCat : 2,
        nomCat : "Imprimante"
      }
    ];

     this.produits = [
      {
        idProduit: 1,
        nomProduit: "PC Asus",
        prixProduit: 3000.600,
        dateCreation: new Date("01/14/2011"),
        categorie: {idCat : 1, nomCat:"PC"}
      },
      {
        idProduit: 2,
        nomProduit: "Imprimante Epson",
        prixProduit: 450,
        dateCreation: new Date("12/17/2010"),
        categorie : {idCat : 2, nomCat:"Imprimante"}
      },
      {
        idProduit: 3,
        nomProduit: "Tablette Samsung",
        prixProduit: 900.123,
        dateCreation: new Date("02/20/2020"),
        categorie:{idCat : 1, nomCat: "PC"}
      }
    ];
   }

   //Lister la liste des produits
   listeProduit(): Produit[]{
      return this.produits;
   }

   //Ajout
   ajouterProduit(produit: Produit){
      this.produits.push(produit);
   }

   //suppression
   supprimerProduit(prod:Produit){

    //supprimer le produit pro du tableau produits
    /*
      const index = this.produits.indexOf(prod,0);
      if(index > -1){
        this.produits.slice(index, 1);
      }
      */
      //ou bien

      this.produits.forEach((cur, index) => {
        if(prod.idProduit === cur.idProduit){
          this.produits.splice(index, 1);
        }
      });
   }

   //Consulter produit
   consulterProduit(id:number){

    this.produit = this.produits.find(p => p.idProduit == id)!; //(! peut être undefind )
    return this.produit;
   }


  //Modifier produit
   updateProduit(p: Produit){
      this.supprimerProduit(p);
      this.ajouterProduit(p);
      this.trierProduits();
   }


   //Trier le tableau de produits
   trierProduits(){
    this.produits = this.produits.sort((n1, n2) => {
      if(n1.idProduit! > n2.idProduit!){
        return 1;
      }
      if(n1.idProduit! < n2.idProduit!){
        return -1;
      }
      return 0;
    })
   }

   //retourne la liste des catégories
   listeCategorie(): Categorie[]{
    return this.categories;
   }

   //permet de consulter une catégorie
   consulterCategorie(id:number): Categorie{
    return this.categories.find(cat => cat.idCat == id)!;
   }
}
