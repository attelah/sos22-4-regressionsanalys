package fi.arcada.regressionsanalys;

import java.io.Console;
import java.math.BigDecimal;

public class RegressionLine {


    double n;
    double k;
    double kRounded;
    double m;
    double y;
    double x;
    double r;
    double xSum;
    double ySum;
    double xy;
    double xSqSum;
    double ySqSum;
    double xAvg;
    double xSum2;
    double ySum2;
    double yAvg;
    double[] xVals;
    double[] yVals;
    double correlationCoefficient;
    String corrStr;


    public RegressionLine(double[] xVals, double[] yVals){
        this.xVals = xVals;
        this.yVals = yVals;
        n = xVals.length;

        for (int i=0; i<xVals.length; i++){
           xSum += xVals[i];
           ySum += yVals[i];
        }

        xSum2 = Math.pow(xSum,2);
        ySum2 = Math.pow(ySum,2);


        for (int i=0; i<xVals.length; i++){
           xy += xVals[i] * yVals[i];
        }

        for (int i=0; i<xVals.length; i++){
            xSqSum += Math.pow(xVals[i], 2);
        }

        for (int i=0; i<yVals.length; i++){
            ySqSum += Math.pow(yVals[i], 2);
        }

        xAvg = xSum / xVals.length;
        yAvg = ySum / yVals.length;

        k = ((n * xy) - (xSum * ySum)) / ((n * xSqSum) - Math.pow(xSum, 2));

        kRounded = Math.round(k*1000)/1000.0;

        m = yAvg - kRounded * xAvg;

        System.out.println("xsum= "+ xSum + " xsum2= "+xSum2+ " ysum= " +ySum+ " xavg= " + xAvg+ " yavg= " + yAvg+ " xy= " +xy+ " xSqSum= " + xSqSum + " k= " + k + "kRounded=" +kRounded+ " m= " + +m+ " r= " +r);

    }

    double getX(double y){
        this.y = y;
        x = (y-m)/kRounded;
        System.out.println("x= " + x);
        return x;
    }

    public double getCorrelationCoefficient() {

        double upper = (n * xy) - (xSum * ySum);
        double lower = ((n*xSqSum)-xSum2)*((n*ySqSum)-ySum2);
        double sqrt = Math.sqrt(lower);
        correlationCoefficient = upper / sqrt ;

        System.out.println("correlationCoefficient= " + correlationCoefficient + "upper" +upper+ "lower=" +lower+ "sqrt" +sqrt);

        return correlationCoefficient;
    }
    public String getCorrelationGrade(double r) {
        this.r=r;

        if(r==1.0 || r==-1.0){
            corrStr = String.format("korrelationskoefficient: %.2f (Perfekt)", r);
        }else if(r<1.0 && r>=0.75 || r<-1.0 && r>=-0.75){
            corrStr = String.format("korrelationskoefficient: %.2f (Hög)", r);
        }else if(r<0.75 && r>=0.25 || r<-0.75 && r>=-0.25){
            corrStr = String.format("korrelationskoefficient: %.2f (Måttlig)", r);
        }else if(r<0.25 && r>0.0 || r>-0.25 && r<-0.0){
            corrStr = String.format("korrelationskoefficient: %.2f (Låg)", r);
        }else if(r==0.0){
            corrStr = String.format("korrelationskoefficient: %.2f (Ingen Korrelation)", r);
        }
        return corrStr;
    }

}