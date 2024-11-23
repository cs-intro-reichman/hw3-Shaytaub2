public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    /*
		System.out.println(plus(2,3));   // 2 + 3 = 5
		System.out.println(plus(5, -2)); // 5+ (-2) = 3
	    System.out.println(minus(7,2));  // 7 - 2 = 5
   		System.out.println(minus(2,-7));  // 2 - (- 7) = 9
		System.out.println(minus(0, 12)); // 0-12 = -12 
 		System.out.println(times(3,4));  // 3 * 4 = 12
		System.out.println(times (3, -4)); // 3*-4 = -12 
		System.out.println(times (-3, 4)); // -3*4 = -12
		System.out.println(times (-3, -4)); // -3*-4 = 12
		System.out.println(absolute(-5)); // |-5| = 5
		System.out.println(absolute(5)); // |5| = 5
 		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2 = 10
   		System.out.println(pow(5,3));      // 5^3 = 125
   		System.out.println(pow(3,5));      // 3^5 = 243
		System.out.println(pow (-5, 2)); // 	 -5^2 = 25
		System.out.println(pow (5, 0));  //	  5^0 = 1
		System.out.println(pow (-5, 3)); // 	 -5^3 = -125
		System.out.println(div(12,3));   // 12 / 3 	 = 4
   		System.out.println(div(5,5));    // 5 / 5		 = 1
   		System.out.println(div(25,7));   // 25 / 7     = 3
	   System.out.println(div(25,-7));   // 25 / -7     = -3
	   System.out.println(div(-25,7));   // -25 / 7     = -3
	   System.out.println(div(-25,-7));   // -25 / -7     = 3
		System.out.println(div(11,2)); // 11/2 		 =5
   		System.out.println(mod(25,7));   // 25 % 7     = 4
   		System.out.println(mod(120,6));  // 120 % 6    = 0
		System.out.println(mod(-120,6));  // -120 % 6    = 0
   		System.out.println(mod(120,-6));  // 120 % -6    = 0
   		System.out.println(mod(-120,-6));  // -120 % -6    = 0
		*/
   		System.out.println(sqrt(36)); //=6
		System.out.println(sqrt(263169));  // =513
   		System.out.println(sqrt(76123)); // = 
		}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int y = x1;
		if (x2<0)
		{
			for (int j=0; j>x2; j--)
			{
				y--;
			}
		}
		else
		{		
		for (int i=0; i<x2; i++)
			{
				y++;
			}
		}
		return y;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int y = x1;
		if (x2<0)
		{
			for (int j=0; j>x2; j--)
			{
				y++;
			}
		}
		else
		{		
		for (int i=0; i<x2; i++) 
		{
			y--;
		}
		}
		return y;
	}

	//Returns the absolute value
	public static int absolute (int x){
		int y = 0;
		if (x>=0){return x;}
		else
		{
			for (int i=0; i>x; i--)
			{
				y++;
			}
		}
		return y;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x1 ==0 || x2 == 0) {return 0;}
		int nx1 = absolute(x1); //returnes the positive of x1
		int nx2 = absolute(x2); //returnes the positive of x2
		int y = nx1;
		for (int i=1; i<nx2; i++) //the times dose not effect from the negative of x1 or x2
		{
			y=plus(y, nx1);
		}
		if (x1<0 && x2<0) {return y;}
		if (x1<0 || x2<0) {y = minus(0, y);} // if one of the veriablles is negative so the outcome needs to be <0
		return y;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n==0) {return 1;}
		int y = 1;
		for (int i=0; i<n; i++)
		{
			y=times(y, x);
		}
		return y;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int y = absolute(x1);
		int nx2= absolute(x2);
		int count = 0;
		while (y>=nx2) 
		{
			y= minus(y, nx2);
			count++;
		}
		if (x1<0 && x2< 0){ return count;}
		else 
		{	
			if (x1<0 || x2< 0){ count = minus (0, count);}
		}
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int y = absolute(div(x1, x2));
		int z = absolute(x1) - times (y, absolute(x2));
		return z;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
	int y = 0;
	while (pow(y,2)<=x)
	{
		y++;
	}	
	y--;
	return y;
	}	  	  
}