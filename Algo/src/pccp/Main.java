package pccp;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static final Point point = new Point();
    private static char map[][];

    public static void main(String[] args) {
        long[][] line = {
                {2, -1, 4},
                {-2, -1, 4},
                {0, -1, 1},
                {5, -8, -12},
                {5, 8, 12}
        };
        Point[] lineList = new Point[line.length];
        ArrayList<Point> intersections = new ArrayList<>();

        for(int i=0; i<line.length; i++){
            lineList[i] = new Point(line[i][0], line[i][1], line[i][2]);
        }

        for(int i=0; i<lineList.length-1; i++){
            for(int j=i+1; j<lineList.length; j++){
                Point p1 = lineList[i];
                Point p2 = lineList[j];
                Point interPoint = point.getIntersectionPoint(p1, p2);

                if(interPoint != null) {
                    intersections.add(interPoint);
                    System.out.println(interPoint.getX()+","+interPoint.getY());
                }
            }
        }

        map = new char[point.getRowSize(intersections)][point.getColSize(intersections)];
        for(int i=0; i<map.length; i++) Arrays.fill(map[i], '.');
        for(Point p : intersections){
            map[(int)(p.getY()+Math.abs(point.getMinPoint(intersections).getY()))][(int)(p.getX()+Math.abs(point.getMinPoint(intersections).getX()))] = '*';
        }
        printArray();
    }

    private static void printArray() {
        for(int i=map.length-1; i>=0; i--){
            for (int j=0; j<map[0].length; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}

class Point{
    private long x, y, z;

    public Point() {}

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public Point(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long getZ() {
        return z;
    }

    public Point getMinPoint(ArrayList<Point> list){
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;

        for(Point p : list){
            minX = Long.min(minX, p.getX());
            minY = Long.min(minY, p.getY());
        }
        return new Point(minX, minY);
    }

    public Point getMaxPoint(ArrayList<Point> list){
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        for(Point p : list){
            maxX = Long.max(maxX, p.getX());
            maxY = Long.max(maxY, p.getY());
        }
        return new Point(maxX, maxY);
    }

    public int getRowSize(ArrayList<Point> list){
        return (int)Math.abs(getMaxPoint(list).getX()-getMinPoint(list).getX()) + 1;
    }

    public int getColSize(ArrayList<Point> list){
        return (int)Math.abs(getMaxPoint(list).getY()-getMinPoint(list).getY()) + 1;
    }

    public Point getIntersectionPoint(Point p1, Point p2){
        double[] result = new double[2];
        long A = p1.getX();
        long B = p1.getY();
        long C = p1.getZ();

        long D = p2.getX();
        long E = p2.getY();
        long F = p2.getZ();

        result[0] = (double)(B*F-C*E)/(A*E-B*D);
        result[1] = (double)(C*D-A*F)/(A*E-B*D);

        // 간단하게 double혹은 float인지 아닌지 구분하는 방법: % 연산자 이용
        if(result[0]%1 != 0 || result[1]%1 != 0) return null;

        return new Point((long)result[0], (long)result[1]);
    }
}
