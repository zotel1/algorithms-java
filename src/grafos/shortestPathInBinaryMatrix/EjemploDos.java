package grafos.shortestPathInBinaryMatrix;



// A point in a Maze (Needed for QNode)
class Point {
    int x, y;
    Point(int x_, int y_) {
        x = x_;
        y = y_;
    }
}

// A QNode (Needed for BFS)
class QNode {
    Point p;
    int d;
    QNode(Point p_, int d_) {
        p = p_;
        d = d_;
    }
}

public class EjemploDos {

    static boolean isValid(int x, int y, int r, int c) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

    static int BFS(int[][] mat, Point src, Point dest) {
        int r = mat.length, c = mat[0].length;

        // If Source and Destination are valid
        if (mat[src.x][src.y] == 0 || mat[dest.x][dest.y] == 0) return -1;

        // Do BFS using Queue and Visited
        boolean[][] vis = new boolean[r][c];
        java.util.Queue<QNode> q = new java.util.LinkedList<>();
        q.add(new QNode(src, 0));
        vis[src.x][src.y] = true;
        while (!q.isEmpty()) {
            // Pop an item from queue
            QNode node = q.poll();
            Point p = node.p;
            int d = node.d;

            // If we reached the destination
            if (p.x == dest.x && p.y == dest.y) return d;

            // Try all four adjacent
            int[] dx = {-1, 0, 0, 1};
            int[] dy = {0, -1, 1, 0};
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i], ny = p.y + dy[i];
                if (isValid(nx, ny, r, c) && mat[nx][ny] == 1 && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    q.add(new QNode(new Point(nx, ny), d + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}
        };

        System.out.println(BFS(mat, new Point(0, 0), new Point(3, 4)));
    }
}