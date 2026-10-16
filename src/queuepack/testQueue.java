package queuepack;

import java.util.Scanner;

public class testQueue {
	
	public static void printMenu() {
		System.out.println("Welcome to PrintServer! Please select a number from the list.");
		System.out.println("");
		System.out.println("1. Enqueue a job (User enters job details).");
		System.out.println("2. Dequeue a job.");
		System.out.println("3. Peek at the job at front of the queue");
		System.out.println("4. Empty the queue");
		System.out.println("5. Display all jobs.");
		System.out.println("6. Quit the program");
	} // stolen from last weeks stack lab

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		QueueArrayBased queue = new QueueArrayBased();
		
		int choice = 0; //also stolen and edited to fit queue instead of stack
		int nextId = 1;
		
		while(choice != 6) {
			printMenu();
			System.out.print("Enter your choice: ");
            choice = s.nextInt();
            s.nextLine();
			
			if(choice == 1) {
				if (queue.isFull()) {
					System.out.println("The queue is full.");
				} else {
					System.out.print("Enter document name: ");
					String name = s.nextLine();

					System.out.print("Enter number of pages: ");
					int pages = s.nextInt();
					s.nextLine();

					PrintJob job = new PrintJob(nextId, name, pages);
					nextId++;
					
					queue.enqueue(job);
				}
			}
			else if (choice == 2) {
				if (queue.isEmpty()) {
                    System.out.println("The queue is empty.");
                } else {
                        PrintJob job = (PrintJob) queue.dequeue();
                }
			}
			else if (choice == 3) {
				if (queue.isEmpty()) {
                    System.out.println("The queue is empty.");
                } else {
                    try {
                        PrintJob job = (PrintJob) queue.peek();
                        System.out.println("Next job to print: " + job);
                    } catch (QueueException e) {
                        System.out.println(e.getMessage());
                    }
                }
			}
			else if (choice == 4) {
				queue.dequeueAll();
                System.out.println("The queue has been emptied.");
			}
			else if (choice == 5) {
				queue.displayQueue();
				
			}
			else if (choice == 6) {
				System.out.println("Thank you, bye");
			}
			else
				System.out.println("Please enter a valid option");
		}
	}
}
