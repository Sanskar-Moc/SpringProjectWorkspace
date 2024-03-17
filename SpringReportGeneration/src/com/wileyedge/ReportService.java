package com.wileyedge;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ReportService {
	private String fileName;
	private PrintWriter writer;
	
	public ReportService() {
		System.out.println("Inside default constructor of ReportService");
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		System.out.println("Inside setFileName() of ReportService");
		this.fileName = fileName;
	}
	
	public void generateReport() {
		System.out.println("Inside generateReport() of ReportService");
		this.writer.write("generating report...");
	
	}
	
	public void doDestroy() {
		System.out.println("Inside doDestroy() of ReportService");
		this.writer.close();
	}
	public void doInit() {
		System.out.println("Inside doInit() of ReportService");
		try {
			this.writer=new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
