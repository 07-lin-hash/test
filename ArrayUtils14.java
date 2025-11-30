/**
 * 泛型工具类，提供数组相关的通用方法
 */
public class ArrayUtils14 {

    /**
     * 返回任意类型数组中的最大元素。
     *
     * @param <T>  元素类型，必须实现 Comparable 接口
     * @param arr  待查找的数组
     * @return 数组中的最大值
     * @throws IllegalArgumentException 当数组为 null 或长度为 0 时抛出
     */
    public static <T extends Comparable<? super T>> T max(T[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("数组不能为空或长度为 0");
        }

        // 先把第一个元素设为当前最大值
        T max = arr[0];

        // 逐个比较其余元素
        for (int i = 1; i < arr.length; i++) {
            // compareTo 返回负数表示 arr[i] 小于 max，正数表示大于，0 表示相等
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    // ------------------- 示例 -------------------
    public static void main(String[] args) {
        // 整数数组
        Integer[] intArr = {3, 7, 2, 9, 5};
        System.out.println("Integer max = " + max(intArr)); // 9

        // 字符串数组（按字典序比较）
        String[] strArr = {"apple", "orange", "banana", "pear"};
        System.out.println("String max = " + max(strArr)); // pear

        // 自定义类示例
        Person[] people = {
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 22)
        };
        System.out.println("Person max (by age) = " + max(people)); // Bob
    }
}

/**
 * 示例自定义类，按年龄比较大小
 */
class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 按年龄升序比较
    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.age, o.age);
    }

    @Override
    public String toString() {
        return name + "(" + age + ")";
    }
}