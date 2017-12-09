/**
 * @File  - Driver.java
 * @Brief - Driver class consist of main method and Display method
 * 			
 * 
 * 
 * @Author Coding Fusion
 *  
 */
import java.util.*;

public class Driver {

	public static void display()
	{
		System.out.println("Press 1 Insert Node at the Beginning");
		System.out.println("Press 2 Insert Node at the End");
		System.out.println("Press 3 Find Node from List");
		System.out.println("Press 4 Delete Node from List");
		System.out.println("Press 5 Sorting Node by ID");
		System.out.println("Press 6 Sorting Node by First Name");
		System.out.println("Press 7 Sorting Node by Last Name");
		System.out.println("Press 8 Clear the List");
		System.out.println("Press 9 Print the Linked List");
		System.out.println("Press 10 Print the option again");
	}
	public static void main(String[] args) {
		String f,l;
		int id;
		int i=0;
		int ch;
		int count=1;
		char flag = 'Y';
		Node n;
		Scanner myScanner = new Scanner(System.in);
		SLL list = new SLL();
		System.out.println("*****************Welcome to Single Linked List*********************");
		display();
		System.out.print("\nHow many node do you want to create at first time");
		i=myScanner.nextInt();
		System.out.print("\nPlease choose your option");
		ch = myScanner.nextInt();
		while(count<=i)
		{
			if(ch==1)
			{
				System.out.print("\nPlease enter the"+i+"ID,First Name,Last Name");
				id=myScanner.nextInt();
				f=myScanner.next();
				l=myScanner.next();
				n=list.CreateNode(id, f, l);
				list.insertAtBegin(n);
			}
			else if(ch==2)
			{
				System.out.print("\nPlease enter the Node "+count+" : ID,First Name,Last Name");
				id=myScanner.nextInt();
				f=myScanner.next();
				l=myScanner.next();
				n=list.CreateNode(id, f, l);
				list.insertAtEnd(n);
			}
			else
			{
				System.out.println("\nIts wrong choice,Please execute again with correct value");
			}
			count++;
		}
		while(flag=='Y')
			{
				System.out.print("\nDo you want to continue , Press Y or N to Exit");
				flag = myScanner.next().charAt(0);
				if(flag=='Y')
				{
					System.out.print("Please enter your choice");
					ch=myScanner.nextInt();
					switch(ch){
					case 1: System.out.print("\nPlease enter the ID,First Name,Last Name");
							id=myScanner.nextInt();
							f=myScanner.next();
							l=myScanner.next();
							n=list.CreateNode(id, f, l);
							list.insertAtBegin(n);
							break;
					case 2:	System.out.print("\nPlease enter the ID,First Name,Last Name");
							id=myScanner.nextInt();
							f=myScanner.next();
							l=myScanner.next();
							n=list.CreateNode(id, f, l);
							list.insertAtEnd(n);
							break;
					case 3: System.out.print("\nPlease enter the ID,First Name,Last Name");
							id=myScanner.nextInt();
							f=myScanner.next();
							l=myScanner.next();
							list.findNode(id, f, l);
							break;
					case 4: System.out.print("\nPlease enter the ID,First Name,Last Name");
							id=myScanner.nextInt();
							f=myScanner.next();
							l=myScanner.next();
							list.deleteNode(id, f, l);
							break;
					case 5: list.sortbyId();
							System.out.print("Linked List is sorted as per ID");
							break;
					case 6: list.sortbyFname();
							System.out.print("Linked List is sorted as per First Name");
							break;
					case 7: list.sortbyLname();
							System.out.print("Linked List is sorted as per Last Name");
							break;
					case 8: list.clearList();
							System.out.print("Linked List is Deleted");
							break;
					case 9: list.printList();
							break;
					case 10:display();
							break;
					}
				}
			}
			System.out.print("\nThank You ,Program is Terminated.............");
			myScanner.close();
		}
	}
