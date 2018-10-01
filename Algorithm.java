/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */

import java.util.Random;


public class Algorithm {
    
    private double mutationProbability;
    private int populationSize;
    private Individual fittestIndividual;
    private Population population;
    private String functionName;
    private int evaluations_limit;
    
    
    public Algorithm(){
        
    }
    public Algorithm(int mutationRate, int populationSize, String functionName,
            int elitismRate, int maxmimumAge, int childrenCount,
            int replacedParentsCount){
        
        
        
    }
    
    
    public void run(){
        
        
        // initialize population (random initialization)
            //-populationSize
        
        population = new Population(populationSize);
            
        // evaluate each candidate
        double[] populationFitness = population.getFitness(functionName);
        
        
        int evals = 0;
        while(evals<evaluations_limit){
            /*
             select parents
                
                Options: 
                    -Fitness proportional Selection(with or without sigma scaling)
                    -Ranking Selection (for higher selection pressure: exponential ranking)
                        - Roulette Wheel vs. stochastic universal sampling (SUS)
                    -Tournament Selection (easy to implement)
                    -Uniform Parent Selection
            */              
            // recombine pairs of parents
            
            // mutate the offspring
                //-mutationRate
                
                
            // evaluate the new candidates
                //-childrenCount
                
            /*
            Survivor Selection
            select individuals for the next generation:
                Options:
                    - Age-based replacement
                    - Fitness-based replacement
                        - Replace worst ( quick convergence, less exploration,
                                        often used with large populations and 
                                        'no duplicates' policy)
                        - Elitism (used in combination wtih others)
                        - Round-robin tournament
                        - (mu + lambda) Selection
                            -hinders self-adaption mechanism, so rather not use it
                        - (mu,lambda) Selection (works on a mixture of age and fitness)
                            +advantageous fore multimodel search
                            +is able to follow moving optima
                (any selection used for parent selection is usable here)
                // -elitismRate
                // -replacedParentsCount
                // -maximumAge
            

            */
        }
        
    }
 
    //private void initialize(int populationSize){
    //    population = Population.initialize();
    //   population.initialize();
    //}
    
    private void evaluate(){
        
    }
    
    
    
    private Population selectParents(int parentCount, int mutProb){
        
        Population selectedParents = new Population(0);
        //Population 
                
        double[] fitnessArray = population.getFitness(functionName);
        int fitnessSum = 0;
        for(int i=0; i< fitnessArray.length; i++){
            fitnessSum += fitnessArray[i];
        }
        
        double[] cumProbArr = new double[fitnessArray.length];
        
        double probabilitySum = 0;
        for(int i=0; i<cumProbArr.length; i++){
            cumProbArr[i] = probabilitySum +fitnessArray[i]/fitnessSum;
            probabilitySum += cumProbArr[i];
        } 
        Random r = new Random();
        for(int i=0; i<parentCount; i++){
            double rnd = r.nextDouble();
            int index = 0;
            while(cumProbArr[i] < rnd){
                
                index ++;
            }
            //selectedParents.addIndividual(population.getIndividual(index));   
        }
        return selectedParents;
    }
        
    public Individual recombine(Individual parent1, Individual parent2){

       Individual child = new Individual();
       Random rnd = new Random();

       for(int i=0; i < 10; i++){
           if(0.5 > rnd.nextDouble()){
               child.setCoordinate(i, parent1.getCoordinate(i));
           }else{
               child.setCoordinate(i, parent2.getCoordinate(i));
           }
       }
       return child;
}    
    private Individual mutateUniform(Individual indiv, int rangemin, int rangemax,
            double mutationProbability){
        
        Individual mutatedIndividual = new Individual();
        
        Random r = new Random();
        for(int i=0; i < 10; i++){
            if(r.nextDouble() < mutationProbability){
                double temp = indiv.getCoordinate(i);
                double mutationValue = rangemin + (rangemax - rangemin) * 
                    r.nextDouble();
                
                double newValue = mutationValue + temp;
                mutatedIndividual.setCoordinate(i, 6);
            }else{
                mutatedIndividual.setCoordinate(i, indiv.getCoordinate(i));
            }
        }
        return mutatedIndividual;
    }
    
    private void SelectIndividuals(){
        
    }
              
}
