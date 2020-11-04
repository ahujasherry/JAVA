
public class MostSigBit {

	
	static int setBitNumber(int n) 
    { 
  
		//find pos of most significant bit	
		int k = (int)(Math.log(n) / Math.log(2)); 
  
        // return no with set bit at k-th position 
        return (int)(Math.pow(2, k)); 
    } 
	
	
	public static void main(String[] args) {
		int n = 25; 
        System.out.print(setBitNumber(n));

	}

}
