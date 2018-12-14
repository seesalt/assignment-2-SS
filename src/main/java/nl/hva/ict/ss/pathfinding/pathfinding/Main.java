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
            EdgeWeightedDigraph graafD =  new EdgeWeightedDigraph("i" + i);

            final int start = graafD.getStart();
            final int finish = graafD.getEnd();

            final Dijkstra dijkstra = new Dijkstra(graafD, start);
            if (dijkstra.hasPathTo(finish)) {
               graafD.tekenPad(dijkstra.pathTo(finish));
               graafD.save("i" + i + "-dijkstra");
            }

            EdgeWeightedDigraph graafF = new EdgeWeightedDigraph("i" + i);
            FloydWarshall floydWarshall = new FloydWarshall(graafF.createAdjMatrixEdgeWeightedDigraph());
            if (floydWarshall.hasPath(start,finish)) {
                graafF.tekenPad(floydWarshall.path(start,finish));
                graafF.save("i" + i + "-floyd");
            }


        }



        // TODO Here you can do your experiments.

        // Please have a good look at the constructors of EdgeWeightedDigraph!

        // Before you save any images make sure the value of TileWorldUtil.outputDir points to an
        // existing folder and ands with a '/'!
        // Example: TileWorldUtil.outputDir = "/Users/nico/output/";
    }

}
