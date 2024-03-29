package cn.langya.sun.values;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import org.apache.logging.log4j.LogManager;

import java.util.List;

public class ListValue extends AbstractValue<String>{
    private final String name;
    private String value;
    private final List<String> values;

    public ListValue(String name, String value, String... values) {
        super(name);
        this.name = name;
        this.value = value;
        this.values = new ObjectArrayList<>(values);
    }
    @Override
    public String get() {
        return value;
    }

    @Override
    public void set(String value) {
        if(value == null || inLimits(value)) {
            this.value = value;
        } else {
            LogManager.getLogger().error("Unable to set " + value + " as it's unacceptable value: " + value);
        }
    }
    public String getName() {
        return name;
    }
    private boolean equals(String value){
        if(value == null) return this.value == null;
        return value.equals(this.value);
    }
    public boolean equalsIgnoreCase(String value) {
        if(value == null) return this.value == null;
        return value.equalsIgnoreCase(this.value);
    }
    private boolean inLimits(String value){
        if (values == null || values.isEmpty()) return true;
        return values.contains(value);
    }
    public List<String> getValues() {
        return values;
    }
}
