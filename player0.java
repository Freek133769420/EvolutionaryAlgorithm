import org.vu.contest.ContestSubmission;
import org.vu.contest.ContestEvaluation;

import java.util.Random;
import java.util.Properties;
import java.util.Arrays;



public class player0 implements ContestSubmission
{
    Random rnd_;
    ContestEvaluation evaluation_;
    private int evaluations_limit_ = 10000;
	
	public player0()
	{
		rnd_ = new Random();
	}
        
        // ContestEvaluation contest = new ContestEvaluation();
	// evaluation_ = evaluation;
        public static void main(String[] args){
            // Set Parameter for the Algorithm
            String functionName = "BentCigarFunction";
            int populationSize = 100;
            
            
            // Initialize the Algorithm with set Parameters
            Algorithm alg = new Algorithm();
            
            // run Algorithm
            
            alg.run();
            
            
            
            
            
            Individual child = new Individual();
            double Fitness;

            
            Population population = new Population(100);
            double[] fitnessArray = population.getFitness(functionName);
            // Fitness = (double) evaluation_.evaluate(child.getCoordinates());

            Individual child2 = new Individual();
            child2.setCoordinates(new double[]{0.0,0.0,0.0,0.0,0.0,5.0,5.0,5.0,5.0,5.0});
            //Fitness = (double) evaluation_.evaluate(child2.getCoordinates());

            for(int i=0; i< population.size(); i++){
                child = population.getIndividual(i);
                //child.setCoordinates(double[]{0,0,0,0,0,0,0,0,0,0});
                //double newFitness = (double) evaluation_.evaluate(child.getCoordinates());
                //double Fitness = (double) evaluation_.evaluate(child.getCoordinates());
                //newFitness = java.lang.Math.max(newFitness, Fitness);
                System.out.printf("Coordinates:" + Arrays.toString(child.getCoordinates()) +"\n");
            }
            Functions.evaluate(child2, functionName);
            double maxValue = Functions.getMaxValue(functionName);
            System.out.printf("The best value for " + functionName + " is: %f", maxValue);
        }
        
	public void setSeed(long seed)
	{
		// Set seed of algortihms random process
		rnd_.setSeed(seed);
	}

	public void setEvaluation(ContestEvaluation evaluation)
	{
		// Set evaluation problem used in the run
		evaluation_ = evaluation;
		
		// Get evaluation properties
		Properties props = evaluation.getProperties();
        // Get evaluation limit
        evaluations_limit_ = Integer.parseInt(props.getProperty("Evaluations"));
		// Property keys depend on specific evaluation
		// E.g. double param = Double.parseDouble(props.getProperty("property_name"));
        boolean isMultimodal = Boolean.parseBoolean(props.getProperty("Multimodal"));
        boolean hasStructure = Boolean.parseBoolean(props.getProperty("Regular"));
        boolean isSeparable = Boolean.parseBoolean(props.getProperty("Separable"));

		// Do sth with property values, e.g. specify relevant settings of your algorithm
        if(isMultimodal){
            // Do sth
        }else{
            // Do sth else
        }
    }
    
	public void run()
	{
		// Run your algorithm here
        System.out.println("Test");
        int evals = 0;
        
        // init population
        Population population = new Population(100);
        
        double Fitness;
        double newFitness = 0;
        
        Individual child = new Individual();
        child.setCoordinates(new double[]{0.0,0.1,0.0,0.1,0.0,0.0,0.0,0.0,0.0,-5.0});
        
        Fitness = (double) evaluation_.evaluate(child.getCoordinates());
        
        for(int i=0; i< population.size(); i++){
            Individual child2 = population.getIndividual(i);
            Fitness = (double) evaluation_.evaluate(child2.getCoordinates());
        }
        
        
        
        
        //evaluation_.evaluate(this)
        
        //while(evals<evaluations_limit_){
            // Select parents
            // Apply crossover / mutation operators
            // double child[] = {0.0,0.0,0.0,7.0,8.0,9.0,0.0,0.0,0.0,0.0};
            // Check fitness of unknown fuction
            // double fitness = (double) evaluation_.evaluate(child);
            // double fitness = newFitness;
            // evals++;
            // Select survivors
        //}
    }
}
