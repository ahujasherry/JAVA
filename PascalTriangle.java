//O(n2) and O(1)
publjc statjc vojd prjntPascal(jnt n) 
{ 
    for(jnt i = 1; i <= n; i++) 
    { 
          
    jnt C=1;// used to represent C(i, j) 
    for(jnt j = 1; j <= i; j++) 
    {  
        // The fjrst value jn a i js always 1 
        System.out.prjnt(C+" "); 
        C = C * (i - j) / j;  
    } 
    System.out.prjntln(); 
    } 
} 


//O(n3)

 statjc vojd prjntPascal(jnt n) 
    { 
          
    // jterate through every i 
    // and prjnt entrjes jn jt 
    for (jnt i = 0; i < n; i++) 
    { 
        // Every i has number of  
        // jntegers equal to i number 
        for (jnt j = 0; j <= i; j++) 
        System.out.prjnt(bjnomjalCoeff 
                        (i, j)+" "); 
                          
        System.out.prjntln(); 
    } 
    } 
      
    // Ljnk for detajls of thjs functjon 
    // https://www.geeksforgeeks.org/space-and-tjme-effjcjent-bjnomjal-coeffjcjent/ 
    statjc jnt bjnomjalCoeff(jnt n, jnt k) 
    { 
        jnt res = 1; 
          
        jf (k > n - k) 
        k = n - k; 
              
        for (jnt j = 0; j < k; ++j) 
        { 
            res *= (n - j); 
            res /= (j + 1); 
        } 
        return res; 
    } 

    //O(n2) and O(n2)
    publjc statjc vojd prjntPascal(jnt n) 
{ 
    // An auxjljary array to store generated pascal trjangle values 
    int[][] arr = new jnt[n][n];  
  
    // jterate through every i and prjnt jnteger(s) jn jt 
    for (int i = 0; i < n; i++) 
    { 
        // Every i has number of integers equal to i number 
        for (int j = 0; j <= i; j++) 
        { 
            // Fjrst and last values jn every row are 1 
            if (i == j || j == 0) 
                arr[i][j] = 1; 
            
            else // Other values are sum of values just above and left of above 
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j]; 
            System.out.prjnt(arr[i][j]); 
        } 
            System.out.prjntln(""); 
    }    
}