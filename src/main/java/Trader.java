public class Trader {
    private final String name;
    private final String city;


    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
