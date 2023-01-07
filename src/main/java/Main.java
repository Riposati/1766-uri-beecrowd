import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Reindeer{
    private String name;
    private int weight;
    private int age;
    private double height;
    public Reindeer(String name, int weight, int age, double height) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Reindeer{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}

public class Main {
    public static void main(String[] args){

        List<Reindeer>reindeers = new ArrayList<>();
        int t;
        int a;
        int b;
        String aux;
        Scanner s = new Scanner(System.in);

        t = s.nextInt();

        s.nextLine(); // skip the newline character

        int cont = 1;

        while(t>0) {

            aux = s.nextLine();
            String [] aux2 = aux.split(" ");

            a = Integer.parseInt(aux2[0]);
            b = Integer.parseInt(aux2[1]);

            for(int i=0;i<a;i++){

                aux = s.nextLine();
                aux2 = aux.split(" ");

                reindeers.add(new Reindeer(aux2[0], Integer.parseInt(aux2[1]), Integer.parseInt(aux2[2]), Double.parseDouble(aux2[3])));
            }

            reindeers.sort(Comparator.comparing(Reindeer::getWeight).reversed().thenComparing(Reindeer::getAge).thenComparing(Reindeer::getHeight).thenComparing(Reindeer::getName));

            System.out.println("CENARIO {" + cont++ + "}");
            for(int i=0;i<b;i++){
                int j = i+1;
                System.out.println(j + " - " + reindeers.get(i).getName());
            }
            reindeers.clear();
            t--;
        }
    }
}
