package Java.KR2_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class KR2_2 {
    public static void main(String[] args) throws IOException {     
        ArrayList <Toy> index = new ArrayList<>();                                                     
        index.add(new Toy(1, "Кукла", 8));
        index.add(new Toy(2, "Супермен", 7));
        index.add(new Toy(3, "Футбольный мяч", 4));
        index.add(new Toy(4, "Мягкая игрушка", 3));
        index.add(new Toy(5, "Пожарный автомобиль", 2));
        index.add(new Toy(6, "Кубик Рубика", 0));
    
        PriorityQueue <Toy> list_selection = new PriorityQueue<>();                                          
        for (Toy position : index) {
            int counter = position.getCounter();                                                                
           while (counter > 0) {
                int id = (int) (Math.random() * 900 + 100);                                                 
                System.out.println(id);
                list_selection.add(new Toy(position.getId(),position.getTitle(),position.getCounter(), id ));
                counter --;
           }
        }
        if ( ! Files.isRegularFile(Path.of("result.txt"))){               
            Files.createFile(Path.of("result.txt"));
        }
        else {
            Files.delete(Path.of("result.txt"));                          
            Files.createFile(Path.of("result.txt"));
        }
        Toy element;
        while((element = list_selection.poll())!= null) {                                                        
            System.out.println(element.getId() + ", " + element.getTitle());                                   
            Path path = Paths.get("result.txt");
            String text = element.getId() + "," + element.getTitle() + "," + element.getEvent()+"\n";               
            Files.write(path, text.getBytes(), StandardOpenOption.APPEND);                                  
        }

    }
}
