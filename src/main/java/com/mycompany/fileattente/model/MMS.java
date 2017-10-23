package com.mycompany.fileattente.model;

public class MMS {

    private int s;
    private double lambda;
    private double mu;

    public MMS(int s, double lambda, double mu) {
        this.s = s;
        this.lambda = lambda;
        this.mu = mu;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public double getLambda() {
        return lambda;
    }

    public void setLambda(double lambda) {
        this.lambda = lambda;
    }

    public double getMu() {
        return mu;
    }

    public void setMu(double mu) {
        this.mu = mu;
    }

    public double rho(){
        return lambda/(s*mu);
    }

    public double calculateL(){
        return lambda*calculateW();
    }

    public double calculateLq(){
        return calculateQj(0)*((Math.pow(rho()*s,s)*rho())/(factorial(s)*Math.pow(1-rho(),2)));
    }

    public double calculateW(){
        return calculateWq()+(1/mu);
    }

    public double calculateWq(){
        return calculateLq()/lambda;
    }

    public double probaTauSupT(double t){
        return Math.exp(-mu*t)*(1+((calculateQj(0)*Math.pow((rho()*s),s))/(factorial(s)*(1-rho())))*
                ((1-Math.exp(-mu*t*(s-1-rho()*s)))/(s-1-rho()*s)));
    }

    public double probaTauSupTFile(double t){
        if( t == 0){
            return (calculateQj(0)*Math.pow(rho()*s, s))/(factorial(s)*(1-rho()));
        }
        else {
            return Math.exp(-s*mu*t*(1-rho()))*probaTauSupTFile(0);
        }
    }

    public double calculateQj(int j){
        if (j == 0){
            double sumElement = 0;
            for (int i = 0; i < s; i++){
                sumElement += Math.pow((rho()*s),i)/factorial(i);
            }
            return 1/(sumElement+(Math.pow((rho()*s),s)/factorial(s)*(1-rho())));
        }
        else {
            if (j < s) return (Math.pow(rho()*s,j)/factorial(j))*calculateQj(0);
            else return ((Math.pow(s,s)*Math.pow(rho(),j))/factorial(s))*calculateQj(0);
        }
    }

    public double factorial(int number){
        if (number == 0) {
            return 1;
        }
        int fact = 1; // this  will be the result
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }

}
