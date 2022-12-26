import { Component, OnInit } from '@angular/core';
import { Produit } from '../model/produit.model';
import { ProduitService } from '../services/produit.service';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html'
})
export class ProduitsComponent implements OnInit {

   produits? : Produit[];

  constructor(private produitservice:ProduitService) {

   }

  ngOnInit(): void {
     this.produits = this.produitservice.listeProduit();
  }

  //Suppression du produit
  supprimerProduit(produit: Produit){

    /*Message de suppression*/
    let conf = confirm("Êtes-vous sûr ?")
    if(conf){

      this.produitservice.supprimerProduit(produit);

    }

  }

}
