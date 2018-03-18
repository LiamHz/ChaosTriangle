import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class ChaosTriangle {
    // Stores probability of each point being moved towards
    double p1 = 0.95;
    double p2 = 0.02;
    double p3 = 0.33;

    // Stores location of each of the original points
    double[] L1 = {0.1, 0.15};
    double[] L2 = {0.5, Math.sqrt(0.48) + 0.15};
    double[] L3 = {0.9, 0.15};

    // Stores the 'current position'
    public static double[] CurrentPos = {0.1, 0.15};

    public void Init(){
        StdDraw.setPenRadius(0.05);
        StdDraw.point(0.1,0.15);
        StdDraw.point(0.5,Math.sqrt(0.48) + 0.15);
        StdDraw.point(0.9,0.15);
    }

    public int PickDirection(){
        double dir = Math.random();

        if (dir <= p1){
            StdDraw.setPenColor(StdDraw.BLUE);
            return 1;
        }else if (dir <= p1 + p2){
            StdDraw.setPenColor(StdDraw.RED);
            return 2;
        }else{
            StdDraw.setPenColor(StdDraw.GREEN);
            return 3;
        }
    }

    public void MoveTowards(int n){
        if(n == 1){
            CurrentPos[0] = (CurrentPos[0] + L1[0]) / 2;
            CurrentPos[1] = (CurrentPos[1] + L1[1]) / 2;
        }else if(n == 2){
            CurrentPos[0] = (CurrentPos[0] + L2[0]) / 2;
            CurrentPos[1] = (CurrentPos[1] + L2[1]) / 2;
        }else{
            CurrentPos[0] = (CurrentPos[0] + L3[0]) / 2;
            CurrentPos[1] = (CurrentPos[1] + L3[1]) / 2;
        }
    }

    public static void main(String args[]){
        int iterations = Integer.parseInt(args[0]);

        ChaosTriangle T1 = new ChaosTriangle();
        T1.Init();

        StdDraw.setPenRadius(0.005);
        int i = 0;
        while(i < iterations){
            int n = T1.PickDirection();
            T1.MoveTowards(n);
            StdDraw.point(CurrentPos[0], CurrentPos[1]);
            i++;
        }
    }
}
