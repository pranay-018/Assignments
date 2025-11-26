package com.nov_26.nov26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

class Student implements Comparable<Student> {
	private int sid;
	private String sname;

	public Student() {
	}

	/**
	 * @param sid
	 * @param sname
	 */
	public Student(int sid, String sname) {
		this.sid = sid;
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + "]";
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public int compareTo(Student o) {
		return this.getSid() - (o.getSid());
	}

}

// Comparator is functional Interface
class NameComparator implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		return s1.getSname().compareTo(s2.getSname());

	}
}

class IdComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getSid() - o2.getSid();
	}

}

public class CollectionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ArrayList
//		ArrayList<Integer> arrayList = new ArrayList(); // without generic we can add many type of data types in single
//														// array
//		arrayList.add(2); // direct add adding at last
//		arrayList.add(10);
//		arrayList.add(1, 9); // at index
//
//		System.out.println(arrayList);
//		System.out.println(arrayList.get(1));
//		System.out.println(arrayList.size());
//		arrayList.add(null);
//		arrayList.add(null); // it can add null values and duplicates are aslo allowed
//		System.out.println(arrayList);
//		for (Integer i : arrayList) {
//			System.out.println(i); // call to_string method
//		}
//
//		Iterator<Integer> itr = arrayList.iterator(); // itr is pointed to before index 0 , we use hasNext() function
//		while (itr.hasNext()) {
//			System.out.println(itr.next());
//		}
//		// Concurrent modification using itr using itr.remove()
//
//		// List Iterator
//		ListIterator<Integer> litr = arrayList.listIterator(); //
//		while (litr.hasNext()) {
//			System.out.println(litr.next());
//		}
//		while (litr.hasPrevious()) {
//			System.out.println(litr.previous());
//		}
//		// note that list iterator has method that has
//		// hasPrevious method that print backword
//		// not hasPrevious after after reaching list iterator end
//		System.out.println(arrayList.contains(10));
//
//		arrayList.forEach(num -> System.out.println(num)); // forEach is consumer
//		arrayList.forEach(System.out::println);// method references using method references
//		arrayList.remove(3); // delete at index
//		arrayList.forEach(System.out::println);
//
//		Integer[] arr = { 1, 10, 9, 20 };
//		List<Integer> arrayList2 = Arrays.asList(arr); // note asList return List so need to
//														// cast expicitly
//
//		arrayList2.forEach(System.out::println);
//
//		arrayList.retainAll(arrayList2); // arrayList is modify with common elements in both arrays
//		System.out.println(arrayList);
//		Collections.sort(arrayList2);
//		System.out.println("sorting : " + arrayList2); // strings will sort based on ascii value
//		// note get work with random access
//		arrayList.removeAll(arrayList2); // remove arrayList2 from arrayList 1
//
//		System.out.println(arrayList);
//		// clonable
//		ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
//		arrayList3.add(20);
//		arrayList3.add(15);
//		arrayList3.add(7);
//		arrayList3.add(69);
//		ArrayList<Integer> clonedarray = (ArrayList<Integer>) arrayList3.clone();
//		System.out.println(arrayList3.hashCode());
//		System.out.println(clonedarray.hashCode()); // have same hash code since no operation clone
//		clonedarray.add(56);
//		System.out.println(arrayList3.hashCode());
//		System.out.println(clonedarray.hashCode()); // diff hashcode since clonearray has modified
//
//		ArrayList<Student> stuArr = new ArrayList<Student>();
//		stuArr.add(new Student(101, "pranay"));
//		stuArr.add(new Student(116, "raju"));
//		stuArr.add(new Student(152, "pranay"));
//		stuArr.add(new Student(106, "pranay"));
//		stuArr.add(new Student(109, "abhi"));
//		stuArr.forEach(System.out::println);
//		Collections.sort(stuArr);
//		System.out.println();
//		stuArr.forEach(System.out::println);
//
//		System.out.println();
//		stuArr.sort(new NameComparator().thenComparing(new IdComparator()));
//		stuArr.forEach(System.out::println);
//		LinkedList<Integer> ll = new LinkedList<>();
//		ll.offer(20);
//		ll.offerFirst(23);
//		System.out.println(ll.peek()); // retrive first
//		ll.push(26); // add at first
//		System.out.println((ll.poll())); // retrive and remove first element
//		System.out.println(ll);
//		Integer[] arrll = { 34, 56, 23, 78, 72 };
//		List<Integer> ll2 = new LinkedList<Integer>();
//		ll2 = Arrays.asList(arrll); // if ll2 is datatype is LinkedList<Integer> we get error
//		System.out.println(ll2);
//		// we can convert like this also
//		LinkedList<Integer> ll3 = new LinkedList<Integer>(Arrays.asList(arrll));
//		System.out.println(ll3);
//
//		Iterator<Integer> decItr = ll3.descendingIterator();
//		while (decItr.hasNext()) {
//			System.out.println(decItr.next());
//		}
//		ll.removeAll(ll);
//		System.out.println("removing all in ll1 : " + ll);
//		ll.add(23);
//		ll.add(56);
//		ll.push(21);
//		System.out.println(ll);
//		Vector<Integer> vec = new Vector<Integer>(); // thread safe , synhronized , performace
//		for (int i = 0; i < 10; i++) {
//			vec.add(i);
//		}
//		System.out.println(vec.capacity());
//		Enumeration<Integer> enums = vec.elements();
//		System.out.println(enums);
//		while (enums.hasMoreElements()) {
//			System.out.println(enums.nextElement());
//		}
//		// using iterator to print collector
//		System.out.println("removing the num divisible by 3");
//		Iterator<Integer> itr = vec.iterator();
//		while (itr.hasNext()) {
//			int num = itr.next();
//			if (num % 3 == 0) {
//				itr.remove();
//			}
//			System.out.println(num);
//		}
//		System.out.println(vec);
//		vec.remove(vec.size() - 1);
//		System.out.println(vec);
		// hashset
//		HashSet<Integer> hashSet1 = new HashSet<Integer>();
//		hashSet1.add(56);
//		hashSet1.add(78);
//		hashSet1.add(99);
//		hashSet1.add(83);
//		hashSet1.add(99);
//		System.out.println(hashSet1);
//		System.out.println(hashSet1.contains(83));
//		hashSet1.forEach(n -> System.out.println(n));
//		Iterator<Integer> hashitr = hashSet1.iterator();
//		while (hashitr.hasNext()) {
//			System.out.println(hashitr.next());
//		}
//		System.out.println(hashSet1.hashCode());
//		System.out.println();
//		// we can add null also
//		hashSet1.forEach(System.out::println);
//		hashSet1.forEach(System.out::print); // --> print with no next line

		// linkedhashset similar to hashset but store linkedList in index of hashTable

//		TreeSet<Integer> treeSet = new TreeSet<Integer>();
//		treeSet.add(26);
//		treeSet.add(57);
//		treeSet.add(05);
//		treeSet.add(20);
//		treeSet.add(1);
//		treeSet.add(20);
//		treeSet.forEach(n -> System.out.println(n));
//		System.out.println(treeSet.ceiling(25)); // get element next greater than 25
//		System.out.println(treeSet.floor(25)); // get element next lower than 25
//		System.out.println();
//		Iterator<Integer> treeItr = treeSet.descendingIterator();
//		while (treeItr.hasNext()) {
//			System.out.println(treeItr.next());
//		}
//		System.out.println();
//		System.out.println(treeSet.headSet(20)); // below 20 elements
//		System.out.println(treeSet.tailSet(20)); // greater than 20 including 20
//		System.out.println(treeSet.higher(26)); // diff between is higher and ceiling is if number exists that gonna be
//												// ceil while higher give strictly greater than number if not element
//												// present then both will return null
//
//		System.out.println(treeSet.ceiling(58));
//
//		TreeSet<Student> stu_tree = new TreeSet<Student>();
//		stu_tree.add(new Student(101, "pranay"));
//		stu_tree.add(new Student(116, "raju"));
//		stu_tree.add(new Student(152, "pranay"));
//		stu_tree.add(new Student(106, "pranay"));
//		stu_tree.add(new Student(109, "abhi"));
//		stu_tree.forEach(System.out::println); // we get error if we don't use comparable interface
		// if comparable there then stu_tree will based on the return value of
		// comparable function and removes the duplicates based on the value we used in
		// comparable
		// map
//		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
//		hashMap.put(12, "hyd");
//		hashMap.put(42, "bglr");
//		hashMap.put(23, "chn");
//		hashMap.put(89, "bombay");
//		hashMap.put(29, "Delhi");
//		System.out.println(hashMap);
//		System.out.println(hashMap.keySet());
//		System.out.println(hashMap.values());
//		System.out.println(hashMap.entrySet());
//		System.out.println(hashMap.get(42));
//		System.out.println(hashMap.getOrDefault(42, "No key")); // if no key then return "no key" but not insert 42 as
//																// key and value as No key
//		System.out.println(hashMap);
//		// using iterator on key set but not on map
//		Set<Integer> keySet = hashMap.keySet();
//		Iterator<Integer> itr = keySet.iterator();
//		while (itr.hasNext())
//			System.out.println(itr.next());
//
//		// using iterator on values;
//		Set<String> valueSet = new HashSet<String>(hashMap.values());
//		System.out.println(valueSet);
//		Iterator<String> valitr = valueSet.iterator();
//		while (valitr.hasNext())
//			System.out.println(valitr.next());
//
//		// Iterator on map
//		Iterator<Entry<Integer, String>> entryIterator = hashMap.entrySet().iterator();
//		while (entryIterator.hasNext()) {
//			System.out.println(entryIterator.next().getKey());// --> will print and next() key  pointer moves forward
////			System.out.println(entryIterator.next().getValue());
////			System.out.println(entryIterator.next());
//		}
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		treeMap.put(12, "hyd");
		treeMap.put(42, "bglr");
		treeMap.put(23, "chn");
		treeMap.put(89, "bombay");
		treeMap.put(29, "Delhi");
		System.out.println(treeMap);
		System.out.println(treeMap.keySet());
		System.out.println(treeMap.values());
		System.out.println(treeMap.entrySet());
		System.out.println(treeMap.get(42));
		System.out.println(treeMap.getOrDefault(42, "No key")); // if no key then return "no key" but not insert 42 as
																// key and value as No key
		System.out.println(treeMap);
		// using iterator on key set but not on map
		Set<Integer> keySet = treeMap.keySet();
		Iterator<Integer> itr = keySet.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());

		// using iterator on values;
		Set<String> valueSet = new HashSet<String>(treeMap.values());
		System.out.println(valueSet);
		Iterator<String> valitr = valueSet.iterator();
		while (valitr.hasNext())
			System.out.println(valitr.next());

		// Iterator on map
		Iterator<Entry<Integer, String>> entryIterator = treeMap.entrySet().iterator();
		while (entryIterator.hasNext()) {
			System.out.println(entryIterator.next().getKey());// --> will print and next() key pointer moves forward
//			System.out.println(entryIterator.next().getValue());
//			System.out.println(entryIterator.next());
		}
		System.out.println(treeMap.ceilingEntry(24)); // print entry with key greater or equal to 24

		System.out.println(treeMap.descendingMap()); // return reverse of treeMap
		System.out.println(treeMap.navigableKeySet());
		TreeMap<Student, Integer> stu_tree_map = new TreeMap<Student, Integer>(); // need to add comparable in key
																					// (Student) for sorting
		stu_tree_map.put(new Student(101, "pranay"), 14);
		stu_tree_map.put(new Student(116, "raju"), 23);
		stu_tree_map.put(new Student(110, "pranay"), 16);
		stu_tree_map.put(new Student(126, "ramu"), 24);
		stu_tree_map.put(new Student(105, "abhi"), 16);
		System.out.println(stu_tree_map);

		Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
		hashtable.put(1, "pranay");
		hashtable.put(2, "ramu");
		hashtable.put(5, "anu");
		System.out.println(hashtable);

		Enumeration<Integer> enumerationKeys = hashtable.keys();
		while (enumerationKeys.hasMoreElements()) {
			System.out.println(enumerationKeys.nextElement());
		}
		Enumeration<String> enumerationValues = hashtable.elements(); // retirve values
		while (enumerationValues.hasMoreElements()) {
			System.out.println(enumerationValues.nextElement());
		}

	}

}
