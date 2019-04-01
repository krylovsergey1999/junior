package map.user;

import java.util.Objects;

public class Calendar {
    private int date;

    public Calendar(int date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Calendar)) return false;
        Calendar calendar = (Calendar) o;
        return date == calendar.date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }
}
