package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> list = new ArrayList<>();
        System.out.print("Enter a number Cont: ");
        int N = sc.nextInt();
        for (int i = 1; i <=N; i++){
            System.out.println("TaxPayer # " + i + "data: ");
            System.out.println("Individual or Company (i/c): ");
            char type = sc.next().charAt(0);
            System.out.println("Name: ");
            String name = sc.next();
            System.out.println("Renda anual: ");
            Double anualIncome = sc.nextDouble();
            if(type == 'i'){
                System.out.println("Healt expenditures: ");
                Double he = sc.nextDouble();
                Individual x = new Individual(name, anualIncome, he);
                list.add(x);
            } else {
                System.out.println("Number employee: ");
                Integer numberF = sc.nextInt();
                Company y = new Company(name, anualIncome, numberF);
                list.add(y);
            }

        }
        System.out.println();
        System.out.println("TAXES PAID: ");
        double sum = 0.0;
        for(TaxPayer taxPayer : list){
            sum += taxPayer.tax();
            System.out.println(taxPayer.getName() + ": $ " + String.format("%.2f", taxPayer.tax()));
            System.out.println("Total: " + sum);
        }


        sc.close();
    }
}
