package de.htw.ai.kbe.runmerunner;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Cli {

	private static final Logger log = Logger.getLogger(Cli.class.getName());
	private String[] args = null;
	private Options options = new Options();

	public Cli(String[] args) {

		this.args = args;

		options.addOption("c", "className", false, "Der Name einer Klasse");
		options.addOption("o", "report", false, "Der Name eines Ausgabefiles");

	}

	public void parse() {

		CommandLineParser parser = new DefaultParser();

		CommandLine cmd = null;
		RunMeRunner rmr = null;
		try {
			cmd = parser.parse(options, args);

			if (cmd.hasOption("c")) {
				if (args[1].equals("")) {
					log.log(Level.SEVERE, "Need a className");
				} else {
					try {
						rmr = new RunMeRunner(args[1]);

					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Input class: " + args[1]);
				}
			} else {
				log.log(Level.SEVERE, "Missing c option");
			}
			if(cmd.hasOption("o")) {
				System.out.println("Report: "+ args[3]);
				if(rmr != null) {
					rmr.analyzeMethod(args[3]);
				}
			}
		} catch (ParseException e) {
			log.log(Level.SEVERE, "Failed to parse comand line properties", e);

		}
	}

}
