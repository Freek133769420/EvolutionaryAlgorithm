/*
import java.util.Random;

class Population{
    Individual[] individualList;
    
    
    // BIN-ARY RECOMBINATION
    // This method will recombine the genes of two parents to generate one new
    // individual. 
    // ARGS: 
    // + individual parent1
    // + individual parent2
    // Return:
    // + individual child
    
    public Individual recombine(Individual parent1, Individual parent2){
        
        Individual child = new Individual();
        Random rnd = new Random();
        
        for(int i=0; i < 10; i++){
            if(0.5 > rnd.nextDouble()){
                child.coordinates[i] = parent1.coordinates[i];
            }else{
                child.coordinates[i] = parent2.coordinates[i];
            }
        }
        return child;
    }     
}
*/


import java.util.ArrayList;
import java.util.Collections;

public class Population {

    public ArrayList<Individual> individuals;
    
    public Population(int size) {
    individuals = new ArrayList<Individual>();
        for (int i = 0; i < size; i++) {
            Individual newIndividual= new Individual();
            individuals.add(newIndividual);     
        }
    }

        
    public Individual getFittest(String functionName) {
       Individual fittest = individuals.get(0);
        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness(functionName) <= individuals.get(i).getFitness(functionName)) {
                fittest = individuals.get(i);
            }
        }
        return fittest;
    }
    
    public double[] getFitness(String functionName) {
        double[] fitness  = new double[individuals.size()];
        for (int i =0;i<individuals.size();i++) {
            fitness[i] = individuals.get(i).getFitness(functionName);
        }
        return fitness;        
    }
    
    public void remove_individual(int i) {
        individuals.remove(i);
    }
    

    public int size() {
        return individuals.size();
    }    
    
    public Individual getIndividual(int index){
        return individuals.get(index);
    }
    
    public void addIndividual(Individual ind) {
        individuals.add(ind);
    }
    /*
    public void order() {
        Collections.sort(individuals);
    }
    */

    
}
