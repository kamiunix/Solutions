/* 
 * A class to find the Nth fibonnacci number and return it as an int  
 * This class uses a Top Down recursive approach with memoization. If stack  
 * space is an issue than a simmilar Bottom Up approach could be used to avoid  
 * extra stack costs from the recursion.  
 * 
 * F(n) = F(n-1) + F(n-2) 
 * 
 * @author Samule Champagne  
 * @version 1.0  
 * @since 2020-05-20  
 */
class Fibonacci {     
	/*
	 * memoization map to avoid recomputation     
	 * memo[i] is a mapping between the ith fibonnacci 
	 * number and its result      
	 */
	private static Integer[] memo;     

	/*     
	 * Top Down memoization approach      
	 * This is the main call to fibonacci which creates a memoization table     
	 * This solutions offers a runtime and space complexity of O(n)      
	 * @param N This is the Nth fibonacci number requested      
	 * @return int This returns the Nth fibonacci number
	 */
	private static int fib(int N) {         
		memo = new Integer[Math.max(N+1, 2)];         
		memo[0]=0;   
		memo[1]=1;   
		return fibRecursion(N);  
	}    
	    
	/*      
	 *  This is the recursive call which uses the momization table      
	 *  @param N This is the Nth fibonacci number requested      
	 *  @return int This returns the Nth fibonacci number      
	 */
	private static int fibRecursion(int n) {  
		if (memo[n] != null) {   
			return memo[n]; 
		}        
		int result = fibRecursion(n-1) + fibRecursion(n-2);    
		memo[n] = result;    
		return result;   
	}     

	/*
	 * This is the main test method to test the above fib function
	 * @param args[1] is the Nth fib wanted (default 33)
	 * @return the Nth fibonacci number
	 */
	public static void main(String[] args) {
		int N = 33;
		if (args.length > 0) {
			try {
				N = Integer.parseInt(args[0]);
			} catch(NumberFormatException e) {
				System.out.println("This Implementation assumes: 2^31-1 >= N >= 0");
				N = 33;
			}
			if (N<0) {
				System.out.println("This Implementation assumes: 2^31-1 >= N >= 0");
				N = 33;
			}
		}
		int fib = fib(N);
		System.out.println("Fib of " + N + " = " + fib);
	}
}
