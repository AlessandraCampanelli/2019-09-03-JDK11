package it.polito.tdp.food.model;

public class Adiacenza {
private String portion1;
private String portion2;
private int peso;
public Adiacenza(String portion1, String portion2, int peso) {
	super();
	this.portion1 = portion1;
	this.portion2 = portion2;
	this.peso = peso;
}
public String getPortion1() {
	return portion1;
}
public void setPortion1(String portion1) {
	this.portion1 = portion1;
}
public String getPortion2() {
	return portion2;
}
public void setPortion2(String portion2) {
	this.portion2 = portion2;
}
public int getPeso() {
	return peso;
}
public void setPeso(int peso) {
	this.peso = peso;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + peso;
	result = prime * result + ((portion1 == null) ? 0 : portion1.hashCode());
	result = prime * result + ((portion2 == null) ? 0 : portion2.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Adiacenza other = (Adiacenza) obj;
	if (peso != other.peso)
		return false;
	if (portion1 == null) {
		if (other.portion1 != null)
			return false;
	} else if (!portion1.equals(other.portion1))
		return false;
	if (portion2 == null) {
		if (other.portion2 != null)
			return false;
	} else if (!portion2.equals(other.portion2))
		return false;
	return true;
}
@Override
public String toString() {
	return "Adiacenza [portion1=" + portion1 + ", portion2=" + portion2 + ", peso=" + peso + "]";
}



}
