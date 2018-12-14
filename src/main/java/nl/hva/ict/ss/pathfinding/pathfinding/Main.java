package nl.hva.ict.ss.pathfinding.pathfinding;

import nl.hva.ict.ss.pathfinding.tileworld.TileWorldUtil;
import nl.hva.ict.ss.pathfinding.weigthedgraph.EdgeWeightedDigraph;

import java.io.File;

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
        for (int i = 1; i <= 21; i++) {
            EdgeWeightedDigraph graafD =  new EdgeWeightedDigraph("i" + i);

            final int start = graafD.getStart();
            final int finish = graafD.getEnd();

            final Dijkstra dijkstra = new Dijkstra(graafD, start);
            EdgeWeightedDigraph graafF = new EdgeWeightedDigraph("i" + i);
            FloydWarshall floydWarshall = new FloydWarshall(graafF.createAdjMatrixEdgeWeightedDigraph());

            if (dijkstra.hasPathTo(finish)) {
                System.out.println("I" + i + "|Aantal onderzochte knooppunten Dijkstra : " + dijkstra.getDijkstraCounter());
                System.out.println("I" + i + "|Aantal onderzochte knooppunten Floyd : " + floydWarshall.getFloydCounter());

            } else {
                System.out.printf("i%d;-;-;-;-\n", i);
            }
        }



        // TODO Here you can do your experiments.

        // Please have a good look at the constructors of EdgeWeightedDigraph!

        // Before you save any images make sure the value of TileWorldUtil.outputDir points to an
        // existing folder and ands with a '/'!
        // Example: TileWorldUtil.outputDir = "/Users/nico/output/";
    }

}
