package quickfix.examples.banzai;

import java.util.HashMap;
import java.util.Map;

public class ExchIdType {
    static private final Map<String, ExchIdType> known = new HashMap<>();
    static public final ExchIdType XSSC = new ExchIdType("XSSC");//0市场
    static public final ExchIdType XSEC = new ExchIdType("XSEC");//1市场
    static public final ExchIdType XHKG = new ExchIdType("XHKG");;//香港市场
    private final String name;
    static private final ExchIdType[] array = { XSSC, XSEC, XHKG};
    private ExchIdType(String name) {
        this.name = name;
        synchronized (OrderType.class) {
            known.put(name, this);
        }
    }
    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    static public Object[] toArray() {
        return array;
    }
    public static ExchIdType parse(String type) throws IllegalArgumentException {
        ExchIdType result = known.get(type);
        if (result == null) {
            throw new IllegalArgumentException
                    ("OrderType: " + type + " is unknown.");
        }
        return result;
    }

}