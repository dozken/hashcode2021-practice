package io.mersys;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Service service = new Service();

        try {
            Path inputPath = Paths.get("src", "main", "resources", "in");
            Path outputPath = Paths.get("src", "main", "resources", "out");

            Files.newDirectoryStream(inputPath,
                    path -> path.toString().endsWith(".txt"))
                    .forEach(path -> {
                        service.readInputFile(path);
                        List<DeliveredPizza> pizzas = service.process();
                        service.writeOutputFile(outputPath.resolve(path.getFileName()), pizzas);
                    });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
