//Spencer Vaughn
//Pollard p-1 factorization

import java.math.BigInteger;

class Pollard{
		
	BigInteger factor(BigInteger n){
		BigInteger limit = new BigInteger("10000");
		BigInteger factor = BigInteger.ZERO;	
		BigInteger TWO = BigInteger.valueOf(2);
		
		for (BigInteger i = TWO; i.compareTo(limit) <= 0; i = i.add(BigInteger.ONE)){
			factor = i.gcd(n);
			if(!factor.equals(BigInteger.ONE)){
				return factor;
			}else{
				BigInteger a = i.modPow(TWO,n);
				factor = (a.subtract(BigInteger.ONE)).gcd(n);
				if((factor.mod(n)).equals(BigInteger.ZERO))
					return factor;					
			}					
		}
		return n;	
	}
	
	public static void main(String args[]){
		
		Pollard p = new Pollard();
	
		BigInteger a = new BigInteger("1739");
		BigInteger b = new BigInteger("220459");
		BigInteger c = new BigInteger("48356747");
		
		System.out.println("(a)1739 = " + p.factor(a) + " and " + a.divide(p.factor(a)));
		System.out.println("(b)220459 = " + p.factor(b) + " and " + b.divide(p.factor(b)));
		System.out.println("(c)48356747 = " + p.factor(c) + " and " + c.divide(p.factor(c)));					
	}
}