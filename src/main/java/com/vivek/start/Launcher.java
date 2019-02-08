package com.vivek.start;

import java.io.File;
import javax.servlet.ServletException;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Launcher {

	public static void main(String[] args) throws LifecycleException, ServletException {
		Tomcat tomcat = new Tomcat();

		tomcat.addWebapp("/", new File("src/main/webapp/").getAbsolutePath());
		tomcat.setPort(getPort(args));
		tomcat.start();
		tomcat.getServer().await();
	}

	static int getPort(String[] args) {
		try {
			return Integer.parseInt(args[0]);
		} catch (Exception ex) {
			return 6161;
		}
	}
}
