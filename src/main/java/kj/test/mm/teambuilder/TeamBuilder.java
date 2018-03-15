package kj.test.mm.teambuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Calculate number of locations which can reach all locations or which can be reached from all other locations.
 * @author kj
 *
 */
public class TeamBuilder {
	private static final Logger logger = LoggerFactory.getLogger(TeamBuilder.class);
	
	PathProcessorIface processor = new PathProcessor() ;
	
	/**
	 * 
	 * @param paths array of Strings, each String contains 0 and 1, were 1 indicate a presence of output path
	 * @return int[] [0] number of locations that can reache all other locations, [1] number of locations that can be reached from all other locations
	 */
	public final int[] specialLocations( final String[] paths ) {

		// create nodeMap
		Nodes nodes = processor.processPaths( paths ) ;
		
		// expand
		nodes.expand();
		
		// create result
		return createResult( nodes ) ;
	}
	
	// PRIVATE

	/** 
	 * Create a result 
	 * @param nodeMap
	 * @return
	 */
	private int[] createResult( final Nodes nodes ) {
		int[] result = new int[2] ;
		
		int expectedMax = nodes.nodeCount() - 1 ;
		
		// max out nodes
		for( Node node : nodes.getAllNodes() ) {
			if ( node.countOutNodes() == expectedMax ) {
				result[0] ++ ;
			}
			if ( node.countInNodes() == expectedMax ) {
				result[1] ++ ;
			}
		}
		return result ;
	}
	

	
	
		
}
