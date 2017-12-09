/**
 * @File  - SLL.java
 * @Brief - Single Linked List - Demonstrated the major function associated with single linked list
 *          InsertatBegin,InsertatEnd,DeleteNode,FindNode,ClearList, SortbyId,SortbyFirstName,SortbyLastname
 * 			
 
 */
public class SLL {
	private Node Head;
	private Node Tail;
	private Node Current;
	private Node Prev;
	private Node temp;
	
	//CreateNode method will a single node which is pointed to null
	public Node CreateNode(int id,String fname,String lname)
	{
		Node Item = new Node(id,fname,lname);
		return Item;
	}
	//updateHead method will replace the head node with new node
	public void updateHead(Node Item)
	{
		this.Head=Item;
	}
	//updateTail method will replace the tail node with the new node
	public void updateTail(Node Item)
	{
		this.Tail=Item;
		Tail.setNext(null);
	}
	/**insertatBegin is all about insertion of single node to the start, if Head is null, new node becomes Head , else Current node become head,
	 * then we consider new node as Head and point that to the Current
	 * @param Item
	 */
	public void insertAtBegin(Node Item)
	{
		if(Head==null)
		{
			updateHead(Item);
		}
		else
		{
			Current=Head;
			updateHead(Item);
			Head.setNext(Current);
		}
		Current=Head;
		while(Current.getNext()!=null)
		{
			Current=Current.getNext();
		}
		updateTail(Current);
	}
	/**inserAtEnd method used to add new node to the end of the list, If head is null,new node becomes the first node or last node else 
	 * Current node will keep track of all the following node and when it becomes last it is pointed to the new node.
	 * @param Item
	 */
	public void insertAtEnd(Node Item)
	{
		if(Head==null)
		{
			updateHead(Item);
			updateTail(Item);
		}
		else
		{
			Current=Head;
			while(Current.getNext()!=null)
			{
				Current=Current.getNext();
			}
			
			Current.setNext(Item);
			updateTail(Item);
		}
	}
	/**In the deleteNode , id, fname, lname will be passed as argument, Node will first match with head , if head is only the single Node,
	 * Linked List will be empty, else Current will keep track of present node and prev node will keep track of the previous node of the current
	 * if Node is matched prev node will be pointed to the next node of Current .
	 * @param id
	 * @param fname
	 * @param lname
	 */
	public void deleteNode(int id,String fname,String lname)
	{
		
			Current=Head;
			Prev=Current;
			if(Head.getNext()==null)
			{
				if(Head.getId()==id&&Head.getFirstName().equals(fname)&&Head.getLastName().equals(lname))
				{
					Head=null;
			    }
				else
				{
					System.out.println("\nNo Match Found");
				}
			}
			else
			{
			while(Current!=null)
			{
				if(Head.getId()==id&&Head.getFirstName().equals(fname)&&Head.getLastName().equals(lname))
				{
					Head=Current.getNext();
					//Current=Tail;
			    }
				else if(Current.getId()==id&&Current.getFirstName().equals(fname)&&Current.getLastName().equals(lname))
				{
					Prev.setNext(Current.getNext());
					Current=Current.getNext();
				}
				else
				{
					Prev=Current;
					Current=Current.getNext();
				}
			
			}
			}
//			if(Current.getId()==id&&Current.getFirstName().equals(fname)&&Current.getLastName().equals(lname))
//			{
//				updateTail(Prev);
//			}
		}
	//clearList will make head as null , so list will empty
	public void clearList()
	{
		Head=null;
		Tail=null;
	}
	/**findNode will take Node information (fname, lname, and id) as argument, a separate counter variable will keep track of the position of the Node
	 * if it is matched
	 * @param id
	 * @param fname
	 * @param lname
	 */
	public void findNode(int id,String fname,String lname)
	{
		Current=Head;
		int count=1;
		int i=0;
		int pos[]=new int[1000];
		int index =0;
		if(Head.getNext()==null&&Head.getId()==id&&Head.getFirstName().equals(fname)&&Head.getLastName().equals(lname))
		{
			pos[i]=count;
			count++;
		}
		else if(Current.getNext()!=null)
		{
			while(Current.getNext()!=null)
			{
				if(Current.getId()==id&&Current.getFirstName().equals(fname)&&Current.getLastName().equals(lname))
				{
				pos[i]=count;
				i++;
				count++;
				Current=Current.getNext();
				}
				else
				{
				//System.out.println("\n No node found");
				Current=Current.getNext();
				count++;
				}
			}
			if(Tail.getId()==id&&Tail.getFirstName().equals(fname)&&Tail.getLastName().equals(lname))
			{
			pos[i]=count;
			}
		}
		
		if(pos[index]!=0)
		{
		System.out.print("\nThe Position is ");
		while(pos[index]!=0)
		{
			System.out.print(pos[index]+" ");
			index++;
		}
		}
		else
		{
			System.out.println("No match found");
		}
		
	}
	/**sortbyId method works on the sorting of the Node , the method will sort basis on id and it swap the position of the Node
	 * Auxiliary node Prev and temp has been taken to keep track of Current node's Prev address and Prev position respectively
	 */
	public void sortbyId()
			{
				int count=1;
				int i=1;
				Current = Head;
				//Taking the count of nodes in the List
				while(Current.getNext()!=null)
				{
					Current=Current.getNext();
					count++;
				}
				Current = Head;
				Prev = Head;
				if(Current.getNext()==null)
				{
					System.out.print("\nOnly one node is found");
				}
				else
				{
				//Outer while loop counts the iteration till all node in sorted order
					while(i<=count)
					{
				//Inner while loop will help Current node to traverse till it reaches to last node
					while(Current.getNext()!=null)
					{
						if(Current==Head&&Current.getId()>Current.getNext().getId())
						{
							Prev = Current.getNext();
							Current.setNext(Prev.getNext());
							Prev.setNext(Current);
							Head = Prev;
							Prev = Current;
							temp = Head;
						}
						//else if condition will be executed from the second node when Current is not Head and Current's next is not null 
						else if(Current.getId()>Current.getNext().getId())
						{
							Prev = Current.getNext();	//Prev becomes the nexr node 
							Current.setNext(Prev.getNext()); //Current pointed with next to Prev node
							Prev.setNext(Current);	//Prev node is set with Current node address that second and third node swapped between each other
							temp.setNext(Prev);	//Now temp was first node , pointed with Prev which is second node
							temp = Prev;	//temp node move one step ahead in the position of Prev,which is second position
							Prev = Current; //Prev node move one step ahead in the position of Current,which is third position
							
						}
						else
						{
							Current=Current.getNext();	//if second node is not greater than third node Current moves to third position
							temp=Prev;	//temp moves to Prev node's position
							Prev = Current;//Prev moves to Current position
						}
					}
					i++;
					Current=Head;	//Again all variable node set back to Head node's position 
					Prev=Head;
					temp=Head;
					}
				}
			}
	/**sortbyfname method works on the sorting of the Node , the method will sort basis on fname and it swap the position of the Node
	 * Auxiliary node Prev and temp has been taken to keep track of Current node's Prev address and Prev position respectively.
	 * CompareTo method is used to compare the String. if String is greater than other String , it will return greater than 0, if equal , its 0 and if it is 
	 * less than next String, will return less than 0
	 */
	public void sortbyFname()
	{
		int count=1;
		int i=1;
		Current = Head;
		//Taking the count of nodes in the List
		while(Current.getNext()!=null)
		{
			Current=Current.getNext();
			count++;
		}
		Current = Head;
		Prev = Head;
		if(Current.getNext()==null)
		{
			System.out.print("\nOnly one node is found");
		}
		else
		{
		//Outer while loop counts the iteration till all node in sorted order
			while(i<=count)
			{
		//Inner while loop will help Current node to traverse till it reaches to last node
			while(Current.getNext()!=null)
			{
				if(Current==Head&&Current.getFirstName().toLowerCase().compareTo(Current.getNext().getFirstName().toLowerCase())>0)
				{
					Prev = Current.getNext();
					Current.setNext(Prev.getNext());
					Prev.setNext(Current);
					Head = Prev;
					Prev = Current;
					temp = Head;
				}
				//else if condition will be executed from the second node when Current is not Head and Current's next is not null 
				else if(Current.getFirstName().toLowerCase().compareTo(Current.getNext().getFirstName().toLowerCase())>0)
				{
					Prev = Current.getNext();	//Prev becomes the nexr node 
					Current.setNext(Prev.getNext()); //Current pointed with next to Prev node
					Prev.setNext(Current);	//Prev node is set with Current node address that second and third node swapped between each other
					temp.setNext(Prev);	//Now temp was first node , pointed with Prev which is second node
					temp = Prev;	//temp node move one step ahead in the position of Prev,which is second position
					Prev = Current; //Prev node move one step ahead in the position of Current,which is third position
					
				}
				else
				{
					Current=Current.getNext();	//if second node is not greater than third node Current moves to third position
					temp=Prev;	//temp moves to Prev node's position
					Prev = Current;//Prev moves to Current position
				}
			}
			i++;
			Current=Head;	//Again all variable node set back to Head node's position 
			Prev=Head;
			temp=Head;
			}
		}
	}
	/**sortbyfname method works on the sorting of the Node , the method will sort basis on lastname and it swap the position of the Node
	 * Auxiliary node Prev and temp has been taken to keep track of Current node's Prev address and Prev position respectively.
	 * CompareTo method is used to compare the String. if String is greater than other String , it will return greater than 0, if equal , its 0 and if it is 
	 * less than next String, will return less than 0
	 */
	public void sortbyLname()
	{
		int count=1;
		int i=1;
		Current = Head;
		//Taking the count of nodes in the List
		while(Current.getNext()!=null)
		{
			Current=Current.getNext();
			count++;
		}
		Current = Head;
		Prev = Head;
		if(Current.getNext()==null)
		{
			System.out.print("\nOnly one node is found");
		}
		else
		{
		//Outer while loop counts the iteration till all node in sorted order
			while(i<=count)
			{
		//Inner while loop will help Current node to traverse till it reaches to last node
			while(Current.getNext()!=null)
			{
				if(Current==Head&&Current.getLastName().toLowerCase().compareTo(Current.getNext().getLastName().toLowerCase())>0)
				{
					Prev = Current.getNext();
					Current.setNext(Prev.getNext());
					Prev.setNext(Current);
					Head = Prev;
					Prev = Current;
					temp = Head;
				}
				//else if condition will be executed from the second node when Current is not Head and Current's next is not null 
				else if(Current.getLastName().toLowerCase().compareTo(Current.getNext().getLastName().toLowerCase())>0)
				{
					Prev = Current.getNext();	//Prev becomes the nexr node 
					Current.setNext(Prev.getNext()); //Current pointed with next to Prev node
					Prev.setNext(Current);	//Prev node is set with Current node address that second and third node swapped between each other
					temp.setNext(Prev);	//Now temp was first node , pointed with Prev which is second node
					temp = Prev;	//temp node move one step ahead in the position of Prev,which is second position
					Prev = Current; //Prev node move one step ahead in the position of Current,which is third position
					
				}
				else
				{
					Current=Current.getNext();	//if second node is not greater than third node Current moves to third position
					temp=Prev;	//temp moves to Prev node's position
					Prev = Current;//Prev moves to Current position
				}
			}
			i++;
			Current=Head;	//Again all variable node set back to Head node's position 
			Prev=Head;
			temp=Head;
			}
		}
	}
	//The below method will Printing out  all the Node.Here Current Node is considered to keep track of the List.
	public void printList()
	{
		Current=Head;
		
		while(Current!=null&&Current.getNext()!=null)
		{
			System.out.print(Current.getId()+" "+Current.getFirstName()+" "+Current.getLastName()+"->");
			Current=Current.getNext();
		}
		if(Current!=null&&Current.getNext()==null)
		{
		System.out.print(Current.getId()+" "+Current.getFirstName()+" "+Current.getLastName()+"/");
	    }
		else
		{
			System.out.println("\nNo Linked List Found to Print");
		}
	}
	
}
