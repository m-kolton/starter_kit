package datastructure.list;

import java.util.ArrayList;

import datatype.CustomQueue;

public class Main {
	public static void main(String[] args) {
		CustomArrayList<String> list = new CustomArrayList();
		list.add("Mateusz");
		list.add("Malwina");
		list.add("Patryk");
		list.add("Artur");
		list.add("Ula");
		list.add("Natalia");
		list.add("Marta");
		list.add("Ala");
		list.add("Mietek");
		//list.add("Gienek");
		System.out.println("----------------");
//		for(int i=0; i<10; i++) {
//			System.out.println(list.get(i));
//		}
		
		
		
		System.out.println("----------------");
		System.out.println("List size: " + list.size());
		System.out.println("Is empty?: " + list.isEmpty());
		System.out.println("----------------");
		
//		System.out.println(list.contains("Mietek"));
//		System.out.println(list.indexOf("Malwina"));
//		
//		list.add("Gienek");
//		System.out.println("----------------");
//		for(int i=0; i<12; i++) {
//			System.out.println(list.get(i));
//		}
//		System.out.println("----------------");
//		
//		list.remove(9);
//		list.remove(8);
//		list.remove(7);
//		list.remove(6);
//		list.remove(5);
//		list.remove(4);
//		list.remove(3);
//		
//		System.out.println("----------------");
//		for(int i=0; i<9; i++) {
//			System.out.println(list.get(i));
//		}
//		System.out.println("List size: " + list.size());
//		System.out.println("----------------");
//		list.remove("Malwina");
//		
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		System.out.println("----------------");
//		System.out.println("List size: " + list.size());
//		System.out.println("Is empty?: " + list.isEmpty());
		
//		list.set(2, "Justyna");
//		for(int i=0; i<10; i++) {
//			System.out.println(list.get(i));
//		}
//		System.out.println("----------------");
//		System.out.println("List size: " + list.size());
//		System.out.println("Is empty?: " + list.isEmpty());
		
		
//		System.out.println("-----ARRAYLISTA-----");
//		
//		ArrayList<String> arrayList= new ArrayList();
//		arrayList.add("Mateusz");
//		arrayList.add("Malwina");
//		arrayList.add(1, "Artur");
//		//System.out.println(arrayList.get(0));
//		for(int i=0; i<arrayList.size(); i++) {
//			System.out.println(arrayList.get(i));
//		}
		
		CustomQueue queue = new CustomQueue(new CustomLinkedList());
		queue.add("String2");
		queue.add("String1");
		System.out.println(queue.peek());
	}	
}
