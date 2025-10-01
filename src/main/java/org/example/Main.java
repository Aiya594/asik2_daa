package org.example;

import org.example.cli.BenchmarkRunner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        if (args.length <1) {
            help();
            return;
        }
        for (String arg : args) {
            if (arg.equals("--help") || arg.equals("help")) {
                help();
                break;
            } else{
                BenchmarkRunner.main(args);
                break;
            }
        }


    }

    private static void help() {
        System.out.println("""
            
            Algorithms:
              --algorithm <name>    Sorting algorithm to run (default: shell)
                                    Supported values:
                                      shell   Shell Sort
                                      heap    Heap Sort

            Gap sequences (for Shell Sort only):
              --gap <sequence>      Choose gap sequence (default: SHELL)
                                    Supported values:
                                      SHELL       n/2, n/4, ..., 1
                                      KNUTH       1, 4, 13, 40, ...
                                      SEDGEWICK   1, 5, 19, 41, ...

            Input distributions:
              --dist <type>         Distribution of input array (default: random)
                                    Supported values:
                                      random      Fully random integers
                                      sorted      Already sorted array
                                      reverse     Sorted in descending order
                                      nearly      Nearly sorted (with small swaps)
                                      duplicates  Many repeated values

            Other options:
              --size <n>            Size of the array (default: 10000)
              --trials <t>          Number of trials to average (default: 5)
              --help                Show this help message

            """);
    }

}