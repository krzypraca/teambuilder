package kj.test.mm.teambuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Node
 * @author kj
 *
 */
public class Node {
	private Integer name ;
	private Map<Integer, Node> inNodeMap = new HashMap<Integer,Node>() ;
	private Map<Integer, Node> outNodeMap = new HashMap<Integer,Node>() ;
	
	public Node( final Integer name ) {
		this.name = name ;
	}
	
	public void addInNode( final Node node ) {
		this.inNodeMap.put( node.name, node ) ;
	}
	
	public void addOutNode( final Node node ) {
		this.outNodeMap.put( node.name, node ) ;
	}

	/**
	 * Expand the node data in the following way
	 * Add all out nodes to the in nodes unless there are duplicates.
	 * Do add the same node to in out out nodes.
	 * @return false if there was nothing to expand
	 */
	public boolean expand() {
		boolean changeWasMade = false ;
		// for each in node
		for( Node inNode : this.inNodeMap.values() ) {
			// for each out node
			for( Node outNode : this.outNodeMap.values() ) {
				if ( inNode != outNode ) {
					// is the out node in the list of out nodes in inNode
					if ( ! inNode.outNodeMap.containsKey( outNode.name) ) {
						inNode.addOutNode( outNode ) ;
						outNode.addInNode( inNode );
						changeWasMade = true ;
					}
				}
			}
		}
		return changeWasMade ;
	}
	
	/**
	 * 
	 * @return number of out nodes
	 */
	public int countOutNodes() {
		return this.outNodeMap.size() ;
	}
	
	/**
	 * 
	 * @return number of in nodes
	 */
	public int countInNodes() {
		return this.inNodeMap.size() ;
	}
	
	public String toString() {
		final StringBuilder result = new StringBuilder() ;
		result.append( this.name ) ;
		
		result.append( " out:[") ;
		for( Node node : this.outNodeMap.values() ) {
			result.append( node.name ) ;
			result.append( " " ) ;
		}
		result.append( "]") ;
		
		result.append( " in:[") ;
		for( Node node : this.inNodeMap.values() ) {
			result.append( node.name ) ;
			result.append( " " ) ;
		}
		result.append( "]") ;
		
		return result.toString() ;
	}
}
