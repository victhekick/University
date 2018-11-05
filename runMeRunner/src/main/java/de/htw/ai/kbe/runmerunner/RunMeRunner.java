package de.htw.ai.kbe.runmerunner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RunMeRunner {

	private Class analyseClass;

	List<String> runMeList = new ArrayList<String>();
	List<String> list = new ArrayList<String>();

	public RunMeRunner(String className) throws ClassNotFoundException {
		this.analyseClass = Class.forName(className);
	}

	public void analyzeMethod(String fileName) {

		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(fw);

		Method[] methodsOfRunner = analyseClass.getDeclaredMethods();
		for (Method m : methodsOfRunner) {

			System.out.println("method name: " + m.getName());
			System.out.println("method return type: " + m.getReturnType().getName());
			if (m.getAnnotation(RunMe.class) != null) {
				runMeList.add("Method name: " + m.getName() + ";   Method return type: " + m.getReturnType().getName());
				System.out.println("Hat RunME");
			} else {
				list.add("Method name: " + m.getName() + ";   Method return type: " + m.getReturnType().getName());
				System.out.println("Ohne RunMe");
			}

		}

		try {
			bw.write("Mit @RunMe");
			for (String i : runMeList) {
				bw.newLine();
				bw.write(i);
			}

			bw.newLine();
			bw.write("Ohne @RunMe");

			for (String i : list) {
				bw.newLine();
				bw.write(i);
			}

			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
