package Java.KR2_2;

public class Toy implements Comparable <Toy>{
    private int id;
    private String title;
    private int counter;
    private int event;

    public Toy (int title_id, String title_toy, int counter, int event){  //конструктор для игрушки с добавленным случайным числом
        this.id  = title_id;
        this.title = title_toy;
        this.counter = counter;
        this.event = event;
    }

    public Toy (int title_id, String title_toy, int counter){              // Базовый конструктор для игрушек
        this.id  = title_id;
        this.title = title_toy;
        this.counter = counter;
    }
                                                                                    // Методы получения значений поля
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public int getCounter() {
        return counter;
    }
    public int getEvent() {
        return event;
    }
                                                                                    // Метод для поиска большего добавочного значения 
    @Override                                                                       // для приоритетной очереди
    public int compareTo(Toy other) {
        if (other == null) {
            return -1; 
        }
        int diff = this.event - other.event;
        if (diff != 0) {
            return - diff;
        }  
        return this.title.compareTo(other.title);
    }
}
