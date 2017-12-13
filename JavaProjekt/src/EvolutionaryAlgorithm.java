
import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class EvolutionaryAlgorithm {
    private static Random rnd = new Random();
    private static String optimumGen = "";

    public static void main(String[] args) {

        algorithm();
    }

    public static String createOptimumGen(final int MAX_BITS) {
        String opGen = "";
        for (int element = 0; element < MAX_BITS; element++) {
            opGen += rnd.nextInt(2);
        }

        return opGen;
    }


    public static void algorithm() {
        final int MAX_BITS = 16;
        optimumGen = createOptimumGen(MAX_BITS);
        List<String> population = createPopulation(MAX_BITS, 10);
        List<String> newPopulation = new ArrayList<String>();
        System.out.println(getMaxFitness(population));
        //printStringArray(population);
        int counter = 0;
        double crossPart = 0.85;
        int crosspoint = 7;

        while (counter++ < 100) {
            // Selection
            int maxElement  = (int) ( ( 1 - crossPart) * population.size() );
            for (int element = 0; element < maxElement ; element++) {
                int index = selectIndividual(population);
                newPopulation.add(population.remove(index));
            }

            maxElement  = (int) ( crossPart * population.size() / 2.0);
            // Crossover
            for (int element = 0; (element < maxElement) && population.size() > 1 ; element++) {
                int index1 = selectIndividual(population);
                int index2;
                do {
                    index2 = selectIndividual(population);
                } while (index1 == index2 );
                if (index1 > index2) {
                    int tmp = index2;
                    index2 = index1;
                    index1 = tmp;
                }
                List<String> tmpList = crossover(population.remove(index1), population.remove(index2 - 1), crosspoint);
                newPopulation.addAll(tmpList);
            }

            int mutationsrate =  rnd.nextInt(newPopulation.size());
            for (int element = 0; element < mutationsrate; element++) {

                int mutationPoint = rnd.nextInt(MAX_BITS);
                String mutation = newPopulation.remove(rnd.nextInt(newPopulation.size()));

                char[] mutationArray = mutation.toCharArray();
                if (mutation.charAt(mutationPoint) == '1') {
                    mutationArray[mutationPoint] = '0';
                } else {
                    mutationArray[mutationPoint] = '1';
                }
                mutation = new String(mutationArray);
                newPopulation.add(mutation);
            }

            population.addAll(newPopulation);
            newPopulation = new ArrayList<String>();


        }
        //printStringArray(population);
        System.out.println("======================================");
        System.out.println(getMaxFitness(population));

    }

    /**
     * Test
     * @param hypothese
     * @return
     */
    public static List<Integer> getAllFitness(List<String> hypothese) {
        List<Integer> list = new ArrayList<Integer>();
        for (String string : hypothese) {
            list.add(getFitness(string));

        }
        return list;
    }

    public static int getBestFitness(List<String> hypotheses) {
        int bestFitness = 0;
        for (int element = 0; element < hypotheses.size(); element++) {
            int fitness = getFitness(hypotheses.get(element));
            if (fitness > bestFitness) {
                bestFitness = fitness;
            }
        }
        return bestFitness;
    }

    public static int getFitness(String hypothese) {
        if (hypothese.length() != optimumGen.length()) {
            return 0;
        }
        int fitness = 0;
        for (int element = 0; element < hypothese.length(); element++) {
            fitness += (hypothese.charAt(element) == optimumGen.charAt(element)) ? 1 : 0;
        }
        return fitness;
    }

    /**
     * Eine Hypothese hat eine feste anzahl an Bits.
     *
     * @param MAX_BIT
     *            Legt die maximale bitzahl fest (bits < 32)
     * @param MAX_COUNT
     *            Legt die anzahl der erzeugten Hypothesen fest
     * @return
     */
    public static ArrayList<String> createPopulation(final int MAX_BIT, final int MAX_COUNT) {

        List<String> pupulation = new ArrayList<String>();
        String individual = "";

        for (int element = 0; element < MAX_COUNT; element++) {
            for (int bitCounter = 0; bitCounter < MAX_BIT; bitCounter++) {
                individual += rnd.nextInt(2);
            }
            pupulation.add(individual);
            individual = "";
        }
        return (ArrayList<String>) pupulation;

    }


    public static int getMaxFitness(List<String> population){
        int fittest = 0;
        for (int i = 0; i < population.size() ; i++){
            int otherFit = getFitness(population.get(i));
            if(otherFit > fittest) fittest = otherFit;
        }
        return fittest;

    }

    public static double sumFitness(List<String> population){
        double fitnessSum = 0;
        for (int individual = 0; individual < population.size(); individual++){
            fitnessSum += getFitness(population.get(individual));
        }
        return fitnessSum;
    }

    public static double sumProbability(List<String> population){
        double probability = 0;
        for (int individual = 0; individual < population.size(); individual++){
            probability += relativeFitness(individual,population);
        }
        System.out.println("Probabilities = [" + probability + "]");
        return probability;
    }
    /**
     * berechnet die fitness eines individuums in relation zur Summe aller Fitnesses
     *
     * @return der wahrscheinlichektiswert
     */
    public static double relativeFitness(int individual, List<String> population) {
        double fitnessSum = sumFitness(population);
        double relFitness = getFitness(population.get(individual))/fitnessSum;
        return relFitness;
    }


    public static int selectIndividual(List<String> population) {

        double randNum = rnd.nextDouble();
        int populationSize = population.size();
        double sum = 0;
        int index = rnd.nextInt(populationSize);
        do{
            index++;
            index %= populationSize;
            sum += relativeFitness(index,population);

        } while (sum < randNum);

        return index;
    }
    /**
     * Gibt den bitStringwert als int zurück
     *
     * @param bitString
     * @return
     */
    public static int getValueOfBitString(String bitString) {
        if (!Pattern.matches("[10]+", bitString)) {
            throw new IllegalCharsetNameException(bitString);
        }

        int value = 0;
        for (int pos = bitString.length() - 1; pos >= 0; pos--) {
            int numericValue = Integer.valueOf(Character.getNumericValue(bitString.charAt(pos)));
            if (numericValue == 1) {
                value += (int) Math.pow(2, (bitString.length() - 1) - pos);
            }
        }
        return value;
    }

    /**
     * Führt ein crossover aus.
     *
     * @param gen1
     * @param gen2
     * @param crosspoint
     *            Ist inclusive. Ab diesem Punkt werden die Zeichen getrennt.
     */
    public static List<String> crossover(String gen1, String gen2, int crosspoint) {

        String headGen1 = gen1.substring(0, crosspoint);
        String tailGen1 = gen1.substring(crosspoint);
        String headGen2 = gen2.substring(0, crosspoint);
        String tailGen2 = gen2.substring(crosspoint);
        List<String> list = new ArrayList<>();
        list.add(headGen1 + tailGen2);
        list.add(headGen2 + tailGen1);

        return list;
    }

    public static void printStringArray(List<String> arr) {
        for (String string : arr) {
            System.out.println(string);
        }
    }
}
