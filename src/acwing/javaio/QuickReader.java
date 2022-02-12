package src.acwing.javaio;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/09/11 10:15:05
 * description: Java快速IO 工具类
 */
class QuickReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException ex) {
            return null;
        }
    }

    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }

    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }

    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    // 若需要nextLong、nextDouble等方法，请自己调用Long.parseLong、Double.parseDouble包装
}

class QuickWriter implements Closeable {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) throws IOException {
        writer.write(object.toString());
    }

    public void println(Object object) throws IOException {
        writer.write(object.toString());
        writer.write(System.lineSeparator());
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }

    public void flush() throws IOException {
        writer.flush();
    }
}


/** usage **/

class Main {
    static int N = 10;
    static boolean[] col = new boolean[N], dg = new boolean[N * 2], udg = new boolean[N * 2];
    static char[][] b = new char[N][N];
    static QuickWriter out = new QuickWriter();

    public static void main(String[] args) throws IOException {
        QuickReader in = new QuickReader();
        int n = in.nextInt();
        // char[][] b = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = '.';
            }
        }
        dfs(0, n);
    }

    public static void dfs(int u, int n) throws IOException {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                StringBuilder ss = new StringBuilder();
                for (int j = 0; j < n; j++) ss.append(b[i][j]);
                out.println(ss.toString());
            }
            out.println("");
            out.flush(); // 输出String时，需要调用“flush()”将缓冲区的内容刷新到输出
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[u - i + n] && !udg[u + i]) {
                b[u][i] = 'Q';
                col[i] = dg[u - i + n] = udg[u + i] = true;
                dfs(u + 1, n);
                col[i] = dg[u - i + n] = udg[u + i] = false;
                b[u][i] = '.';
            }
        }
    }
}
