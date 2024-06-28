package Practice;

import java.net.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.io.*;
import javax.swing.*; // JFrame, JPanel, ...
import java.awt.*; // Canvas, Graphics, Color
import java.awt.event.*;

public class KChatServer {
      protected  Vector<KChatHandler> vhandler;  /* 사용자 등록 리스트 (Vector) */
      int id = 0;

      KChatServer (int port)  throws IOException {
	  ServerSocket server = new ServerSocket (port);
	  vhandler  = new Vector<KChatHandler> (2, 5);
/**/	  System.out.println("KChatRoom@"+ port +" ready ...");
	  while (true) {
	      Socket csock = server.accept();
	      KChatHandler c = new KChatHandler (this, csock);
	      vhandler.addElement (c);   // user 등록(handler as the user)
	      System.out.println( ++id + "번 손님 받아라 (현재 " + vhandler.size() + "명)");
	      c.start();
	}
      }
      public int numChatters() { return vhandler.size(); }

      public static void main (String args[]) throws IOException {
	  if (args.length != 1)
	      throw new RuntimeException ("Syntax: ChatServer port");
	  new KChatServer (Integer.parseInt (args[0]));
      }
}

class KChatHandler extends Thread {
      protected KChatServer server;
      protected Socket sock;
      protected DataInputStream is;
      protected DataOutputStream os;

      KChatHandler (KChatServer server, Socket sock) throws IOException {
	this.server = server;
	this.sock = sock;
	// create I/O streasm to send & receive messags
	is = new DataInputStream(new BufferedInputStream(sock.getInputStream()));
	os = new DataOutputStream(new BufferedOutputStream(sock.getOutputStream()));
      }

      public void run() {
	String name = "";
	try {
		// (1) receive login name
		name = is.readUTF();
		if (name.equals(""))  name = "나몰라";

		// (2) 방송한다 - '누구' 입장
		broadcast(name + "님 입장!");

		// (3) 반복한다: 이후 담당 고객의 모든 언행을 방송한다
		while (true)  { broadcast (name + ": " + is.readUTF()); }

	} catch (IOException e) { System.out.println("... ??? ...");}
	finally {
		// 사용자 연결이 끊긴 모양이다. 뒷정리 한다.
		System.out.println(name +" 퇴장.");
		server.vhandler.removeElement(this);
	}
      }

      protected void broadcast (String message) {
	synchronized (server.vhandler) {
	      Enumeration en = server.vhandler.elements();   // 차례로 읽어 주는 객체
	      while (en.hasMoreElements()) {
		KChatHandler c = (KChatHandler) en.nextElement();
		// 모든 사용자/고객의 담당자 KChatHandler 가 열어 놓은 소켓으로 언행 전달.
		try {
		c.os.writeUTF(message);
		c.os.flush();
		} catch(IOException e) {}
	      }
	}
      }
}

