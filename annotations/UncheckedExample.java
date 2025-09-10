package annotations;

import java.util.ArrayList;

public class UncheckedExample {
    @SuppressWarnings("unchecked")
    public void demonstrateUnchecked() {
        ArrayList list = new ArrayList();
        list.add("test");
        System.out.println(list.get(0));
    }

    public static void main(String[] args) {
        UncheckedExample example = new UncheckedExample();
        example.demonstrateUnchecked();
    }
}