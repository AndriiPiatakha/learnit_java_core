
import java.util.ListResourceBundle;

public class MyLabels_de_DE extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return labels;
    }

    private Object[][] labels = {
            { "integer_value"   , Integer.valueOf(100) },
            { "string_value", "MILES" },
    };
}
