package com.Pyramid;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/pyramid")
public class PyramidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PyramidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input = request.getParameter("input");
		PrintWriter out = response.getWriter();
		
		int passes = lengthCheck(input);
		boolean outp = false;
		if(passes >= 0)
			 outp = isPyramid(input,passes);
		out.println(outp);
	}

	/* Check to see if the input word is long enough to make a pyramid
	 * For each new row of the pyramid the amount of letters n must increase by n+i times
	 * where i represents the amount of rows 
	 * ex. for 2 rows we have 3 letters (n) if we want a 3rd row we will need 3 (i) more letters for a total of 6
	 * 6 = 3 + 3
	 * we return the number of passes if we have the correct amount of letters otherwise the program ends and returns -1
	 */
	public int lengthCheck(String in) {
		int n = 0;
		for(int i = 1; i < in.length(); i++) {
			n += i;
			if(n == in.length()) {
				return i;
			}
			else if(n > in.length())
				return -1;				
		}
		return -1;
	}
	
	public boolean isPyramid(String in, int height) {
		HashMap<Character, Integer> charCount = new HashMap<Character,Integer>();
		for(int i = 0; i < in.length(); i++) {
			char c = in.charAt(i);
			if(charCount.containsKey(c)) {
				charCount.put(c, charCount.get(c) + 1);
			}
			else {
				charCount.put(c, 1);
			}
		}
		for(int i = 1; i <= height; i++) {
			if(!charCount.containsValue(i)){
				return false;
			}
		}		
		return true;
	}
	
}