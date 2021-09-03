package it.polito.tdp.food.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;


import it.polito.tdp.food.db.FoodDao;




public class Model {
	
	private FoodDao dao;
	private Map <Long,Food>idMap;
	private SimpleWeightedGraph<String,DefaultWeightedEdge> grafo;
	
	public Model() {
		
		this.dao = new FoodDao();
		idMap= new HashMap <Long,Food> ();
	}
	public void creaGrafo(Integer calorie) {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(grafo, dao.getVertix(calorie));
		
		//AGGIUNGO GLI ARCHI CON LE ADIACENZE
		for(Adiacenza a:dao.getAdiacenza())
		{
			if (this.grafo.vertexSet().contains(a.getPortion1()) && 
					this.grafo.vertexSet().contains(a.getPortion2())) 
			if(this.grafo.getEdge(a.getPortion1(), a.getPortion2())==null)//SE NON HO NESSUN ARCO, DEVO SEMPRE FARE QUESTO CONTROLLO
		 Graphs.addEdgeWithVertices(grafo, a.getPortion1(), a.getPortion2(), a.getPeso());
		}
		System.out.println("# Vertici: " + this.grafo.vertexSet().size());
		System.out.println("# Archi: " + this.grafo.edgeSet().size());
	}
	public List<Adiacenza> getAdiacenza (){
		return this.dao.getAdiacenza();
	}
	public LinkedList<StringPeso> trovaVicini  (String vicino ){
		LinkedList<StringPeso> lista = new LinkedList<>();
		for(String a : Graphs.neighborListOf(grafo, vicino)) {
			Integer peso = (int) grafo.getEdgeWeight(grafo.getEdge(vicino, a));
			lista.add(new StringPeso(a, peso));}
		
		return lista;
	}
	
}
