/*
 * "@(#)JsseClient.java	1.1	05/06/15 SMI"
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or 
 * without modification, are permitted provided that the following 
 * conditions are met:
 * 
 * -Redistributions of source code must retain the above copyright  
 * notice, this  list of conditions and the following disclaimer.
 * 
 * -Redistribution in binary form must reproduct the above copyright 
 * notice, this list of conditions and the following disclaimer in 
 * the documentation and/or other materials provided with the 
 * distribution.
 * 
 * Neither the name of Oracle or the names of 
 * contributors may be used to endorse or promote products derived 
 * from this software without specific prior written permission.
 * 
 * This software is provided "AS IS," without a warranty of any 
 * kind. ALL EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND 
 * WARRANTIES, INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY 
 * EXCLUDED. SUN AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY 
 * DAMAGES OR LIABILITIES  SUFFERED BY LICENSEE AS A RESULT OF  OR 
 * RELATING TO USE, MODIFICATION OR DISTRIBUTION OF THE SOFTWARE OR 
 * ITS DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE 
 * FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, 
 * SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER 
 * CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF 
 * THE USE OF OR INABILITY TO USE SOFTWARE, EVEN IF SUN HAS BEEN 
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 * 
 * You acknowledge that Software is not designed, licensed or 
 * intended for use in the design, construction, operation or 
 * maintenance of any nuclear facility. 
 */

import java.io.*;
import java.net.*;
import javax.net.ssl.*;
import java.security.PrivilegedExceptionAction;
import java.security.Principal;

public class JsseClient {

    private static final String KRB5_CIPHER = "TLS_KRB5_WITH_3DES_EDE_CBC_SHA";

    private static final int PORT = 4569;
    private static final boolean verbose = false;
    
    public static void main(String[] args) throws Exception {
	// Obtain the command-line arguments and parse the server's name
	
	if (args.length < 1) {
	    System.err.println(
		"Usage: java <options> JsseClient <serverName>");
	    System.exit(-1);
	}

	PrivilegedExceptionAction action = new JsseClientAction(args[0], PORT);

	Jaas.loginAndAction("client", action);
    }

    static class JsseClientAction implements PrivilegedExceptionAction {
	private String server;
	private int port;

	JsseClientAction(String server, int port) {
	    this.port = port;
	    this.server = server;
	}

	public Object run() throws Exception {
	    SSLSocketFactory sslsf =
		(SSLSocketFactory) SSLSocketFactory.getDefault();
	    SSLSocket sslSocket = (SSLSocket) sslsf.createSocket(server, port);

	    // Enable only a KRB5 cipher suite.
	    String enabledSuites[] = { KRB5_CIPHER };
	    sslSocket.setEnabledCipherSuites(enabledSuites);
	    // Should check for exception if enabledSuites is not supported

	    BufferedReader in = new BufferedReader(new InputStreamReader(
		sslSocket.getInputStream()));
	    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
		sslSocket.getOutputStream()));

	    String outStr = "Hello There!\n";
	    out.write(outStr);
	    out.flush();
	    System.out.print("Sending " + outStr);

	    String inStr = in.readLine();
	    System.out.println("Received " + inStr);

	    String cipherSuiteChosen = sslSocket.getSession().getCipherSuite();
	    System.out.println("Cipher suite in use: " + cipherSuiteChosen);
	    Principal self = sslSocket.getSession().getLocalPrincipal();
	    System.out.println("I am: " + self.toString());
	    Principal peer = sslSocket.getSession().getPeerPrincipal();
	    System.out.println("Server is: " + peer.toString());

	    sslSocket.close();
	    return null;
	}
    }
}
