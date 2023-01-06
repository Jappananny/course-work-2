package DiaryPackage;

import java.time.LocalDate;

public interface Repeatable {

    void markCompleted();

    boolean appearsIn(LocalDate localDate);
}
