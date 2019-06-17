package com.OK.zhou;

public class Calculate {
  public Calculate() {
	  super();
  }
  public static String cal(String m1,String m2,String sym) {
	  
	  
	  String result="";
	  switch(sym.charAt(0)) {
	  case '-':
		  result=(Double.parseDouble(m1)-Double.parseDouble(m2))+""; break;
	  case '+':
		  result=(Double.parseDouble(m1)+Double.parseDouble(m2))+""; break;
	  case '*':
		  result=(Double.parseDouble(m1)*Double.parseDouble(m2))+""; break;
	  case '/':
		  result=(Double.parseDouble(m1)/Double.parseDouble(m2))+""; break;
	  case '%':
		  result=(Double.parseDouble(m1)%Double.parseDouble(m2))+""; break;
	  case 's':
		  result=(Math.sqrt(Double.parseDouble(m1)))+""; break;
	  case '1':
		  result=(1/Double.parseDouble(m1))+""; break;
		  
		 
	  }
	  
	return result;
  }
}
