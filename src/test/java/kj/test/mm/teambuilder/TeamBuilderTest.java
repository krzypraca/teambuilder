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
public class TeamBuilderTest {
	
	@Test
	public void exampleOne() {
		final TeamBuilder teamBuilder = new TeamBuilder() ;
		int[] result = teamBuilder.specialLocations( new String[] { "010", "000", "110" } ) ;
		assertTrue( result[0] == 1 ) ;
		assertTrue( result[1] == 1 ) ;
	}
	
	@Test
	public void exampleTwo() {
		final TeamBuilder teamBuilder = new TeamBuilder() ;
		int[] result = teamBuilder.specialLocations( new String[] { "0010", "1000", "1100", "1000" } ) ;
		assertTrue( result[0] == 1 ) ;
		assertTrue( result[1] == 3 ) ;
	}
	
	@Test
	public void exampleThree() {
		final TeamBuilder teamBuilder = new TeamBuilder() ;
		int[] result = teamBuilder.specialLocations( new String[] { "01000", "00100", "00010", "00001", "10000" } ) ;
		assertTrue( result[0] == 5 ) ;
		assertTrue( result[1] == 5 ) ;
	}
	
	@Test
	public void exampleFour() {
		final TeamBuilder teamBuilder = new TeamBuilder() ;
		int[] result = teamBuilder.specialLocations( new String[] { "0110000", "1000100", "0000001", "0010000", "0110000", "1000010", "0001000" } ) ;
		assertTrue( result[0] == 1 ) ;
		assertTrue( result[1] == 3 ) ;
	}
	
}
