package nl.hva.ict.ss.pathfinding.pathfinding;

import nl.hva.ict.ss.pathfinding.tileworld.TileWorldUtil;
import nl.hva.ict.ss.pathfinding.weigthedgraph.EdgeWeightedDigraph;

/**
 * TODO make sure your code is compliant with the HBO-ICT coding conventions!
 *
 * @author ???
 */
public class Main {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TileWorldUtil.outputDir = "C:/Users/seesalt/output/";
        for (int i = 1; i <= 21; i++) {
            EdgeWeightedDigraph graafD = new EdgeWeightedDigraph("i" + i);

            final int start = graafD.getStart();
            final int finish = graafD.getEnd();

            final Dijkstra dijkstra = new Dijkstra(graafD, start);
            if (dijkstra.hasPathTo(finish)) {
                graafD.tekenPad(dijkstra.pathTo(finish));
                graafD.save("i" + i + "-dijkstra");
            }

            EdgeWeightedDigraph graafF = new EdgeWeightedDigraph("i" + i);
            FloydWarshall floydWarshall = new FloydWarshall(graafF.createAdjMatrixEdgeWeightedDigraph());
            if (floydWarshall.hasPath(start, finish)) {
                graafF.tekenPad(floydWarshall.path(start, finish));
                graafF.save("i" + i + "-floyd");
            }

            if (dijkstra.hasPathTo(finish)) {
                System.out.printf("i%d;\t%d;\t%d;\t%1.0f;\t\t%d;\t%d;\t%1.0f;\n",
                        i,
                        dijkstra.nodeCount(),
                        length(dijkstra.pathTo(finish)),
                        dijkstra.distTo(finish),
                        floydWarshall.getFloydCounter(),
                        length(floydWarshall.path(start, finish)),
                        floydWarshall.dist(start, finish)
                );
            } else {
                System.out.printf("i%d;-;-;-;-\n", i);
            }

        }
    }

    private static <T> int length(Iterable<T> iterable) {
        int length = 0;
        for (T notNeeded : iterable) {
            length++;
        }
        return length;
    }

}
