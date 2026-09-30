package Lab2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Interest {
	private BigDecimal principal;
	private BigDecimal rate;
	private int time;

	    public Interest(BigDecimal principal, BigDecimal rate, int time) {
	        if (principal.compareTo(BigDecimal.ZERO) < 0) {
	            throw new IllegalArgumentException("Principal cannot be negative.");
	        }
	        if (rate.compareTo(BigDecimal.ZERO) < 0) {
	            throw new IllegalArgumentException("Rate cannot be negative.");
	        }
	        if (time < 0) {
	            throw new IllegalArgumentException("Time cannot be negative.");
	        }

	        this.principal = principal;
	        this.rate = rate;
	        this.time = time;
	    }
		
    public BigDecimal calculateSimpleInterest(BigDecimal p, BigDecimal r, int t) {
        BigDecimal timeBg = new BigDecimal(t);
        BigDecimal divisor = new BigDecimal("100");
        return p.multiply(r).multiply(timeBg).divide(divisor, 2, RoundingMode.HALF_UP);
    }

    // Simple Interest using Double - method overloading
    public double calculateSimpleInterest(double p, double r, int t) {
        return (p * r * t) / 100.0;
    }

    // Compound Interest using BigDecimal
    public BigDecimal calculateCompoundInterest(BigDecimal p, BigDecimal r, int t) {
        BigDecimal divisor = new BigDecimal("100");
        BigDecimal base = r.divide(divisor, 6, RoundingMode.HALF_UP).add(BigDecimal.ONE);
        BigDecimal amount = p.multiply(base.pow(t));
        return amount.subtract(p).setScale(2, RoundingMode.HALF_UP);
    }

    // Compound Interest using Double - method overloading
    public double calculateCompoundInterest(double p, double r, int t) {
        double amount = p * Math.pow(1 + r / 100.0, t);
        double compoundInterest = amount - p;
        return compoundInterest;
    }

    public double calculateCompoundInterest() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ask the user to input Prinicipal Amt");
        double localPrincipal = sc.nextDouble();
        
        System.out.println("Ask the user to input Rate");
        double localRate = sc.nextDouble();
        
        System.out.println("Ask the user to input Time");
        int localTime = sc.nextInt();
        
        double amount = localPrincipal * Math.pow(1 + localRate / 100.0, localTime);
        double val = amount - localPrincipal;
        
        return val;
    }

    public double getPrincipalDouble() {
        return principal.doubleValue();
    }

    public double getRateDouble() {
        return rate.doubleValue();
    }

    public int getTime() {
        return time;
    }
}

