/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Testing git commit


/**
 *
 * @author user
 */
public class Functions {
    
    private static double maxBCFValue = 0;
    private static double maxKFValue = 0;
    private static double maxS7FValue = 0;
    
    private static double[] maxBCFCoordinates = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
    private static double[] maxKFCoordinates = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
    private static double[] maxS7FCoordinates = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
    
    
    
    public Functions(){
        
    }
    
    public static double BentCigarFunction(double[] coordinates){
        double sum = coordinates[1] * coordinates[1];
        for(int i=1; i<coordinates.length; i++){
            sum += Math.pow(10,6) * Math.pow(coordinates[i],2);
        }
        //Make sure that the values only lie between 0 and 10
        sum = sum/22500002.5;
        return sum;
    }
    
    public static double KatsuuraFunction(double[] coordinates){
        double sum = 0;
        return sum;
    }
    public static double Schaffer7Function(double[] coordinates){
        double sum = 0;
        return sum;
    }
    
    public static double getMaxValue(String functionName){
        double maxValue=0;
        switch (functionName){
            case "BentCigarFunction":
                maxValue = maxBCFValue;
                break;
            case "KatsuuraFunction":
                maxValue = maxKFValue;
                break;
            case "Schaffer7Function":
                maxValue = maxS7FValue;
                break;
            default:
                System.out.printf("The functionName %s is unknown.", functionName);
                break;
        }
        return maxValue;
    }
    
    public static double[] getMaxCoordinates(String functionName){
        double[] coordinates = new double[10];
        switch (functionName){
            case "BentCigarFunction":
                coordinates = maxBCFCoordinates;
                break;
            case "KatsuuraFunction":
                coordinates = maxKFCoordinates;
                break;
            case "Schaffer7Function":
                coordinates = maxS7FCoordinates;
                break;
            default:
                System.out.printf("The functionName %s is unknown.", functionName);
                break;
        }
        return coordinates;
    }
 
    
    public static double evaluate(Individual ind, String functionName){
        double value = 0;
        switch (functionName) {
            case "BentCigarFunction":
                value = BentCigarFunction(ind.getCoordinates());
                if(value > maxBCFValue){
                    maxBCFValue = value;
                    maxBCFCoordinates = ind.getCoordinates();
                }
                break;
            case "KatsuuraFunction":
                value = KatsuuraFunction(ind.getCoordinates());
                if(value > maxKFValue){
                    maxKFValue = value;
                    maxKFCoordinates = ind.getCoordinates();
                }
                break;
            case "Schaffer7Function":
                value = Schaffer7Function(ind.getCoordinates());
                if(value > maxS7FValue){
                    maxS7FValue = value;
                    maxS7FCoordinates = ind.getCoordinates();
                }
                break;
            default:
                break;
        }
        return value;
    }
}
