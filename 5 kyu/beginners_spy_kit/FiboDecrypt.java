public class FiboDecrypt {
  //public char[] charTable = {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z};
  public String charTable = "abcdefghijklmnopqrstuvwxyz";
  
  public int generateFibonacciSum(int n){
    int[] fib = new int[n];
    if(n >= 1){fib[0]=1;}
    if(n >= 2){fib[1]=1;}
    if(n >= 3){fib[2]=2;}
    if(n > 3){
      int pos = 3;
      while(pos < n){
        fib[pos]=fib[pos-1]+fib[pos-2];
        pos++;
      }
    }
    int sum = 0;
    for(int f : fib){ sum += f;}
    System.out.println("Sum:"+sum);
    return sum;
  }

  public String decrypt(String encrypted, String password) {
    char[] inText = encrypted.substring(0,encrypted.length() - password.length()).toCharArray();
    for(char c : inText){System.out.print(","+c);}
    System.out.println();
    int fibOffset = generateFibonacciSum(password.length());
    int[] inTextNums = new int[inText.length];
    int[] outTextNums = new int[inText.length];
    
    int pos = 0;
    for(char ch : inText){
      inTextNums[pos]=charTable.indexOf(ch);
      pos++;
    }
    
    int mod = charTable.length();
    for(int i = 0; i < inTextNums.length; i++ ){
      outTextNums[i] = i % 2 == 1 ? (inTextNums[i]+fibOffset)%mod : (inTextNums[i]-fibOffset+mod)%mod;
    }
    
    String text = "";
    for(int x = outTextNums.length - 1;  x >= 0; x--){
      text += charTable.charAt(outTextNums[x]);
    }
    
    return text;
  }
}
