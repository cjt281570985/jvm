package jvm.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;

/**
 * @Author: jimmy
 * @Description:
 * @Date: Created 2023-06-28 下午4:52
 */
public class MyTest3 {

  public void test() {
    try {
      InputStream is = new FileInputStream("test.txt");

      ServerSocket serverSocket = new ServerSocket(9999);

      serverSocket.accept();
    } catch (FileNotFoundException ex) {

    } catch (IOException ex) {

    } catch (Exception ex) {

    } finally {
      System.out.println("finally");
    }
  }

}
