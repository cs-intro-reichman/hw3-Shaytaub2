// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	private static double endBalance(double loan, double rate, int n, double payment) {	
		
		double endB = loan;
		for (int i=1; i<=n; i++)
		{
			if (endB>=0)
			{
				endB = (endB - payment)*(1+rate/100);	 
			}
		}
		return endB;
	}
	
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		 double x =loan/n;
		 iterationCounter=0;
		 while (endBalance(loan, rate, n, x)>epsilon)
		 {
			x+=epsilon;
			iterationCounter++;
		 }

		return x;
    }
    
        public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		iterationCounter = 0;
		double H = loan;
		double L = loan/n;
		double g = (H+L)/2;
		while ((H-L)>epsilon) {
			iterationCounter++;
			if (endBalance(loan, rate, n, g)*endBalance(loan, rate, n, H)>0)
			{
				H = g;
			}
			else {L = g;}
			g = (L+H)/2;
		}
		return g;
    }
}