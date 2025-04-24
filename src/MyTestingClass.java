public class MyTestingClass {
    private String data;

    public MyTestingClass(String data) {
        this.data = data;
    }

    @Override
    public int hashCode() {

        int result = 17;
        result = 31 * result + (data == null ? 0 : data.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return data;
    }
}
