package com.mouloud.produits;

import com.mouloud.produits.entities.Categorie;
import com.mouloud.produits.entities.Produit;
import com.mouloud.produits.repos.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ProduitsApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;

	@Test
	public void testCreateProduit(){
		Produit prod = new Produit("imprimante Asus", 500.000, new Date());
		produitRepository.save(prod);
	}

	@Test
	public void testFindProduit(){
		Produit p = produitRepository.findById(1L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdateProduit(){
		Produit p = produitRepository.findById(1L).get();
		p.setPrixProduit(2000.0);
		produitRepository.save(p);
	}

	@Test
	public void testDeleteProduit(){
		produitRepository.deleteById(1L);
	}

	@Test
	public void testListerTousProduits(){
		List<Produit> prods = produitRepository.findAll();
		for(Produit p : prods){
			System.out.println(p);
		}
	}

	@Test
	public void testFindProduitByNom(){
		List<Produit> prods = produitRepository.findByNomProduit("PS 4");
		for (Produit p : prods ){
			System.out.println(p);
		}
	}

	@Test
	public void testFindProduitBynomContains(){
		List<Produit> prods = produitRepository.findByNomProduitContains("p");
		for (Produit p : prods){
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomPrix(){
		List<Produit> prods = produitRepository.findByNomPrix("PS 4", 1000.0);
		for (Produit p : prods){
			System.out.println(p);
		}
	}

	@Test
	public void testFindByCategorie(){
		Categorie cat = new Categorie();
		cat.setIdCat(1L);

		List<Produit> prods = produitRepository.findByCategorie(cat);
		for (Produit p : prods){
			System.out.println(p);
		}
	}

	@Test
	public void testFindByCategorieIdCat(){
		List<Produit> prods = produitRepository.findByCategorieIdCat(2L);
		for (Produit p : prods){
			System.out.println(p);
		}
	}

	@Test
	public void testFindByOrderByNomProduitAsc(){
		List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
		for (Produit p : prods){
			System.out.println(p);
		}
	}

	@Test
	public void testTrieProduitNomsPrix(){
		List<Produit> prods = produitRepository.trierProduitsNomsPrix();
		for (Produit p : prods){
			System.out.println(p);
		}
	}

}
