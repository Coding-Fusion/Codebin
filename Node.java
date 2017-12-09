/**
 * @File  - Node.java
 * @Brief - Node class consist of basic attribute along with accessors and mutators
 * 			
 *  
 * @Author Coding Fusion
 * 2017  
 */
public class Node 
{
//Attributes Declaration
private String fname;
private String lname;
private int id;
private Node next;

//Node Constructor will initialize all the attribute and create a single Node
public Node(int id,String fname,String lname)
{
	this.fname=fname;
	this.lname=lname;
	this.id=id;
	this.next=null;
}
//Accessor and Mutators
public Node getNext()
{
	return next;
}
public void setNext(Node next)
{
	this.next=next;
}
public String getFirstName()
{
	return fname;
}
public void setFirstName(String fname)
{
	this.fname=fname;
}
public String getLastName()
{
	return lname;
}
public void setLastName(String lname)
{
	this.lname=lname;
}
public int getId()
{
	return id;
}
}
