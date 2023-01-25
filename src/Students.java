import com.serialization.annotations.Marked;
import com.serialization.annotations.SerializableToJSON;

@SerializableToJSON
public class Students {
    @Marked
    public int age ;
    @Marked(name = "nom")
    public String name;

    public boolean admis ;


}
