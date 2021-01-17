package io.mersys;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service {

    int pizzaType;
    int teamOf2;
    int teamOf3;
    int teamOf4;
    Pizza[] pizzas;


    public List<DeliveredPizza> process() {
        List<DeliveredPizza> result = new ArrayList<>();

        //TODO add algo here
        DeliveredPizza dp = new DeliveredPizza();
        dp.team = 2;
        dp.pizzaIndexes = Arrays.asList(1, 2, 3);
        result.add(dp);

        //end
        return result;
    }

    public void readInputFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line[] = br.readLine().split(" ");

            pizzaType = Integer.parseInt(line[0]);
            teamOf2 = Integer.parseInt(line[1]);
            teamOf3 = Integer.parseInt(line[2]);
            teamOf4 = Integer.parseInt(line[3]);

            pizzas = new Pizza[pizzaType];
            for (int i = 0; i < pizzaType; i++) {
                String[] input = br.readLine().split(" ");
                pizzas[i] = new Pizza(input[0], Arrays.copyOfRange(input, 1, input.length));
                System.out.println(pizzas[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeOutputFile(Path path, List<DeliveredPizza> out) {
        try {
            Files.createDirectories(path.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(String.format("%d", out.size()));
            writer.newLine();
            for (DeliveredPizza deliveredPizza : out) {
                writer.write(String.format("%s", deliveredPizza));
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
