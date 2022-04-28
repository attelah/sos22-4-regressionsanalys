package fi.arcada.regressionsanalys;

import java.io.Console;

public class RegressionLine {

    // deklarera k, m, x  och correlationCoefficient som double
   double value;
    double n = 26;
    double k;
    double m;
    double y;
    double x;
    double xSum;
    double ySum;
    double xy;
    double xSqSum;
    double ySqSum;
    double xAvg;
    double yAvg;
    double[] xVals;
    double[] yVals;
    double correlationCoefficient;


    // Skapa en konstruktor som tar emot data-arrays för x och y

    public RegressionLine(double[] xVals, double[] yVals){
        this.xVals = xVals;
        this.yVals = yVals;

        for (int i=0; i<xVals.length; i++){
           xSum += xVals[i];
           ySum += yVals[i];
        }

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

        k = (n*xy-xSum*ySum) / (n*xSqSum - Math.pow(xSum, 2));

        m = yAvg - (k*xAvg);

        System.out.println(k + " " + xSum + " " +ySum+ " " + xy+ " " + xSqSum + " " +m);

    }

    double getX(double y){
        this.y = y;
        x = (y-m) / k;
        return x;
    }
    // Uträkningen för k och m kan ske i konstruktorn m.h.a.
    // formeln för minsta kvadratmetoden
    // Del 3: uträkningen för correlationCoefficient kan också ske i konstruktorn
    // (det är förstås också ok att ha en skild metod för uträknigarna om man vill
    // hålla konstruktorn simpel.)

    // skapa en metod getX som tar emot ett y-värde, räknar ut x
    // m.h.a. räta linjens ekvation y=kx+m, och returnerar x

    // Del 3:
    // - skapa en getter-metod för correlationCoefficient
    // - skapa en String-metod getCorrelationGrade() för uträkning av korrelationsgrad

    public double getCorrelationCoefficient(double value) {
        this.value = value;
        correlationCoefficient = (n * xy - xSum * ySum) / Math.sqrt((n*xSqSum-xSqSum)*(n*ySqSum-ySqSum));
        return correlationCoefficient;
    }
    public String getCorrelationGrade(double r) {

    }

}