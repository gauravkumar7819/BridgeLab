package annotations;

public class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old way");
    }

    public void newFeature() {
        System.out.println("This is the new and improved way");
    }

    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); // Will show warning
        api.newFeature();
    }
}