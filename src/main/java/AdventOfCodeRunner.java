import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AdventOfCodeRunner {

  public static void main(String[] args) throws Exception {

    Set<Class> classes = new LinkedHashSet<>();

    int i = 1;
    while (isPackagePresent("day" + i)) {
      classes.addAll(findAllClassesUsingClassLoader("day" + i++));
    }

    for (Class clazz : classes) {
      System.out.println("=== " + clazz.getName().split("\\.")[1] + " ===");
      clazz.getDeclaredMethods()[0].invoke(null);
      System.out.println();
    }
  }

  public static boolean isPackagePresent(String packageName) {
    InputStream stream = ClassLoader.getSystemClassLoader()
        .getResourceAsStream(packageName.replaceAll("[.]", "/"));

    if (stream == null) {
      return false;
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

    return reader.lines().findAny().isPresent();
  }

  public static Set<Class> findAllClassesUsingClassLoader(String packageName) {
    InputStream stream = ClassLoader.getSystemClassLoader()
        .getResourceAsStream(packageName.replaceAll("[.]", "/"));
    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
    return reader.lines()
        .filter(line -> line.endsWith(".class"))
        .map(line -> getClass(line, packageName))
        .collect(Collectors.toSet());
  }

  private static Class getClass(String className, String packageName) {
    try {
      return Class.forName(packageName + "."
          + className.substring(0, className.lastIndexOf('.')));
    } catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

}
