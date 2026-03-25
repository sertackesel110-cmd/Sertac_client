package net.fabricmc.example;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public static final List<Module> modules = new ArrayList<>();
    public static void init() {
        modules.add(new FullBright());
    }
    public static List<Module> getModules() { return modules; }
}

