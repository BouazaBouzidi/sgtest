package entities;

public class Client {
private long id;
private String name;
public Client(long id, String name) {
	super();
	this.id = id;
	this.name = name;
}
public Client() {
	super();
	// TODO Auto-generated constructor stub
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}


}
