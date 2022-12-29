package com.mouloud.produits.restcontrollers;

import com.mouloud.produits.entities.Produit;
import com.mouloud.produits.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRESTController {

    @Autowired
    ProduitService produitService;

    //Afficher tout les produits
    @RequestMapping(method = RequestMethod.GET)
    public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }

    //Afficher unproduit
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Produit getProduitById(@PathVariable("id") Long id){
        return produitService.getProduit(id);
    }

    //Créer un produit
    @RequestMapping(method = RequestMethod.POST)
    public Produit createProduit(@RequestBody Produit produit){
        return produitService.saveProduit(produit);
    }

    //Modifier un produit
    @RequestMapping(method = RequestMethod.PUT)
    public Produit updateProduit(@RequestBody Produit produit){
        return produitService.updateProduit(produit);
    }

    //Supprimer un produit par id
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteProduit(@PathVariable("id") Long id){
        produitService.deleteProduitById(id);
    }

    //Retourner une liste de produits qui ont une catégorie spécifiée
    @RequestMapping(value = "/prodscat/{idCat}", method = RequestMethod.GET)
    public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat){
        return produitService.findByCategorieIdCat(idCat);
    }
}
