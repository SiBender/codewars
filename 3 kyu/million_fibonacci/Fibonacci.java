import java.math.BigInteger;

class BIMatrix{
  // class for matrix with 4 BigIntegers  |f11  f12|
  //                                      |f21  f22|
  public BigInteger field11;
  public BigInteger field12;
  public BigInteger field21;
  public BigInteger field22;
  
  public BIMatrix(BigInteger f11,BigInteger f12,BigInteger f21,BigInteger f22){
    field11 = f11;
    field12 = f12;
    field21 = f21;
    field22 = f22;
  }
  
  public String toString(){
    return "" + field11 + " | " + field12 + "\n" + field21 + " | " + field22;
  }
}

public class Fibonacci {

  public static BigInteger fib(BigInteger n) {
    int cicleNum = n.intValue();
    System.out.println(cicleNum);

    BigInteger one = BigInteger.valueOf(1);
    BigInteger two = BigInteger.valueOf(2);
    BigInteger zero = BigInteger.valueOf(0);
 
    BigInteger result = one;
    
    if(cicleNum == 0) {return zero;}
    if(cicleNum == 1) {return one;}

    if (cicleNum > 0 ){     // if n > 0
      result = zero;
      
      BIMatrix startMatrix = new BIMatrix(one, one, one, zero);
      BIMatrix outMatr = pow(startMatrix, cicleNum);
      
      result = outMatr.field21;
      /*BigInteger first = zero;
      BigInteger second = one;
      while (cicleNum > 1){
        result = second.add(first);
        first = second;
        second = result;
        cicleNum--;
      }*/
    } else {                        //if n is negative 

      BigInteger negFirst = zero;   //fib(n+1)
      BigInteger negSecond = one;   //fib(n+2)
      while(cicleNum < 0){
        result = negSecond.subtract(negFirst);
        negSecond = negFirst;
        negFirst = result;
        cicleNum++;
      }
    }
    
    return result;
  }
  
  public static BIMatrix multiply(BIMatrix m1, BIMatrix m2){
    BigInteger outF11;
    BigInteger outF12;
    BigInteger outF21;
    BigInteger outF22;
    
    outF11 = m1.field11.multiply(m2.field11);
    outF11 = outF11.add(m1.field12.multiply(m2.field21));
    
    outF12 = m1.field11.multiply(m2.field12);
    outF12 = outF12.add(m1.field12.multiply(m2.field22));
    
    outF21 = m1.field21.multiply(m2.field11);
    outF21 = outF21.add(m1.field22.multiply(m2.field21));
    
    outF22 = m1.field21.multiply(m2.field12);
    outF22 = outF22.add(m1.field22.multiply(m2.field22));
    
    
    return new BIMatrix(outF11,outF12,outF21,outF22);
    //return outMatrix;
  }
  
  public static BIMatrix pow(BIMatrix inMatrix, int p){
  
    if (p == 1){
      return inMatrix;
    }
    
    if (p == 2){
      return multiply(inMatrix, inMatrix);
    }
  
    if ( p % 2 == 1){
      return multiply(inMatrix, pow(inMatrix, p-1));
    } else{
      return multiply(pow(inMatrix, p/2), pow(inMatrix, p/2));
    }
  
  }
}