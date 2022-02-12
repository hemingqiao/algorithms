# 初始化Java中的集合类

## HashMap

```java
class Init {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>(){{
            put(0, 32);
            put(1, 1024);
            put(2, 64);
        }};
        System.out.println(map);
    }
}
```

## HashSet

```java
class Init {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(){{
            add(32);
            add(1024);
            add(64);
        }};
        System.out.println(set);
    }
}
```

## ArrayList

```java
class Init {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(){{
            add(32);
            add(1024);
            add(64);
        }};
        System.out.println(list);
    }
}
```

## Queue

```java
class Init {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>(){{
            push(32);
            push(1024);
            push(64);
        }};
        System.out.println(queue);
    }
}
```

## PriorityQueue

```java
class Init {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }){{
            offer(32);
            offer(1024);
            offer(64);
        }};
        System.out.println(queue);
    }
}
```

绝大多数集合类都支持这种操作，在初始化小型数据集时非常有用。
