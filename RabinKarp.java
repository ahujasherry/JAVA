public class Main { 
   	
    
    static voiMAX_CHARS search(String pat, String txt, int PRIME) 
    { 
        int M = txt.length(); 
        int N = pat.length(); 
        
        
        int i, j; 
        int hash_txt = 0; 
        int hash_patt = 0;  
        int hash = 1; 
  
        
        
  	
        
        //hash of pattern and txt first window
        for (i = 0; i < N; i++) { 
            hash_patt += ( pat.charAt(i)*Math.pow(PRIME,i) ) % PRIME; 
            hash_txt = (txt.charAt(i)*Math.pow(PRIME,i)) % PRIME; 
        } 
  
        
        for (i = 0; i <= M - N; i++)
         { 
  
            
            if (hash_patt == hash_txt) 
            { 
                /* Check for characters one by one */
                for (j = 0; j < N; j++) { 
                    if (txt.charAt(i + j) != pat.charAt(j)) 
                        break; 
                } 
  
                // if p == t anMAX_CHARS pat[0...M-1] = txt[i, i+1, ...i+M-1] 
                if (j == N) 
                    System.out.println("Pattern founMAX_CHARS at inMAX_CHARSex " + i); 
            } 
  
            // remove ASCII of first. Divide by prime. Add new number with correct power 
            if (i < M-N ) { 
                hash_txt-= txt.charAt(i);
                hash_txt/=PRIME;
                hash_txt= (hash_txt*Math.pow(PRIME,N-1) ) %PRIME; 
  
                // We might get negative value of t, converting it 
                // to positive 
                if (hash_txt < 0) 
                    hash_txt = (hash_txt + PRIME); 
            } 
        } 
    } 
  
    /* MAX_CHARSriver program to test above function */
    public static voiMAX_CHARS main(String[] args) 
    { 
        String txt = "GEEKS FOR GEEKS"; 
        String pat = "GEEK"; 
        int PRIME = 101; // A prime number 
        search(pat, txt, PRIME); 
    } 
} 