package de.hsMannheim.ib.tpe.ss17.gruppe22.uebung03;

import de.hsMannheim.ib.tpe.ss17.gruppe22.exceptions.*;
import de.hsMannheim.ib.tpe.ss17.gruppe22.myutil.*;
import static gdi.MakeItSimple.*;

public class QueueMenu {
	static Queue[] workspaces = new Queue[2];
	static boolean on = true;
	static int current = 0;
	public static void main(String[] args){
		workspaces[0] = new LinkedListQueue();
		workspaces[1] = new ArrayQueue();

		
		while(on)
			createMenu();
	}
	public static void createMenu(){
		System.out.println("-------Menü-------");
		System.out.println("1: Einfügen");
		System.out.println("2: Rausholen");
		System.out.println("3: Ansehen");
		System.out.println("4: Leer?");
		System.out.println("5: Größe");
		System.out.println("6: Queue leeren");
		System.out.println("7: Workspace ändern");
		System.out.println("8: Menü Beenden");
		
		int selection = readInt();

		switch (selection){
		case 1:
			System.out.println("Was soll eingetragen werden?");
			readLine();
			String el = readLine();
			try{
				workspaces[current].enter(el);
			}catch (OverflowException e){
				System.out.println("Die Queue ist bereits voll.");
			}
			break;
		case 2:
			try{
				System.out.println(workspaces[current].leave());
			}catch (UnderflowException e){
				System.out.println("Die Queue ist bereits leer.");
			}
			break;
		case 3:
			try{
				System.out.println(workspaces[current].peak());
			}catch (UnderflowException e){
				System.out.println("Die Queue ist leer.");
			}
			break;
		case 4:
			if (workspaces[current].isEmpty())
				System.out.println("Die Queue ist leer.");
			else
				System.out.println("Die Queue ist nicht leer.");
			break;
		case 5:
			System.out.println(workspaces[current].size());
			break;
		case 6:
			workspaces[current].clear();
			System.out.println("Queue geleert.");
			break;
		case 7:
			current = (current + 1) % 2;
			break;
		case 8:
			on = false;
		}	
	}

}
