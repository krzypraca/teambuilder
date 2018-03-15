package kj.test.mm.teambuilder;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PathProcessorTests {
	private PathProcessor processor = new PathProcessor() ;
	
	@Test
	public void validationProcessPaths() {
		
		// null arguments
		try {
			processor.processPaths( null ) ;
			fail( "Expected IllegalArgumentException exception") ;
		} catch ( IllegalArgumentException e ) {
			// expected 
		} catch ( Throwable t ) {
			fail( "Expected IllegalArgumentException exception") ;
		}
		
		// empty arguments
		try {
			processor.processPaths( new String[] { } ) ;
			fail( "Expected IllegalArgumentException exception") ;
		} catch ( IllegalArgumentException e ) {
			// expected 
		} catch ( Throwable t ) {
			fail( "Expected IllegalArgumentException exception") ;
		}
		
		// too few arguments
		try {
			processor.processPaths( new String[] { "one" } ) ;
			fail( "Expected IllegalArgumentException exception") ;
		} catch ( IllegalArgumentException e ) {
			// expected 
		} catch ( Throwable t ) {
			fail( "Expected IllegalArgumentException exception") ;
		}
	}
	
	@Test
	public void validationProcessPath() {
		final Nodes nodes = new Nodes() ;
		
		// null arguments
		try {
			processor.processPath( 5, 0, null, nodes ) ;
			fail( "Expected IllegalArgumentException exception") ;
		} catch ( IllegalArgumentException e ) {
			// expected 
		} catch ( Throwable t ) {
			fail( "Expected IllegalArgumentException exception") ;
		}
		
		// empty arguments
		try {
			processor.processPath( 5, 0, "", nodes ) ;
			fail( "Expected IllegalArgumentException exception") ;
		} catch ( IllegalArgumentException e ) {
			// expected 
		} catch ( Throwable t ) {
			fail( "Expected IllegalArgumentException exception") ;
		}
		
		// too few arguments
		try {
			processor.processPath( 5, 0, "1", nodes ) ;
			fail( "Expected IllegalArgumentException exception") ;
		} catch ( IllegalArgumentException e ) {
			// expected 
		} catch ( Throwable t ) {
			fail( "Expected IllegalArgumentException exception") ;
		}
		
		// invalid characters
		try {
			processor.processPath( 5, 0, "12345", nodes ) ;
			fail( "Expected IllegalArgumentException exception") ;
		} catch ( IllegalArgumentException e ) {
			// expected 
		} catch ( Throwable t ) {
			fail( "Expected IllegalArgumentException exception") ;
		}
	}
	
	@Test
	public void validationOutPaths() {
		Nodes nodes = processor.processPaths( new String[] { "00", "00" } ) ;
		assertTrue( nodes.getNode(0).countOutNodes() == 0 ) ;
		assertTrue( nodes.getNode(1).countOutNodes() == 0 ) ;
		
		nodes = processor.processPaths( new String[] { "11", "11" } ) ;
		assertTrue( nodes.getNode(0).countOutNodes() == 1 ) ;
		assertTrue( nodes.getNode(1).countOutNodes() == 1 ) ;
		
		nodes = processor.processPaths( new String[] { "0000000000", "0000000000",
				"0000000000", "0000000000",
				"0000000000", "0000000000",
				"0000000000", "0000000000",
				"0000000000", "0000000000" } ) ;
		assertTrue( nodes.getNode(0).countOutNodes() == 0 ) ;
		assertTrue( nodes.getNode(9).countOutNodes() == 0 ) ;
		
		nodes = processor.processPaths( new String[] { "1111111111", "1111111111",
				"1111111111", "1111111111",
				"1111111111", "1111111111",
				"1111111111", "1111111111",
				"1111111111", "1111111111" } ) ;
		assertTrue( nodes.getNode(0).countOutNodes() == 9 ) ;
		assertTrue( nodes.getNode(9).countOutNodes() == 9 ) ;
	}
}
