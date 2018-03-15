package kj.test.mm.teambuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Read, validate all paths and produce structure of all Nodes.
 * @author kj
 *
 */
public class PathProcessor implements PathProcessorIface {
	private static final Logger logger = LoggerFactory.getLogger(PathProcessor.class);
	
	/**
	 * Read, validate all paths and produce structure of all Nodes.
	 * @param paths
	 * @return
	 */
	public Nodes processPaths( final String[] paths ) {
		if ( paths == null ) throw new IllegalArgumentException( "Paths cannot be null") ;
		if ( paths.length == 0 ) throw new IllegalArgumentException( "Paths cannot empty") ;
		if ( paths.length < Configuration.MIN_ELEMENTS ) {
			throw new IllegalArgumentException( 
				String.format( "There must min %s and max %s paths", 
					String.valueOf( Configuration.MIN_ELEMENTS),
					String.valueOf( Configuration.MAX_ELEMENTS) ) ) ;
		}
		if ( paths.length > Configuration.MAX_ELEMENTS ) {
			throw new IllegalArgumentException( 
				String.format( "There must min %s and max %s paths", 
					String.valueOf( Configuration.MIN_ELEMENTS),
					String.valueOf( Configuration.MAX_ELEMENTS) ) ) ;
		}
		
		final Nodes nodes = new Nodes() ;
		
		// create all nodes
		for( int i=0; i<paths.length; i++ ) {
			nodes.addNode( i );
		}

		// for each path populate each node with in and out data
		for( int i=0; i<paths.length; i++ ) {			
			processPath( paths.length, i, paths[i], nodes ) ;
		}
		
		return nodes;
	}
	
	/**
	 * Process one path
	 * @param expectedNodeCount
	 * @param pathIndex
	 * @param path
	 * @param nodes
	 */
	void processPath( final int expectedNodeCount,  final int pathIndex, final String path, final Nodes nodes ) {
		logger.debug( String.format( "Processing path: %s", path) );
		
		if ( path == null ) throw new IllegalArgumentException( "Path cannot be null") ;
		if ( path.isEmpty() ) throw new IllegalArgumentException( "Path cannot empty") ;
		
		if ( path.length() != expectedNodeCount ) {
			throw new IllegalArgumentException( "Number of elements must match number of paths" ) ;
		}
		
		if ( pathIndex < 0 || 
			 pathIndex >= path.length() ) throw new IllegalArgumentException( "PathIndex is invalid.") ;
		
		final Node currentNode = nodes.getNode( pathIndex ) ;
		
		// analyze each path and populate in and out nodes
		for ( int i=0; i< path.length(); i++ ) {
			char character = path.charAt(i) ;
			
			if ( character != '0' &&  character != '1') throw new IllegalArgumentException( "Path must contain only 0 or 1 characters" ) ;
			
			// do not look at current path
			if ( i != pathIndex ) {
				if ( character == '1') {
					Node foundNode = nodes.getNode( i ) ;
					currentNode.addOutNode( foundNode );
					foundNode.addInNode( currentNode );
				}
			}
		}

	}
}
