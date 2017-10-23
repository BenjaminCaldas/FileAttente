package com.mycompany.fileattente.model;

public class MM1{

    private double lambda;
    private double mu;

    public MM1(double lambda, double mu) {
        this.lambda = lambda;
        this.mu = mu;
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
        return lambda/(mu - lambda);
    }

    public double calculateLq(){
        return Math.pow(lambda,2)/(mu*(mu-lambda));
    }

    public double calculateW(){
        return 1/(mu - lambda);
    }

    public double calculateWq(){
        return lambda/(mu*(mu-lambda));
    }

    public double calculateProbaTauSupT(double t){
        return Math.exp(-mu*(1-rho())*t);
    }

    public double calculateProbaTauQSupT(double t){
        if( t == 0){
            return (calculateQj(0)*rho())/(1-rho());
        }
        else {
            return Math.exp(-mu*t*(1-rho()))*calculateProbaTauQSupT(0);
        }
    }

    public double calculateQj(int j){
        return Math.pow(rho(),j) * (1 - rho());
    }

}
