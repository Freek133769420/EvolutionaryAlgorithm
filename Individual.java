/*
import java.util.Random;
import java.lang.Math;

class Individual{
   
    static int dimension = 10;
    double[] coordinates = new double[10];
    double[] stdDeviations = new double[10];
    double mainStdDevation;
    static double sigmaThreshold = 0.01;
    static double tauOneStep = 1 / Math.sqrt(dimension); // tau proportional to  '1/sqrt(n)'. 
    // What is n? the dimension = 10? Yes: "number of variables".
    static double tauGeneralNStep = 1 / Math.sqrt(2*dimension);
    static double tauNStep = 1 /Math.sqrt(2*Math.sqrt(dimension));
    
    public Individual(){
        this.coordinates = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        this.stdDeviations = new double[]{0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5,0.5};
    }
    
    public Individual(double[] coordinates, double[] stdDeviations){
        this.coordinates = coordinates;        
        this.stdDeviations = stdDeviations;
    }
    
    private void setMainStdDevation(double newSigma){
        if(newSigma > sigmaThreshold){
            this.mainStdDevation = newSigma;
        }else{
            this.mainStdDevation = sigmaThreshold;
        }
    }
    
    private void setStdDeviations(double newSigma, int index){
        if(newSigma > sigmaThreshold){
            this.stdDeviations[index] = newSigma;
        }else{
            this.stdDeviations[index] = sigmaThreshold;
        }
    }
       
    // MUTATION: Uniform,
    // This take random values from a specified interval with a 
    // uniform distribution.
    // ARGS:
    //  + int rangemin: The lower boundary of the interval
    //  + int rangemax: The upper boundary of the interval
    //  + double mutationProbability: The probability of a single gene to mutate.
    //  + String distribution: The probability distribution from which is drawn.
    //      It can take values in {"uniform"} This set will be extended to 
    //      {"uniform","normal"} and possible other distributions.
    // Returns:
    //  + void
    
    public void mutateUniform(int rangemin, int rangemax,
            double mutationProbability){
        
        Random r = new Random();
        for(int i=0; i < 10; i++){
            if(r.nextDouble() < mutationProbability){
                double temp = this.coordinates[i];
                double mutationValue = rangemin + (rangemax - rangemin) * 
                    r.nextDouble();
                
                
                this.coordinates[i] = mutationValue + temp;                   
            }
        }
    }
    // Quote from the book: "It is normal practice to apply this operator with
    // probability one per gene, and instead the mutation parameter is used to 
    // control the standard deviation of the Gaussian and hence the probability 
    // distribution of the steps sizes taken." 
    // Therefore we could set "mutationProbability" of the "mutateNormal" method
    // to 1. We still need to figure out the problem with the truncated normal
    // distribution.
    public void mutateNormalOneSigma(){
        Random r = new Random();
        this.setMainStdDevation(this.mainStdDevation 
                * Math.pow(Math.E, tauOneStep * r.nextGaussian()));
        for(int i=0; i<10; i++){
            double temp = this.coordinates[i];
            double mutationValue = r.nextGaussian() * this.mainStdDevation;    
            this.coordinates[i] = Math.max(Math.min(mutationValue + temp, 5),-5);  
        }
    }
    public void mutateNormalNSigma(){
        Random r = new Random();
        for(int i=0; i<10; i++){
           this.setStdDeviations(this.stdDeviations[i] 
                * Math.pow(Math.E, tauGeneralNStep * r.nextGaussian() 
                            + tauNStep * r.nextGaussian()),i);
            
            double temp = this.coordinates[i];
            double mutationValue = r.nextGaussian() * this.stdDeviations[i];
            this.coordinates[i] = Math.max(Math.min(mutationValue + temp, 5),-5);  
            
        }
    }
}
*/


import org.vu.contest.ContestEvaluation;

public class Individual{ // implements Comparable {

    ContestEvaluation evaluation_;
    static int dimensions = 10;
    private double[] coordinates = new double[dimensions];
    private double fitness = 0;
    private int age = 0;
        // Cache    

    public Individual() {
        for (int i = 0; i < size(); i++) {
            double coordinate = (double) -5+10*Math.random();
            coordinates[i] = coordinate;
        }
    }
    
    private int size() {
        return coordinates.length;
    }

    public double getCoordinate(int index) {
        return coordinates[index];
    }
    
    public double[] getCoordinates(){
        return this.coordinates;
    }
    
    public void setCoordinate(int index, double value) {
        coordinates[index] = value;
    }
    public void setCoordinates(double[] coordinates){
        this.coordinates = coordinates;
    }
            
    
    public double getFitness() {
        if (fitness == 0) {
            fitness = (double) evaluation_.evaluate(this);
        }
        return fitness;
    }
    
    public double getFitness(String functionName){
        double fitness = 0;
        if(functionName.equals("BentCigarFunction")){
            fitness = Functions.BentCigarFunction(this.coordinates);
        }else if(functionName.equals("KatsuuraFunction")){
            fitness = Functions.KatsuuraFunction(this.coordinates);
        }else if(functionName.equals("Schaffer7Function")){
            fitness = Functions.Schaffer7Function(this.coordinates);
        }
        
        return fitness;
    }
    
    /*
    Compare is a static function of the individual class for comparing two
    individuals according to a certain function, whichs name is given as argument:
    ARGS: 
    - Individual a
    - Individual b
    - String functionName
        - "BentCigarFunction",
        - "KatsuuraFunction" or
        - "Schaffer7Function"
    
    RETURN:
    double value, namely Fitness of Individual 'a' minus Fitness of Individual 'b'.
    */
    
    public static double compare(Individual a, Individual b, String functionName){
        double compareValue = a.getFitness(functionName) - b.getFitness(functionName);
        return compareValue;
    }
    
    /*
    @Override
    public int compareTo(Object compare) {
        int compFitness=(int) ((Individual)compare).getFitness();
        // For Ascending order
        return (int) this.fitness-compFitness;
        // For Descending order
        //return compFitness-this.fitness;
    }
    */
    
    public void addAge() {
        age ++;
    }

}
