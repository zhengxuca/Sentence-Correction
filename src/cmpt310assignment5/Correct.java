/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpt310assignment5;

/**
 *
 * @author home
 */
import java.io.*;
import java.util.*;

public class Correct {

    ArrayList bi = new ArrayList();
    ArrayList word = new ArrayList();//this is the usuer's input
    //we must correct this input
    ArrayList vocab = new ArrayList();
    ArrayList uni = new ArrayList();
    ArrayList mList = new ArrayList();
    ArrayList testE = new ArrayList();

    public Correct() {
    }

    public void start(String sentense) {
        loadBi("bigram_counts.txt");
        //   loadBi("testBi.txt");
        // loadBi("testX.txt");
        loadVocabOrUnigram("vocab.txt", vocab);

        // loadVocabOrUnigram("testVocab.txt", vocab);
        // loadVocabOrUnigram("location.txt", vocab);
        // loadVocabOrUnigram("testE.txt", testE);
        //   loadVocabOrUnigram("unigram_counts.txt", uni);
        splitSen(sentense);
        printWord();
        startM();
        cal();
    }

    public void print() {
        for (int i = 0; i < mList.size(); i++) {
            M current = (M) mList.get(i);
            System.out.println(current.getT() + " " + current.getX() + " " + current.getPro());
        }
    }

    public void printSequence() {
        System.out.println("SDFSDFSDF");
        for (int i = 0; i < word.size(); i++) {
            int n = Integer.parseInt(maxM(i + 1));
            String v = (String) vocab.get(n - 1);
            System.out.print(v + " ");
        }

    }

    private String maxM(int t) {
        String result = "";
        double value = 0;
        int flag = 0;
        for (int i = 0; i < mList.size(); i++) {
            M current = (M) mList.get(i);
            if (current.getT() == t) {
                if (flag == 0) {

                    flag = 1;
                    value = current.getPro();
                    result = current.getX();
                } else {
                    if (current.getPro() > value) {
                        value = current.getPro();
                        result = current.getX();
                    }
                }
            }

        }
        return result;
    }

    private void splitSen(String sen) {
        String value = "";
        for (int i = 0; i < sen.length(); i++) {
            if (sen.charAt(i) != ' ') {
                value = value + sen.charAt(i);


            } else {
                word.add(value);
                value = "";
            }
        }
        word.add(value);

    }

    public void printWord() {
        for (int i = 0; i < word.size(); i++) {
            String value = (String) word.get(i);
            System.out.print(value + " ");


        }
    }

    private int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public double computeLevenshteinDistance(CharSequence str1, CharSequence str2) {
        int[][] distance = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            distance[i][0] = i;
        }
        for (int j = 0; j <= str2.length(); j++) {
            distance[0][j] = j;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                distance[i][j] = minimum(
                        distance[i - 1][j] + 1,
                        distance[i][j - 1] + 1,
                        distance[i - 1][j - 1] + ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0
                        : 1));
            }
        }
        int k = distance[str1.length()][str2.length()];

        //  double pro = k * Math.log10(0.01) - Math.log10(factorial(k));
        double pro = (Math.pow(0.01, k) * Math.pow(Math.E, -0.01)) / factorial(k);

        return pro;
    }

    private long factorial(int x) {
        long result = 1;
        for (int i = 1; i <= x; i++) {
            result = result * i;
        }
        return result;
    }

    private double getLengthTest(String x, String input) {
        double k = 0;

        for (int i = 0; i < testE.size(); i++) {
            String current = (String) testE.get(i);
            if (x.compareTo(i + 1 + "") == 0) {
                if (input.compareTo("true") == 0) {


                    return Double.parseDouble(current);
                } else {
                    return 1 - Double.parseDouble(current);
                }

            }
        }

        return k;

    }

    private void startM() {


    }

    private M testgetM(String x, int t) {
        //this is for testing

        if (t == 1) {

            if (x.compareTo("1") == 0) {

                return new M(x, (double) 2, 0);

            }
            if (x.compareTo("2") == 0) {

                return new M(x, (double) 0.4, 0);
            }
            if (x.compareTo("3") == 0) {

                return new M(x, (double) 0.4, 0);
            }
        } else {

            for (int i = 0; i < mList.size(); i++) {
                M current = (M) mList.get(i);
                if (current.getX().compareTo(x) == 0 && current.getT() == t - 1) {
                    return current;
                }


            }
        }
        System.out.println("null");
        return null;


    }

    private M getM(String x, int t) {


        if (t == 1) {
            if (x.compareTo("153") == 0) {
                return new M(x, 1, 0);
            } else {
                return new M(x, 0, 0);
            }

        } else {

            for (int i = 0; i < mList.size(); i++) {
                M current = (M) mList.get(i);
                if (current.getX().compareTo(x) == 0 && current.getT() == t - 1) {
                    return current;
                }


            }
        }
        System.out.println("null");
        return null;


    }

    private double getMax(String x, int t) {
        double result = 0;
        int flag = 0;
        for (int i = 0; i < bi.size(); i++) {
            Node current = (Node) bi.get(i);

            if (x.compareTo(current.getJ()) == 0) {

                if (flag == 0) {
                    flag = 1;

                    //      result = current.getPro() * testgetM(current.getI(), t).getPro();
                    //  M newM = getM(current.getI(), t);

                    //  result = current.getPro() + Math.log10(getM(current.getI(), t).getPro());
                    result = Math.pow(10, current.getPro()) + Math.pow(10, getM(current.getI(), t).getPro());


                } else {
                    double temp = 0;
                    // temp = current.getPro() * testgetM(current.getI(), t).getPro();
                    // M newM = getM(current.getI(), t);

                    temp = Math.pow(10, current.getPro()) + Math.pow(10, getM(current.getI(), t).getPro());


                    if (temp > result) {
                        result = temp;
                    }
                }

            }


        }

        return result;
    }

    private void cal() {
        //calucute the most likly squence of words
        int t = 0;

        for (int i = 0; i < word.size(); i++) {
            t++;
            String w = (String) word.get(i);
            //w is the word of the input sentence
            for (int j = 0; j < vocab.size(); j++) {

                String current = (String) vocab.get(j);
                // System.out.println(current);

                // double m = getLengthTest(j + 1 + "", w) * getMax(j + 1 + "", t);
                double m = Math.log10(computeLevenshteinDistance(current + "", w) * getMax(j + 1 + "", t));
                System.out.println(m);
                M newM = new M(j + 1 + "", m, t);

                mList.add(newM);



            }
            System.out.println();

        }
        System.out.println(mList.size());
    }

    private void loadVocabOrUnigram(String file, ArrayList list) {
        boolean exists = (new File(file)).exists();
        if (exists) {
            try {

                BufferedReader in = new BufferedReader(new FileReader(file));
                String str = "";

                while ((str = in.readLine()) != null) {

                    int i;
                    int count = 0;
                    String value = "";

                    for (i = 0; i < str.length(); i++) {
                        if (str.charAt(i) != ' ' && count == 1) {
                            value = value + str.charAt(i);
                        } else {


                            value = "";
                            count = 1;
                        }
                    }
                    list.add(value);


                }

            } catch (IOException e) {
                System.out.println(e);
            }

        } else {
            System.out.println("The file " + file + " does not exist");
        }
    }

    private void loadBi(String file) {
        //load the bigram stuff
        boolean exists = (new File(file)).exists();
        if (exists) {
            try {

                BufferedReader in = new BufferedReader(new FileReader(file));
                String str = "";

                while ((str = in.readLine()) != null) {

                    int i;
                    int count = 1;
                    String value = "";
                    Node newNode = new Node();
                    for (i = 0; i < str.length(); i++) {
                        if (str.charAt(i) != ' ') {
                            value = value + str.charAt(i);
                        } else {
                            switch (count) {
                                case 1:
                                    newNode.setI(value);
                                    break;
                                case 2:
                                    newNode.setJ(value);
                                    break;


                            }

                            value = "";
                            count++;
                        }
                    }
                    newNode.setPro(Double.parseDouble(value));

                    bi.add(newNode);

                }

            } catch (IOException e) {
                System.out.println(e);
            }

        } else {
            System.out.println("The file " + file + " does not exist");
        }
    }

    public void printBi() {
        for (int i = 0; i < bi.size(); i++) {
            Node current = (Node) bi.get(i);
            System.out.println(current.getI() + " " + current.getJ() + " " + current.getPro());
            System.out.println();

        }

    }
}
