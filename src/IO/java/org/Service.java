package IO.java.org;

import java.time.LocalDate;
import java.util.ArrayList;

public class Service {
    private final LocalDate date;
    private final int price;
    private final ArrayList<String> parts;
    private final ArrayList<String> partNums;

    public Service(LocalDate date, int price, ArrayList<String> parts, ArrayList<String> partNums) {
        this.date = date;
        this.price = price;
        this.parts = parts;
        this.partNums = partNums;
    }

    public String[] getPartsByRow(int i){
        return new String[]{parts.get(i),partNums.get(i)};
    }

    public int getPartSize(){
        return parts.size();
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }
}
