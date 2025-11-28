package com.nov_28.nov_28;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class Student implements Serializable{
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

}

public class InputOutputStreams {
	public static void main(String[] args) {
		try {
//			File file = new File("data.txt");
//
//			System.out.println(file.exists());
//			System.out.println(file.createNewFile()); // if not created then create and return true else false for
//														// alreay existing file note: create file in src -> target
//														// folder
//			System.out.println(file.exists());
//			System.out.println(file.isFile());
//			System.out.println(file.isDirectory());
//			System.out.println(file.getName());
//			System.out.println(file.getParent()); // null because we created data.txt but not used directory in file
//													// creation
//			System.out.println(file.getPath());
//			System.out.println(file.getAbsolutePath());
//
//			// using directory
//			File dir = new File("assests");
//			if (!dir.exists()) {
//				dir.mkdir();
//			}
//			File file2 = new File(dir, "data2.txt");
//
//			System.out.println(file2.exists());
//			System.out.println(file2.createNewFile());
//			System.out.println(file2.exists());
//			System.out.println(file2.isFile());
//			System.out.println(file2.isDirectory()); // return true if file2 is directory
//			System.out.println(dir.isDirectory()); // return true if dir is isDirectory
//			System.out.println(file2.getName());
//			System.out.println(file2.getParent());// gives directory
//			System.out.println(file2.getPath());
//			System.out.println(file2.getAbsolutePath());
//			System.out.println(file2.length());
//			System.out.println(file2.canRead());
//			System.out.println(file2.canWrite());
//			// for writing or reading we need to create a IO streams
//
//			// using BYTE streams for IO
//			BufferedReader reader = new BufferedReader(new FileReader("assests/data2.txt"));
//			String data;
//			while ((data = reader.readLine()) != null) {
//				System.out.println(data);
//			}
//			BufferedWriter writer = new BufferedWriter(new FileWriter("assests/data2.txt", true));
////			writer.newLine(); // for new line in writing
//			writer.write("\n hello , pranay."); // we can also use \n for new line
//			writer.close(); // need to close
//			System.out.println();
//			while ((data = reader.readLine()) != null) {
//				System.out.println(data);
//			}
//			FileOutputStream fileOutputStream = new FileOutputStream("assests/info.txt", true);
//			String bytetext = "pranay reddy";
//			fileOutputStream.write("\n".getBytes());
//			fileOutputStream.write(bytetext.getBytes()); // write accepts only bytes
//			fileOutputStream.close();

			// not for only character sending use character stream but byte stream can use
			// any type of data like audio,video,image character

//			FileInputStream fileInputStream = new FileInputStream("assests/info.txt");
//			int b;
//			while ((b = fileInputStream.read()) != -1) {
//				System.out.print((char) b);
//			}
//			// using no while loop
//			byte[] byteArray = new byte[(int)new File("assests/info.txt").length()];
//			fileInputStream.read(byteArray);
//			String str  = new String(byteArray);
//			System.out.println("\nnew string : "+str+"..."); // str is not printing
			
			Student s = new Student(101,"pranay");
			
			ObjectOutputStream sobj_output = new ObjectOutputStream(new FileOutputStream("assests/stuInfo.txt",true));
			sobj_output.writeObject(s);
			Student s3 = new Student(102,"raju");
			sobj_output.writeObject(s3);
			sobj_output.close();
			
			
			ObjectInputStream sobj_input = new ObjectInputStream(new FileInputStream("assests/stuInfo.txt"));
			Student s2 = (Student)sobj_input.readObject(); // we may get classCastException which is checked expection so we need to write in try and catch
			System.out.println(s2);
			sobj_input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
