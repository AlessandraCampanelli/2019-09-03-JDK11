package it.polito.tdp.food.model;

public class StringPeso {
private String a;
private Integer peso;
public StringPeso(String a, Integer peso) {
	super();
	this.a = a;
	this.peso = peso;
}
public String getA() {
	return a;
}
public void setA(String a) {
	this.a = a;
}
public Integer getPeso() {
	return peso;
}
public void setPeso(Integer peso) {
	this.peso = peso;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((a == null) ? 0 : a.hashCode());
	result = prime * result + ((peso == null) ? 0 : peso.hashCode());
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
	StringPeso other = (StringPeso) obj;
	if (a == null) {
		if (other.a != null)
			return false;
	} else if (!a.equals(other.a))
		return false;
	if (peso == null) {
		if (other.peso != null)
			return false;
	} else if (!peso.equals(other.peso))
		return false;
	return true;
}
@Override
public String toString() {
	return  a + "   peso" + peso;
}

}
