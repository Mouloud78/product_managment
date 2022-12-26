import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from '../model/categorie.model';
import { Produit } from '../model/produit.model';
import { ProduitService } from '../services/produit.service';

@Component({
  selector: 'app-update-produit',
  templateUrl: './update-produit.component.html',
  styles: [
  ]
})
export class UpdateProduitComponent implements OnInit {

  //variable qui va stocker le produit à modifier
  currentProduit = new Produit();

  categories! : Categorie[];
  updatedCatId! : number;

  constructor(private activatedRoute : ActivatedRoute,
              private router : Router,
              private produitService : ProduitService) { }

  ngOnInit(): void {
    this.categories = this.produitService.listeCategorie();

    this.currentProduit = this.produitService.consulterProduit(this.activatedRoute.
                                                              snapshot.
                                                              params['id']);
    this.updatedCatId = this.currentProduit.categorie.idCat;
  }



  updateProduit(){

    this.currentProduit.categorie = this.produitService.consulterCategorie(this.updatedCatId);

    this.produitService.updateProduit(this.currentProduit);

    //Retour à la page d'accueille
    this.router.navigate(['produits']);

  }
}
