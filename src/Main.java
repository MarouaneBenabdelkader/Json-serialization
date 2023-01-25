import com.serialization.Json;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        Students students = new Students();
        students.age =  5;
        students.admis = true;
        students.name = "John Doe";
        System.out.println(Json.toJSON(students));
    }
}