/**
 * 
 */
package com.slober.web.user.controller;

/**
 * @author Kunal
 *
 */
public class Test {

}

 class A{
	public void doStuff(){
		System.out.println("IN A's call");
	}
}

class B extends A{
	public  void call() {
		
		doStuff();
	}
}