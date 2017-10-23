package com.mycompany.fileattente.model;

public class MM1K {

    private int k;
    private double lambda;
    private double mu;

    public MM1K(int k, double lambda, double mu) {
        this.k = k;
        this.lambda = lambda;
        this.mu = mu;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
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
        return lambda/mu;
    }

    public double calculateL(){
        if (rho() == 1)
            return k/2;
        if (rho() < 1)
            return (rho()*(1-(k+1)*Math.pow(rho(),k)+k*Math.pow(rho(),(k+1))))/((1-rho())*(1-Math.pow(rho(),(k+1))));
        else return 0;
    }

    public double calculateLq(){
        return calculateL()-(1-calculateQj(0));
    }

    public double calculateW(){
        return 1/(mu - lambda);
    }

    public double calculateWq(){
        return lambda/(mu*(mu-lambda));
    }

    public double calculateProbaTauSupT(double t){
        return Math.exp(-mu*(1-(lambda/mu))*t);
    }

    public double calculateQj(int j){
        if(rho() == 1)
            return 1/(k+1);
        if(rho() < 1)
            return ((1-rho())*Math.pow(rho(),j))/(1-Math.pow(rho(),k+1));
        else return 0;
    }

}
