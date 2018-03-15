package kj.test.mm.teambuilder;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Container of all nodes
 * @author kj
 *
 */
public class Nodes {
	private static final Logger logger = LoggerFactory.getLogger(Nodes.class);
	
	private Map<Integer,Node> nodeMap = new HashMap<Integer,Node>() ;
	
	/**
	 * Add node
	 * @param nodeName
	 */
	public void addNode( final int nodeName) {
		this.nodeMap.put( nodeName, new Node( nodeName ) ) ;
	}
	
	/**
	 * 
	 * @param name
	 * @return Node with a given name
	 */
	public Node getNode( final int name ) {
		return nodeMap.get( name ) ;
	}
	
	/**
	 * 
	 * @return number of nodes
	 */
	public int nodeCount() {
		return this.nodeMap.size() ;
	}
	
	/**
	 * Not thread safe
	 * @return all nodes
	 */
	public Collection<Node> getAllNodes() {
		return this.nodeMap.values() ;
	}
	
	/**
	 * Iterate through all nodes until there all expansions are done.
	 * @param nodeMap
	 * @return
	 */
	public void expand() {
		boolean changeWasMade = true ;
		while (changeWasMade) {
			logger.debug( this.toString() ) ;
			
			changeWasMade = false ;
			for( Node node : this.nodeMap.values() ) {
				if ( node.expand() ) {
					changeWasMade = true ;
				}
			}
		}
	}
	
	public String toString() {
		final StringBuilder result = new StringBuilder() ;
		result.append( "Nodes:" );
		for( Node node : nodeMap.values() ) {
			result.append( node.toString() );
		}
		return result.toString() ;
	}
}
