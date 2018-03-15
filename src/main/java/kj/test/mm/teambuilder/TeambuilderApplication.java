package kj.test.mm.teambuilder;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeambuilderApplication implements ApplicationRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(TeambuilderApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TeambuilderApplication.class, args);
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("Command-line arguments: {}", Arrays.toString(args.getSourceArgs()));
//        logger.info("Non Option Args: {}", args.getNonOptionArgs());
//        logger.info("Option Names: {}", args.getOptionNames());
		
		try {
			TeamBuilder teamBulder = new TeamBuilder() ;
			final String result = Arrays.toString( teamBulder.specialLocations( args.getSourceArgs() )) ;
			logger.info( String.format("RESULT: %s", result )) ;
			
			// I will also print it like this to be visible
			System.out.println( "**********************************************************************");
			System.out.println( "*                                                                    ");
			System.out.println( String.format("* RESULT: %s ", result ) );
			System.out.println( "*                                                                    ");
			System.out.println( "**********************************************************************");
			
		} catch( Throwable e ) {
			logger.error( e.toString() ) ;
			// I will also print it like this to be visible
			System.out.println( "**********************************************************************");
			System.out.println( "*                                                                    ");
			System.out.println( String.format("* ERROR: %s ", e.toString() ) );
			System.out.println( "*                                                                    ");
			System.out.println( "**********************************************************************");
			
		}

	}
}
