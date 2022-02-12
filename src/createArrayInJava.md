# Java中创建数组的几种方式

## 第一种

```java
public class Array {
    public static void main(String[] args) {
        int[] first = new int[10];
        System.out.println(Arrays.toString(first));
    }
}

// logs
// [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
```
通过这种方法创建的数组元素被初始化为0。

## 第二种

```java
public class Array {
    public static void main(String[] args) {
        int[] second = new int[]{32, 1024, 64};
        System.out.println(Arrays.toString(second));
    }
}

// logs
// [32, 1024, 64]
```

这种方式以大括号中给定的值为数组执行初始化。

## 第三种

```java
public class Array {
    public static void main(String[] args) {
        int[] second = {32, 1024, 64};
        System.out.println(Arrays.toString(second));
    }
}

// logs
// [32, 1024, 64]
```

第三种方式和第二种很类似，可以视为第二种的简化。
