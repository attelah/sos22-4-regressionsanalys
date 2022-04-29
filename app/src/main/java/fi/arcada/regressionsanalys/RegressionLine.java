package fi.arcada.regressionsanalys;

import java.io.Console;
import java.math.BigDecimal;

public class RegressionLine {

    double[] xTest = { 520,
            610,
            840,
            540,
            360,
            260,
            85
    };


    double n = xTest.length;
    double k;
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
    double yAvg;
    double[] xVals;
    double[] yVals;
    double correlationCoefficient;
    String corrStr;


    public RegressionLine(double[] xVals, double[] yVals){
        this.xVals = xVals;
        this.yVals = yVals;

        for (int i=0; i<xVals.length; i++){
           xSum += xVals[i];
           ySum += yVals[i];
        }

        xSum2 = Math.pow(xSum,2);
        //BigDecimal bigXsum = new BigDecimal(xSum);


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

        k = n*xy-xSum*ySum / n*xSqSum - xSum2;

        m = yAvg - k * xAvg;

        System.out.println("xsum= "+ xSum + " xsum2= "+xSum2+ " ysum= " +ySum+ " xavg= " + xAvg+ " yavg= " + yAvg+ " xy= " +xy+ " xSqSum= " + xSqSum + " k= " + k + " m= " + +m+ " r= " +r);

    }

    double getX(double y){
        this.y = y;
        x = (y-m) / k;
        return x;
    }

    public double getCorrelationCoefficient() {

        double sum = Math.sqrt(n*xSqSum-xSqSum)*(n*ySqSum-ySqSum);
        correlationCoefficient = (n * xy - xSum * ySum) / sum;
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