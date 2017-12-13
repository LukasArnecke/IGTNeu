import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

    public class EvolutionaryAlgorithm {

        private static String optimumGen = "";

        public static void main(String[] args) {

            algorithm();
        }

        public static String createOptimumGen(final int MAX_BITS) {

            Random rnd = new Random();
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

            Random rnd = new Random();

            int counter = 0;
            while (counter++ < 100) {

                // Selection
                // int selCcount = hypo
                int crossCount = rnd.nextInt(MAX_BITS);
                int popCount = population.size();
                for (int element = 0; element < ((1 - crossCount) * popCount) - element; element++) {
                    int index = selectHypothesis(population);
                    newPopulation.add(population.remove(index));
                }

                // Crossover
                for (int element = 0; (element < crossCount * population.size() / 2.0) && population.size() > 1 ; element++) {
                    int index1 = selectHypothesis(population);
                    int index2;
                    do {
                        index2 = selectHypothesis(population);
                    } while (index1 == index2 );
                    if (index1 > index2) {
                        int tmp = index2;
                        index2 = index1;
                        index1 = tmp;
                    }
                    List<String> tmpList = crossover(population.remove(index1), population.remove(index2 - 1), crossCount);
                    newPopulation.addAll(tmpList);
                }

                // Mutation
                int mutationsrate = rnd.nextInt(newPopulation.size());
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

                population = newPopulation;
                newPopulation = new ArrayList<String>();

            }


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
            String tmp = "";
            Random rnd = new Random();

            for (int element = 0; element < MAX_COUNT; element++) {
                for (int bitCounter = 0; bitCounter < MAX_BIT; bitCounter++) {
                    tmp += rnd.nextInt(2);
                }
                pupulation.add(tmp);
                tmp = "";
            }
            return (ArrayList<String>) pupulation;

        }

        public static int selectHypothesis(List<String> population) {
            Random rnd = new Random();
            int hypothesesCount = population.size();
            double randNum = rnd.nextDouble();
            double summe = 0;
            int index = rnd.nextInt(hypothesesCount);

            do {
                index++;
                index %= hypothesesCount;
                summe = summe + possibility(index, population);

            } while (summe < randNum);
            return index;
        }

        /**
         * In MLE als "Pr()" bezeichnet
         *
         * @return der wahrscheinlichektiswert
         */
        public static double possibility(int index, List<String> hypotheses) {
            double fitness = getFitness(hypotheses.get(index));
            double fitnessSum = 0;
            for (int element = 0; element < hypotheses.size(); element++) {
                fitnessSum += getFitness(hypotheses.get(element));
            }
            return fitness / fitnessSum;
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
        public class LoopException extends Exception{



        }

    }

